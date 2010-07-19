package net.javagraphviz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphvizEngineTest {

	GraphvizEngine engine;
	Graph graph;
	
	@Before
	public void onSetUp() {
		graph = new Digraph("test");
		this.engine = new GraphvizEngine(graph);
	}
	
	@Test
	public void testGraphvizEngineTypeDefault() {
		assertEquals("xdot",engine.type());
	}

	@Test
	public void testOutput() {
		fail("Not yet implemented");
	}

}
