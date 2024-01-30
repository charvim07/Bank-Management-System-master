import java.lang.reflect.Constructor;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transactions extends JFrame implements ActionListener {
    JButton deposit, cashWith, fastCash, balance, exit;
    String pin;

    transactions(String pin) {
        this.pin = pin;
        setLayout(null);
        JLabel heading = new JLabel("Please select from the options below");
        add(heading);
        heading.setBounds(250, 30, 400, 30);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 19));

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(150, 90, 200, 30);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        add(deposit);

        cashWith = new JButton("CASH WITHDRAWAL");
        cashWith.setBounds(450, 90, 200, 30);
        cashWith.setBackground(Color.WHITE);
        cashWith.setForeground(Color.BLACK);
        cashWith.addActionListener(this);
        add(cashWith);

        fastCash = new JButton("FAST CASH");
        fastCash.setBounds(150, 150, 200, 30);
        fastCash.setBackground(Color.WHITE);
        fastCash.setForeground(Color.BLACK);
        fastCash.addActionListener(this);
        add(fastCash);

        balance = new JButton("BALANCE");
        balance.setBounds(450, 150, 200, 30);
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.addActionListener(this);
        add(balance);

        exit = new JButton("EXIT");
        exit.setBounds(300, 250, 200, 30);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(Color.BLACK);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(1);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new depositmoney(pin).setVisible(true);
        } else if (ae.getSource() == cashWith) {
            setVisible(false);
            new withdrawMoney(pin).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new fastCash(pin).setVisible(true);
        } else if (ae.getSource() == balance) {
            conn con = new conn();
            try {
                int total = 0;
                String query = "select * from bank where pin = '" + pin + "'";
                ResultSet rs = con.s.executeQuery(query);
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        total += Integer.parseInt(rs.getString("amount"));
                    } else if (rs.getString("type").equals("Withdraw")) {
                        total -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                JOptionPane.showMessageDialog(null, "$" + total + " present in your account");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new transactions("");
    }
}
