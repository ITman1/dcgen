package com.jsen.dcgen;

import com.jsen.dcgen.script.ContentScriptBuilder;

public abstract class ScriptBlock {
	protected ContentScriptBuilder contentScriptBuilder;
	
	protected MarkMatchResult matchedStart;
	protected MarkMatchResult matchedEnd;
	
	public ScriptBlock(ContentScriptBuilder contentScriptBuilder, MarkMatchResult matchedStart, MarkMatchResult matchedEnd) {
		this.matchedStart = matchedStart;
		this.matchedEnd = matchedEnd;
		
		this.contentScriptBuilder = contentScriptBuilder;
	}
	
	public void clear() {
		this.matchedStart.clear();
		this.matchedEnd.clear();
	}
	
	public void extractAndGenerate(String template) {
		String script = extract(template);
		generate(script);
	}
	
	public String extract(String template) {
		return template.substring(this.matchedStart.pos + this.matchedStart.tokenString.length(), this.matchedEnd.pos -1).trim();
	}
	
	public abstract void generate(String script);
}
