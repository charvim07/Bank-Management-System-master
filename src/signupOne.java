import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupOne extends JFrame implements ActionListener {
    int ran;
    JTextField nameText, FnameText, sinText, emailText, addressText, cityText, stateText, pincodeText;
    JRadioButton male, female, married, unmarried;
    JButton next;

    signupOne() {
        setLayout(null);
        ran = this.getRandomNumber(1000, 9999);
        JLabel formNo = new JLabel("APPLICATION FORM NUMBER " + ran);
        formNo.setFont(new Font("Times New Roman", Font.BOLD, 25));
        formNo.setBounds(200, 20, 600, 40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
        personalDetails.setBounds(320, 80, 500, 40);
        add(personalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Times New Roman", Font.BOLD, 17));
        name.setBounds(150, 140, 200, 30);
        add(name);

        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        nameText.setBounds(380, 140, 250, 25);
        add(nameText);

        JLabel Fname = new JLabel("Fathers Name: ");
        Fname.setFont(new Font("Times New Roman", Font.BOLD, 17));
        Fname.setBounds(150, 190, 200, 30);
        add(Fname);

        FnameText = new JTextField();
        FnameText.setFont(new Font("Raleway", Font.BOLD, 14));
        FnameText.setBounds(380, 190, 250, 25);
        add(FnameText);

        JLabel sin = new JLabel("Social Insurance Number: ");
        sin.setFont(new Font("Times New Roman", Font.BOLD, 17));
        sin.setBounds(150, 240, 200, 30);
        add(sin);

        sinText = new JTextField();
        sinText.setFont(new Font("Raleway", Font.BOLD, 14));
        sinText.setBounds(380, 240, 250, 25);
        add(sinText);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Times New Roman", Font.BOLD, 17));
        gender.setBounds(150, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(380, 290, 100, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(500, 290, 100, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup btnGender = new ButtonGroup();
        btnGender.add(male);
        btnGender.add(female);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Times New Roman", Font.BOLD, 17));
        email.setBounds(150, 340, 200, 30);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        emailText.setBounds(380, 340, 250, 25);
        add(emailText);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Times New Roman", Font.BOLD, 17));
        marital.setBounds(150, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(380, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(500, 390, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup btnMarital = new ButtonGroup();
        btnMarital.add(married);
        btnMarital.add(unmarried);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Times New Roman", Font.BOLD, 17));
        address.setBounds(150, 440, 200, 30);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD, 14));
        addressText.setBounds(380, 440, 250, 25);
        add(addressText);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Times New Roman", Font.BOLD, 17));
        city.setBounds(150, 490, 200, 30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        cityText.setBounds(380, 490, 250, 25);
        add(cityText);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Times New Roman", Font.BOLD, 17));
        state.setBounds(150, 540, 200, 30);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        stateText.setBounds(380, 540, 250, 25);
        add(stateText);

        JLabel pincode = new JLabel("PinCode: ");
        pincode.setFont(new Font("Times New Roman", Font.BOLD, 17));
        pincode.setBounds(150, 590, 200, 30);
        add(pincode);

        pincodeText = new JTextField();
        pincodeText.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeText.setBounds(380, 590, 250, 25);
        add(pincodeText);

        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(350, 630, 100, 25);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formNumber = "" + ran;
        String name = nameText.getText();
        String FName = FnameText.getText();
        String sin = sinText.getText();
        String gender = "null";
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailText.getText();
        String marital = "null";
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        }
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pincode = pincodeText.getText();
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name field can't be empty");
            } else if (sin.equals("")) {
                JOptionPane.showMessageDialog(null, "SIN field can't be empty");
            } else if (gender.equals("null")) {
                JOptionPane.showMessageDialog(null, "Gender field can't be empty");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email field can't be empty");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address field can't be empty");
            } else if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode field can't be empty");
            } else {
                conn c = new conn();
                String query = "insert into signup values('" + formNumber + "', '" + name + "', '" + FName + "', '"
                        + sin + "', '" + gender + "', '" + email + "','" + marital + "', '" + address + "', '" + city
                        + "','" + state + "', '" + pincode + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signupTwo(formNumber).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {
        new signupOne();
    }
}