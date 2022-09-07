import org.junit.Test;

import static org.junit.Assert.*;


public class testExpense {

    @Test
    public void testConstructor(){
        Expense one = new Expense("Bill", 500);
        assertEquals(one.getAmt(), 500, 0);
        assertEquals(one.getName(), "Bill");
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidConstructor1(){
        Expense one = new Expense("", 500);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidConstructor2(){
        Expense one = new Expense("Bill", -500);
    }

    @Test
    public void testSetAmt(){
        Expense one = new Expense("Bill", 500);
        one.setAmt(100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidSetAmt(){
        Expense one = new Expense("Bill", 500);
        one.setAmt(-9);
    }

    @Test
    public void testSetName(){
        Expense one = new Expense("Bill", 500);
        one.setName("Billayyy");
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidSetName(){
        Expense one = new Expense("Bill", 500);
        one.setName("");
    }

    @Test
    public void testToString(){
        Expense one = new Expense("Bill", 12.99);
        assertEquals(one.toString(), "Bill costs $12.99");
    }

    @Test
    public void testSave(){
        Expense test = new Expense("test", 1);
        test.save("testData");
    }

    @Test (expected = NullPointerException.class)
    public void testSaveFail(){
        Expense test = new Expense("test2", 11);
        test.save("/");
    }

}
