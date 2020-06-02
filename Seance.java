package HomeWork4;

public class Seance implements Comparable<Seance> {
	
	private Movie movie;
	private Time startTime;
	private Time endTime;
	
	
	public Seance(Movie movie, Time startTime) {
		this.movie = movie;
		this.startTime = startTime;
		int hour = movie.getDuration().getHour() + startTime.getHour();
		int min = movie.getDuration().getMin() + startTime.getMin(); 
		if (min  >= 60) {
			min = min - 60;
			hour = hour + 1;
		};
		this.endTime = new Time(hour, min);
		
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public Time getStartTime() {
		return startTime;
	}


	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}


	public Time getEndTime() {
		return endTime;
	}


	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Seance other = (Seance) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "seanceStart: " + startTime + ", Movie: " + movie + ", seanceEnd: " + endTime + "";
	}


	@Override
	public int compareTo(Seance o) {
		int rezult = this.startTime.getHour() - o.getStartTime().getHour();
		if (rezult == 0) {
			rezult = this.startTime.getMin() - o.getStartTime().getMin();
			if (rezult == 0) {
				int compareTitle = this.movie.getTitle().compareTo(o.getMovie().getTitle());
				if (compareTitle == 0) {
					rezult = this.movie.getDuration().getHour() - o.movie.getDuration().getHour();
					if (rezult == 0) {
						rezult = this.movie.getDuration().getMin() - o.movie.getDuration().getMin();
						if (rezult == 0) {
							rezult = this.endTime.getHour() - o.endTime.getHour();
							if (rezult == 0) {
								 return this.endTime.getMin() - o.endTime.getMin();
							} return rezult;
						} return rezult;
					} return rezult;
				} return compareTitle;
			}return rezult;
		} return rezult;
	}
	
	
	
}
