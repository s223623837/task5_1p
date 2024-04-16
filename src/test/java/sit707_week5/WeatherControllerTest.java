package sit707_week5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeatherControllerTest {
    private WeatherController wController;

	@Test
	public void testStudentIdentity() {
		String studentId = "223623837";
		Assert.assertNotNull("Student ID is", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Bidhan Babu Gupta";
		Assert.assertNotNull("Student name is", studentName);
	}
	  @Before
	public void setUp() {
	        System.out.println("+++ Test Setup +++");
	        // Initialize WeatherController instance
	        wController = WeatherController.getInstance();
	  }

	 @After
	 public void tearDown() {
	        System.out.println("+++ Test Teardown +++");
	        // Close WeatherController instance after each test
	        wController.close();
	 }
	 @Test
	    public void testTemperatureMin() {
	        System.out.println("+++ testTemperatureMin +++");
	        // Arrange - Retrieve total hours
	        int nHours = wController.getTotalHours();
	        double minTemperature = Double.MAX_VALUE;

	        // Act - Calculate minimum temperature
	        for (int i = 1; i <= nHours; i++) {
	            double temperatureVal = wController.getTemperatureForHour(i);
	            if (temperatureVal < minTemperature) {
	                minTemperature = temperatureVal;
	            }
	        }

	        // Assert - Validate against cached minimum value
	        Assert.assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0.001);
	    }

	    @Test
	    public void testTemperatureMax() {
	        System.out.println("+++ testTemperatureMax +++");
	        // Arrange - Retrieve total hours
	        int nHours = wController.getTotalHours();
	        double maxTemperature = Double.MIN_VALUE;

	        // Act - Calculate maximum temperature
	        for (int i = 1; i <= nHours; i++) {
	            double temperatureVal = wController.getTemperatureForHour(i);
	            if (temperatureVal > maxTemperature) {
	                maxTemperature = temperatureVal;
	            }
	        }

	        // Assert - Validate against cached maximum value
	        Assert.assertEquals(maxTemperature, wController.getTemperatureMaxFromCache(), 0.001);
	    }

	    @Test
	    public void testTemperatureAverage() {
	        System.out.println("+++ testTemperatureAverage +++");
	        // Arrange - Retrieve total hours and calculate average
	        int nHours = wController.getTotalHours();
	        double sumTemp = 0;

	        // Act - Calculate sum of temperatures
	        for (int i = 1; i <= nHours; i++) {
	            sumTemp += wController.getTemperatureForHour(i);
	        }
	        double averageTemp = sumTemp / nHours;

	        // Assert - Validate against cached average value
	        Assert.assertEquals(averageTemp, wController.getTemperatureAverageFromCache(), 0.001);
	    }

	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
