package com.couggi.javagraphviz;

import java.util.List;

/**
 * type Graph component of the graphviz tools.
 * 
 * @author Everton Cardoso
 *
 */
public interface Graph extends Component {

	/**
	 * attributes default of the nodes.
	 */
	Node node();
	
	/**
	 * attributes default of the edges.
	 */
	Edge edge();
	
	/**
	 * list of the nodes.
	 */
	List<Node> nodes();
	
	/**
	 * list of the edges.
	 */
	List<Edge> edges();
	
	/**
	 * type of the Graph componenet (graph, digraph.. etc)
	 */
	String type();
	
	/**
	 * create a node with name to graph.
	 */
	Node addNode(String name);
	
	/**
	 * create a edge with two nodes.
	 */
	Edge addEdge(Node nodeFrom, Node nodeTo);
	
	boolean containsNode(Node node);
}
