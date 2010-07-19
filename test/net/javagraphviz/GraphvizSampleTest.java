package net.javagraphviz;

import junit.framework.Assert;

import org.junit.Test;

public class GraphvizSampleTest {
	
	@Test
	public void generateHelloWorld() { 
		
		Digraph digraph = new Digraph("digraph");
		digraph.attribute("rankdir").setValue("LR");
		digraph.attribute("size").setValue("8,5");
		digraph.node().attribute("shape").setValue("doublecircle");
		digraph.edge().attribute("shape").setValue("folder");
		Node nodeA = digraph.addNode("nodeA");
		Node nodeB = digraph.addNode("nodeB");
		digraph.addEdge(nodeA,nodeB);
		
		new GraphvizEngine(digraph).type("xdot").output("helloworld.xdot");
	}
	
}
