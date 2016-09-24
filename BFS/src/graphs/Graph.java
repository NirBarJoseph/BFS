package graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.Completion;

public abstract class Graph<T> {
	
	List<Vertex<T>> vertexes = null;
	Map<Vertex<T>, List<Vertex<T>>> adjList = null;
	int[][] adjMatrix = null;
	
	public Graph(){
		this.vertexes = new ArrayList<>();
		this.adjList = new HashMap<>();
	}
	
	public Graph(List<Vertex<T>> vertexes){
		this.vertexes = new ArrayList<>();
		this.vertexes.addAll(vertexes);

		this.adjList = new HashMap<>();
		for(Vertex<T> ver : vertexes){
			this.adjList.put(ver, new LinkedList<Vertex<T>>());
		}
	}
	
	public Graph(Map<Vertex<T>, List<Vertex<T>>> adjList){
		//edges list
		this.adjList = new HashMap<>();
		this.adjList.putAll(adjList);;
		
		//vertexes list
		this.vertexes = new ArrayList<>();
		this.vertexes.addAll(adjList.keySet());
	}
	
/*	public Graph(int[][] adjMatrix){
		this.adjMatrix = adjMatrix;
	}*/

	public Map<Vertex<T>, List<Vertex<T>>> getAdjList() {
		return adjList;
	}

	public void setAdjList(Map<Vertex<T>, List<Vertex<T>>> adjList) {
		this.adjList = adjList;
	}

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}
	
	public int addVer(Vertex<T> ver){
		if(!this.vertexes.contains(ver)){
			this.vertexes.add(ver);
			this.adjList.put(ver, new LinkedList<Vertex<T>>());
			return 1;
		} else {
			System.out.println("Vertex already exiset");
			return 0;
		}
	}
	
	public abstract int addVer(Vertex<T> from, Vertex<T> to);
	
	public abstract int addEdge(Vertex<T> from, Vertex<T> to);
	
	public String toString(){
		StringBuilder out = new StringBuilder();
		for(Entry<Vertex<T>, List<Vertex<T>>> ver : this.adjList.entrySet()){
			out.append(ver.toString() + "\n");
		}
		return out.toString();
	}
	

	/*	BFS Algorithm	*/
	
	public void reset(){
		for(Vertex<T> vert : vertexes){
			vert.color = 0;
			vert.d = Integer.MAX_VALUE;
			vert.p = null;			
		}
	}
	
	public static <T> int BFS(Graph<T> G, Vertex<T> source){
		G.reset();
		source.color = 1;
		source.d = 0;
		source.p = null;
		
		Queue<Vertex<T>> Q = new LinkedList<>();
		Q.add(source);
		while (Q.isEmpty() == false){
			Vertex<T> u = Q.poll();
			for (Vertex<T> v : G.adjList.get(u)){
				if (v.color == 0){
					v.color = 1;
					v.d = u.d + 1;
					v.p = u;
					Q.add(v);
				}
			}
			System.out.format("The distance of \"%s\" from \"%s\" is: %d\n", u.getName(), source.getName(), u.d);
			u.color = 2;
		}
		for(Vertex<T> ver : G.vertexes){
			if(ver.d == Integer.MAX_VALUE){
				System.out.format("Vertex %s is unreachable from vertex %s\n", ver.getName(), source.getName());
			}
		}
		return 1;
	}
	
	/*	DFS Algorithm	*/
	
	public static <T> DirectedGraph<T> DFS(Graph<T> G){
		DirectedGraph<T> DFSGraph = new DirectedGraph<>();
		
		G.reset();
		int time = 0;
		Collections.sort(G.vertexes, new Comparator<Vertex<T>>(){

			@Override
			public int compare(Vertex<T> o1, Vertex<T> o2) {
				return o2.f - o1.f;
			}
			
		});
		for(Vertex<T> u : G.vertexes){
			if(u.color == 0){
				DFSGraph.addVer(u);
				time = G.DFS_Visit(u, time, DFSGraph);
			}
		}
		return DFSGraph;
	}
	
	public int DFS_Visit(Vertex<T> u, int time, Graph<T> DFSGraph){
		time++;
		u.d = time;
		u.color = 1;
		for(Vertex<T> v : this.getAdjList().get(u)){
			if(v.color == 0){
				v.p = u;
				DFSGraph.addVer(v);
				time = this.DFS_Visit(v, time, DFSGraph);
				DFSGraph.addEdge(u, v);
			}
		}
		u.color = 2;
		time++;
		u.f = time;
		return time;
	}

}




