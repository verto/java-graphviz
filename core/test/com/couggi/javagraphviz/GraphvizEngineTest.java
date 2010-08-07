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
		assertEquals(1,engine.types().size());
		assertEquals("png",engine.types().get(0).name());
	}
	
	@Test
	public void testOutput() {
		engine.type("png");
		graph.addEdge(graph.addNode("Hello"), graph.addNode("World"));
		engine.fromDirectoryPath(".");
		engine.output();
		File file = new File("default.png");
		Assert.assertTrue(file.exists());
		
	}
	
	@Test
	public void testTwoOutputFiles() { 
		
		engine.type("png").toFilePath("xpto.png");
		engine.type("imap").toFilePath("xpto.map");
		graph.addEdge(graph.addNode("Hello"), graph.addNode("World"));
		engine.fromDirectoryPath(".");
		engine.output();
		File png = new File("xpto.png");
		File map = new File("xpto.map");
		Assert.assertTrue(png.exists());
		Assert.assertTrue(map.exists());
		
	}
	
	@Test
	public void testToFilePath() { 
		
		engine.toFilePath("test.png");
		Assert.assertEquals(1, engine.types().size());
		Assert.assertEquals("test.png", engine.types().get(0).filePath());
	}

}
