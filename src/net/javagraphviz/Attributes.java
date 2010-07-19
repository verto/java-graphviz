package net.javagraphviz;

import java.util.HashMap;
import java.util.Map;

public class Attributes {

	private Component componenet;
	private Map<String, Attribute> data;
	
	/**
	 * create attributes to the component.
	 * 
	 */
	public Attributes(Component component) { 
		this.componenet = component;
		this.data = new HashMap<String, Attribute>();
		this.data.put("label", new Attribute(this, "label",component.name()));
	}

	/**
	 * return a attribute of the component.
	 * 
	 */
	public Attribute get(String name) {
		Attribute attr = this.data.get(name);
		if (attr == null)
			attr = new Attribute(this,name);
		return attr;
	}

	/**
	 * create/update the attribute of the list.
	 */
	public void set(String name, Attribute attribute) {
		this.data.put(name, attribute);
	}

	/**
	 * total of the attributes.
	 * 
	 */
	public int total() {
		return this.data.size();
	}

	/**
	 * remove the attribute of the data.
	 * 
	 */
	public void remove(String name) {
		this.data.remove(name);
	}
}
