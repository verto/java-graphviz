package com.couggi.javagraphviz;

/**
 * the graph components (node, edges, etc)
 * 
 * @author Everton Cardoso
 *
 */
public interface Component {

	/**
	 * return the attribute of the component.
	 * 
	 */
	Attr attr(String name);

	Attrs attrs();
	
	/**
	 * name of the componenet.
	 */
	String name();
	
	
	/**
	 * output the component structure 
	 */
	String output();
	
	
}
