package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UndirectedGraph<T> extends Graph<T> {
	
	
	public UndirectedGraph(){
		super();
	}
	
	public UndirectedGraph(List<Vertex<T>> vertexes){
		super(vertexes);
	}
	
	
	public int addVer(Vertex<T> from, Vertex<T> to){
		if(this.vertexes.contains(from)){
			if( ! this.vertexes.contains(to)){
				this.vertexes.add(to);
				this.adjList.put(to, new LinkedList<Vertex<T>>());
				this.adjList.get(to).add(to);

				this.addEdge(from, to);
				return 1;
			} else {
				System.out.println("Target vertex already exiset");
				return 0;
			}
		} else {
			System.out.println("From vertex dosen't exiset");
			return 0;
		}
	}
	
	public int addEdge(Vertex<T> from, Vertex<T> to){
		if(this.vertexes.contains(from) && this.vertexes.contains(to)){
			if( ! this.adjList.get(from).contains(to) ){
				this.adjList.get(from).add(to);
				this.adjList.get(to).add(from);
/*				
				from.getAdj().add(to);
				to.getAdj().add(from);*/
				return 1;
			}
			System.out.println("Edge already exiset");
			return 0;
		} else {
			System.out.println("Vertex dosen't exiset");
			return 0;
		}
	}

}
