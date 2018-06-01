import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class SMSRCC {
	
	 public static List<String> resultBiCluster (Country country, int[] features){
		 List<String> resultat = new ArrayList<>();
		 resultat.add("name="+country.getName());
		 for(int i = 0; i<features.length; i++) {
			 switch (features[i]) {
			 case (0):
				 resultat.add("landMass="+String.valueOf(country.getLandMass()));
			 break;
			 case (1):
				 resultat.add("zone="+String.valueOf(country.getZone()));
			 break;
			 case (2):
				 resultat.add("area="+String.valueOf(country.getArea()));
			 break;
			 case (3):
				 resultat.add("population="+String.valueOf(country.getPopulation()));
			 break;
			 case (4):
				 resultat.add("language="+String.valueOf(country.getLanguage()));
			 break;
			 case (5):
				 resultat.add("religion="+String.valueOf(country.getReligion()));
			 break;
			 case (6):
				 resultat.add("bars="+String.valueOf(country.getBars()));
			 break;
			 case (7):
				 resultat.add("stripes="+String.valueOf(country.getStripes()));
			 break;
			 case (8):
				 resultat.add("colours="+String.valueOf(country.getColours()));
			 break;
			 case (9):
				 resultat.add("red="+String.valueOf(country.getRed()));
			 break;
			 case (10):
				 resultat.add("green="+String.valueOf(country.getGreen()));
			 break;
			 case (11):
				 resultat.add("blue="+String.valueOf(country.getBlue()));
			 break;
			 case (12):
				 resultat.add("gold="+String.valueOf(country.getGold()));
			 break;
			 case (13):
				 resultat.add("white="+String.valueOf(country.getWhite()));
			 break;
			 case (14):
				 resultat.add("black="+String.valueOf(country.getBlack()));
			 break;
			 case (15):
				 resultat.add("orange="+String.valueOf(country.getOrange()));
			 break;
			 case (16):
				 resultat.add("circles="+String.valueOf(country.getCircles()));
			 break;
			 case (17):
				 resultat.add("crosses="+String.valueOf(country.getCrosses()));
			 break;
			 case (18):
				 resultat.add("saltires="+String.valueOf(country.getSaltires()));
			 break;
			 case (19):
				 resultat.add("quarters="+String.valueOf(country.getQuarters()));
			 break;
			 case (20):
				 resultat.add("crescent="+String.valueOf(country.getCrescent()));
			 break;
			 case (21):
				 resultat.add("sunstars="+String.valueOf(country.getSunstars()));
			 break;
			 case (22):
				 resultat.add("triangle="+String.valueOf(country.getTriangle()));
			 break;
			 case (23):
				 resultat.add("icon="+String.valueOf(country.getIcon()));
			 break;
			 case (24):
				 resultat.add("animate="+String.valueOf(country.getAnimate()));
			 break;
			 case (25):
				 resultat.add("text="+String.valueOf(country.getText()));
			 break;
			 }
		 }
		 return resultat;
	 }
	
	// Permet de normaliser les données entre 0 et 1
	public static  Vector<Vector<Float>> Normalized(Vector<Vector<Integer>> ListPays){
		Vector<Vector<Float>> normalized = new Vector<>();
		float[] max = new float[ListPays.get(0).size()];
		float[] min = new float[ListPays.get(0).size()];
		
		for (int i = 0; i<ListPays.get(0).size(); i++) {
			List<Integer> feature = new ArrayList<>();
			for (Vector<Integer> vecteur : ListPays) {
				feature.add(vecteur.get(i));
			}
			max[i] = Collections.max(feature);
			min[i] = Collections.min(feature);
		}
		for (Vector<Integer> vecteur : ListPays) {
			Vector<Float> vNormalized = new Vector<>();
			for (int i = 0; i < vecteur.size(); i++) {
				float v = (vecteur.get(i) - min[i])/(max[i]-min[i]);
				vNormalized.add(v);
			}
			normalized.add(vNormalized);
		}
		return normalized;
	}
		
	// Permet de calculer les ecarts moyens de chaque caractéristique
	public static  List<Float> MoyenneEcarts (Vector<Vector<Float>> ListPays){
		
		List<Float> ecartMoyen = new ArrayList<>();
		float[] mean = new float[ListPays.get(0).size()];
		List<List<Float>> feature = new ArrayList<>();
		for (int i = 0; i<ListPays.get(0).size(); i++) {
			List<Float> f = new ArrayList<>();
			float m = 0;
			for (Vector<Float> vecteur : ListPays) {
				f.add(vecteur.get(i));
				m += vecteur.get(i);
			}
			mean[i] = m/ListPays.size();
			feature.add(f);
		}
				
		for (int i = 0; i<feature.size(); i++) {
			float s = 0;
			for (float f : feature.get(i)) {
				s+= Math.abs(mean[i] - f);
			}
			ecartMoyen.add(s/feature.get(i).size());
		}		
		
		return ecartMoyen;
	}
	
	public static  float[] EcartType (Vector<Vector<Integer>> ListPays){
		
		float[] ecartType = new float[ListPays.get(0).size()];
		float[] mean = new float[ListPays.get(0).size()];
		List<List<Integer>> feature = new ArrayList<>();
		for (int i = 0; i<ListPays.get(0).size(); i++) {
			List<Integer> f = new ArrayList<>();
			float m = 0;
			for (Vector<Integer> vecteur : ListPays) {
				f.add(vecteur.get(i));
				m += vecteur.get(i);
			}
			mean[i] = m/ListPays.size();
			feature.add(f);
		}
		
		List<Float> eType = new ArrayList<>();
				
		for (int i = 0; i<feature.size(); i++) {
			float s = 0;
			for (float f : feature.get(i)) {
				s+= Math.pow(Math.abs(mean[i] - f), 2);
			}
			ecartType[i] = ((float) Math.log(Math.sqrt(s/feature.get(i).size())));
		}		
		return ecartType;
	}
	
	public static int[] TriFeatures(int nbrFeatures, Vector<Vector<Integer>> ListPays ) {
		
		int size = ListPays.get(0).size();
		float[] ecartsType = EcartType(ListPays);
		int start = (int) (Math.random() * size );
		int[] features = new int[nbrFeatures];
		Map<Integer, Float> possibilites = new LinkedHashMap<>();
		
		int loop = size - nbrFeatures;
		
		for (int i = 0; i<loop; i++) {
			float max = 0;
			int abs = 0;
			for (int j = 0; j<size; j++) {
				if (ecartsType[j]!=0) {
					float diff = Math.abs(Math.abs(ecartsType[j]) - Math.abs(ecartsType[start]));
					if (diff>max) {
						max = diff;
						abs = j;
					}
				}
			}
			ecartsType[abs] = 0;
		}
		int j = 0;
		for (int i = 0; i< size ; i++) {
			if (ecartsType[i]!=0) {
				features[j] = i;
				j++;
			}
		}
		return features;
	}
	
	
	public static void biClusters (List<Country> countryList, Vector<Vector<Integer>> ListPays, int nbrBiClusters) {
		
		int chara = ListPays.get(0).size();
		int nbrPays = ListPays.size();
		
		for (int i = 0; i<nbrBiClusters; i++) {
			System.out.println("Bi-cluster " + (i+1));
			
			//Initialisation du pays au hasard et des caractéristiques au hasard
			int pays = (int) (Math.random() * nbrPays );
			int nbrFeatures = (int) (2 + (Math.random() * (6)));
			int[] features = new int[nbrFeatures];
			features = TriFeatures(nbrFeatures, ListPays);
			Vector<Vector<Integer>> matrix = new Vector<>();
			
			for (Vector<Integer> v : ListPays) {
				Vector<Integer> vbis = new Vector<>();
				for (int j = 0; j<features.length; j++) {
					vbis.add(v.get(features[j]));
				}
				matrix.add(vbis);
			}
			
			Vector<Vector<Float>> normMatrix = Normalized(matrix);
			List<Float> ecart = MoyenneEcarts(normMatrix);
			Vector<Float> init = normMatrix.get(pays);
			List<List<String>> resultat = new ArrayList<>();
			
			for (int k = 0; k<normMatrix.size(); k++) {
				Vector<Float> m = normMatrix.get(k);
				List<Boolean> verif = new ArrayList<>();
				for(int j = 0; j<m.size(); j++) {
					float f = m.get(j);
					float iInit = init.get(j);
					float delta = (float) (ecart.get(j)*0.3);
					if (f <= (iInit+delta) && f>=(iInit-delta)) {
						verif.add(true);
					}
					else {
						verif.add(false);
					}
				}
				if(!verif.contains(false)) {
					Country country = countryList.get(k);
					resultat.add(resultBiCluster(country, features));
				}
			}
			for (List<String> r : resultat) {
				System.out.println(r);
			}
		}
	}
}
