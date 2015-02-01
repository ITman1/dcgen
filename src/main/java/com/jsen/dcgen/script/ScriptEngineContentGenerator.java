package com.jsen.dcgen.script;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public abstract class ScriptEngineContentGenerator {
	protected ScriptEngine scriptEngine;
	protected ContentScriptBuilder contentScriptBuilder;
	
	public ScriptEngineContentGenerator(ScriptEngine scriptEngine, ContentScriptBuilder contentScriptBuilder) {
		this.scriptEngine = scriptEngine;
		this.contentScriptBuilder = contentScriptBuilder;
	}
	
	public ScriptEngine getScriptEngine() {
		return this.scriptEngine;
	}
	
	public ContentScriptBuilder getContentScriptBuilder() {
		return contentScriptBuilder;
	}
	
	public abstract String generate(String script) throws ScriptException ;
}
