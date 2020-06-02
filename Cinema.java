package HomeWork4;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Cinema {
	
	private TreeMap<Days, Schedule> sheduleMap;
	private Time open;
	private Time close;
	
	
	public Cinema(TreeMap<Days, Schedule> sheduleMap, Time open, Time close) {
		this.sheduleMap = sheduleMap;
		this.open = open;
		this.close = close;
	}


	public TreeMap<Days, Schedule> getSheduleMap() {
		return sheduleMap;
	}


	public void setSheduleMap(TreeMap<Days, Schedule> sheduleMap) {
		this.sheduleMap = sheduleMap;
	}


	public Time getOpen() {
		return open;
	}


	public void setOpen(Time open) {
		this.open = open;
	}


	public Time getClose() {
		return close;
	}


	public void setClose(Time close) {
		this.close = close;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((close == null) ? 0 : close.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		result = prime * result + ((sheduleMap == null) ? 0 : sheduleMap.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		if (close == null) {
			if (other.close != null)
				return false;
		} else if (!close.equals(other.close))
			return false;
		if (open == null) {
			if (other.open != null)
				return false;
		} else if (!open.equals(other.open))
			return false;
		if (sheduleMap == null) {
			if (other.sheduleMap != null)
				return false;
		} else if (!sheduleMap.equals(other.sheduleMap))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cinema [sheduleMap=" + sheduleMap + ", open=" + open + ", close=" + close + "]";
	}
	
	
	public void addSeance(Seance seance, String day) {
		if (seance.getStartTime().getHour() >= open.getHour() && seance.getEndTime().getHour() <= close.getHour()) {
			if (sheduleMap.containsKey(Days.valueOf(day.toUpperCase()))) {
				sheduleMap.get(Days.valueOf(day.toUpperCase())).addSeance(seance);				
			} else {
				sheduleMap.put(Days.valueOf(day.toUpperCase()), new Schedule());
				sheduleMap.get(Days.valueOf(day.toUpperCase())).addSeance(seance);
			}
		} else { 
			System.out.println("ERROR seance time from " + open + " to " + close);
		}
	}
	
	public void addSeances(String day, Seance seance, Seance seance1, Seance seance2, Seance seance3, Seance seance4) {
		List<Seance> seances = new ArrayList<>();
		seances.add(seance);
		seances.add(seance1);
		seances.add(seance2);
		seances.add(seance3);
		seances.add(seance4);
		for (Seance seanc : seances) {
			if (seanc.getStartTime().getHour() >= open.getHour() && seanc.getEndTime().getHour() <= close.getHour()) {
				if (sheduleMap.containsKey(Days.valueOf(day.toUpperCase()))) {
					sheduleMap.get(Days.valueOf(day.toUpperCase())).addSeance(seanc);
					} else {
						sheduleMap.put(Days.valueOf(day.toUpperCase()), new Schedule());
						sheduleMap.get(Days.valueOf(day.toUpperCase())).addSeance(seanc);
						}
			} else { 
				System.out.println("ERROR seance time from " + open + " to " + close);
			}
		}
	}
	
	public void removeMovie(Movie movie) {
		for (Map.Entry<Days, Schedule> entry : sheduleMap.entrySet()) {
			Iterator<Seance> iterator = entry.getValue().getSeanceSet().iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getMovie().getTitle().equals(movie.getTitle())) {
					iterator.remove();
				}
			}
		}
	}
	
	
	public void removeSeance(Seance seance, String day) {
		sheduleMap.get(Days.valueOf(day.toUpperCase())).deleteSeance(seance);
	}
	
	
	
	
	
	

}
