package graphs;

public class Edge<T> {
	
	Vertex<T> from = null;
	Vertex<T> to = null;
	
	
	public Edge(Vertex<T> from, Vertex<T> to){
		this.from = from;
		this.to = to;
	}


	public Vertex<T> getFrom() {
		return from;
	}


	public void setFrom(Vertex<T> from) {
		this.from = from;
	}


	public Vertex<T> getTo() {
		return to;
	}


	public void setTo(Vertex<T> to) {
		this.to = to;
	}

	public String toString(){
		StringBuilder out = new StringBuilder("Edges from: ");
		out.append(from.getName());
		out.append(" to: ");
		out.append(to.getName());
		return out.toString();
	}
	
}
