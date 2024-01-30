import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupTwo extends JFrame implements ActionListener {
    int ran;
    JTextField nameText, FnameText, sinText, emailText, addressText, cityText, stateText, pincodeText;
    JRadioButton studentYes, studentNo, seniorYes, seniorNo;
    JButton next, prev;
    JComboBox religionBox, incomeBox, cateBox, ocpnBox;
    String formNo;

    signupTwo(String formNo) {
        this.formNo = formNo;
        setLayout(null);

        JLabel personalDetails = new JLabel("Page 2: Additional Details");
        personalDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
        personalDetails.setBounds(300, 40, 500, 40);
        add(personalDetails);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Times New Roman", Font.BOLD, 17));
        religion.setBounds(150, 140, 200, 30);
        add(religion);

        String rlgn[] = { "Christian", "Hindu", "Sikh", "Muslim", "Other" };
        religionBox = new JComboBox<>(rlgn);
        religionBox.setBackground(Color.white);
        religionBox.setBounds(380, 140, 250, 25);
        add(religionBox);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Times New Roman", Font.BOLD, 17));
        income.setBounds(150, 190, 200, 30);
        add(income);

        String incm[] = { "Less than $12,000", "Less than $25,000", "Less than $50,000", "$50,000 or more" };
        incomeBox = new JComboBox<>(incm);
        incomeBox.setBackground(Color.white);
        incomeBox.setBounds(380, 190, 250, 25);
        add(incomeBox);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Times New Roman", Font.BOLD, 17));
        category.setBounds(150, 240, 200, 30);
        add(category);

        String ctgry[] = { "Domestic", "International", "Refugee", "Other" };
        cateBox = new JComboBox<>(ctgry);
        cateBox.setBackground(Color.white);
        cateBox.setBounds(380, 240, 250, 25);
        add(cateBox);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Times New Roman", Font.BOLD, 17));
        occupation.setBounds(150, 290, 200, 30);
        add(occupation);

        String ocpn[] = { "Engineer", "Doctor", "Self Employed", "Teacher", "Other" };
        ocpnBox = new JComboBox<>(ocpn);
        ocpnBox.setBackground(Color.white);
        ocpnBox.setBounds(380, 290, 250, 25);
        add(ocpnBox);

        JLabel student = new JLabel("Student: ");
        student.setFont(new Font("Times New Roman", Font.BOLD, 17));
        student.setBounds(150, 340, 200, 30);
        add(student);

        studentYes = new JRadioButton("Yes");
        studentYes.setBounds(380, 340, 100, 30);
        studentYes.setBackground(Color.white);
        add(studentYes);

        studentNo = new JRadioButton("No");
        studentNo.setBounds(500, 340, 100, 30);
        studentNo.setBackground(Color.white);
        add(studentNo);

        ButtonGroup btnGender = new ButtonGroup();
        btnGender.add(studentYes);
        btnGender.add(studentNo);

        JLabel senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Times New Roman", Font.BOLD, 17));
        senior.setBounds(150, 390, 200, 30);
        add(senior);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(380, 390, 100, 30);
        seniorYes.setBackground(Color.white);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(500, 390, 100, 30);
        seniorNo.setBackground(Color.white);
        add(seniorNo);

        ButtonGroup btnMarital = new ButtonGroup();
        btnMarital.add(seniorYes);
        btnMarital.add(seniorNo);

        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(500, 440, 100, 25);
        next.addActionListener(this);
        add(next);

        prev = new JButton("PREVIOUS");
        prev.setBackground(Color.black);
        prev.setForeground(Color.white);
        prev.setBounds(200, 440, 100, 25);
        prev.addActionListener(this);
        add(prev);

        getContentPane().setBackground(Color.white);
        setSize(800, 650);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String religion = (String) religionBox.getSelectedItem();
            String income = (String) incomeBox.getSelectedItem();
            String category = (String) cateBox.getSelectedItem();
            String student = "null";
            if (studentYes.isSelected()) {
                student = "Yes";
            } else if (studentNo.isSelected()) {
                student = "No";
            }
            String occupation = (String) ocpnBox.getSelectedItem();
            String senior = "null";
            if (seniorYes.isSelected()) {
                senior = "Yes";
            } else if (seniorNo.isSelected()) {
                senior = "No";
            }
            try {

                conn c = new conn();
                String query = "insert into signupTwo values('" + formNo + "','" + religion + "', '" + income + "', '"
                        + category + "', '" + student + "', '" + occupation + "','" + senior + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signupThree(formNo).setVisible(true);
                ;
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == prev) {
            setVisible(false);
            new signupOne().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new signupTwo("");
    }
}