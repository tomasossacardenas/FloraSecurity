package graph_structure;

import java.util.ArrayList;
import java.util.Hashtable;

import MyLinkedList_data_structure.MyLinkedList;
import MyLinkedList_data_structure.Node;

public class Graph<T> {
	
	private Hashtable<T,MyLinkedList<T>> adj_list;
	
	public Graph() {
		adj_list = new Hashtable<>();
	}
	
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
	 
    public ArrayList<Node<T>> adjacent(T value) {
    	MyLinkedList<T> temp = new MyLinkedList<>();
    	ArrayList<Node<T>> adjacentV = new ArrayList<>();  	

    	if (adj_list.containsKey(value)==true) {
    		temp = adj_list.get(value);
    		Node<T> current = temp.getFirst();
    		while(current!=null) {
    			adjacentV.add(current);
    			current = current.getNext();
    		}

    	}
    	return adjacentV;    	
    }
    
    
    
    public void getVertex(T value) {
    	for (int i=0;i<adj_list.size();i++) {
    		if (adj_list.containsKey(value)==true) {
    			
    		}
    	}
    	
    }
    
    public void getEdge() {
    	
    }
    
    public boolean isEmpty() {
    	boolean empty = false;
    	if (adj_list.size()==0) {
    		empty = true;
    	}else {
    		empty = false;
    	}
    	return empty;
    }
    
    public void deleteVertex() {
    	
    }
    
    public void deleteEdge() {
    	
    }


}
