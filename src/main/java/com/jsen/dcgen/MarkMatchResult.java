package com.jsen.dcgen;

public class MarkMatchResult {
	public String tokenString;
	public int chars = 0;
	public int pos = -1;
	
	public MarkMatchResult(int chars, int pos) {
		this.pos = pos;
		this.chars = chars;
	}
	
	public MarkMatchResult(String tokenString) {
		this.tokenString = tokenString;
	}
	
	public boolean match(int pos, char c) {
		if (c == tokenString.charAt(chars) && chars == 0) {
			this.pos = pos;
		}
		
		if (c == tokenString.charAt(chars)) {
			this.chars++;
			
			if (this.chars == tokenString.length()) {
				return true;
			}
		} else {
			clear();
		}
		
		return false;
	}
	
	public void clear() {
		this.chars = 0;
		this.pos = -1;
	}
}
