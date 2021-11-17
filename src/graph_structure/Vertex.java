package graph_structure;

public class Vertex<T> implements Comparable<Vertex<T>>{
	
	//Attributes
	private T value;
	//private int weight
	
	//Constructor
	public Vertex(T object) {
		this.value = object;
	}

	//Getter and setter
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}



	@Override
	public int compareTo(Vertex<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	

}
