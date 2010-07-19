package net.javagraphviz;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DigraphTest {

	Digraph digraph;
	
	@Before
	public void onSetUp() {
		digraph = new Digraph("finite_state_machine");
	}
	
	@Test
	public void getAttribute() { 
		
		Attribute attr =  digraph.attribute("rankdir");
		Assert.assertEquals("rankdir",attr.name());
		Assert.assertEquals(null,attr.value());
	}
	
	@Test
	public void addNode() { 
		Node node = digraph.addNode("nodeA");
		Assert.assertEquals(new Node("nodeA", digraph), node);
	}
	
	@Test
	public void addEdge() { 
		Node nodeFrom = digraph.addNode("nodeFrom");
		Node nodeTo = digraph.addNode("nodeTo");
		Edge edge = digraph.addEdge(nodeFrom, nodeTo);
		Assert.assertEquals(new Edge(nodeFrom,nodeTo,digraph), edge);
	}
}
