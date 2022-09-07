import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Handling and Creation of Expense Objects.
 *
 * @author Lucas Myers
 * @version Summer 2022
 */
public class Expense {

  /**
   * Name of the expense.
   */
  private String name;

  /**
   * Amount of the expense in dollars.
   */
  private double amt;

  /**
   * Getter method gets name.
   *
   * @return the name of the expense
   */
  public String getName() {
    return name;
  }

  /**
   * Bank of words the computer will choose from.
   *
   * @param name The name of the expense
   */
  public void setName(String name) {
    if (name.length() == 0) {
      throw new NullPointerException();
    }
    this.name = name;
  }

  /**
   * Getter method gets amount.
   *
   * @return the amount of the expense in dollars
   */
  public double getAmt() {
    return amt;
  }

  /**
   * Setter method sets amount.
   *
   * @param amt the amount of the expense in dollars
   */
  public void setAmt(double amt) {
    if (amt <= 0) {
      throw new IllegalArgumentException();
    }
    this.amt = amt;
  }

  /**
   * Constructor for expense object.
   *
   * @param name name of expense
   * @param amt  amount of expense in dollars
   */
  public Expense(String name, double amt) {
    if (name.length() == 0) {
      throw new NullPointerException();
    }
    if (amt <= 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.amt = amt;
  }

  /**
   * Method saves expense info to file.
   *
   * @param fileName Name/path of the file to write to
   */
  public void save(String fileName) {
    PrintWriter out = null;
    try {
      out = new PrintWriter(new FileWriter(fileName, true));
    } catch (Exception e) {
      e.printStackTrace();
    }
    out.println("E: " + this.name + " " + this.amt);
    out.close();
  }

  /**
   * toString method for expense.
   *
   * @return expense as a string
   */
  @Override
  public String toString() {
    return name + " costs $" + amt;
  }


}
