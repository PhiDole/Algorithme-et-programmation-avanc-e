
import java.util.Vector;

public class Country {

	private String name;
	
	private int landMass;
	
	private int zone;
	
	private int area;
	
	private int population;
	
	private int language;
	
	private int religion;
	
	private int bars;
	private int stripes;
	private int colours;
	
	private int red;
	private int green;
	private int blue;
	private int gold;
	private int white;
	private int black;
	private int orange;
	
	private String mainhue;
	
	private int circles;
	private int crosses;
	private int saltires;
	private int quarters;
	private int sunstars;
	
	private int crescent;
	private int triangle;
	private int icon;
	private int animate;
	private int text;
	
	private String topleft;
	private String botright;

	public Country(String name, int landMass, int zone, int area, int population, int language, int religion, int bars,
			int stripes, int colours, int red, int green, int blue, int gold, int white,
			int black, int orange, String mainhue, int circles, int crosses, int saltires, int quarters,
			int sunstars, int crescent, int triangle, int icon, int animate, int text,
			String topleft, String botright) {
		this.name = name;
		this.landMass = landMass;
		this.zone = zone;
		this.area = area;
		this.population = population;
		this.language = language;
		this.religion = religion;
		this.bars = bars;
		this.stripes = stripes;
		this.colours = colours;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.gold = gold;
		this.white = white;
		this.black = black;
		this.orange = orange;
		this.mainhue = mainhue;
		this.circles = circles;
		this.crosses = crosses;
		this.saltires = saltires;
		this.quarters = quarters;
		this.sunstars = sunstars;
		this.crescent = crescent;
		this.triangle = triangle;
		this.icon = icon;
		this.animate = animate;
		this.text = text;
		this.topleft = topleft;
		this.botright = botright;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLandMass() {
		return landMass;
	}

	public void setLandMass(int landMass) {
		this.landMass = landMass;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getReligion() {
		return religion;
	}

	public void setReligion(int religion) {
		this.religion = religion;
	}

	public int getBars() {
		return bars;
	}

	public void setBars(int bars) {
		this.bars = bars;
	}

	public int getStripes() {
		return stripes;
	}

	public void setStripes(int stripes) {
		this.stripes = stripes;
	}

	public int getColours() {
		return colours;
	}

	public void setColours(int colours) {
		this.colours = colours;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getWhite() {
		return white;
	}

	public void setWhite(int white) {
		this.white = white;
	}

	public int getBlack() {
		return black;
	}

	public void setBlack(int black) {
		this.black = black;
	}

	public int getOrange() {
		return orange;
	}

	public void setOrange(int orange) {
		this.orange = orange;
	}

	public String getMainhue() {
		return mainhue;
	}

	public void setMainhue(String mainhue) {
		this.mainhue = mainhue;
	}

	public int getCircles() {
		return circles;
	}

	public void setCircles(int circles) {
		this.circles = circles;
	}

	public int getCrosses() {
		return crosses;
	}

	public void setCrosses(int crosses) {
		this.crosses = crosses;
	}

	public int getSaltires() {
		return saltires;
	}

	public void setSaltires(int saltires) {
		this.saltires = saltires;
	}

	public int getQuarters() {
		return quarters;
	}

	public void setQuarters(int quarters) {
		this.quarters = quarters;
	}

	public int getSunstars() {
		return sunstars;
	}

	public void setSunstars(int sunstars) {
		this.sunstars = sunstars;
	}

	public int getCrescent() {
		return crescent;
	}

	public void setCrescent(int crescent) {
		this.crescent = crescent;
	}

	public int getTriangle() {
		return triangle;
	}

	public void setTriangle(int triangle) {
		this.triangle = triangle;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getAnimate() {
		return animate;
	}

	public void setAnimate(int animate) {
		this.animate = animate;
	}

	public int getText() {
		return text;
	}

	public void setText(int text) {
		this.text = text;
	}

	public String getTopleft() {
		return topleft;
	}

	public void setTopleft(String topleft) {
		this.topleft = topleft;
	}

	public String getBotright() {
		return botright;
	}

	public void setBotright(String botright) {
		this.botright = botright;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", landMass=" + landMass + ", zone=" + zone + ", area=" + area
				+ ", population=" + population + ", language=" + language + ", religion=" + religion + ", bars=" + bars
				+ ", stripes=" + stripes + ", colours=" + colours + ", red=" + red + ", green=" + green + ", blue="
				+ blue + ", gold=" + gold + ", white=" + white + ", black=" + black + ", orange=" + orange
				+ ", mainhue=" + mainhue + ", circles=" + circles + ", crosses=" + crosses + ", saltires=" + saltires
				+ ", quarters=" + quarters + ", sunstars=" + sunstars + ", crescent=" + crescent + ", triangle="
				+ triangle + ", icon=" + icon + ", animate=" + animate + ", text=" + text + ", topleft=" + topleft
				+ ", botright=" + botright + "]";
	}
    
    public Vector<Integer> toExpressionVector() {
    	Vector<Integer> vector = new Vector<>();
    	vector.add(landMass);
    	vector.add(zone);
    	vector.add(area);
    	vector.add(population);
    	vector.add(language);
    	vector.add(religion);
    	vector.add(bars);
    	vector.add(stripes);
    	vector.add(colours);
    	vector.add(red);
    	vector.add(green);
    	vector.add(blue);
    	vector.add(gold);
    	vector.add(white);
    	vector.add(black);
    	vector.add(orange);
    	vector.add(circles);
    	vector.add(crosses);
    	vector.add(saltires);
    	vector.add(quarters);
    	vector.add(crescent);
    	vector.add(sunstars);
    	vector.add(triangle);
    	vector.add(icon);
    	vector.add(animate);
    	vector.add(text);
    	
    	return vector;
    }
    
   
}