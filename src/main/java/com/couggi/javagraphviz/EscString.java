package com.couggi.javagraphviz;

public class EscString implements AttrType {

	private String value;
	
	public EscString(String value) { 
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}

	public String toGv() {
		return "\""+ this.value + "\"";
	}
	
	

}
