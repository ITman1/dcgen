package com.jsen.dcgen.blocks.anglebracket;

import com.jsen.dcgen.ScriptBlocksSettings;
import com.jsen.dcgen.script.ContentScriptBuilder;

public class AngleBracketSettings extends ScriptBlocksSettings {
	public AngleBracketSettings(ContentScriptBuilder contentScriptBuilder) {
		super(contentScriptBuilder, 
				new ExecutiveAngleBracketScriptBlock(contentScriptBuilder), 
				new StatementAngleBracketScriptBlock(contentScriptBuilder), 
				new OutputAngleBracketScriptBlock(contentScriptBuilder)
		);
	}
}
