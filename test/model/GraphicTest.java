package model;

import org.junit.Assert;
import org.junit.Test;

import graph_structure.Graph;
import graph_structure.Vertex;

public class GraphicTest {
	
	private Graphic graphic;
	
	public void sc1() {    	
		graphic=new Graphic();
		Graph<Vertex<Integer>> graph = new Graph<Vertex<Integer>>();
		
		Vertex<Integer> v0 = new Vertex<>(0);
		Vertex<Integer> v1 = new Vertex<>(1);
		Vertex<Integer> v2 = new Vertex<>(2);
		Vertex<Integer> v3 = new Vertex<>(3);
		
		graph.createVertex(v0);
		graph.createVertex(v1);
		graph.createVertex(v2);
		graph.createVertex(v3);
		
		graph.createEdge(v0, v1, 4);
		graph.createEdge(v0, v2, 2);
		graph.createEdge(v2, v1, 1);
		graph.createEdge(v1, v3, 2);
		graph.createEdge(v2, v3, 5);
    }
	
	@Test
	public void dijsktraTest() {
		sc1();
		
		int[][] adjacencyMatrixD =				
			  { { 0, 4, 2, 0},
				{ 4, 0, 1, 2},
				{ 2, 1, 0, 5},
				{ 0, 2, 5, 0}};
		//graphic.dijkstra(adjacencyMatrixD, 0);
		
		int[] shortestDistancesWaited= new int[]{0,3,2,5};
		
		Assert.assertEquals(shortestDistancesWaited[0], graphic.dijkstra(adjacencyMatrixD, 0)[0]);
		Assert.assertEquals(shortestDistancesWaited[1], graphic.dijkstra(adjacencyMatrixD, 0)[1]);
		Assert.assertEquals(shortestDistancesWaited[2], graphic.dijkstra(adjacencyMatrixD, 0)[2]);
		Assert.assertEquals(shortestDistancesWaited[3], graphic.dijkstra(adjacencyMatrixD, 0)[3]);
	}

	@Test
	public void floydTest() {
		graphic=new Graphic();
		int inf = Integer.MAX_VALUE;

		int[][] matrix = {
				{0, 4, 2, inf},
				{4, 0, 1, 2},
				{2, 1, 0, 5},
				{inf, 2, 5, 0}
		};

		int[][] expected = {
				{0, 3, 2, 5},
				{3, 0, 1, 2},
				{2, 1, 0, 3},
				{5, 2, 3, 0}
		};

		int[][] actual = graphic.floydWarshall(matrix);

		for (int i = 0; i < expected.length; i++) {
			for (int j = 0; j < actual.length; j++) {
				Assert.assertEquals(actual[i][j],expected[i][j]);
			}
		}

	}
	
}
