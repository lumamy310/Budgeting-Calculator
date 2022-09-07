import org.junit.Test;

import static org.junit.Assert.*;

public class testPaycheck {

    @Test
    public void testConstructor(){
        Paycheck one = new Paycheck("Job", 11.75, 33);
        assertEquals(one.getHoursWeek(), 33, 0);
        assertEquals(one.getRate(), 11.75, 0);
        assertEquals(one.getName(), "Job");
        assertEquals(one.getAmt(), 1551, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidConstructor(){
        Paycheck one = new Paycheck("Job", -11.75, 33);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidConstructor1(){
        Paycheck one = new Paycheck("Job", 11.75, -33);
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidConstructor2(){
        Paycheck one = new Paycheck("", 11.75, 33);
    }

    @Test
    public void testToString(){
        Paycheck two = new Paycheck("Job", 18.10, 40);
        assertEquals(two.toString(), "Job profits $2896.0");
    }

    @Test
    public void testSetHoursWeek(){
        Paycheck one = new Paycheck("Job", 11.75, 33);
        one.setHoursWeek(25);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidSetHoursWeek(){
        Paycheck one = new Paycheck("Job", 11.75, 33);
        one.setHoursWeek(-1);
    }

    @Test
    public void testSetRate(){
        Paycheck one = new Paycheck("Job", 11.75, 33);
        one.setRate(25);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidSetRate(){
        Paycheck one = new Paycheck("Job", 11.75, 33);
        one.setRate(-1);
    }

    @Test
    public void testSetAmt(){
        Paycheck one = new Paycheck("Job", 11.75, 33);
        one.setAmt(6000);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidSetAmt(){
        Paycheck one = new Paycheck("Job", 11.75, 33);
        one.setAmt(-1);
    }

    @Test
    public void testSave(){
        Paycheck test = new Paycheck("test", 1, 2);
        test.save("testData");
    }

    @Test (expected = NullPointerException.class)
    public void testSaveFail(){
        Paycheck test = new Paycheck("test2", 11, 12);
        test.save("/");
    }

}
