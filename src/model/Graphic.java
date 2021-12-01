package model;

import java.util.ArrayList;

import graph_structure.Graph;
import graph_structure.Vertex;

public class Graphic {
	
	public final  int NO_PARENT = -1;
	public final  int INF = 9999;
	public final  int V = 16;
	
	private String message ;
	private ArrayList<String> messageList; 
	
	private Graph<Vertex<Integer>> graph;
	
	public Graphic() {
		this.message = "";
		this.messageList = new ArrayList<>();	
		
	}
	
	public void bestFasterWay(int start) {
		graph = new Graph<Vertex<Integer>>();

		Vertex<Integer> v1 = new Vertex<>(1);
		Vertex<Integer> v2 = new Vertex<>(2);
		Vertex<Integer> v3 = new Vertex<>(3);
		Vertex<Integer> v4 = new Vertex<>(4);
		Vertex<Integer> v5 = new Vertex<>(5);
		Vertex<Integer> v6 = new Vertex<>(6);
		Vertex<Integer> v7 = new Vertex<>(7);
		Vertex<Integer> v8 = new Vertex<>(8);
		Vertex<Integer> v9 = new Vertex<>(9);
		Vertex<Integer> v10 = new Vertex<>(10);
		Vertex<Integer> v11 = new Vertex<>(11);
		Vertex<Integer> v12 = new Vertex<>(12);
		Vertex<Integer> v13 = new Vertex<>(13);
		Vertex<Integer> v14 = new Vertex<>(14);
		Vertex<Integer> v15 = new Vertex<>(15);
		Vertex<Integer> v16 = new Vertex<>(16);


		graph.createVertex(v1);
		graph.createVertex(v2);
		graph.createVertex(v3);
		graph.createVertex(v4);
		graph.createVertex(v5);
		graph.createVertex(v6);
		graph.createVertex(v7);
		graph.createVertex(v8);
		graph.createVertex(v9);
		graph.createVertex(v10);
		graph.createVertex(v11);
		graph.createVertex(v12);
		graph.createVertex(v13);
		graph.createVertex(v14);
		graph.createVertex(v15);
		graph.createVertex(v16);

		graph.createEdge(v1, v2, 1);
		graph.createEdge(v1, v5, 9);
		graph.createEdge(v2, v3, 2);
		graph.createEdge(v2, v6, 23);
		graph.createEdge(v3, v4, 3);
		graph.createEdge(v3, v7, 24);
		graph.createEdge(v4, v8, 10);
		graph.createEdge(v5, v9, 8);
		graph.createEdge(v5, v6, 21);
		graph.createEdge(v6, v10, 18);
		graph.createEdge(v6, v7, 20);
		graph.createEdge(v7, v11, 19);
		graph.createEdge(v7, v8, 22);
		graph.createEdge(v9, v10, 13);
		graph.createEdge(v9, v13, 7);
		graph.createEdge(v10, v11, 16);
		graph.createEdge(v10, v14, 14);
		graph.createEdge(v11, v15, 15);
		graph.createEdge(v11, v12, 17);
		graph.createEdge(v12, v16, 12);
		graph.createEdge(v16, v15, 6);
		graph.createEdge(v15, v14, 5);
		graph.createEdge(v14, v13, 4);
		graph.createEdge(v8, v12, 11);

		int[][] adjacencyMatrixD =				
			{ { 0, 1, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 0, 2, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 2, 0, 3, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 3, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 9, 0, 0, 0, 0, 21, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 23, 0, 0, 21, 0, 20, 0, 0, 18, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 24, 0, 0, 20, 0, 22, 0, 0, 19, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 10, 0, 0, 22, 0, 0, 0, 0, 11, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 8, 0, 0, 0, 0, 13, 0, 0, 7, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 18, 0, 0, 13, 0, 16, 0, 0, 14, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 19, 0, 0, 6, 0, 17, 0, 0, 15, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 17, 0, 0, 0, 0, 12 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 4, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 4, 0, 5, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 5, 0, 6 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 6, 0 } };
		dijkstra(adjacencyMatrixD,start);

		int[][] adjacencyMatrixF =				
			{ { 0, 1, INF, INF, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF },
					{ 1, 0, 2, INF, INF, 23, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF },
					{ INF, 2, 0, 3, INF, INF, 24, INF, INF, INF, INF, INF, INF, INF, INF, INF },
					{ INF, INF, 3, 0, INF, INF, INF, 10, INF, INF, INF, INF, INF, INF, INF, INF },
					{ 9, INF, INF, INF, 0, 21, INF, INF, 8, INF, INF, INF, INF, INF, INF, INF },
					{ INF, 23, INF, INF, 21, 0, 20, INF, INF, 18, INF, INF, INF, INF, INF, INF },
					{ INF, INF, 24, INF, INF, 20, 0, 22, INF, INF, 19, INF, INF, INF, INF, INF },
					{ INF, INF, INF, 10, INF, INF, 22, 0, INF, INF, INF, 11, INF, INF, INF, INF },
					{ INF, INF, INF, INF, 8, INF, INF, INF, 0, 13, INF, INF, 7, INF, INF, INF },
					{ INF, INF, INF, INF, INF, 18, INF, INF, 13, 0, 16, INF, INF, 14, INF, INF },
					{ INF, INF, INF, INF, INF, INF, 19, INF, INF, 6, 0, 17, INF, INF, 15, INF },
					{ INF, INF, INF, INF, INF, INF, INF, 11, INF, INF, 17, 0, INF, INF, INF, 12 },
					{ INF, INF, INF, INF, INF, INF, INF, INF, 7, INF, INF, INF, 0, 4, INF, INF },
					{ INF, INF, INF, INF, INF, INF, INF, INF, INF, 14, INF, INF, 4, 0, 5, INF },
					{ INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 15, INF, INF, 5, 0, 6 },
					{ INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 12, INF, INF, 6, 0 } };
		floydWarshall(adjacencyMatrixF);
	}
	
