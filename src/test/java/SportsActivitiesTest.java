import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SportsActivitiesTest {
    SportsActivities sportsActivities;

    //Setting new sports activities before every test
    @BeforeEach
    public void setUp() {
        this.sportsActivities = new SportsActivities();
    }

    //Testing if logging adds activities and times to the map
    @Test
    public void logTimeTest() {
        sportsActivities.logTime("Swimming", 2);
        assertTrue(sportsActivities.getActivities().containsKey(2.0));
        assertTrue(sportsActivities.getActivities().containsValue("Swimming"));
    }

    //Testing if adding multiple logs are displayed
    @Test
    void testViewActivities() {
        sportsActivities.logTime("Running", 30.0);
        sportsActivities.logTime("Swimming", 45.0);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        sportsActivities.viewActivities();

        String actualOutput = outContent.toString();

        assertTrue(actualOutput.contains("Activity: Running, time spent: 30.0"));
        assertTrue(actualOutput.contains("Activity: Swimming, time spent: 45.0"));

        System.setOut(System.out);
    }


    //Testing total time with multiple logs
    @Test
    public void testGetTotalTime() {
        sportsActivities.logTime("Running", 30.0);
        sportsActivities.logTime("Swimming", 45.0);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        sportsActivities.getTotalTime();

        String expectedOutput = "Total time spent: 75.0";
        assertEquals(expectedOutput, outContent.toString().trim());

        System.setOut(System.out);
    }

}
