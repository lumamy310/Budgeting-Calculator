import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;


/**
 * Creation of panels, handling of buttons and logic on panel.
 *
 * @author Lucas Myers
 * @version Summer 2022
 */
public class BudgetPanel extends JPanel {

  //declare components
  private JButton addIncome;
  private JButton editIncome;
  private JButton removeIncome;
  private JButton addExpense;
  private JButton editExpense;
  private JButton removeExpense;
  private JButton budgetPlan;
  private JButton saveBudget;
  private JButton loadBudget;
  private JLabel incomeListLbl;
  private JLabel expenseListLbl;
  private JLabel totalIncomeLbl;
  private JLabel totalExpenseLbl;
  private JLabel remainingLbl;

  //ArrayLists to store objects
  ArrayList<Income> incomes;
  ArrayList<Expense> expenses;
  ArrayList<Paycheck> paychecks;

  //scrollable lists
  DefaultListModel<String> incomeModel;
  DefaultListModel<String> expenseModel;
  final JList<String> incomeJList;
  final JList<String> expenseJList;
  JScrollPane scrollPaneI;
  JScrollPane scrollPaneE;

  /**
   * Creation of the gui panel and initialization of components.
   */
  public BudgetPanel() {
    //initialize components
    incomeModel = new DefaultListModel<>();
    expenseModel = new DefaultListModel<>();
    incomes = new ArrayList<Income>();
    expenses = new ArrayList<Expense>();
    paychecks = new ArrayList<Paycheck>();
    incomeJList = new JList<>(incomeModel);
    expenseJList = new JList<>(expenseModel);
    scrollPaneI = new JScrollPane(incomeJList);
    scrollPaneE = new JScrollPane(expenseJList);
    scrollPaneI.setPreferredSize(new Dimension(300, 100));
    scrollPaneE.setPreferredSize(new Dimension(300, 100));

    addIncome = new JButton("Add");
    editIncome = new JButton("Edit");
    removeIncome = new JButton("Remove");
    addExpense = new JButton("Add");
    editExpense = new JButton("Edit");
    removeExpense = new JButton("Remove");
    budgetPlan = new JButton("Budget Planner");
    saveBudget = new JButton("Save Budget");
    loadBudget = new JButton("Load Budget");
    incomeListLbl = new JLabel("Incomes");
    expenseListLbl = new JLabel("Expenses");
    totalIncomeLbl = new JLabel("Total Income = ");
    totalExpenseLbl = new JLabel("Total Expense = ");
    remainingLbl = new JLabel("Total Remaining = ");

    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    //add components
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(incomeListLbl, gbc);

    gbc.gridx = 4;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(expenseListLbl, gbc);

    gbc.insets = new Insets(0, 0, 0, 25);
    gbc.ipady = 200;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    gbc.gridheight = 3;
    add(scrollPaneI, gbc);

    gbc.insets = new Insets(0, 25, 0, 0);
    gbc.gridx = 3;
    add(scrollPaneE, gbc);

    gbc.insets = new Insets(0, 0, 0, 0);
    gbc.ipady = 0;
    gbc.ipadx = 20;
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(addIncome, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(editIncome, gbc);

    gbc.insets = new Insets(0, 0, 0, 25);
    gbc.gridx = 2;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(removeIncome, gbc);

    gbc.insets = new Insets(0, 25, 0, 0);
    gbc.gridx = 3;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(addExpense, gbc);

    gbc.insets = new Insets(0, 0, 0, 0);
    gbc.gridx = 4;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(editExpense, gbc);

    gbc.gridx = 5;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(removeExpense, gbc);

    gbc.insets = new Insets(25, 0, 0, 0);
    gbc.ipadx = 25;
    gbc.gridx = 4;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(budgetPlan, gbc);

    gbc.insets = new Insets(0, 0, 0, 0);
    gbc.gridy = 7;
    add(saveBudget, gbc);

    gbc.gridy = 8;
    add(loadBudget, gbc);


    gbc.insets = new Insets(25, 0, 0, 0);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.ipadx = 0;
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(totalIncomeLbl, gbc);

    gbc.gridx = 0;
    gbc.gridy = 7;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(totalExpenseLbl, gbc);

    gbc.gridx = 0;
    gbc.gridy = 8;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(remainingLbl, gbc);
    //add action listeners
    addIncome.addActionListener(new ButtonListener());
    editIncome.addActionListener(new ButtonListener());
    removeIncome.addActionListener(new ButtonListener());
    addExpense.addActionListener(new ButtonListener());
    editExpense.addActionListener(new ButtonListener());
    removeExpense.addActionListener(new ButtonListener());
    budgetPlan.addActionListener(new ButtonListener());
    saveBudget.addActionListener(new ButtonListener());
    loadBudget.addActionListener(new ButtonListener());
  }

  /**
   * Adds the final element of the incomes list to the display.
   */
  private void updateIncomeJList() {
    String[] update = new String[incomes.size()];
    update[0] = incomes.get(incomes.size() - 1).toString();
    incomeModel.addElement(update[0]);
  }

  /**
   * Removes specified income from list.
   *
   * @param index index of income object
   */
  private void removeFromIncomeJList(int index) {
    incomes.remove(index);
    incomeModel.remove(index);
  }

  /**
   * Clears the income JList.
   */
  public void clearIncomeJList(){
    incomes.clear();
    incomeModel.clear();
  }

  /**
   * Adds the final element of the expense list to the display.
   */
  private void updateExpenseJList() {
    String[] update = new String[expenses.size()];
    update[0] = expenses.get(expenses.size() - 1).toString();
    expenseModel.addElement(update[0]);
  }

  /**
   * Removes specified expense from list.
   *
   * @param index index of expense object
   */
  private void removeFromExpenseJList(int index) {
    expenses.remove(index);
    expenseModel.remove(index);
  }

  /**
   * Clears the expense JList.
   */
  public void clearExpenseJList(){
    expenses.clear();
    expenseModel.clear();
  }

  /**
   * Sums the value of all income objects.
   */
  private double sumIncome() {
    double sum = 0;
    for (int i = 0; i < incomes.size(); i++) {
      sum += incomes.get(i).getAmt();
    }
    return sum;
  }

  /**
   * Sums the value of all expense objects.
   */
  private double sumExpense() {
    double sum = 0;
    for (int i = 0; i < expenses.size(); i++) {
      sum += expenses.get(i).getAmt();
    }
    return sum;
  }

  /**
   * Sums the value of all income and expense objects.
   */
  private double sumTotal() {
    double sum = 0;
    sum = sumIncome() - sumExpense();
    return sum;
  }


  private class ButtonListener implements ActionListener {

    /**
     * Receives action events.
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == addIncome) {
        //prompt user to enter a new income object
        //will need to open a custom JOptionPane
        String[] options = {"Paycheck", "Other Income"};
        JComboBox incomeList = new JComboBox(options);
        JTextField nameField = new JTextField();
        JTextField amtField = new JTextField();
        JTextField hoursField = new JTextField();
        JTextField rateField = new JTextField();
        JLabel nameLbl = new JLabel("Name:");
        JLabel amtLbl = new JLabel("Amount");
        JLabel hoursLbl = new JLabel("Hours:");
        JLabel rateLbl = new JLabel("Rate:");

        JPanel incomePanel = new JPanel();
        incomePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        incomePanel.add(incomeList, gbc);
        JOptionPane.showMessageDialog(null, incomePanel, "Add Income", JOptionPane.PLAIN_MESSAGE);
        if (incomeList.getSelectedItem() == "Paycheck") {
          incomePanel.remove(incomeList);
          gbc.gridx = 0;
          gbc.gridy = 0;
          gbc.gridwidth = 1;
          gbc.gridheight = 1;
          incomePanel.add(nameLbl, gbc);
          gbc.gridx = 1;
          gbc.gridy = 0;
          gbc.ipadx = 60;
          incomePanel.add(nameField, gbc);
          gbc.gridx = 0;
          gbc.gridy = 1;
          gbc.ipadx = 0;
          incomePanel.add(hoursLbl, gbc);
          gbc.gridx = 1;
          gbc.gridy = 1;
          gbc.ipadx = 60;
          incomePanel.add(hoursField, gbc);
          gbc.gridx = 0;
          gbc.gridy = 2;
          gbc.ipadx = 0;
          incomePanel.add(rateLbl, gbc);
          gbc.gridx = 1;
          gbc.gridy = 2;
          gbc.ipadx = 60;
          incomePanel.add(rateField, gbc);
          JOptionPane.showMessageDialog(null, incomePanel,
              "Add Paycheck", JOptionPane.PLAIN_MESSAGE);
          if (Objects.equals(nameField.getText(), "") && Objects.equals(amtField.getText(), "")) {
            System.out.print("User hit cancel");
          } else {
            try {
              Paycheck newPaycheck = new Paycheck(nameField.getText(),
                  Double.parseDouble(rateField.getText()),
                  Double.parseDouble(hoursField.getText()));
              incomes.add(newPaycheck);
              updateIncomeJList();
              totalIncomeLbl.setText("Total Income = " + String.valueOf(sumIncome()));
              remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));
            } catch (NullPointerException n) {
              JOptionPane.showMessageDialog(null, "Please enter a valid name.");
            } catch (IllegalArgumentException ex) {
              JOptionPane.showMessageDialog(null, "Please enter rate/hours greater than 0.");
            }
          }
        } else {
          incomePanel.remove(incomeList);
          gbc.gridx = 0;
          gbc.gridy = 0;
          gbc.gridwidth = 1;
          gbc.gridheight = 1;
          incomePanel.add(nameLbl, gbc);
          gbc.gridx = 1;
          gbc.gridy = 0;
          gbc.ipadx = 60;
          incomePanel.add(nameField, gbc);
          gbc.gridx = 0;
          gbc.gridy = 1;
          gbc.ipadx = 0;
          incomePanel.add(amtLbl, gbc);
          gbc.gridx = 1;
          gbc.gridy = 1;
          gbc.ipadx = 60;
          incomePanel.add(amtField, gbc);
          JOptionPane.showMessageDialog(null, incomePanel, "Add Income", JOptionPane.PLAIN_MESSAGE);
          if (Objects.equals(nameField.getText(), "") && Objects.equals(amtField.getText(), "")) {
            System.out.print("User hit cancel");
          } else {
            try {
              Income newIncome = new Income(nameField.getText(),
                  Double.parseDouble(amtField.getText()));
              incomes.add(newIncome);
              updateIncomeJList();
              totalIncomeLbl.setText("Total Income = " + String.valueOf(sumIncome()));
              remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));
            } catch (NullPointerException n) {
              JOptionPane.showMessageDialog(null, "Please enter a valid name.");
            } catch (IllegalArgumentException ex) {
              JOptionPane.showMessageDialog(null, "Please enter an amount greater than 0.");
            }
          }
        }
      }
      if (e.getSource() == addExpense) {
        JTextField nameField = new JTextField();
        JTextField amtField = new JTextField();
        JLabel nameLbl = new JLabel("Name:");
        JLabel amtLbl = new JLabel("Amount");

        JPanel expensePanel = new JPanel();
        expensePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        expensePanel.add(nameLbl, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 60;
        expensePanel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 0;
        expensePanel.add(amtLbl, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 60;
        expensePanel.add(amtField, gbc);
        JOptionPane.showMessageDialog(null, expensePanel, "Add Expense", JOptionPane.PLAIN_MESSAGE);
        if (Objects.equals(nameField.getText(), "") && Objects.equals(amtField.getText(), "")) {
          System.out.print("User hit cancel");
        } else {
          try {
            Expense newExpense = new Expense(nameField.getText(),
                Double.parseDouble(amtField.getText()));
            expenses.add(newExpense);
            updateExpenseJList();
            totalExpenseLbl.setText("Total Expense = " + String.valueOf(sumExpense()));
            remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));
          } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Please enter a valid name.");
          } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Please enter an amount greater than 0.");
          }
        }
      }
      try {
        if (e.getSource() == removeIncome) {
          int index = incomeJList.getSelectedIndex();
          removeFromIncomeJList(index);
          totalIncomeLbl.setText("Total Income = " + String.valueOf(sumIncome()));
          remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));
        }
      } catch (IndexOutOfBoundsException a) {
        JOptionPane.showMessageDialog(null, "Please select an item from the list first.");
      }
      try {
        if (e.getSource() == removeExpense) {
          int index = expenseJList.getSelectedIndex();
          removeFromExpenseJList(index);
          totalExpenseLbl.setText("Total Expense = " + String.valueOf(sumExpense()));
          remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));
        }
      } catch (IndexOutOfBoundsException a) {
        JOptionPane.showMessageDialog(null, "Please select an item from the list first.");
      }
      try {
        if (e.getSource() == editIncome) {
          JTextField nameField = new JTextField();
          JTextField amtField = new JTextField();
          JTextField hoursField = new JTextField();
          JTextField rateField = new JTextField();
          JLabel nameLbl = new JLabel("Name:");
          JLabel amtLbl = new JLabel("Amount");
          JLabel hoursLbl = new JLabel("Hours:");
          JLabel rateLbl = new JLabel("Rate:");

          JPanel incomePanel = new JPanel();
          incomePanel.setLayout(new GridBagLayout());
          GridBagConstraints gbc = new GridBagConstraints();
          gbc.gridx = 0;
          gbc.gridy = 0;
          gbc.gridwidth = 1;
          gbc.gridheight = 1;
          int index = incomeJList.getSelectedIndex();
          if (incomes.get(index) instanceof Paycheck) {
            incomePanel.add(nameLbl, gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.ipadx = 60;
            incomePanel.add(nameField, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.ipadx = 0;
            incomePanel.add(hoursLbl, gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.ipadx = 60;
            incomePanel.add(hoursField, gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.ipadx = 0;
            incomePanel.add(rateLbl, gbc);
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.ipadx = 60;
            incomePanel.add(rateField, gbc);
            nameField.setText(incomes.get(index).getName());
            hoursField.setText(String.valueOf(((Paycheck) incomes.get(index)).getHoursWeek()));
            rateField.setText(String.valueOf(((Paycheck)
                incomes.get(index)).getRate()));
            JOptionPane.showMessageDialog(null,
                incomePanel, "Edit Paycheck", JOptionPane.PLAIN_MESSAGE);
            try {
              incomes.get(index).setName(nameField.getText());
              ((Paycheck) incomes.get(index)).setRate(Double.parseDouble(rateField.getText()));
              ((Paycheck) incomes.get(index))
                  .setHoursWeek(Double.parseDouble(hoursField.getText()));
              incomeModel.set(index, incomes.get(index).toString());
              totalIncomeLbl.setText("Total Income = " + String.valueOf(sumIncome()));
              remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));
            } catch (NullPointerException n) {
              JOptionPane.showMessageDialog(null, "Please enter a valid name.");
            } catch (IllegalArgumentException ex) {
              JOptionPane.showMessageDialog(null, "Please enter rate/hours greater than 0.");
            }
          } else {
            incomePanel.add(nameLbl, gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.ipadx = 60;
            incomePanel.add(nameField, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.ipadx = 0;
            incomePanel.add(amtLbl, gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.ipadx = 60;
            incomePanel.add(amtField, gbc);
            nameField.setText(incomes.get(index).getName());
            amtField.setText(String.valueOf(incomes.get(index).getAmt()));
            JOptionPane.showMessageDialog(null,
                incomePanel, "Edit Income", JOptionPane.PLAIN_MESSAGE);
            try {
              incomes.get(index).setName(nameField.getText());
              incomes.get(index).setAmt(Double.parseDouble(amtField.getText()));
              incomeModel.set(index, incomes.get(index).toString());
              totalIncomeLbl.setText("Total Income = " + String.valueOf(sumIncome()));
              remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));
            } catch (NullPointerException n) {
              JOptionPane.showMessageDialog(null, "Please enter a valid name.");
            } catch (IllegalArgumentException ex) {
              JOptionPane.showMessageDialog(null, "Please enter an amount greater than 0.");
            }
          }
        }
      } catch (IndexOutOfBoundsException a) {
        JOptionPane.showMessageDialog(null, "Please select an item from the list first.");
      }
      try {
        if (e.getSource() == editExpense) {
          int index = expenseJList.getSelectedIndex();
          JTextField nameField = new JTextField();
          JTextField amtField = new JTextField();
          JLabel nameLbl = new JLabel("Name:");
          JLabel amtLbl = new JLabel("Amount");

          JPanel expensePanel = new JPanel();
          expensePanel.setLayout(new GridBagLayout());
          GridBagConstraints gbc = new GridBagConstraints();
          gbc.gridx = 0;
          gbc.gridy = 0;
          gbc.gridwidth = 1;
          gbc.gridheight = 1;
          expensePanel.add(nameLbl, gbc);
          gbc.gridx = 1;
          gbc.gridy = 0;
          gbc.ipadx = 60;
          expensePanel.add(nameField, gbc);
          gbc.gridx = 0;
          gbc.gridy = 1;
          gbc.ipadx = 0;
          expensePanel.add(amtLbl, gbc);
          gbc.gridx = 1;
          gbc.gridy = 1;
          gbc.ipadx = 60;
          expensePanel.add(amtField, gbc);
          nameField.setText(expenses.get(index).getName());
          amtField.setText(String.valueOf(expenses.get(index).getAmt()));
          JOptionPane.showMessageDialog(null,
              expensePanel, "Edit Expense", JOptionPane.PLAIN_MESSAGE);
          try {
            expenses.get(index).setName(nameField.getText());
            expenses.get(index).setAmt(Double.parseDouble(amtField.getText()));
            expenseModel.set(index, expenses.get(index).toString());
            totalExpenseLbl.setText("Total Income = " + String.valueOf(sumExpense()));
            remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));
          } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Please enter a valid name.");
          } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Please enter an amount greater than 0.");
          }
        }
      } catch (IndexOutOfBoundsException a) {
        JOptionPane.showMessageDialog(null, "Please select an item from the list first.");
      }
      if (e.getSource() == budgetPlan) {
        //TODO create the budget planner (needs web scraping)
        JOptionPane.showMessageDialog(null, "Coming in the future... Provides"
            + " investment opportunities for your remaining balance by pulling info from "
            + "the stock market, interest rates, ect.");
      }
      if (e.getSource() == saveBudget) {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
        int r = j.showSaveDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
          File file = new File(j.getSelectedFile().getAbsolutePath());
          PrintWriter writer = null;
          try {
            writer = new PrintWriter(file);
          } catch (FileNotFoundException ex) {
            ex.printStackTrace();
          }
          writer.print("");
          writer.close();
          for (int i = 0; i < incomes.size(); i++) {
            incomes.get(i).save(j.getSelectedFile().getAbsolutePath());
          }
          for (int i = 0; i < expenses.size(); i++) {
            expenses.get(i).save(j.getSelectedFile().getAbsolutePath());
          }
        } else {
          JOptionPane.showMessageDialog(null, "User cancelled operation");
        }
      }
      if (e.getSource() == loadBudget) {
        try {
          JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
          int r = j.showOpenDialog(null);
          if (r == JFileChooser.APPROVE_OPTION) {
            if(incomes.size() != 0) {
              clearIncomeJList();
              totalIncomeLbl.setText("Total Income = " + sumIncome());
              remainingLbl.setText("Total Remaining = " + sumTotal());
            }
            if(expenses.size() != 0) {
              clearExpenseJList();
              totalExpenseLbl.setText("Total Expense = " + sumExpense());
              remainingLbl.setText("Total Remaining = " + sumTotal());
            }
            BufferedReader reader = new
                BufferedReader(new FileReader(j.getSelectedFile().getAbsolutePath()));
            String line;
            String[] tokenLine;
            while ((line = reader.readLine()) != null) {
              //if expense
              if (line.charAt(0) == 'E') {
                tokenLine = line.split(" ");
                Expense read = new Expense(tokenLine[1], Double.parseDouble(tokenLine[2]));
                expenses.add(read);
                updateExpenseJList();
                totalExpenseLbl.setText("Total Expense = " + String.valueOf(sumExpense()));
                remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));

                //if income
              } else if (line.charAt(0) == 'I') {
                tokenLine = line.split(" ");
                Income read = new Income(tokenLine[1], Double.parseDouble(tokenLine[2]));
                incomes.add(read);
                updateIncomeJList();
                totalIncomeLbl.setText("Total Income = " + String.valueOf(sumIncome()));
                remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));

                //if paycheck
              } else if (line.charAt(0) == 'P') {
                tokenLine = line.split(" ");
                Paycheck read = new Paycheck(tokenLine[1],
                    Double.parseDouble(tokenLine[2]),
                    Double.parseDouble(tokenLine[3]));
                incomes.add(read);
                updateIncomeJList();
                totalIncomeLbl.setText("Total Income = " + String.valueOf(sumIncome()));
                remainingLbl.setText("Total Remaining = " + String.valueOf(sumTotal()));
              }
            }
            reader.close();
          } else {
            JOptionPane.showMessageDialog(null, "User cancelled operation");
          }
        } catch (RuntimeException a) {
          JOptionPane.showMessageDialog(null, "Bad data");
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

}
