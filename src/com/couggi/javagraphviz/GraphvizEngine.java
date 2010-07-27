package com.couggi.javagraphviz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	 * directory path where the dot command will be executed.
	 */
	private String directoryPathExecute = ".";
	
	private String filePathOutput;
	
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
	public void output() {
		
		
		String dotContent = graph.output();
		
		try {
			String prog = findExecutable("dot");
			File tmpDot = createDotFileTemp("in",dotContent);
			String outputPath = filePathOutput;
			if (outputPath == null) { 
				File tmpOut = createDotFileTemp("out." + this.type);
				outputPath = tmpOut.getPath();
			} 
			
			String dotCommand = prog + " -T" + this.type + " -o" + outputPath + " " + tmpDot.getPath();
			Runtime.getRuntime().exec(dotCommand,null,new File(directoryPathExecute));
	      
		} catch (IOException e) {
			
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
	 * create a file temp.
	 * 
	 * @param dotContent
	 * @return
	 */
	private File createDotFileTemp(String suffix) {
		return createDotFileTemp(suffix,null);
	}

	/**
	 * type of output
	 */
	public String type() {
		return this.type;
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
	 * define where the output file will be generated.
	 * 
	 * @param fileOutput
	 */
	public GraphvizEngine toFilePath(String path) {
		this.filePathOutput = path;
		return this;
	}
	
	

}
