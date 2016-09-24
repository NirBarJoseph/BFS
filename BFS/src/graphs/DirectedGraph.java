package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class DirectedGraph<T> extends Graph<T> {
	
	
	public DirectedGraph(){
		super();
	}
	
	public DirectedGraph(List<Vertex<T>> vertexes){
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
	
	public static <T> DirectedGraph<T> reverseGraph(DirectedGraph<T> graph){
		DirectedGraph<T> out = new DirectedGraph<>(graph.vertexes);
		for (Entry<Vertex<T>, List<Vertex<T>>> entry : graph.getAdjList().entrySet()){
			if( ! entry.getValue().isEmpty()){
				for(Vertex<T> vertex : entry.getValue()){
					out.addEdge(vertex, entry.getKey());
				}
			}
		}
		return out;
	}
	
	public static <T> DirectedGraph<T> topologicalSort (DirectedGraph<T> graph){
		DirectedGraph.DFS(graph);
		DirectedGraph<T> out = DirectedGraph.DFS(DirectedGraph.reverseGraph(graph));
		return out;
	}

}
