package graph_structure;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import MyLinkedList_data_structure.MyLinkedList;
import MyLinkedList_data_structure.Node;

public class Graph<T> {
	
	private Hashtable<T,MyLinkedList<T>> adj_list;
	private ArrayList<Edge<T>> edges_list;
	
	public Graph() {
		adj_list = new Hashtable<>();
		edges_list = new ArrayList<>();
	}
	
	//Create a vertex
    public void createVertex(T start)    {
    	adj_list.put(start, new MyLinkedList<T>());
    }
  
    // This function adds and edge between source to destination
    public void createEdge(T start,T end, double weight){      	
        if (!adj_list.containsKey(start)) {
        	createVertex(start);
        }          
  
        if (!adj_list.containsKey(end)) {
        	createVertex(end);
        }      
        
        Edge<T> edge = new Edge<>(start,end,weight);
        boolean hasIt = false;
        for (int i=0;i<edges_list.size();i++) {
        	if (edges_list.get(i).getStart().equals(start) && edges_list.get(i).getEnd().equals(end)) {
        		hasIt = true;
        	}
        }
        
        if (hasIt==false) {
        	edges_list.add(edge);
        }
        
          
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
    
    
    
    public T getVertex(T value) {
    	boolean exit = false;
    	T vertex = null;
    	Enumeration<T> keys = adj_list.keys();
    	    	
    	while (keys.hasMoreElements() && !exit) {
    		if(keys.equals(value)) {
    			vertex = value;
    			exit = true;
    		}    	
    	}
    	return vertex;
    	
    }
    
    public Edge<T> getEdge(double weight) {
    	Edge<T> edge = null;
    	boolean exit = false;
    	for (int i=0;i<edges_list.size() && !exit;i++) {
    		if (edges_list.get(i).getWeight()==weight) {
    			edge = edges_list.get(i);
    			exit = true;
    		}
    	}
    	return edge;
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
    
    public Node<T> deleteVertex(Node<T> delete) {
    	MyLinkedList<T> temp = adj_list.get(delete.getElement());//Obtengo la lista adyacente de la key    	
    	Node<T> current = temp.getFirst();
		while(current!=null) {//elimino delete de cada nodo adyacente
			adj_list.get(current.getElement()).deleteNode(delete);
			current = current.getNext();
		}
		
		adj_list.remove(delete.getElement());
		return delete;
    }
    
    public Edge<T> deleteEdge(double weight) {// al eliminar la arista, su peso se pone en 0
    	//T start = null;
    	//T end = null;
    	Edge<T> edge = null;
    	boolean exit = false;
    	for (int i=0;i<edges_list.size() && !exit;i++) {
    		if (edges_list.get(i).getWeight()==weight) {
    			//start = edges_list.get(i).getStart();
    			//end = edges_list.get(i).getEnd();
    			edges_list.get(i).setWeight(0);
    			edge = edges_list.get(i);
    			exit = true;
    		}
    	}    	
    	return edge;   	
    }
}
