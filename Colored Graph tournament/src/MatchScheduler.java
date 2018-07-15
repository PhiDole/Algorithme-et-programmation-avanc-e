import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MatchScheduler<Vertex extends Comparable<Vertex>> {

	public static<Vertex extends Comparable<Vertex>> void scheduleMatch (UndirectedAdjGraph g) {
		
		List<Vertex> verticesList = g.vertices(); 
		
		Collections.sort(verticesList, new Comparator<Vertex>() {
	        public int compare(Vertex v1, Vertex v2)
	        {
	        	int d1  = g.outDegree(v1);
	        	int d2  = g.outDegree(v2);
	            return  d2-d1;
	        }
	    });
		
		while (!verticesList.isEmpty()) {
			List<Vertex> semaine = new ArrayList<>();
			semaine.add(verticesList.get(0));
			for (int i = 1; i<verticesList.size(); i++) {
				if (Collections.disjoint(semaine, g.outNeighbors(verticesList.get(i)))) {
					semaine.add(verticesList.get(i));
				}
			}
			verticesList.removeAll(semaine);
			g.getColors().add(semaine);
			
		}
	}
}
