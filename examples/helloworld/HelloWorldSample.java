package helloworld;

import com.couggi.javagraphviz.Digraph;
import com.couggi.javagraphviz.Graph;
import com.couggi.javagraphviz.GraphvizEngine;
import com.couggi.javagraphviz.Node;


public class HelloWorldSample {

	public static void main(String[] args) {
		
		// define a graph with the Digraph Type.
		Graph graph = new Digraph("G");
		// create nodes with names 
		Node hello = graph.addNode("Hello");
		Node world = graph.addNode("World");
		// create a edge with hello node and world node.
		graph.addEdge(hello, world);
		// create the Graphviz engine to the graph
		GraphvizEngine engine = new GraphvizEngine(graph);
		// define the type of the output 
		engine.type("png");
		// define the file name of the output.
		engine.toFilePath("helloworld.png");
		// generate output.
		engine.output();
		
	}
}
