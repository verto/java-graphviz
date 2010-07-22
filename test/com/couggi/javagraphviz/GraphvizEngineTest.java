package com.couggi.javagraphviz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.couggi.javagraphviz.Digraph;
import com.couggi.javagraphviz.Graph;
import com.couggi.javagraphviz.GraphvizEngine;

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
		graph.addEdge(graph.addNode("Hello"), graph.addNode("World"));
		String xDotContent = engine.output();
		
	}

}
