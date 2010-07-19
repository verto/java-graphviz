package net.javagraphviz;

public class Edge implements Component {

	private Graph graph;
	private Node nodeFrom;
	private Node nodeTo;
	private String name;
	private Attributes attributes;
	
	/**
	 * create edge with two nodes.
	 */
	public Edge(Node nodeFrom, Node nodeTo, Graph graph) {
		this.graph = graph;
		this.nodeFrom = nodeFrom;
		this.nodeTo = nodeTo;
		this.name = nodeFrom.name() + "_" + nodeTo.name();
		this.attributes = new Attributes(this);
	}
	
	/**
	 * node from
	 */
	public Node from() {
		return nodeFrom;
	}
	
	/**
	 * node to
	 */
	public Node to() {
		return nodeTo;
	}

	/* 
	 * @see net.javagraphviz.Component#name()
	 */
	public String name() {
		return this.name;
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
	
	/**
	 * edge default.
	 */
	private Edge(String name) { 
		this.name = name;
		this.attributes = new Attributes(this);
	}
	
	/**
	 * create the edge default
	 */
	static Edge getDefault(String name) { 
		return new Edge(name);
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
		Edge other = (Edge) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
