package helloworld;

import com.couggi.javagraphviz.Digraph;
import com.couggi.javagraphviz.Edge;
import com.couggi.javagraphviz.Graph;
import com.couggi.javagraphviz.GraphvizEngine;
import com.couggi.javagraphviz.Node;


public class HelloWorldSample {

	public static void main(String[] args) {
		
		// define a graph with the Digraph Type.
		Graph graph = new Digraph("G");
		graph.attr("rankdir").value("LR");
		graph.node().attr("shape").value("record");
		// create nodes with names 
		Node hello = graph.addNode("Hello");
		hello.attr("fixedsize").value("true");
		hello.attr("width").value("0.8");
		hello.attr("height").value("0.6");
		hello.attr("label").value("");
		Edge label = graph.addEdge(hello, hello);
		label.attr("taillabel").value("Mp1x123");
		label.attr("fontsize").value("7");
		label.attr("arrowtail").value("none");
		label.attr("arrowhead").value("none");
		label.attr("labeldistance").value("1.0");
		label.attr("labelangle").value("-60.0");
		// create a edge with hello node and world node.
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
