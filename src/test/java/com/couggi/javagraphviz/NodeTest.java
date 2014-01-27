package com.couggi.javagraphviz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.couggi.javagraphviz.Digraph;
import com.couggi.javagraphviz.Node;

public class NodeTest {
	
	Node node;
	
	@Before
	public void onSetUp() {
		node = new Node("nodeTest", new Digraph("DigraphTest"));
	}
	
	@Test
	public void testOutput() {
		
		node.attr("shape").value("doublecircle");
		node.attr("color").value("#000");
		
		StringBuilder xAttr = new StringBuilder("");
		xAttr.append("color" + " = " + "\"#000\"");
		xAttr.append(", label" + " = " + "\"nodeTest\"");
		xAttr.append(", shape" + " = " + "\"doublecircle\"");
		StringBuilder xOut = new StringBuilder("nodeTest [" + xAttr.toString() + "];");
		
		assertEquals(xOut.toString(), node.output());
	}

}
