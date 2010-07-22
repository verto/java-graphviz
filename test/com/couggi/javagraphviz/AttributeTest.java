package com.couggi.javagraphviz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.couggi.javagraphviz.Attr;
import com.couggi.javagraphviz.Attrs;
import com.couggi.javagraphviz.Component;
import com.couggi.javagraphviz.Digraph;

public class AttributeTest {

	Attrs attributes;
	Component component;
	
	@Before
	public void onSetUp() {
		component = new Digraph("test");
		this.attributes = new Attrs(component);
	}
	
	@Test
	public void testAttribute() {
		Attr attribute = new Attr(attributes,"rankdir");
		assertEquals("rankdir",attribute.name());
		assertEquals(null,attribute.value());
	}

	@Test
	public void testSetValue() {
		component.attr("rankdir").value("#999");
		assertEquals("#999", component.attr("rankdir").value().toString());
		
	}
	
	@Test
	public void testSetValueWithNullRemovedAttribute() {
		component.attr("rankdir").value("#999");
		component.attr("rankdir").value(null);
		assertEquals(0, component.attrs().total());
	}
	
	@Test
	public void testRemoveTheAttribute() { 
		component.attr("rankdir").value("#000");
		component.attr("rankdir").remove();
		assertEquals(0, component.attrs().total()); 
	}

}
