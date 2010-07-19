package net.javagraphviz;

public class EscString implements AttrType {

	private String value;
	
	public EscString(String value) { 
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public String toGv() {
		return "\""+ this.value + "\"";
	}
	
	

}
