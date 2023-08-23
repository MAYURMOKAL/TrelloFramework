package com.info.trello.genericutility;

import java.time.LocalDateTime;

public class JavaUtility {
/**
 * This method will be used to Capture the current date and time of the machine.
 * @author MAYUR
 * @return timeStamp
 */
	public String timeStamp() {
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		return timeStamp;
	}
	
}
