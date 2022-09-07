import org.junit.Test;

import static org.junit.Assert.*;

public class testIncome {

    @Test
    public void testConstructor(){
        Income one = new Income("Money", 150);
        assertEquals(one.getAmt(), 150, 0);
        assertEquals(one.getName(), "Money");
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidConstructor(){
        Income one = new Income("", 150);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidConstructor2(){
        Income one = new Income("Money", -50);
    }

    @Test
    public void testToString(){
        Income two = new Income("Gift", 50.01);
        assertEquals(two.toString(), "Gift profits $50.01");
    }

    @Test
    public void testSetName(){
        Income one = new Income("Yes", 500);
        one.setName("No");
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidSetName(){
        Income one = new Income("Krabs", 500);
        one.setName("");
    }

    @Test
    public void testSetAmt(){
        Income one = new Income("Sand", 500);
        one.setAmt(100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidSetAmt(){
        Income one = new Income("sand", 500);
        one.setAmt(-9);
    }

    @Test
    public void testConstructorName(){
        Income one = new Income("Money");
        assertEquals(one.getName(), "Money");
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidConstructorName(){
        Income one = new Income("");
    }

    @Test
    public void testSave(){
        Income test = new Income("test", 1);
        test.save("testData");
    }

    @Test (expected = NullPointerException.class)
    public void testSaveFail(){
        Income test = new Income("test2", 11);
        test.save("/");
    }

}
