package com.couggi.javagraphviz;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

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
		SubGraph subGraph = new SubGraph("hello_world");
		Node hello = subGraph.addNode("hello");
		Node world = subGraph.addNode("world");
		subGraph.addEdge(hello, world);
		digraph.addSubGraph(subGraph);
		
		StringBuffer xData = new StringBuffer("graph [bgcolor = \"#000\"];");
		xData.append(" node [shape = \"doublecircle\"];");
		xData.append(" edge [shape = \"folder\"];");
		xData.append("subgraph cluster_hello_world {");
		xData.append(" hello [label = \"hello\"];");
		xData.append(" world [label = \"world\"];");
		xData.append(" hello -> world;");
		xData.append("}");
		xData.append(" nodeB [label = \"nodeB\", shape = \"circle\"];");
		xData.append(" nodeA [label = \"nodeA\", fillcolor = \"#fff\"];");
		xData.append(" nodeA -> nodeB [label = \"change_label\"];");
		
		StringBuffer out = new StringBuffer("digraph finite_state_machine { ");
		out.append(xData).append("}");
		
		Assert.assertEquals(out.toString(), digraph.output());
	}
	
	@Test
	public void testAddSubGraph() { 
		SubGraph subGraph = new SubGraph("G");
		subGraph.attr("label").value("hello_world");
		Node hello = subGraph.addNode("hello");
		Node world = subGraph.addNode("world");
		subGraph.addEdge(hello, world);
		
		digraph.addSubGraph(subGraph);
		
		Assert.assertEquals(Arrays.asList(subGraph), digraph.subGraphs());
	}
	
	@Test
	public void testAddTwoSubGraphAndDefineExternalNodesRelationship() { 
		SubGraph subGraphOne = new SubGraph("G");
		subGraphOne.attr("label").value("hello_world");
		Node hello = subGraphOne.addNode("hello");
		Node world = subGraphOne.addNode("world");
		subGraphOne.addEdge(hello, world);
		Graph subGraphTwo = new Digraph("G");
		Node cat = subGraphTwo.addNode("cat");
		Node dog = subGraphTwo.addNode("dog");
		subGraphTwo.addEdge(cat, dog);
		digraph.addSubGraph(subGraphOne);
		
		Edge edge = digraph.addEdge(hello, dog);
		
		Assert.assertEquals(subGraphOne,edge.from().graph());
		Assert.assertEquals(subGraphTwo,edge.to().graph());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidateIfExistsNodesWhenDefineExternalNodesRelationship() { 
		SubGraph subGraphOne = new SubGraph("G");
		subGraphOne.attr("label").value("hello_world");
		Node hello = subGraphOne.addNode("hello");
		Node world = subGraphOne.addNode("world");
		subGraphOne.addEdge(hello, world);
		SubGraph subGraphTwo = new SubGraph("G");
		Node cat = subGraphTwo.addNode("cat");
		Node dog = subGraphTwo.addNode("dog");
		subGraphTwo.addEdge(cat, dog);
		digraph.addSubGraph(subGraphOne);
		Graph graphOrphan = new Digraph("G");
		Node nodeOphan = graphOrphan.addNode("node_orphan");
		
		digraph.addEdge(nodeOphan, dog);
	}
	
	
}
