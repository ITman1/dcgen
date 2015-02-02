package com.jsen.dcgen.test;

import javax.script.ScriptException;

import org.junit.Assert;
import org.junit.Test;

import com.jsen.dcgen.DynamicContentProcessor;
import com.jsen.dcgen.script.engines.NativeJavaScriptEngineContentGenerator;

public class ScriptContentGeneratorsTest {

	/*@Test
	public void jsenJs() throws ScriptException, InstantiationException, IllegalAccessException {
		DynamicContentProcessor processor = new DynamicContentProcessor();
	
		String output = processor.process("test");
		Assert.assertEquals("test", output);
	}*/
	
	@Test
	public void nativeJs() throws ScriptException, InstantiationException, IllegalAccessException {
		DynamicContentProcessor processor = new DynamicContentProcessor(new NativeJavaScriptEngineContentGenerator());
	
		String output = processor.process("test");
		Assert.assertEquals("test", output);
	}
	
}
