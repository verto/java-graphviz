package com.couggi.javagraphviz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Graphviz engine to generate of graph output 
 * 
 * @author Everton Cardoso
 *
 */
public class GraphvizEngine {

	private static final Logger log = Logger.getLogger("net.javagraphviz.GraphvizEngine");
	
	private String type;
	private Graph graph;
	
	/**
	 * create the engine. type defualt = xdot.
	 */
	public GraphvizEngine(Graph graph) {
		this.graph = graph;
		this.type = "xdot";
	}

	/**
	 * define the type of output
	 * 
	 */
	public GraphvizEngine type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * generate the output file 
	 * 
	 */
	public String output() {
		
		
		String dotContent = graph.output();
		
		try {
			// echo "digraph G {Hello->World}" | dot -Txdot
			String dotCommand = "/usr/bin/dot -T" + this.type;
			String command = "echo \"" + dotContent + "\" | " + dotCommand;
			String line;
			StringBuffer output = new StringBuffer();
	      Process p = Runtime.getRuntime().exec(command);
	      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	      while ((line = input.readLine()) != null) {
	    	  output.append(line);
	      }
	      input.close();
	      
	      return output.toString();
	      
		} catch (IOException e) {
			
			if (log.isLoggable(Level.SEVERE)) {
				log.log(Level.SEVERE,"command error",e);
			}
			throw new GraphvizOutputException(e.getMessage(),e);
			
		}
		
	}

	/**
	 * type of output
	 */
	public String type() {
		return this.type;
	}

}
