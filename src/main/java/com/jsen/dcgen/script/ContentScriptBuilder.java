package com.jsen.dcgen.script;

import javax.script.ScriptEngine;

public abstract class ContentScriptBuilder {
	private ScriptEngine scriptEngine;
	
	public ContentScriptBuilder(ScriptEngine scriptEngine) {
		this.scriptEngine = scriptEngine;
	}
	
	public ScriptEngine getScriptEngine() {
		return this.scriptEngine;
	}
	
	public abstract void output(String variable);
	public abstract void outputString(String text);
}
