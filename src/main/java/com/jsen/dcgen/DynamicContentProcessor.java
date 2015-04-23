package com.jsen.dcgen;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.script.ScriptException;

import com.jsen.dcgen.blocks.anglebracket.AngleBracketSettings;
import com.jsen.dcgen.script.ContentScriptBuilder;
import com.jsen.dcgen.script.ScriptEngineContentGenerator;
import com.jsen.dcgen.script.engines.JavaScriptEngineContentGenerator;

public class DynamicContentProcessor {
	
	private ScriptEngineContentGenerator generator;
	private Class<? extends ScriptBlocksSettings> scriptBlocksSettingsClazz;
	
	public DynamicContentProcessor() {
		this(new JavaScriptEngineContentGenerator(), AngleBracketSettings.class);
	}
	
	public DynamicContentProcessor(Class<? extends ScriptBlocksSettings> scriptBlocksSettingsClazz) {
		this(new JavaScriptEngineContentGenerator(), scriptBlocksSettingsClazz);
	}
	
	public DynamicContentProcessor(ScriptEngineContentGenerator generator) {
		this(generator, AngleBracketSettings.class);
	}
	
	public DynamicContentProcessor(ScriptEngineContentGenerator generator, Class<? extends ScriptBlocksSettings> scriptBlocksSettingsClazz) {
		this.generator = generator;
		this.scriptBlocksSettingsClazz = scriptBlocksSettingsClazz;
	}
	
	public String process(String template) throws ScriptException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Constructor<? extends ScriptBlocksSettings> settingsConstructor = scriptBlocksSettingsClazz.getConstructor(ContentScriptBuilder.class);
		ScriptBlocksSettings settings = settingsConstructor.newInstance(generator.getContentScriptBuilder());
		return process(template, settings);		
	}
	
	public String process(String template, ScriptBlocksSettings scriptBlocksSettings) throws ScriptException {	
	MarkMatchResult templateCharsMatched = new MarkMatchResult(0, 0);
		
		ScriptBlock startedScriptBlock = null;
		for (int i = 0; i < template.length(); i++) {
			char c = template.charAt(i);
			
			if (startedScriptBlock == null) {
				templateCharsMatched.chars++;
			}
			
			if (startedScriptBlock == null) {
				for (ScriptBlock scriptBlock : scriptBlocksSettings.getScriptBlocks()) {
					if (scriptBlock.matchedStart.match(i, c)) {
						startedScriptBlock = scriptBlock;
						templateCharsMatched.chars = templateCharsMatched.chars - startedScriptBlock.matchedStart.tokenString.length();
						break;
					}
				}
			}
			
			if (startedScriptBlock != null && templateCharsMatched.chars > 0) {
				generator.getContentScriptBuilder().outputString(template.substring(templateCharsMatched.pos, templateCharsMatched.pos + templateCharsMatched.chars));
				templateCharsMatched.chars = 0;
			}
			
			if (startedScriptBlock != null && startedScriptBlock.matchedEnd.match(i, c)) {
				startedScriptBlock.extractAndGenerate(template);
				String trailingString = startedScriptBlock.trailingString(template);
				i += trailingString.length();
				templateCharsMatched.pos = i + 1;
				templateCharsMatched.chars = 0;
				startedScriptBlock = null;
				
				for (ScriptBlock scriptBlock : scriptBlocksSettings.getScriptBlocks()) {
					scriptBlock.clear();
				}
			}
		}
		
		if (templateCharsMatched.chars != 0) {
			generator.getContentScriptBuilder().outputString(template.substring(templateCharsMatched.pos, templateCharsMatched.pos + templateCharsMatched.chars));
		}
		
		String script = generator.getContentScriptBuilder().build();
		return generator.generate(script);
	}
	
}
