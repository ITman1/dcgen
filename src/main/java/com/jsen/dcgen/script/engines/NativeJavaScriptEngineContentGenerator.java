package com.jsen.dcgen.script.engines;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.jsen.dcgen.script.ContentScriptBuilder;
import com.jsen.dcgen.script.builders.JavaScriptContentScriptBuilder;

public class NativeJavaScriptEngineContentGenerator extends JavaScriptEngineContentGenerator {

	public NativeJavaScriptEngineContentGenerator() {
		this(getNativeScriptEngine(), new JavaScriptContentScriptBuilder());
	}
	
	public NativeJavaScriptEngineContentGenerator(ScriptEngine scriptEngine, ContentScriptBuilder scriptBuilder) {
		super(scriptEngine, scriptBuilder);
	}
	
	protected static ScriptEngine getNativeScriptEngine() {
        return new ScriptEngineManager().getEngineByName("javascript");
	}

}
