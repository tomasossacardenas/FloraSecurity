package ui;

import graph_structure.Graph;
import graph_structure.Vertex;

public class Main {

	public static void main(String[] args) {
	
		Graph<Vertex<Integer>> graph = new Graph<Vertex<Integer>>();
		
		Vertex<Integer> v1 = new Vertex<>(1);
		graph.createVertex(v1);
		graph.createVertex(v1);
		
		
		
		

	}

}
