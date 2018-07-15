import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GraphFactory {
	
	public static UndirectedAdjGraph<String> createGraphFromTextFile(String path) {
		
		UndirectedAdjGraph<String> g = new UndirectedAdjGraph<>();
		
		try(Scanner scan = new Scanner(FileSystems.getDefault().getPath(path)))
		{
			Map<String, List<String>> players = new HashMap<>();
			while(scan.hasNextLine()) 
			{
				String  match = scan.nextLine();
				match.replaceAll("vs ", "");
				String[] playersInMatch = match.split(" ");
				for(String player : playersInMatch) 
				{
					if(players.containsKey(player)) 
					{
						players.get(player).add(match);
					} 
					else 
					{
						players.put(player, new ArrayList<>());
						players.get(player).add(match);
					}
				}
			}
			for(String player : players.keySet()) 
			{
				List<String> neighborsMatch  = players.get(player);
				//System.out.println(neighborsMatch );
					for (int i = 0; i<neighborsMatch.size(); i++ ) {
						for(int j =i; j<neighborsMatch.size(); j++) {
							g.addEdge(neighborsMatch.get(i),neighborsMatch.get(j));
						}
					
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return g;
	}

	
	public void addNeighbors(List<String> neighborsMatch) {
		while (neighborsMatch.size()>1) {
			String match = neighborsMatch.get(0);
			neighborsMatch.subList(1, neighborsMatch.size());
			
		}
	}
	
	public static void main (String[] args) {
		UndirectedAdjGraph g = createGraphFromTextFile("Tournament-data");
		MatchScheduler.scheduleMatch(g);
		g.printColors();
	}

}
