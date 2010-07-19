package net.javagraphviz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttributeTest {

	Attributes attributes;
	Component component;
	
	@Before
	public void onSetUp() {
		component = new Digraph("test");
		this.attributes = new Attributes(component);
	}
	
	@Test
	public void testAttribute() {
		Attribute attribute = new Attribute(attributes,"rankdir");
		assertEquals("rankdir",attribute.name());
		assertEquals(null,attribute.value());
	}

	@Test
	public void testSetValue() {
		component.attribute("rankdir").setValue("#999");
		assertEquals("#999", component.attribute("rankdir").value());
		
	}
	
	@Test
	public void testSetValueWithNullRemovedAttribute() {
		component.attribute("rankdir").setValue("#999");
		component.attribute("rankdir").setValue(null);
		assertEquals(0, component.attributes().total());
	}
	
	@Test
	public void testRemoveTheAttribute() { 
		component.attribute("rankdir").setValue("#000");
		component.attribute("rankdir").remove();
		assertEquals(0, component.attributes().total());
	}

}
