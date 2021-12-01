package model;

import java.util.ArrayList;

public class Graphic {
	
	public final  int NO_PARENT = -1;
	public final  int INF = 9999;
	public final  int V = 16;
	
	public String message ;
	public ArrayList<String> messageList; 
	
	public Graphic() {
		this.message = " ";
		this.messageList = new ArrayList<>();	
		
	}
	
	public int[] dijkstra(int[][] adjacencyMatrix,int startVertex){
	
		int nVertices = adjacencyMatrix[0].length;

		// shortestDistances[i] will hold the
		// shortest distance from src to i
		  
		int[] shortestDistances = new int[nVertices];

		// added[i] will true if vertex i is
		// included / in shortest path tree
		// or shortest distance from src to
		// i is finalized
		 
		boolean[] added = new boolean[nVertices];

		// Initialize all distances as
		// INFINITE and added[] as false
		 
		for (int vertexIndex = 0; vertexIndex < nVertices;vertexIndex++){
			shortestDistances[vertexIndex] = Integer.MAX_VALUE;
			added[vertexIndex] = false;
		}
		
		// Distance of source vertex from
		// itself is always 0
		shortestDistances[startVertex] = 0;

		// Parent array to store shortest
		// path tree
		int[] parents = new int[nVertices];

		// The starting vertex does not
		// have a parent
		parents[startVertex] = NO_PARENT;

		// Find shortest path for all
		// vertices
		for (int i = 1; i < nVertices; i++)
		{

			// Pick the minimum distance vertex
			// from the set of vertices not yet
			// processed. nearestVertex is
			// always equal to startNode in
			// first iteration.
			 
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0;vertexIndex < nVertices;vertexIndex++){
				if (!added[vertexIndex] && shortestDistances[vertexIndex] <	shortestDistance){
					nearestVertex = vertexIndex;
					shortestDistance = shortestDistances[vertexIndex];
				}
			}

			// Mark the picked vertex as
			// processed
			added[nearestVertex] = true;

			// Update dist value of the
			// adjacent vertices of the
			// picked vertex.
			 
			for (int vertexIndex = 0;vertexIndex < nVertices;vertexIndex++)	{
				int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
				
				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])){
					parents[vertexIndex] = nearestVertex;
					shortestDistances[vertexIndex] = shortestDistance +	edgeDistance;
				}
			}
		}
		
		
		
		printSolution(startVertex, shortestDistances, parents);
		//System.out.println("SIZE"+messageList.size());
		return shortestDistances;
		
	}
	

	// A utility function to print
	// the constructed distances
	// array and shortest paths

	private  void printSolution(int startVertex,int[] distances,int[] parents){
		int nVertices = distances.length;
		
		//System.out.print("Vertex\t  Distance\t Path");
		
		for (int vertexIndex = 0;vertexIndex < nVertices;vertexIndex++){
			if (vertexIndex != startVertex){
				//System.out.print("\n" + startVertex + " -> ");
				//System.out.print(vertexIndex + " \t\t ");
				//System.out.print(distances[vertexIndex] + "\t\t");
				printPath(vertexIndex, parents);
				//System.out.println("MESSAGE:"+message);
				messageList.add(message);
				message = " ";
			}
		}
	}
	

	// Function to print shortest path
	// from source to currentVertex
	// using parents array
	private  void printPath(int currentVertex,int[] parents){
		
		// Base case : Source node has
		// been processed
		if (currentVertex == NO_PARENT)	{
			return;
		}
		printPath(parents[currentVertex], parents);
		message += currentVertex + " ";
		//System.out.print(currentVertex + " ");
	}
	
	/*
	
// This code is contributed by Harikrishnan Rajan

	 * 
	 * 
	 * 
	 */
	
	public int[][] floydWarshall(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (matrix[j][i] != Integer.MAX_VALUE && matrix[i][k] != Integer.MAX_VALUE) {
						if (matrix[j][k] > matrix[j][i] + matrix[i][k]) {
							matrix[j][k] = matrix[j][i] + matrix[i][k];
						}
					}
				}
			}
		}
		printSolution(matrix);
		return matrix;
	}
	
	public void printSolution(int dist[][]){

		System.out.println("\nThe following matrix shows the shortest "+
				"distances between every pair of vertices");
		for (int i=0; i<V; ++i){
			for (int j=0; j<V; ++j){
				if (dist[i][j]==INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j]+"   ");
			}
			System.out.println();
		}
	}

	
	
	public void setMessageList(ArrayList<String> messageList) {
		this.messageList = messageList;
	}
	
	public ArrayList<String> getMessageList() {
		return messageList;
	}

}
