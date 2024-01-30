import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {
    JButton deposit, cashWith, fastCash, balance, exit;
    String pin;

    fastCash(String pin) {
        this.pin = pin;
        setLayout(null);
        JLabel heading = new JLabel("Please select from the options below");
        add(heading);
        heading.setBounds(250, 30, 400, 30);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 19));

        deposit = new JButton("$5");
        deposit.setBounds(150, 90, 200, 30);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        add(deposit);

        cashWith = new JButton("$10");
        cashWith.setBounds(450, 90, 200, 30);
        cashWith.setBackground(Color.WHITE);
        cashWith.setForeground(Color.BLACK);
        cashWith.addActionListener(this);
        add(cashWith);

        fastCash = new JButton("$20");
        fastCash.setBounds(150, 150, 200, 30);
        fastCash.setBackground(Color.WHITE);
        fastCash.setForeground(Color.BLACK);
        fastCash.addActionListener(this);
        add(fastCash);

        balance = new JButton("$50");
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
        int amt = 0;
        if (ae.getSource() == exit) {
            setVisible(false);
            new transactions(pin).setVisible(true);
            return;
        } else if (ae.getSource() == deposit) {
            amt = 5;
        } else if (ae.getSource() == cashWith) {
            amt = 10;
        } else if (ae.getSource() == fastCash) {
            amt = 20;
        } else if (ae.getSource() == balance) {
            amt = 50;
        }
        String val = Integer.toString(amt);
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
            if (ae.getSource() != exit && total < amt) {
                JOptionPane.showMessageDialog(null, "Insufficient Funds");
                return;
            }
            Date date = new Date();
            String query1 = "insert into bank values('" + pin + "', '" + date + "', 'Withdraw', '" + val
                    + "')";
            con.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null, "$" + val + " debited successfully");
            setVisible(false);
            new transactions(pin).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new fastCash("");
    }
}