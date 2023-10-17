package asg3Clock;

import java.util.Calendar;
import java.util.TimeZone;

public class HoursAndMinutes {
	
	private String timeZone;
	private int minutes, hours;
	
	//////////////////////////
	// no-arg constructor
	////////////////////////
	public HoursAndMinutes() {
		
		/////////////////////////
		// initialize variable
		///////////////////////
		minutes = 0;
		hours = 0;
	}
	
	///////////////////////////////
	// Parameterized constructor
	/////////////////////////////
	public HoursAndMinutes(String timeZone) {

		/////////////////////
		// set variables
		///////////////////
		if (timeZone.equalsIgnoreCase("loc")) {
			Calendar local = Calendar.getInstance();
			setMinutes(local.get(Calendar.MINUTE));
			setHours(local.get(Calendar.HOUR_OF_DAY));
		} else if (timeZone.equalsIgnoreCase("fra")) {
			TimeZone tz = TimeZone.getTimeZone("GMT+2");
			Calendar frankfurt = Calendar.getInstance(tz);
			setMinutes(frankfurt.get(Calendar.MINUTE));
			setHours(frankfurt.get(Calendar.HOUR_OF_DAY));
		} else if (timeZone.equalsIgnoreCase("clt")) {
			TimeZone tz = TimeZone.getTimeZone("GMT-4");
			Calendar charlotte = Calendar.getInstance(tz);
			setMinutes(charlotte.get(Calendar.MINUTE));
			setHours(charlotte.get(Calendar.HOUR_OF_DAY));
		}
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

}
