package HomeWork4;

public class Time {

	private int hour;
	private int min;
	
	
	public Time(int hour, int min) {
        if(hour >= 0 && hour <= 23)
            this.hour = hour;
        if(min >= 0 && min <= 59)
            this.min = min;
    }


	public int getHour() {
		return hour;
	}


	public void setHour(int hour) {
		this.hour = hour;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
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
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "" + hour + "hour" + min + "min";
	}
	
	

	
	
	
}
