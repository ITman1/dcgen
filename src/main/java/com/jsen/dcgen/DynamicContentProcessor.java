package com.jsen.dcgen;

import com.jsen.dcgen.blocks.anglebracket.AngleBracketSettings;

public class TemplateScriptGeneratoressor {
	
	public String process(String template) {
		return process(template, new AngleBracketSettings());		
	}
	
	public String process(String template, ScriptBlocksSettings scriptBlocksSettings) {		
		StringBuilder scriptStringBuilder = new StringBuilder();
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
						//startedScriptBlock.templateStartScriptBlockCorrection(template, templateCharsMatched);
						break;
					}
				}
			}
			
			if (startedScriptBlock != null && templateCharsMatched.chars > 0) {
				scriptStringBuilder.append("write('");
				scriptStringBuilder.append(template.substring(templateCharsMatched.pos, templateCharsMatched.pos + templateCharsMatched.chars).replace("\\", "\\\\").replace("\r", "\\r").replace("\n", "\\n").replace("'", "\\'"));
				scriptStringBuilder.append("');\n");
				templateCharsMatched.chars = 0;
			}
			
			if (startedScriptBlock != null && startedScriptBlock.matchedEnd.match(i, c)) {
				scriptStringBuilder.append(startedScriptBlock.extractAndGenerate(template));
				templateCharsMatched.pos = i + 1;
				templateCharsMatched.chars = 0;
				startedScriptBlock = null;
				//endCorrection(template, i, templateCharsMatched);
				
				for (ScriptBlock scriptBlock : scriptBlocksSettings.getScriptBlocks()) {
					scriptBlock.clear();
				}
			}
		}
		
		if (templateCharsMatched.chars != 0) {
			scriptStringBuilder.append("write('");
			scriptStringBuilder.append(template.substring(templateCharsMatched.pos, templateCharsMatched.pos + templateCharsMatched.chars).replace("\\", "\\\\").replace("\r", "\\r").replace("\n", "\\n").replace("'", "\\'"));
			scriptStringBuilder.append("');\n");
		}
		
		return scriptStringBuilder.toString();
			
	}
	
	private void endCorrection(String template, int i, MarkMatchResult templateCharsMatched) {
		boolean wasEmpty = true;
		for (int j = i + 1; j < template.length(); j++) {
			char d = template.charAt(j);
			boolean isEmpty = d == '\t' || d == ' ';
			if (wasEmpty && d == '\r' || d == '\n') {
				templateCharsMatched.pos = j;
				break;
			} else if (!isEmpty) {
				break;
			}
			wasEmpty = isEmpty;
		}
	}

}
