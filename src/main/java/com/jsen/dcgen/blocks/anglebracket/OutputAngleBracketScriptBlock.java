package com.jsen.dcgen.blocks.anglebracket;

import com.jsen.dcgen.MarkMatchResult;
import com.jsen.dcgen.ScriptBlock;

public class OutputAngleBracketScriptBlock extends ScriptBlock {
	private static final String BLOCK_START = "<%";
	private static final String BLOCK_END = "%>";
	
	public OutputAngleBracketScriptBlock() {
		super(new MarkMatchResult(BLOCK_START), new MarkMatchResult(BLOCK_END));
	}
	
	@Override
	public String generate(String script) {
		return "write(" + script + ");\n";
	}
}
