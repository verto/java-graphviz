package net.javagraphviz;


/**
 * Graphviz engine to generate of graph output 
 * 
 * @author Everton Cardoso
 *
 */
public class GraphvizEngine {

	private String type;
	private Graph graph;
	
	/**
	 * create the engine. type defualt = xdot.
	 */
	public GraphvizEngine(Graph graph) {
		this.graph = graph;
		this.type = "xdot";
	}

	/**
	 * define the type of output
	 * 
	 */
	public GraphvizEngine type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * generate the output file 
	 * 
	 */
	public void output(String path) {
		
		
	}

	/**
	 * type of output
	 */
	public String type() {
		return this.type;
	}

}
