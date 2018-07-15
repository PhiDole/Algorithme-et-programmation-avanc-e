import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UndirectedAdjGraph<Vertex extends Comparable<Vertex>> extends Graph<Vertex> {

	private final Map<Vertex, List<Vertex>> adjacency = new TreeMap<>();
	private List<List<Vertex>> colors = new ArrayList<>();

	@Override
	public void addEdge(Vertex s, Vertex t) {
		m++;		
		if(!adjacency.containsKey(s))
			addVertex(s);
		if(!adjacency.containsKey(t))
			addVertex(t);
		
		List<Vertex> se = adjacency.get(s);
		se.add(t);
		List<Vertex> te = adjacency.get(t);
		te.add(s);
	}

	@Override
	public void addVertex(Vertex v) {
		n++;
		adjacency.put(v, new LinkedList<>());
		
	}

	@Override
	public List<Vertex> vertices() {
		List<Vertex> out = new ArrayList<>();
		out.addAll(adjacency.keySet());
		
		return out;
	}

	
	public List<Vertex> inEdges(Vertex vertice) {
		return adjacency.get(vertice);
	}

	
	public List<Vertex> outEdges(Vertex vertice) {
		
		return inEdges(vertice);
	}

	@Override
	public List<Vertex> inNeighbors(Vertex v) {
		List<Vertex> out = new LinkedList<>();
		
		for(Vertex e: adjacency.get(v))
			out.add(e);
		
		return out;
	}

	@Override
	public List<Vertex> outNeighbors(Vertex v) {
		
		return inNeighbors(v);
	}

	@Override
	public int inDegree(Vertex v) {
		
		return adjacency.get(v).size();
	}

	@Override
	public int outDegree(Vertex v) {
		return inDegree(v);
	}
	
	public List<List<Vertex>> getColors(){
		return colors;
	}
	
	public void printColors() {
		for (List<Vertex> color : colors) {
			System.out.println(color);
		}
	}
}
