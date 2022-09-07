import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creation of the GUI, frame in this case.
 *
 * @author Lucas Myers
 * @version Spring 2022
 */
public class budgetGUI extends JFrame implements ActionListener {
  //declare components
  JFrame budgetFrame = new JFrame();
  private JMenuBar menus;
  private JMenu exitMenu;
  private JMenuItem exitItem;
  private BudgetPanel panel = new BudgetPanel();

  /**
   * Method that creates the gui frame.
   */
  public budgetGUI() {
    //initialize components
    menus = new JMenuBar();
    exitMenu = new JMenu("Exit");
    exitItem = new JMenuItem("Exit Application");

    //add components to menu
    exitMenu.add(exitItem);
    menus.add(exitMenu);

    //set menu bar
    budgetFrame.setJMenuBar(menus);

    //add action listener
    exitItem.addActionListener(this);

    //set frame parameters
    budgetFrame.add(panel);
    budgetFrame.setSize(800, 650);
    budgetFrame.setTitle("Budget Calculator");
    budgetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    budgetFrame.setResizable(false);
    budgetFrame.setVisible(true);
    budgetFrame.setLocationRelativeTo(null);

  }

  /**
   * Receives action events.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == exitItem) {
      System.exit(0);
    }
  }

  /**
   * Launches the gui.
   */
  public static void main(String[] args) {
    new budgetGUI();
  }

}
