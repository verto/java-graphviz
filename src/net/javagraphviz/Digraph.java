package net.javagraphviz;

import java.util.HashMap;
import java.util.Map;


/**
 * the Digraph Component of graphviz tools.
 * 
 * @author Everton Cardoso
 *
 */
public class Digraph implements Graph {

	private String name;
	
	private Attributes attributes;
	
	/**
	 * representation of general node attributes 
	 */
	private Node nodeDefault;
	
	/**
	 * representation of general node attributes 
	 */
	private Edge edgeDefault;
	
	/**
	 * nodes of the graph
	 */
	private Map<String, Node> nodes;
	
	/**
	 * edges of the graph
	 */
	private Map<String, Edge> edges;
	
	
	/**
	 * create a Digraph with name.
	 */
	public Digraph(String name) {
		this.name = name;
		this.attributes = new Attributes(this);
		this.nodeDefault = new Node("default",this);
		this.edgeDefault = Edge.getDefault(name);
		this.nodes = new HashMap<String, Node>();
		this.edges = new HashMap<String, Edge>();
	}

	/* 
	 * @see net.javagraphviz.Component#attribute(java.lang.String)
	 */
	public Attribute attribute(String key) {
		return this.attributes.get(key);
	}

	/* 
	 * @see net.javagraphviz.Component#attributes()
	 */
	@Override
	public Attributes attributes() {
		return this.attributes;
	}
	
	/**
	 * return the digraph name.
	 */
	public String name() {
		return this.name;
	}

	/**
	 * attributes default of the nodes.
	 */
	public Node node() {
		return this.nodeDefault;
	}

	/**
	 * create a node with name to graph.
	 */
	public Node addNode(String name) {
		Node node = new Node(name,this);
		nodes.put(name, node);
		return node;
	}

	/**
	 * create a edge with two nodes.
	 */
	public Edge addEdge(Node nodeFrom, Node nodeTo) {
		Edge edge = new Edge(nodeFrom,nodeTo,this);
		edges.put(edge.name(),edge);
		return edge;
	}

	/**
	 * attributes default of the edges.
	 */
	public Edge edge() {
		return this.edgeDefault;
	}

	

}
