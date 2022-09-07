import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Handling and Creation of Income Objects.
 *
 * @author Lucas Myers
 * @version Summer 2022
 */
public class Income {

  /**
   * Name of income.
   */
  private String name;

  /**
   * Total amount of income.
   */
  private double amt;

  /**
   * Getter method gets name.
   *
   * @return name of income
   */
  public String getName() {
    return name;
  }

  /**
   * Setter sets name of income.
   *
   * @param name name of income
   */
  public void setName(String name) {
    if (name.length() == 0) {
      throw new NullPointerException();
    }
    this.name = name;
  }

  /**
   * Getter gets amount of income.
   *
   * @return amount of income
   */
  public double getAmt() {
    return amt;
  }

  /**
   * Setter sets amount of income.
   *
   * @param amt amount of income
   */
  public void setAmt(double amt) {
    if (amt <= 0) {
      throw new IllegalArgumentException();
    }
    this.amt = amt;
  }

  /**
   * Constructor for income object (used by paycheck).
   *
   * @param name name of income
   */
  public Income(String name) {
    if (name.length() == 0) {
      throw new NullPointerException();
    }
    this.name = name;
  }

  /**
   * Constructor for income object.
   *
   * @param name name of income
   * @param amt  amount of income
   */
  public Income(String name, double amt) {
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
   * Method for saving income information to a file.
   *
   * @param fileName file to be written to
   */
  public void save(String fileName) {
    PrintWriter out = null;
    try {
      out = new PrintWriter(new FileWriter(fileName, true));
    } catch (Exception e) {
      e.printStackTrace();
    }
    out.println("I: " + this.name + " " + this.amt);
    out.close();
  }

  /**
   * toString for income object.
   */
  public String toString() {
    return name + " profits $" + amt;
  }


}
