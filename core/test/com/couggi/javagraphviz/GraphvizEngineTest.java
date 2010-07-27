package com.couggi.javagraphviz;

import static org.junit.Assert.assertEquals;

import java.io.File;

import junit.framework.Assert;

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
		engine.type("png");
		graph.addEdge(graph.addNode("Hello"), graph.addNode("World"));
		engine.fromDirectoryPath(".").toFilePath("xpto");
		engine.output();
		File file = new File("xpto");
		Assert.assertTrue(file.exists());
		
	}

}
