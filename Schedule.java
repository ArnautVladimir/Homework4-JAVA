package HomeWork4;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Schedule {
	
	private Set<Seance> seanceSet;

	public Schedule() {
		this.seanceSet = new TreeSet<Seance>();
	}

	public Set<Seance> getSeanceSet() {
		return seanceSet;
	}

	public void setSeanceSet(Set<Seance> seanceSet) {
		this.seanceSet = seanceSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seanceSet == null) ? 0 : seanceSet.hashCode());
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
		Schedule other = (Schedule) obj;
		if (seanceSet == null) {
			if (other.seanceSet != null)
				return false;
		} else if (!seanceSet.equals(other.seanceSet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Schedule : " + seanceSet;
	}
	

		
	public void addSeance(Seance seance) {
		if (seanceSet.size() == 0) {
			seanceSet.add(seance);
			return;			
		} else {
			Iterator<Seance> iterator = seanceSet.iterator();
			while (iterator.hasNext()) {
				int startSeance = seance.getStartTime().getHour();
				int endSeance = seance.getEndTime().getHour();
				Seance seanceCheck = iterator.next();
				int seanceStartCheck = seanceCheck.getStartTime().getHour();
				int seanceEndCheck = seanceCheck.getEndTime().getHour();
				if (startSeance >= seanceStartCheck && startSeance <= seanceEndCheck) {
					System.out.println("ERROR start seance " + seance.getStartTime());
					return;
				} else if (endSeance >= seanceStartCheck && endSeance <= seanceEndCheck){
					System.out.println("ERROR end seance " + seance.getEndTime());
					return;
					}
			seanceSet.add(seance);
			return;
			}
		}
		
	}
	
	public void deleteSeance(Seance seance) {
		Iterator<Seance> iterator = seanceSet.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(seance)) {
				iterator.remove();
			}
		}
	}
	
	
	
	
	

}
