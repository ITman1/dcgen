package com.jsen.dcgen.blocks.anglebracket;

import com.jsen.dcgen.ScriptBlocksSettings;

public class AngleBracketSettings extends ScriptBlocksSettings {
	public AngleBracketSettings() {
		super(
				new ExecutiveAngleBracketScriptBlock(), 
				new StatementAngleBracketScriptBlock(), 
				new OutputAngleBracketScriptBlock()
		);
	}
}
