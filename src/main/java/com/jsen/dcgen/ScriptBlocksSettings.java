package com.jsen.dcgen;

public class ScriptBlocksSettings {

	private ScriptBlock[] scriptBlocks;
	
	public ScriptBlock[] getScriptBlocks() {
		return scriptBlocks;
	}

	public void setScriptBlocks(ScriptBlock[] scriptBlocks) {
		this.scriptBlocks = scriptBlocks;
	}

	public ScriptBlocksSettings(ScriptBlock ...scriptBlocks) {
		this.scriptBlocks = scriptBlocks;
	}
	
}
