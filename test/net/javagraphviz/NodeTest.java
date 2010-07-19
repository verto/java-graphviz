package net.javagraphviz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		
		StringBuffer xAttr = new StringBuffer("");
		xAttr.append("color" + " = " + "\"#000\"");
		xAttr.append(", label" + " = " + "\"nodeTest\"");
		xAttr.append(", shape" + " = " + "\"doublecircle\"");
		StringBuffer xOut = new StringBuffer("nodeTest [" + xAttr.toString() + "];");
		
		assertEquals(xOut.toString(), node.output());
	}

}
