package graphs;

import java.util.Comparator;

public class FinalTimeComp<T> implements Comparator<Vertex<T>>{
 
    public int compare(Vertex<T> ver1, Vertex<T> ver2) {
    	
    	if(ver1.f < ver2.f){
    		return 1;
    	} else {
    		return -1;
    	}
    }
}
