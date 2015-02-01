package com.jsen.dcgen.script.builders;

import com.jsen.dcgen.script.ContentScriptBuilder;

public class JavaScriptContentScriptBuilder extends ContentScriptBuilder {

	private final static String OUTPUT_CONTENT_VARIABLE = "$$output";
	private final static String OUTPUT_FUNCTION_NAME = "$$write";
	private final static String FLUSH_FUNCTION_NAME = "$$flush";
	
	@Override
	public String defineOutputFunction() {
		append(
				"var " + OUTPUT_CONTENT_VARIABLE + " = '';\n" +
				"function " + OUTPUT_FUNCTION_NAME + " (text) {\n" +
				"    " + OUTPUT_CONTENT_VARIABLE + " = " + OUTPUT_CONTENT_VARIABLE + " + text;\n" +
				"}\n\n");
		return OUTPUT_FUNCTION_NAME;
	}
	
	@Override
	public String defineFlushFunction() {
		append(
				"function " + FLUSH_FUNCTION_NAME + " () {\n" +
				"    var output = " + OUTPUT_CONTENT_VARIABLE + ";\n" +
				"    " + OUTPUT_CONTENT_VARIABLE + " = '';\n" +
				"    return output;\n" +
				"}\n\n");
		return FLUSH_FUNCTION_NAME;
	}
	
	@Override
	public void outputVariable(String variable) {
		append(OUTPUT_FUNCTION_NAME + "(");
		append(variable);
		append(");\n");
	}

	@Override
	public void outputString(String text) {
		append(OUTPUT_FUNCTION_NAME + "('");
		append(text.replace("\\", "\\\\").replace("\r", "\\r").replace("\n", "\\n").replace("'", "\\'"));
		append("');\n");
	}

}
