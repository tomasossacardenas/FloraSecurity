package model;

public class Graphic {
	
	public final static int NO_PARENT = -1;
	public final static int INF = 9999;
	public final static int V = 16;

	
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
		
		for(int i=0;i<shortestDistances.length;i++) {
			System.out.print(shortestDistances[i]+"-");
		}

		
		return shortestDistances;
		//printSolution(startVertex, shortestDistances, parents);
	}
	

	// A utility function to print
	// the constructed distances
	// array and shortest paths
	private static void printSolution(int startVertex,
									int[] distances,
									int[] parents)
	{
		int nVertices = distances.length;
		System.out.print("Vertex\t  Distance\t Path");
		
		for (int vertexIndex = 0;vertexIndex < nVertices;vertexIndex++){
			if (vertexIndex != startVertex){
				System.out.print("\n" + startVertex + " -> ");
				System.out.print(vertexIndex + " \t\t ");
				System.out.print(distances[vertexIndex] + "\t\t");
				printPath(vertexIndex, parents);
			}
		}
	}

	// Function to print shortest path
	// from source to currentVertex
	// using parents array
	private static void printPath(int currentVertex,
								int[] parents)
	{
		
		// Base case : Source node has
		// been processed
		if (currentVertex == NO_PARENT)
		{
			return;
		}
		printPath(parents[currentVertex], parents);
		System.out.print(currentVertex + " ");
	}
	
	/*
	
// This code is contributed by Harikrishnan Rajan

	 * 
	 * 
	 * 
	 */
	public  void floydWarshall(int graph[][]) {
		int dist[][] = new int[V][V];
		int i, j, k;

		for (i = 0; i < V; i++){
			for (j = 0; j < V; j++){
				dist[i][j] = graph[i][j];		
			}
		}
		
		for (k = 0; k < V; k++){
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++){
				// Pick all vertices as destination for the
				// above picked source
				for (j = 0; j < V; j++){
					// If vertex k is on the shortest path from
					// i to j, then update the value of dist[i][j]
					if (dist[i][j] > dist[i][k] + dist[k][j] ) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
						
				}
			}
		}

		// Print the shortest distance matrix
		printSolution(dist);
	}
		  
	public void printSolution(int dist[][]){

		System.out.println("The following matrix shows the shortest "+
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
	
	/*
	public void dijkstra(int[][] adjacencyMatrix,int startVertex){
		
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
	}
	*/

}
