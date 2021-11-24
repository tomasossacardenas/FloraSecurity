package model;

import graph_structure.Graph;
import graph_structure.Vertex;
import org.junit.Assert;
import org.junit.Test;

import MyLinkedList_data_structure.Node;

import java.util.ArrayList;

public class GraphTest {

    private Graph<Vertex<Integer>> graph;
    private ArrayList<Vertex<Integer>> list;

    public void sc1() {    	
        graph = new Graph<>();    
        list = new ArrayList<>();
        Vertex<Integer> v1 = new Vertex<>(10);
        Vertex<Integer> v2 = new Vertex<>(5);
        graph.createVertex(v1);
        graph.createVertex(v2);
        graph.createEdge(v1, v2, 3);
        list.add(v1);
        list.add(v2);
    }

    public void sc2() {
        graph = new Graph<>();
    }

    public void sc3() {    	
        graph = new Graph<>();
        list = new ArrayList<>();
        Vertex<Integer> v1 = new Vertex<>(10);
        Vertex<Integer> v2 = new Vertex<>(5);
        graph.createVertex(v1);
        graph.createVertex(v2);
        list.add(v1);
        list.add(v2);
    }

    //Graph Tests

    @Test
    public void isEmptyTest() {
        sc2();
        Assert.assertTrue(graph.isEmpty());
    }

    //Vertex Tests

    @Test
    public void createVertexTest() {
        sc2();
        boolean initialEmptyState = graph.isEmpty(); //Should be true, because graph is empty.
        Vertex<Integer> v2 = new Vertex<>(5);
        graph.createVertex(v2);
        boolean finalEmptyState = graph.isEmpty(); //Should be false, because vertex has been added.
        Assert.assertTrue(initialEmptyState);
        Assert.assertFalse(finalEmptyState);
    }

    @Test
    public void removeVertexTest() {
        sc2();
        Vertex<Integer> v2 = new Vertex<>(5);
        graph.createVertex(v2);
        boolean initialEmptyState = graph.isEmpty(); //Should be false, because graph is not empty.
        graph.deleteVertex(v2); //Give previously created vertex as parameter.
        boolean finalEmptyState = graph.isEmpty(); //Should be true. The only vertex was deleted.
        Assert.assertTrue(finalEmptyState);
        Assert.assertFalse(initialEmptyState);
    }

    @Test
    
    public void getVertexTest() {
        sc1();
        Vertex<Integer> expected = list.get(1) ;        
        Vertex<Integer> returned = graph.getVertex(expected).getFirst().getElement();
        Assert.assertEquals(expected, returned);
    }
    

    @Test
    public void adjacentTest() {
        sc1();        
        Vertex<Integer> vertex = graph.getVertex(list.get(0)).getFirst().getElement();
        ArrayList<Node<Vertex<Integer>>> adjacentList = graph.adjacent(vertex);
        Assert.assertEquals(1, adjacentList.size());
    }

    //Edge Tests

    @Test
    public void createEdgeTest() {
        sc3();        
        ArrayList<Node<Vertex<Integer>>> adjacentList = graph.adjacent(list.get(0));
        boolean initialAdjacentListState = adjacentList.isEmpty(); //Should be true. No adjacent vertex.
        
        graph.createEdge(list.get(0), list.get(1), 3);
        adjacentList = graph.adjacent(list.get(0));
        
        boolean finalAdjacentListState = adjacentList.isEmpty(); //Should be false. 5 and 10 are now adjacent vertexes.        
        Assert.assertTrue(initialAdjacentListState);
        Assert.assertFalse(finalAdjacentListState);
    }

    @Test
    public void removeEdgeTest() {
        sc1();
        ArrayList<Node<Vertex<Integer>>> adjacentList = graph.adjacent(list.get(0));
        boolean initialAdjacentListState = adjacentList.isEmpty(); //Should be false. 5 and 10 are adjacent vertexes.
        graph.deleteEdge(3);
        adjacentList = graph.adjacent(list.get(0));
        boolean finalAdjacentListState = adjacentList.isEmpty(); //Should be true. 5 and 10 are not any more adjacent vertexes.
        Assert.assertFalse(initialAdjacentListState);
        Assert.assertTrue(finalAdjacentListState);
        
    }

}
