import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountInterface extends JFrame implements ActionListener {
  private JLabel initialBalanceLabel, balanceLabel, depositLabel, withdrawalLabel;
  private JTextField initialBalanceField, balanceField, depositField, withdrawalField;
  private JButton submitButton, depositButton, withdrawButton;
  private JPanel welcomeScreen, menuScreen;
  private CardLayout view;
  private double balance = 0.0;


  BankAccountInterface() {
    setTitle("Bank Account");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 200);


    // Welcome screen
    welcomeScreen = new JPanel();
    initialBalanceLabel = new JLabel("What is your initial balance? ");
    initialBalanceField = new JTextField(10);
    submitButton = new JButton("Submit");
    submitButton.addActionListener(this);
    welcomeScreen.add(initialBalanceLabel);
    welcomeScreen.add(initialBalanceField);
    welcomeScreen.add(submitButton);

    // Menu screen
    menuScreen = new JPanel();
    balanceLabel = new JLabel("Your current balance: ");
    balanceField = new JTextField(String.valueOf(balance));
    menuScreen.add(balanceLabel);
    menuScreen.add(balanceField);


    // balanceLabel = new JLabel("Your current balance: ");
    // depositLabel = new JLabel("How much do you want to deposit?");
    // withdrawalLabel = new JLabel("How much do you want to withdraw");
    add(welcomeScreen);
    // add(menuScreen);

  }

  @Override
  public void actionPerformed(ActionEvent event) {
    if(event.getSource() == submitButton) {
      try {
        balance += Double.parseDouble(initialBalanceField.getText());
        balanceField.setText(String.valueOf(balance));
        setContentPane(menuScreen);
        repaint();
        revalidate();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number");
      } 
    }
  }

  public static void main(String[] args) {
    BankAccountInterface frame = new BankAccountInterface();
    frame.pack();
    frame.setVisible(true);
  }
}
