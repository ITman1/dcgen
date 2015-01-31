package com.jsen.dcgen.blocks.anglebracket;

import com.jsen.dcgen.MarkMatchResult;
import com.jsen.dcgen.ScriptBlock;

public class StatementAngleBracketScriptBlock extends ScriptBlock {
	private static final String BLOCK_START = "<:";
	private static final String BLOCK_END = ":>";
	
	public StatementAngleBracketScriptBlock() {
		super(new MarkMatchResult(BLOCK_START), new MarkMatchResult(BLOCK_END));
	}
	
	@Override
	public String generate(String script) {
		return script + "\n";
	}
	
	protected void templateStartScriptBlockCorrection(String template, MarkMatchResult templateCharsMatched) {
		boolean wasEmpty = true;
		for (int j = templateCharsMatched.pos + templateCharsMatched.chars - 1; j >= 0; j--) {
			char d = template.charAt(j);
			boolean isEmpty = d == '\t' || d == ' ';
			if (wasEmpty && d == '\r' || d == '\n') {
				templateCharsMatched.chars = j - templateCharsMatched.pos;
				break;
			} else if (!isEmpty) {
				break;
			}
			wasEmpty = isEmpty;
		}
	}
}
