package com.couggi.javagraphviz;

public class SubGraph extends Digraph {

	public SubGraph(String name) {
		super("cluster_" +name);
	}
	
	@Override
	public String getType() {
		return "subgraph";
	}

}
