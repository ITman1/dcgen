package com.jsen.dcgen.blocks.anglebracket;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jsen.dcgen.MarkMatchResult;
import com.jsen.dcgen.ScriptBlock;
import com.jsen.dcgen.script.ContentScriptBuilder;

public class StatementAngleBracketScriptBlock extends ScriptBlock {
	private static final String BLOCK_START = "<:";
	private static final String BLOCK_END = ":>";
	
	public StatementAngleBracketScriptBlock(ContentScriptBuilder contentScriptBuilder) {
		super(contentScriptBuilder, new MarkMatchResult(BLOCK_START), new MarkMatchResult(BLOCK_END));
	}
	
	@Override
	public void generate(String script) {
		contentScriptBuilder.append(script + "\n");
	}
	
	@Override
	public String trailingString(String template) {
		String string = template.substring(this.matchedEnd.pos + this.matchedEnd.tokenString.length(), template.length());
        Matcher m = Pattern.compile("([\\t ]*\\n?)")
        		.matcher(string);
        while (m.find() && m.groupCount() > 0) {
        	return m.group(1);
        }
        
		return "";
	}
}
