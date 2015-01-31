package com.jsen.dcgen.script;

import javax.script.ScriptEngine;

public abstract class ContentScriptEngine {
	private ScriptEngine scriptEngine;
	
	public ContentScriptEngine(ScriptEngine scriptEngine) {
		this.scriptEngine = scriptEngine;
	}
	
	public ScriptEngine getScriptEngine() {
		return this.scriptEngine;
	}
	
	public abstract void output(String variable);
	public abstract void outputString(String text);
}
