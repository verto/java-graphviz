package com.couggi.javagraphviz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	private Map<String,OutputType> type;
	private Graph graph;
	/**
	 * directory path where the dot command will be executed.
	 */
	private String directoryPathExecute = ".";
	
	/**
	 * create the engine. type defualt = xdot.
	 */
	public GraphvizEngine(Graph graph) {
		this.graph = graph;
		this.type = new HashMap<String,OutputType>();
		this.type.put("png",new OutputType("png"));
	}

	/**
	 * generate the output file 
	 * 
	 */
	public void output() {
		
		
		String dotContent = graph.output();
		
		try {
			String prog = findExecutable("dot");
			File tmpDot = createDotFileTemp("in",dotContent);
			
			StringBuffer outputTypes = new StringBuffer();
			for (OutputType type : this.type.values()){ 
				outputTypes.append(" -T")
						   .append(type.name())
						   .append(" -o")
						   .append(type.filePath());
			}
			
			String dotCommand = prog + outputTypes + " " + tmpDot.getPath();
			Process process = Runtime.getRuntime().exec(dotCommand,null,new File(directoryPathExecute));
			
			@SuppressWarnings("unused")
			int exitVal = process.waitFor();
			
			
	      
		} catch (IOException e) {
			
			if (log.isLoggable(Level.SEVERE)) {
				log.log(Level.SEVERE,"command error",e);
			}
			throw new GraphvizOutputException(e.getMessage(),e);
			
		} catch (InterruptedException e) {
			
			if (log.isLoggable(Level.SEVERE)) {
				log.log(Level.SEVERE,"command error",e);
			}
			throw new GraphvizOutputException(e.getMessage(),e);
		}
		
	}

	
	private String findExecutable(String prog) {
		
		String[] paths = System.getenv().get("PATH").split(File.pathSeparator); 
	    for (String path : paths) {    
	    	String file = (path == null) ? prog : (path + File.separator + prog);
	      if (new File(file).canExecute() && !new File(file).isDirectory()) {
	    	  return file;
	      }
	    }
	    return null;
	}
	
	/**
	 * create a file temp with the content of the dot.
	 * 
	 * @param dotContent
	 * @return
	 */
	private File createDotFileTemp(String suffix, String dotContent) {
		try {
			File temp = File.createTempFile("graph",suffix);
			if (dotContent != null) { 
				BufferedWriter out = new BufferedWriter(new FileWriter(temp));
				out.write(dotContent);
				out.close();
			}
		    return temp;
		} catch (IOException e) {
			throw new GraphvizOutputException(e.getMessage(),e);
		}
	}
	
	/**
	 * type of output
	 */
	public List<OutputType> types() {
		return new ArrayList<OutputType>(type.values());
	}

	/**
	 * define where the dot command will be executed.
	 * 
	 * @param dir
	 * @return
	 */
	public GraphvizEngine fromDirectoryPath(String path) {
		this.directoryPathExecute = path;
		return this;
	}

	
	/**
	 * set or add a ouput type.
	 * 
	 * @param name
	 * @return
	 */
	public OutputType type(String name) { 
		
		OutputType output = type.get(name);
		if (output == null) { 
			output = new OutputType(name);
			type.put(name,output);
		}
		
		return this.type.get(name);
	}
	
	/**
	 * remove a output type.
	 */
	public GraphvizEngine removeType(String name) { 
		if (type.size() == 1) { 
			throw new IllegalStateException("must be a type defined.");
		}
		
		type.remove(name);
		
		return this;
	}

	/**
	 * set filePath of the output type. only used method when exist a output type.
	 * 
	 * @param filePath
	 */
	public GraphvizEngine toFilePath(String filePath) {
		if (this.type.size() > 1) { 
			throw new IllegalStateException("there was more of a type defined.");
		}
		
		this.type.values().iterator().next().toFilePath(filePath);
		
		return this;
	}
	
	

}
