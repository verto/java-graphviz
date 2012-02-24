package com.couggi.javagraphviz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * the Digraph Component of graphviz tools.
 * 
 * @author Everton Cardoso
 *
 */
public class Digraph implements Graph {

	private String name;
	
	private Attrs attrs;
	
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
	
	private List<SubGraph> subGraphs;
	
	
	/**
	 * create a Digraph with name.
	 */
	public Digraph(String name) {
		this.name = name;
		this.attrs = new Attrs(this);
		this.nodeDefault = Node.getDefault(name);
		this.edgeDefault = Edge.getDefault(name);
		this.nodes = new HashMap<String, Node>();
		this.edges = new HashMap<String, Edge>();
		this.subGraphs = new ArrayList<SubGraph>();
	}

	/* 
	 * @see net.javagraphviz.Component#attribute(java.lang.String)
	 */
	public Attr attr(String key) {
		return this.attrs.get(key);
	}

	/* 
	 * @see net.javagraphviz.Component#attributes()
	 */
	@Override
	public Attrs attrs() {
		return this.attrs;
	}
	
	/**
	 * return the digraph name.
	 */
	public String name() {
		return this.name;
	}

	
	/* 
	 * @see net.javagraphviz.Graph#node()
	 */
	public Node node() {
		return this.nodeDefault;
	}

	
	/* 
	 * @see net.javagraphviz.Graph#addNode(java.lang.String)
	 */
	public Node addNode(String name) {
		Node node = new Node(name,this);
		nodes.put(name, node);
		return node;
	}

	/* 
	 * @see net.javagraphviz.Graph#addEdge(net.javagraphviz.Node, net.javagraphviz.Node)
	 */
	public Edge addEdge(Node nodeFrom, Node nodeTo) {
		if (!containsNode(nodeFrom) || !containsNode(nodeFrom))
			throw new IllegalArgumentException("nodes not found");
		Edge edge = new Edge(nodeFrom,nodeTo,this);
		edges.put(edge.name(),edge);
		return edge;
	}

	
	public boolean containsNode(Node node) {
		boolean contains = this.nodes().contains(node);
		if (!contains)
			for (Graph graph : subGraphs) { 
				contains = graph.containsNode(node);
				if (contains)break;
			}
		return contains;
	}

	/* 
	 * @see net.javagraphviz.Graph#edge()
	 */
	public Edge edge() {
		return this.edgeDefault;
	}

	@Override
	public List<Edge> edges() {
		return new ArrayList<Edge>(this.edges.values());
	}

	@Override
	public List<Node> nodes() {
		return new ArrayList<Node>(this.nodes.values());
	}
	
	public List<SubGraph> subGraphs() { 
		return this.subGraphs;
	}

	@Override
	public String type() {
		return "digraph";
	}
	
	@Override
	public String getType() {
		return type();
	}

	@Override
	public String output() {
		
		StringBuffer xDOTScript = new StringBuffer("");
	    String xSeparator = "";
	    StringBuffer xData = new StringBuffer("");
	    
	    // mount the graph attributes
	    if (!this.attrs.list().isEmpty()) {
		    for (Attr attr : this.attrs.list()) {
		    	xData.append(xSeparator + attr.name() + " = " + attr.value().toGv());
		          xSeparator = ", ";
		    }
		    xDOTScript.append(" graph [" + xData + "];");
	    }
	    
	    //reset variables
	    xSeparator = "";
	    xData = new StringBuffer("");
	    
	    // mount the node attributes
	    if (!this.node().attrs().list().isEmpty()) { 
		    for (Attr attr : this.node().attrs().list()) {
		    	xData.append(xSeparator + attr.name() + " = " + attr.value().toGv());
		          xSeparator = ", ";
		    }
		    xDOTScript.append(" node [" + xData + "];");
	    }
	    
	    //reset variables
	    xSeparator = "";
	    xData = new StringBuffer("");
	    
	    // mount the edge attributes
	    if (!this.edge().attrs().list().isEmpty()) {
		    for (Attr attr : this.edge().attrs().list()) {
		    	xData.append(xSeparator + attr.name() + " = " + attr.value().toGv());
		          xSeparator = ", ";
		    }
		    xDOTScript.append(" edge [" + xData + "];");
	    }
	    
	    //reset variables
	    xSeparator = "";
	    xData = new StringBuffer("");
	    
	    // mount the subgraph
	    for (SubGraph subGraph : subGraphs) { 
	    	xDOTScript.append(xSeparator + subGraph.output());
	    }
	    
	    // mount components output
	    // nodes
	    for (Component component : this.nodes()) {
	    	xDOTScript.append(" " + component.output() + "");
	    }
	    //edges
	    for (Component component : this.edges()) {
	    	xDOTScript.append(" " + component.output() + "");
	    }
	    
	    // structure final
	    xDOTScript = new StringBuffer(this.type())
	    				          .append(" ")
	    				          .append(this.name())
	    				          .append(" {")
	    				          .append(xDOTScript)
	    				          .append("}");
	    
	    return (xDOTScript.toString());
		
	}

	public void addSubGraph(SubGraph graph) {
		this.subGraphs.add(graph);
	}

	

}
