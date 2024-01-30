import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class depositmoney extends JFrame implements ActionListener {
    JButton submit, exit;
    JTextField money;
    String pin;

    depositmoney(String pin) {
        this.pin = pin;
        setLayout(null);
        JLabel heading = new JLabel("Please enter the amount you want to deposit");
        add(heading);
        heading.setBounds(50, 30, 400, 30);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 19));

        money = new JTextField();
        add(money);
        money.setBounds(50, 90, 300, 30);
        money.setFont(new Font("Times New Roman", Font.BOLD, 18));

        submit = new JButton("DEPOSIT");
        submit.setBounds(220, 150, 200, 30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        exit = new JButton("CANCEL");
        exit.setBounds(220, 200, 200, 30);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(Color.BLACK);
        setSize(550, 400);
        setVisible(true);
        setLocation(350, 200);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new transactions(pin).setVisible(true);
        } else if (ae.getSource() == submit) {
            String amount = money.getText();
            Date date = new Date();
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to add");
            } else {
                try {
                    conn con = new conn();
                    String query = "insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount
                            + "')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$" + amount + " was deposited successfully");
                    setVisible(false);
                    new transactions(pin).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new depositmoney("");
    }
}