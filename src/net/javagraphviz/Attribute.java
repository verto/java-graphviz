package net.javagraphviz;

/**
 * representation of the {@link Component} attributes.
 * 
 * @author Everton Cardoso
 *
 */
public class Attribute {

	Attributes attributes;
	String name;
	String value;
	
	/**
	 * create the attribute with name.
	 */
	public Attribute(Attributes attributes, String name) { 
		this.attributes = attributes;
		this.name = name;
	}
	
	/**
	 * create the attribute with name and value
	 */
	public Attribute(Attributes attributes, String name, String value) { 
		this(attributes,name);
		this.value = value;
	}
	
	/**
	 * 
	 * set value of the attribute, if the value be null, then, the attribute will removed.
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
		if (this.value == null) { 
			this.remove();
		} else { 
			this.attributes.set(name,this);
		}
	}

	/**
	 * remove the attribute of the component.
	 */
	public void remove() {
		this.attributes.remove(name);
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
	public String value() {
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
		Attribute other = (Attribute) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
