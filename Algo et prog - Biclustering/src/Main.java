import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static List<Country> countryListBuilder() {
		
		List<Country> countryList = new ArrayList<Country>();
		
		try(Scanner scan = new Scanner(new File("countries.csv"))) {
			scan.useDelimiter(",|\n");
			while(scan.hasNext()) {
				countryList.add(new Country(scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return countryList;
	}
	
	public static Vector<Vector<Integer>> expressionMatrixBuilder(List<Country> countryList) {
		Vector<Vector<Integer>> matrix = new Vector<>();
		
		for(Country country : countryList) {
			matrix.add(country.toExpressionVector());
		}
		
		return matrix;
	}
	
	public static void main(String[] args) {
		List<Country> countryList = countryListBuilder();
		
		Vector<Vector<Integer>> matrix = expressionMatrixBuilder(countryList);	
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un nombre de Bi-clusters (au moins 1):");
		int str = sc.nextInt();
		SMSRCC.biClusters(countryList, matrix, str);
		
	}
}