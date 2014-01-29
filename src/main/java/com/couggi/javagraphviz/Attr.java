package com.couggi.javagraphviz;

/**
 * representation of the {@link Component} attributes.
 * 
 * @author Everton Cardoso
 *
 */
public class Attr {

	private Attrs attrs;
	private String name;
	private AttrType value;
	
	/**
	 * create the attribute with name.
	 */
	public Attr(Attrs attributes, String name) { 
		this.attrs = attributes;
		this.name = name;
	}
	
	/**
	 * create the attribute with name and value
	 */
	public Attr(Attrs attributes, String name, String value) { 
		this(attributes,name);
		this.value = new EscString(value);
	}
	
	/**
	 * 
	 * set value of the attribute, if the value be null, then, the attribute will removed.
	 * 
	 */
	public void value(String value) {
		if (value == null) { 
			this.remove();
		} else { 
			this.value = new EscString(value);
			this.attrs.set(name,this);
		}
	}

	/**
	 * remove the attribute of the component.
	 */
	public void remove() {
		this.attrs.remove(name);
	}

	/**
	 * return the name of the attribute.
	 */
	public String name() {
		return name;
	}
	
	/**
	 * return the value of the attribute.
	 */
	public AttrType value() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attr other = (Attr) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
