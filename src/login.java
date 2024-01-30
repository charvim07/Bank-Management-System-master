import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardText;
    JPasswordField pinText;

    login() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel text = new JLabel("Welcome to ATM");
        add(text);
        text.setBounds(250, 40, 400, 40);
        text.setFont(new Font("Times New Roman", Font.BOLD, 38));

        JLabel cardNo = new JLabel("Card Number: ");
        add(cardNo);
        cardNo.setBounds(200, 120, 200, 30);
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));

        JLabel format = new JLabel("FORMAT: XXXX-XXXX-XXXX-XXXX");
        add(format);
        format.setBounds(200, 152, 200, 20);
        format.setFont(new Font("Raleway", Font.BOLD, 12));

        cardText = new JTextField();
        cardText.setBounds(420, 120, 200, 30);
        cardText.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardText);

        JLabel pin = new JLabel("PIN: ");
        add(pin);
        pin.setBounds(200, 200, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));

        pinText = new JPasswordField();
        pinText.setBounds(420, 200, 200, 30);
        pinText.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinText);

        login = new JButton("SIGN IN");
        login.setBounds(270, 270, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        signup = new JButton("SIGN UP");
        signup.setBounds(440, 270, 100, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        clear = new JButton("CLEAR");
        clear.setBounds(270, 320, 270, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
        setTitle("ATM");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            conn con = new conn();
            String cardno = cardText.getText();
            String pin = pinText.getText();
            String query = "select * from login where cardNo = '" + cardno + "' and pin = '" + pin + "'";
            try {
                ResultSet rs = con.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new transactions(pin).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new signupOne().setVisible(true);
        } else if (ae.getSource() == clear) {
            cardText.setText("");
            pinText.setText("");
        }
    }

    public static void main(String[] args) {
        new login();
    }

}