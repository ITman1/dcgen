package com.jsen.dcgen;

public abstract class ScriptBlock {
	public ScriptBlock(MarkMatchResult matchedStart, MarkMatchResult matchedEnd) {
		this.matchedStart = matchedStart;
		this.matchedEnd = matchedEnd;
	}
	
	protected MarkMatchResult matchedStart;
	protected MarkMatchResult matchedEnd;
	
	public void clear() {
		this.matchedStart.clear();
		this.matchedEnd.clear();
	}
	
	public String extractAndGenerate(String template) {
		String script = extract(template);
		return generate(script);
	}
	
	public String extract(String template) {
		return template.substring(this.matchedStart.pos + this.matchedStart.tokenString.length(), this.matchedEnd.pos -1).trim();
	}
	
	public abstract String generate(String script);
	
	protected void templateStartScriptBlockCorrection(String template, MarkMatchResult templateCharsMatched) {
	}
}
