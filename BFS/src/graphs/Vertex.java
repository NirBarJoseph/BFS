package graphs;

import java.util.LinkedList;
import java.util.List;

public class Vertex<T> implements Comparable<T> {

	private String name = null;
	private T data = null;
	int color = 0;
	int d = Integer.MAX_VALUE;
	int f = Integer.MAX_VALUE;
	Vertex<T> p = null;
	
	public Vertex(String name, T data){
		this.name = name;
		this.data = data;
	}
	
	public Vertex(String name, T data, List<Vertex<T>> adj){
		this.name = name;
		this.data = data;
	}
	
	public String getName(){
		return this.name;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public int compareTo(Vertex<T> o) {
		return this.name.compareTo(o.getName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(T o) {
		return this.name.compareTo(((Vertex<T>) o).getName());
	}
	
	public String toString(){
		StringBuilder out = new StringBuilder("Vertex: ");
		out.append(name);
		return out.toString();
	}
	
}
