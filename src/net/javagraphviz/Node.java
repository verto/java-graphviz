package net.javagraphviz;

/**
 * the Node Component of graphviz tools.
 * 
 * @author Everton Cardoso
 *
 */
public class Node implements Component {

	private Graph graph;
	private String name;
	private Attributes attributes;
	
	/**
	 * create a node with name
	 */
	public Node(String name, Graph graph) {
		this.name = name;
		this.graph = graph;
		this.attributes = new Attributes(this);
	}
	
	/* 
	 * @see net.javagraphviz.Component#attribute(java.lang.String)
	 */
	@Override
	public Attribute attribute(String name) {
		return this.attributes.get(name);
	}

	/* 
	 * @see net.javagraphviz.Component#attributes()
	 */
	@Override
	public Attributes attributes() {
		return this.attributes;
	}
	
	/* 
	 * @see net.javagraphviz.Component#name()
	 */
	public String name() {
		return this.name;
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
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
