package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

		Vertex<Integer> a = new Vertex<Integer>("a", 1);
		Vertex<Integer> b = new Vertex<Integer>("b", 2);
		Vertex<Integer> c = new Vertex<Integer>("c", 3);
		Vertex<Integer> d = new Vertex<Integer>("d", 4);
		Vertex<Integer> e = new Vertex<Integer>("e", 4);
		List<Vertex<Integer>> verset = new ArrayList<>();
		verset.add(a); verset.add(b); verset.add(c); 
		DirectedGraph<Integer> graph = new DirectedGraph<>(verset);
		graph.addVer(d);
		graph.addVer(e);
		graph.addVer(new Vertex<Integer>("f", 5));
				
		graph.addEdge(b,a);
		graph.addEdge(a,c);
		graph.addEdge(c,b);
		graph.addEdge(b,d);
		graph.addEdge(e,d);
		graph.addEdge(b,e);
		
		Graph.BFS(graph, a);
		
		System.out.println();
		
		System.out.println(Graph.DFS(graph));
		
		System.out.println();
		
		System.out.println(DirectedGraph.reverseGraph(Graph.DFS(graph)));
		
		System.out.println();
		
		System.out.println(DirectedGraph.topologicalSort(graph));

	}

}
