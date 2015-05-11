package datetime;

import java.util.Calendar;
import java.util.TimeZone;

import org.junit.Test;

import static org.junit.Assert.*;

public class DaylightSavingsExperimentTestJDK {
	
	@Test
	public void createNonExistingDateInDSTBrusselsShoulWorkWithStupudJDK() {

		Calendar nonExistngInstant = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
		nonExistngInstant.set(Calendar.YEAR, 2015);
		nonExistngInstant.set(Calendar.MONTH, 2);
		nonExistngInstant.set(Calendar.DAY_OF_MONTH, 29);
		nonExistngInstant.set(Calendar.HOUR_OF_DAY, 2);
		nonExistngInstant.set(Calendar.MINUTE, 15);
		
		assertEquals("JDK Calendar does an automatic offset with DST", 3, nonExistngInstant.get(Calendar.HOUR_OF_DAY));
	}

	@Test
	public void createNonExistingDateInDSTNewYorkShoulWorkWithStupudJDK() {

		Calendar nonExistngInstant = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		nonExistngInstant.set(Calendar.YEAR, 2015);
		nonExistngInstant.set(Calendar.MONTH, 2);
		nonExistngInstant.set(Calendar.DAY_OF_MONTH, 8);
		nonExistngInstant.set(Calendar.HOUR_OF_DAY, 2);
		nonExistngInstant.set(Calendar.MINUTE, 15);
		
		assertEquals("JDK Calendar does an automatic offset with DST", 3, nonExistngInstant.get(Calendar.HOUR_OF_DAY));
	}
	
}
