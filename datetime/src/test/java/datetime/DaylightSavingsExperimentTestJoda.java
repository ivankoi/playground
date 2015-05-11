package datetime;

import java.time.Period;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import static org.junit.Assert.*;

public class DaylightSavingsExperimentTestJoda {
	
	@Test(expected = Exception.class)
	public void createNonExistingDateInDSTParisShouldFail() {

		DateTime nonExistingInstant = new DateTime().withDate(2015, 3, 29).withTime(2, 12, 0, 0).withZone(DateTimeZone.forID("Europe/Paris"));
		System.out.println(nonExistingInstant);
		
	}
	
	@Test
	public void createNonExistingTimeWithoutTZInfoShouldPass() {
		LocalDateTime nonExistingInstant = new LocalDateTime().withDate(2015, 3, 29).withTime(2, 12, 0, 0);
		assertNotNull("It works if TimeZone is unknown", nonExistingInstant);
	}
	
	@Test
	public void dstOneDayEquals23Hours() {
		DateTime _1HourBeforeDST = new DateTime().withDate(2015, 3, 29).withTime(1, 0, 0, 0).withZone(DateTimeZone.forID("Europe/Paris"));
		DateTime _22HoursAfterDST = new DateTime().withDate(2015, 3, 30).withTime(1, 0, 0, 0).withZone(DateTimeZone.forID("Europe/Paris"));
		
		assertEquals(1, Days.daysBetween(_1HourBeforeDST, _22HoursAfterDST).getDays());
		assertEquals(23, Hours.hoursBetween(_1HourBeforeDST, _22HoursAfterDST).getHours()); 
	}
	
	@Test
	public void oneHourFromParisToLondon() {
		DateTime brusslesTime = new DateTime().withDate(2015, 3, 20).withTime(1, 0, 0, 0).withZone(DateTimeZone.forID("Europe/Paris"));
		DateTime athensTime = brusslesTime.withZoneRetainFields(DateTimeZone.forID("Europe/Athens"));
		
		assertEquals(1, Hours.hoursBetween(athensTime, brusslesTime).getHours()); 
	}
}