	public void bestSecureWay(int start) {
		graph = new Graph<Vertex<Integer>>();

		Vertex<Integer> v1 = new Vertex<>(1);
		Vertex<Integer> v2 = new Vertex<>(2);
		Vertex<Integer> v3 = new Vertex<>(3);
		Vertex<Integer> v4 = new Vertex<>(4);
		Vertex<Integer> v5 = new Vertex<>(5);
		Vertex<Integer> v6 = new Vertex<>(6);
		Vertex<Integer> v7 = new Vertex<>(7);
		Vertex<Integer> v8 = new Vertex<>(8);
		Vertex<Integer> v9 = new Vertex<>(9);
		Vertex<Integer> v10 = new Vertex<>(10);
		Vertex<Integer> v11 = new Vertex<>(11);
		Vertex<Integer> v12 = new Vertex<>(12);
		Vertex<Integer> v13 = new Vertex<>(13);
		Vertex<Integer> v14 = new Vertex<>(14);
		Vertex<Integer> v15 = new Vertex<>(15);
		Vertex<Integer> v16 = new Vertex<>(16);

		graph.createVertex(v1);
		graph.createVertex(v2);
		graph.createVertex(v3);
		graph.createVertex(v4);
		graph.createVertex(v5);
		graph.createVertex(v6);
		graph.createVertex(v7);
		graph.createVertex(v8);
		graph.createVertex(v9);
		graph.createVertex(v10);
		graph.createVertex(v11);
		graph.createVertex(v12);
		graph.createVertex(v13);
		graph.createVertex(v14);
		graph.createVertex(v15);
		graph.createVertex(v16);

		graph.createEdge(v1, v2, 1);
		graph.createEdge(v1, v5, 2);
		graph.createEdge(v2, v3, 7);
		graph.createEdge(v2, v6, 5);
		graph.createEdge(v3, v4, 10);
		graph.createEdge(v3, v7, 9);
		graph.createEdge(v4, v8, 8);
		graph.createEdge(v5, v9, 8);
		graph.createEdge(v5, v6, 4);
		graph.createEdge(v6, v10, 2);
		graph.createEdge(v6, v7, 2);
		graph.createEdge(v7, v11, 1);
		graph.createEdge(v7, v8, 5);
		graph.createEdge(v9, v10, 3);
		graph.createEdge(v9, v13, 9);
		graph.createEdge(v10, v11, 2);
		graph.createEdge(v10, v14, 4);
		graph.createEdge(v11, v15, 2);
		graph.createEdge(v11, v12, 12);
		graph.createEdge(v12, v16, 9);
		graph.createEdge(v16, v15, 4);
		graph.createEdge(v15, v14, 4);
		graph.createEdge(v14, v13, 3);
		graph.createEdge(v8, v12, 13);

		int[][] adjacencyMatrixD =				
			{ { 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },//0
					{ 1, 0, 7, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },//1
					{ 0, 7, 0, 10, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0 },//2
					{ 0, 0, 10, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0 },//3
					{ 2, 0, 0, 0, 0, 4, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0 },//4
					{ 0, 5, 0, 0, 4, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0 },//5
					{ 0, 0, 9, 0, 0, 2, 0, 5, 0, 0, 1, 0, 0, 0, 0, 0 },//6
					{ 0, 0, 0, 8, 0, 0, 5, 0, 0, 0, 0, 3, 0, 0, 0, 0 },//7
					{ 0, 0, 0, 0, 8, 0, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0 },//8
					{ 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 2, 0, 0, 4, 0, 0 },//9
					{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 12, 0, 0, 2, 0 },//10
					{ 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 12, 0, 0, 0, 0, 9 },//11
					{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 4, 0, 0 },//12
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 3, 0, 4, 0 },//13
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 4, 0, 4 },//14
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 4, 0 } };//15
		// 0--1--2--3--4--5--6--7--8--9-10--11-12-13-14-15
		dijkstra(adjacencyMatrixD, start);

		int[][] adjacencyMatrixF = {
				{0, 1, INF, INF, 2, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
				{1, 0, 7, INF, INF, 5, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
				{INF, 7, 0, 10, INF, INF, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF},
				{INF, INF, 10, 0, INF, INF, INF, 8, INF, INF, INF, INF, INF, INF, INF, INF},
				{2, INF, INF, INF, 0, 4, INF, INF, 8, INF, INF, INF, INF, INF, INF, INF},
				{INF, 5, INF, INF, 4, 0, 2, INF, INF, 2, INF, INF, INF, INF, INF, INF},
				{INF, INF, 9, INF, INF, 2, 0, 5, INF, INF, 1, INF, INF, INF, INF, INF},
				{INF, INF, INF, 8, INF, INF, 5, 0, INF, INF, INF, 3, INF, INF, INF, INF},
				{INF, INF, INF, INF, 8, INF, INF, INF, 0, 3, INF, INF, 1, INF, INF, INF},
				{INF, INF, INF, INF, INF, 2, INF, INF, 3, 0, 2, INF, INF, 4, INF, INF},
				{INF, INF, INF, INF, INF, INF, 1, INF, INF, 2, 0, 12, INF, INF, 2, INF},
				{INF, INF, INF, INF, INF, INF, INF, 3, INF, INF, 12, 0, INF, INF, INF, 9},
				{INF, INF, INF, INF, INF, INF, INF, INF, 1, INF, INF, INF, 0, 4, INF, INF},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, 4, INF, INF, 3, 0, 4, INF},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 2, INF, INF, 4, 0, 4},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 9, INF, INF, 4, 0}
		};
		floydWarshall(adjacencyMatrixF);


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
				message = "";
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
		//printSolution(matrix);
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
