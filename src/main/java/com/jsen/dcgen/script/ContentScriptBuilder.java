package com.jsen.dcgen.script;


public abstract class ContentScriptBuilder {
	private StringBuilder scriptStringBuilder = new StringBuilder();
	
	protected String outputFunctionName;
	protected String flushFunctionName;
	
	protected ContentScriptBuilder() {
		this.outputFunctionName = defineOutputFunction();
		this.flushFunctionName = defineFlushFunction();
	}
	
	public abstract String defineOutputFunction();
	public abstract String defineFlushFunction();
	
	public abstract void outputVariable(String variable);
	public abstract void outputString(String text);
	
	public String getOutputFunctionName() {
		return outputFunctionName;
	}
	
	public String getFlushFunctionName() {
		return flushFunctionName;
	}
	
	public void append(String script) {
		scriptStringBuilder.append(script);
	}
	
	public String build() {
		String script = scriptStringBuilder.toString();
		scriptStringBuilder = new StringBuilder();
		return script;
	}
}
