import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupThree extends JFrame implements ActionListener {
    JRadioButton saving, chequing, fixed;
    JCheckBox atm, mobile, email, estatement, declare;
    JButton submit, cancel;
    String formNo;

    signupThree(String formNo) {
        this.formNo = formNo;
        setLayout(null);
        JLabel heading = new JLabel("Page3: Account Details");
        add(heading);
        heading.setBounds(300, 20, 400, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 25));

        JLabel account = new JLabel("Account Type*");
        add(account);
        account.setBounds(150, 70, 300, 30);
        account.setFont(new Font("Times New Roman", Font.BOLD, 20));

        saving = new JRadioButton("Saving Account");
        add(saving);
        saving.setBounds(150, 120, 200, 30);
        saving.setFont(new Font("Times New Roman", Font.BOLD, 16));
        saving.setBackground(Color.white);

        chequing = new JRadioButton("Chequing Account");
        add(chequing);
        chequing.setBounds(370, 120, 200, 30);
        chequing.setFont(new Font("Times New Roman", Font.BOLD, 16));
        chequing.setBackground(Color.white);

        fixed = new JRadioButton("Fixed Deposit Account");
        add(fixed);
        fixed.setBounds(590, 120, 200, 30);
        fixed.setFont(new Font("Times New Roman", Font.BOLD, 16));
        fixed.setBackground(Color.white);

        ButtonGroup btngp = new ButtonGroup();
        btngp.add(saving);
        btngp.add(chequing);
        btngp.add(fixed);

        JLabel cardno = new JLabel("Card Number: ");
        add(cardno);
        cardno.setBounds(150, 200, 200, 30);
        cardno.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JLabel no = new JLabel("XXXX-XXXX-XXXX-XXXX");
        add(no);
        no.setBounds(400, 200, 300, 30);
        no.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel msg = new JLabel("Your 16 Digit Card Number");
        add(msg);
        msg.setBounds(150, 235, 300, 20);
        msg.setFont(new Font("Times New Roman", Font.BOLD, 14));

        JLabel pin = new JLabel("PIN: ");
        add(pin);
        pin.setBounds(150, 290, 200, 30);
        pin.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JLabel pinX = new JLabel("XXXX");
        add(pinX);
        pinX.setBounds(400, 290, 200, 30);
        pinX.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel pinval = new JLabel("Your 4 Digit Pin");
        add(pinval);
        pinval.setBounds(150, 325, 200, 20);
        pinval.setFont(new Font("Times New Roman", Font.BOLD, 14));

        JLabel services = new JLabel("Services Required");
        add(services);
        services.setBounds(150, 390, 200, 30);
        services.setFont(new Font("Times New Roman", Font.BOLD, 20));

        atm = new JCheckBox("ATM Card");
        add(atm);
        atm.setBounds(150, 440, 200, 30);
        atm.setFont(new Font("Times New Roman", Font.BOLD, 15));
        atm.setBackground(Color.white);

        mobile = new JCheckBox("Mobile Banking");
        add(mobile);
        mobile.setBounds(500, 440, 200, 30);
        mobile.setFont(new Font("Times New Roman", Font.BOLD, 15));
        mobile.setBackground(Color.white);

        email = new JCheckBox("Email and SMS Alerts");
        add(email);
        email.setBounds(150, 490, 200, 30);
        email.setFont(new Font("Times New Roman", Font.BOLD, 15));
        email.setBackground(Color.white);

        estatement = new JCheckBox("E-Statement");
        add(estatement);
        estatement.setBounds(500, 490, 200, 30);
        estatement.setFont(new Font("Times New Roman", Font.BOLD, 15));
        estatement.setBackground(Color.white);

        declare = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
        add(declare);
        declare.setBounds(150, 600, 600, 30);
        declare.setFont(new Font("Times New Roman", Font.BOLD, 15));
        declare.setBackground(Color.white);

        submit = new JButton("SUBMIT");
        submit.setBounds(450, 650, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(250, 650, 100, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String account = "null";
            if (saving.isSelected()) {
                account = "Saving Account";
            } else if (chequing.isSelected()) {
                account = "Chequing Account";
            } else if (fixed.isSelected()) {
                account = "Fixed Deposit Account";
            }
            String cardNo = "";
            int r1 = this.getRandomNumber(1000, 9999);
            int r2 = this.getRandomNumber(1000, 9999);
            int r3 = this.getRandomNumber(1000, 9999);
            int r4 = this.getRandomNumber(1000, 9999);
            cardNo += r1 + "-" + r2 + "-" + r3 + "-" + r4;
            String pin = "";
            int r5 = this.getRandomNumber(1000, 9999);
            pin += r5;
            String services = "";
            if (atm.isSelected()) {
                services += "ATM";
            } else if (mobile.isSelected()) {
                services += ", Mobile";
            } else if (email.isSelected()) {
                services += ", Email & SMS Alerts";
            } else if (estatement.isSelected()) {
                services += ", EStatement";
            }

            try {
                if (account.equals("null")) {
                    JOptionPane.showMessageDialog(null, "Account Type has to be selected");
                } else if (!(declare.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Agreement not checked");
                } else {
                    conn con = new conn();
                    String query1 = "insert into signupthree values('" + formNo + "', '" + account + "', '" + cardNo
                            + "', '" + pin + "', '" + services + "')";
                    String query2 = "insert into login values('" + formNo + "', '" + cardNo
                            + "', '" + pin + "')";
                    con.s.executeUpdate(query1);
                    con.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNo + "\nPIN: " + pin);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            setVisible(false);
            new depositmoney(pin).setVisible(true);
            JOptionPane.showMessageDialog(null, "You have to put some money to activate your account");
        } else if (ae.getSource() == cancel) {

        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {
        new signupThree("");
    }
}
