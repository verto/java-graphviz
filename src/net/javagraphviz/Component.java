package net.javagraphviz;

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
	Attribute attribute(String name);

	Attributes attributes();
	
	/**
	 * name of the componenet.
	 */
	String name();
	
	
}
