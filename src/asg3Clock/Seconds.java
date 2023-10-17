package asg3Clock;

import java.time.*;
import java.util.Calendar;
import java.util.TimeZone;

public class Seconds extends HoursAndMinutes{
	private String timeZone;
	private int seconds;
	
	//////////////////////////
	// no-arg constructor
	////////////////////////
	public Seconds() {
		
		/////////////////
		// call parent
		///////////////
		super();
		
		/////////////////////////
		// initialize variable
		///////////////////////
		seconds = 0;
	}
	
	///////////////////////////////
	// Parameterized constructor
	/////////////////////////////
	public Seconds(String timeZone) {
		
		//////////////////
		// call parent
		////////////////
		super(timeZone);
		
		///////////////////////
		// set variable
		/////////////////////
		if (timeZone.equalsIgnoreCase("loc")) {
			Calendar local = Calendar.getInstance();
			setSeconds(local.get(Calendar.SECOND));
		} else if (timeZone.equalsIgnoreCase("fra")) {
			TimeZone tz = TimeZone.getTimeZone("GMT+2");
			Calendar frankfurt = Calendar.getInstance(tz);
			setSeconds(frankfurt.get(Calendar.SECOND));
		} else if (timeZone.equalsIgnoreCase("clt")) {
			TimeZone tz = TimeZone.getTimeZone("GMT-4");
			Calendar charlotte = Calendar.getInstance(tz);
			setSeconds(charlotte.get(Calendar.SECOND));
		} 
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	////////////////////////////////
	// give full time as string
	//////////////////////////////
	public String getTime() {
		return super.getHours() + ":" + super.getMinutes() + ":" + getSeconds();
	}

}
