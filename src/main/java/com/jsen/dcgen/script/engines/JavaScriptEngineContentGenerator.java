package com.jsen.dcgen.script.engines;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import com.jsen.core.GlobalObjectScriptSettings;
import com.jsen.core.ScriptEngineManager;
import com.jsen.dcgen.script.ContentScriptBuilder;
import com.jsen.dcgen.script.ScriptEngineContentGenerator;
import com.jsen.dcgen.script.builders.JavaScriptContentScriptBuilder;

public class JavaScriptEngineContentGenerator extends ScriptEngineContentGenerator {

	public JavaScriptEngineContentGenerator(Object globalObject) {
		this(getScriptEngine(globalObject), new JavaScriptContentScriptBuilder());
	}
	
	public JavaScriptEngineContentGenerator() {
		this(new Object());
	}
	
	public JavaScriptEngineContentGenerator(ScriptEngine scriptEngine, ContentScriptBuilder scriptBuilder) {
		super(scriptEngine, scriptBuilder);
	}
	
	@Override
	public String generate(String script) throws ScriptException {
		scriptEngine.eval(script);
		
		String flushFunction = contentScriptBuilder.getFlushFunctionName();
		try {
			Object content = ((Invocable)scriptEngine).invokeFunction(flushFunction);
			if (content instanceof String) {
				return (String)content;
			} else {
				throw new ScriptException("Flush function returned non-String content.");
			}
		} catch (NoSuchMethodException e) {
			throw new ScriptException("Function that flushes the output is not defined");
		}
	}
	
	protected static ScriptEngine getScriptEngine(Object globalObject) {

        return ScriptEngineManager.getInstance().getBrowserScriptEngine("text/javascript", 
        		new GlobalObjectScriptSettings<Object>(globalObject)
        );
	}

}
