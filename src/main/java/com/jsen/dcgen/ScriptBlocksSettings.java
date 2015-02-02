package com.jsen.dcgen;

import com.jsen.dcgen.script.ContentScriptBuilder;

public class ScriptBlocksSettings {

	private ScriptBlock[] scriptBlocks;
	private ContentScriptBuilder contentScriptBuilder;
	
	public ScriptBlocksSettings(ContentScriptBuilder contentScriptBuilder) {
		this.contentScriptBuilder = contentScriptBuilder;
	}
	
	public ContentScriptBuilder getContentScriptBuilder() {
		return contentScriptBuilder;
	}
	
	public ScriptBlock[] getScriptBlocks() {
		return scriptBlocks;
	}

	public void setScriptBlocks(ScriptBlock[] scriptBlocks) {
		this.scriptBlocks = scriptBlocks;
	}

	public ScriptBlocksSettings(ContentScriptBuilder contentScriptBuilder, ScriptBlock ...scriptBlocks) {
		this.scriptBlocks = scriptBlocks;
	}
	
}
