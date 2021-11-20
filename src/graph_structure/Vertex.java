package graph_structure;

public class Vertex<T> {
	
	//Attributes
	private T value;
	private int weight;
	
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

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	





	

	

}
