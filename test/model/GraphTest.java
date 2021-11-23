package model;

import MyLinkedList_data_structure.Node;
import graph_structure.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GraphTest {

    private Graph<Integer> graph;

    public void sc1() {
        graph = new Graph<>();
        graph.createVertex(10);
        graph.createVertex(5);
        graph.createEdge(10, 5, 3);
    }

    public void sc2() {
        graph = new Graph<>();
    }

    public void sc3() {
        graph = new Graph<>();
        graph.createVertex(10);
        graph.createVertex(5);
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
        graph.createVertex(5);
        boolean finalEmptyState = graph.isEmpty(); //Should be false, because vertex has been added.
        Assert.assertTrue(initialEmptyState);
        Assert.assertFalse(finalEmptyState);
    }

    @Test
    public void removeVertexTest() {
        sc2();
        graph.createVertex(5);
        boolean initialEmptyState = graph.isEmpty(); //Should be false, because graph is not empty.
        graph.deleteVertex(); //Give previously created vertex as parameter.
        boolean finalEmptyState = graph.isEmpty(); //Should be true. The only vertex was deleted.
        Assert.assertTrue(finalEmptyState);
        Assert.assertFalse(initialEmptyState);
    }

    @Test
    public void getVertexTest() {
        sc1();
        int expected = 5;
        int returned = graph.getVertex(expected);
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void adjacentTest() {
        sc1();
        int vertex = graph.getVertex(5);
        ArrayList<Node<Integer>> adjacentList = graph.adjacent(vertex);
        Assert.assertEquals(1, adjacentList.size());
    }

    //Edge Tests

    @Test
    public void createEdgeTest() {
        sc3();
        ArrayList<Node<Integer>> adjacentList = graph.adjacent(10);
        boolean initialAdjacentListState = adjacentList.isEmpty(); //Should be true. No adjacent vertex.
        graph.createEdge(10, 5, 3);
        boolean finalAdjacentListState = adjacentList.isEmpty(); //Should be false. 5 and 10 are now adjacent vertexes.
        Assert.assertTrue(initialAdjacentListState);
        Assert.assertFalse(finalAdjacentListState);
    }

    @Test
    public void removeEdgeTest() {
        sc1();
        ArrayList<Node<Integer>> adjacentList = graph.adjacent(10);
        boolean initialAdjacentListState = adjacentList.isEmpty(); //Should be false. 5 and 10 are adjacent vertexes.
        graph.deleteEdge(3);
        boolean finalAdjacentListState = adjacentList.isEmpty(); //Should be true. 5 and 10 are not any more adjacent vertexes.
        Assert.assertTrue(finalAdjacentListState);
        Assert.assertFalse(initialAdjacentListState);
    }

}
