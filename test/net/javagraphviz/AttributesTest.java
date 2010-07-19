package net.javagraphviz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttributesTest {

	Attrs attributes;
	
	@Before
	public void onSetUp() {
		attributes = new Attrs(new Digraph("test"));
	}
	
	@Test
	public void testGet() {
		
		Attr attr = attributes.get("rankdir");
		assertEquals("rankdir", attr.name());
		assertEquals(null, attr.value());
		
	}
	
	@Test
	public void testGetWithValue() { 
		attributes.get("rankdir").value("#999");
		Attr attr = attributes.get("rankdir");
		assertEquals("#999", attr.value().toString());
	}
	
	@Test
	public void testSetAttribute() { 
		Attr attribute = new Attr(attributes, "rankdir");
		attributes.set("rankdir", attribute);
		assertEquals(1, attributes.total());
		assertEquals(attributes.get("rankdir"), attribute);
	}

}
