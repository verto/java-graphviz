package net.javagraphviz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttributesTest {

	Attributes attributes;
	
	@Before
	public void onSetUp() {
		attributes = new Attributes(new Digraph("test"));
	}
	
	@Test
	public void testGet() {
		
		Attribute attr = attributes.get("rankdir");
		assertEquals("rankdir", attr.name());
		assertEquals(null, attr.value());
		
	}
	
	@Test
	public void testGetWithValue() { 
		attributes.get("rankdir").setValue("#999");
		Attribute attr = attributes.get("rankdir");
		assertEquals("#999", attr.value());
	}
	
	@Test
	public void testSetAttribute() { 
		
		Attribute attribute = new Attribute(attributes, "rankdir");
		attributes.set("rankdir", attribute);
		assertEquals(attributes.total(), 1);
		assertEquals(attributes.get("rankdir"), attribute);
	}

}
