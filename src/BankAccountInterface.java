import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountInterface extends JFrame implements ActionListener {
  private JLabel initialBalanceLabel, balanceLabel, actionLabel;
  private JTextField initialBalanceField, balanceField, actionField;
  private JButton submitButton, depositButton, withdrawButton;
  private JPanel welcomeScreen, menuScreen;
  private double balance = 0.0;


  BankAccountInterface() {
    setTitle("Bank Account");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(600, 400);

    // Welcome screen
    welcomeScreen = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);

    initialBalanceLabel = new JLabel("What is your initial balance? ");
    initialBalanceField = new JTextField(10);
    submitButton = new JButton("Submit");
    submitButton.addActionListener(this);
    gbc.gridx = 0;
    gbc.gridy = 0;
    welcomeScreen.add(initialBalanceLabel, gbc);
    gbc.gridx = 1;
    welcomeScreen.add(initialBalanceField, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 2;

    welcomeScreen.add(submitButton, gbc);

    // Menu screen
    // Display current balance
    menuScreen = new JPanel(new GridBagLayout());
    balanceLabel = new JLabel("Your current balance: ");
    balanceField = new JTextField(String.valueOf(balance), 10);
    balanceField.setEditable(false);
    gbc.gridwidth = 1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    menuScreen.add(balanceLabel, gbc);
    gbc.gridx = 1;
    menuScreen.add(balanceField, gbc);

    // One input to deposit or withdraw
    actionLabel = new JLabel("Amount to withdraw/deposit");
    actionField = new JTextField("0.00", 10);
    gbc.gridx = 0;
    gbc.gridy = 1;
    menuScreen.add(actionLabel, gbc);
    gbc.gridx = 1;
    menuScreen.add(actionField, gbc);

    // Use buttons to decide which action to take.
    depositButton = new JButton("Deposit");
    depositButton.addActionListener(this);
    withdrawButton = new JButton("Withdraw");
    withdrawButton.addActionListener(this);
    gbc.gridx = 0;
    gbc.gridy = 2;
    menuScreen.add(depositButton,gbc);
    gbc.gridx = 1;
    menuScreen.add(withdrawButton, gbc);

    // Initialize the program with the welcome screen
    setContentPane(welcomeScreen);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    // Each action should validate the input
    if(event.getSource() == submitButton) {
      try {
        balance += Double.parseDouble(initialBalanceField.getText());
        balanceField.setText(String.valueOf(balance));
        // Switch screen
        setContentPane(menuScreen);
        repaint();
        revalidate();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number");
      } 
    } else if (event.getSource() == depositButton) {
      try {
        // Deposit balance
        balance += Double.parseDouble(actionField.getText());
        balanceField.setText(String.valueOf(balance));
        actionField.setText("0.00");
      } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number");
      } 
    } else if (event.getSource() == withdrawButton) {
      try {
        // Withdraw balance
        balance -= Double.parseDouble(actionField.getText());
        balanceField.setText(String.valueOf(balance));
        actionField.setText("0.00");
      } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number");
      } 
    }
  }

  public static void main(String[] args) {
    BankAccountInterface frame = new BankAccountInterface();
    frame.setVisible(true);
  }
}
