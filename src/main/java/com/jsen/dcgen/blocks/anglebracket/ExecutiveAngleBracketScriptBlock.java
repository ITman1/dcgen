package com.jsen.dcgen.blocks.anglebracket;

import com.jsen.dcgen.MarkMatchResult;
import com.jsen.dcgen.ScriptBlock;
import com.jsen.dcgen.script.ContentScriptBuilder;

public class ExecutiveAngleBracketScriptBlock extends ScriptBlock {
	private static final String BLOCK_START = "<?";
	private static final String BLOCK_END = "?>";
	
	public ExecutiveAngleBracketScriptBlock(ContentScriptBuilder contentScriptBuilder) {
		super(contentScriptBuilder, new MarkMatchResult(BLOCK_START), new MarkMatchResult(BLOCK_END));
	}
	
	@Override
	public void generate(String script) {
		contentScriptBuilder.append(script + "\n");
	}
}
