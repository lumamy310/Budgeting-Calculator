import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Handling and Creation of Paycheck Objects.
 *
 * @author Lucas Myers
 * @version Summer 2022
 */
public class Paycheck extends Income {

  /**
   * Hours worked per week.
   */
  private double hoursWeek;

  /**
   * Pay rate.
   */
  private double rate;

  /**
   * Total amount of income.
   */
  private double amt;

  /**
   * Getter gets hours worked per week.
   *
   * @return hours worked per week
   */
  public double getHoursWeek() {
    return hoursWeek;
  }

  /**
   * Setter sets hours worked per week.
   *
   * @param hoursWeek hours worked per week
   */
  public void setHoursWeek(double hoursWeek) {
    if (hoursWeek <= 0) {
      throw new IllegalArgumentException();
    }
    this.hoursWeek = hoursWeek;
    super.setAmt(calcAmt());
  }

  /**
   * Getter method gets pay rate.
   *
   * @return pay rate
   */
  public double getRate() {
    return rate;
  }

  /**
   * Setter sets pay rate.
   *
   * @param rate pay rate
   */
  public void setRate(double rate) {
    if (rate <= 0) {
      throw new IllegalArgumentException();
    }
    this.rate = rate;
    super.setAmt(calcAmt());
  }

  /**
   * Getter gets the total income amount.
   *
   * @return total income amount
   */
  @Override
  public double getAmt() {
    return amt;
  }

  /**
   * Setter sets the total income amount.
   *
   * @param amt total income amount
   */
  @Override
  public void setAmt(double amt) {
    if (amt <= 0) {
      throw new IllegalArgumentException();
    }
    this.amt = amt;
  }

  /**
   * Method to calculate the total income amount with rate and hours.
   *
   * @return total income amount
   */
  private double calcAmt() {
    amt = (hoursWeek * 4) * rate;
    return amt;
  }

  /**
   * Constructor for Paycheck objects.
   *
   * @param name Name of paycheck
   * @param rate pay rate
   * @param hoursWeek hours worked per week
   */
  public Paycheck(String name, double rate, double hoursWeek) {
    super(name);
    if (rate <= 0) {
      throw new IllegalArgumentException();
    }
    if (hoursWeek <= 0) {
      throw new IllegalArgumentException();
    }
    this.rate = rate;
    this.hoursWeek = hoursWeek;
    super.setAmt(calcAmt());
  }

  /**
   * Method to save paycheck information to file.
   *
   * @param fileName The name or path of the file being written to
   */
  public void save(String fileName) {
    PrintWriter out = null;
    try {
      out = new PrintWriter(new FileWriter(fileName, true));
    } catch (Exception e) {
      e.printStackTrace();
    }
    out.println("P: " + super.getName() + " " + this.hoursWeek + " " + this.rate);
    out.close();
  }

  /**
   * toString for paycheck objects.
   */
  @Override
  public String toString() {
    return super.getName() + " profits $" + amt;
  }
}
