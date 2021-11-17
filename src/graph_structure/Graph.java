package graph_structure;

import java.util.Hashtable;

import MyLinkedList_data_structure.MyLinkedList;

public class Graph<T> {
	
	private Hashtable<T,MyLinkedList<T>> adj_list = new Hashtable<>();
	
	//Create a vertex
    public void createVertex(T start)    {
    	adj_list.put(start, new MyLinkedList<T>());
    }
  
    // This function adds and edge between source to destination
    public void createEdge(T start,T end){      	
        if (!adj_list.containsKey(start)) {
        	createVertex(start);
        }          
  
        if (!adj_list.containsKey(end)) {
        	createVertex(end);
        }      
        
        adj_list.get(start).createNode(end);     
    }
	 


}
