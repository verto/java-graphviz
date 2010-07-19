package net.javagraphviz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attrs {

	private Component componenet;
	private Map<String, Attr> data;
	
	/**
	 * create attributes to the component.
	 * 
	 */
	public Attrs(Component component) { 
		this.componenet = component;
		this.data = new HashMap<String, Attr>();
	}

	/**
	 * return a attribute of the component.
	 * 
	 */
	public Attr get(String name) {
		Attr attr = this.data.get(name);
		if (attr == null)
			attr = new Attr(this,name);
		return attr;
	}

	/**
	 * create/update the attribute of the list.
	 */
	public void set(String name, Attr attribute) {
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
	
	public List<Attr> list() { 
		return new ArrayList<Attr>(data.values());
	}
}
