package graph_structure;

public class Edge<T> {

	//Attributes 
	private T start;//start vertex
	private T end;//end vertex
	private T weight;//weight of the edge

	//Constructor
	public Edge(T start, T end, T weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	//Getters and setters	
	public void setStart(T start) {
		this.start = start;
	}

	public T getStart() {
		return start;
	}

	public void setEnd(T end) {
		this.end = end;
	}

	public T getEnd() {
		return end;
	}
	
	public void setWeight(T weight) {
		this.weight = weight;
	}
	
	public T getWeight() {
		return weight;
	}




	
}
