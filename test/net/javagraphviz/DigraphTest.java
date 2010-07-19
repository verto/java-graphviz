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
		
		Attr attr =  digraph.attr("rankdir");
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
	
	@Test
	public void testOutput() { 
	
		digraph.attr("bgcolor").value("#000");
		digraph.node().attr("shape").value("doublecircle");
		digraph.edge().attr("shape").value("folder");
		Node nodeA = digraph.addNode("nodeA");
		nodeA.attr("fillcolor").value("#fff");
		Node nodeB = digraph.addNode("nodeB");
		nodeB.attr("shape").value("circle");
		Edge edge = digraph.addEdge(nodeA, nodeB);
		edge.attr("label").value("change_label");
		
		StringBuffer xData = new StringBuffer(" graph [bgcolor = \"#000\"];\n");
		xData.append(" node [shape = \"doublecircle\"];\n");
		xData.append(" edge [shape = \"folder\"];\n");
		xData.append(" nodeB [label = \"nodeB\", shape = \"circle\"];\n");
		xData.append(" nodeA [label = \"nodeA\", fillcolor = \"#fff\"];\n");
		xData.append(" nodeA -> nodeB [label = \"change_label\"];\n");
		
		StringBuffer out = new StringBuffer("digraph finite_state_machine {\n");
		out.append(xData).append("}");
		
		Assert.assertEquals(out.toString(), digraph.output());
	}
}
