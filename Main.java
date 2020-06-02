package HomeWork4;

import java.util.Map;
import java.util.TreeMap;

public class Main {

	
	
	public static void main(String[] args) {
		
		Movie remboter = new Movie("Remboter", new Time(1, 35));
		
		Seance seance1 = new Seance(new Movie("Rembo", new Time(1, 10)), new Time(18, 50));
		Seance seance2 = new Seance(new Movie("Aembot", new Time(2, 10)), new Time(16, 50));
		Seance seance3 = new Seance(new Movie("Remboter", new Time(1, 35)), new Time(17, 55));
		Seance seance4 = new Seance(new Movie("Rembrrro", new Time(1, 10)), new Time(15, 30));
		Seance seance5 = new Seance(new Movie("Predator", new Time(2, 10)), new Time(10, 50));
		Seance seance6 = new Seance(new Movie("Rembo2", new Time(1, 0)), new Time(19, 0));
		Seance seance7 = new Seance(new Movie("Rembo3", new Time(1, 30)), new Time(8, 25));
		Seance seance8 = new Seance(new Movie("Remboter", new Time(0, 50)), new Time(13, 0));
		
				
				
		Cinema star = new Cinema(new TreeMap<>(), new Time(8, 0), new Time(20, 0));
		
				
		star.getSheduleMap().put(Days.MONDAY, new Schedule());
		
		star.getSheduleMap().put(Days.TUESDAY, new Schedule());
				
		
		
		
			
		
		
		star.addSeances("friday", seance3, seance4, seance5, seance6, seance7);
		
		
		star.addSeance(seance8, "monday");
		
		star.addSeance(seance1, "sunday");
		
		star.addSeance(seance8, "sunday");
		
		
		star.addSeance(seance8, "tuesday");
		
		
		star.removeSeance(seance2, "sunday");
		
		for (Map.Entry<Days, Schedule> entry : star.getSheduleMap().entrySet()) {
			System.out.println(entry.getKey() + " :");
			for (Seance seanc : entry.getValue().getSeanceSet()) {
				System.out.println("\t" + seanc);
			}
		}
		
		star.removeMovie(remboter);
		
		for (Map.Entry<Days, Schedule> entry : star.getSheduleMap().entrySet()) {
			System.out.println(entry.getKey() + " :");
			for (Seance seanc : entry.getValue().getSeanceSet()) {
				System.out.println("\t" + seanc);
			}
		}
		
		
				
		
	}
}
