/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator.system;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Signup2 extends JFrame implements ActionListener
{
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    JLabel l8;
    JLabel l9;
    JLabel l10;
    JLabel l11;
    JLabel l12;
    JLabel l13;
    JButton b;
    JRadioButton r1;
    JRadioButton r2;
    JRadioButton r3;
    JRadioButton r4;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JComboBox c1;
    JComboBox c2;
    JComboBox c3;
    JComboBox c4;
    JComboBox c5;
    String formno;
    
    Signup2(final String formno) {
       final ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/icons/logo.jpg"));
        final Image i2 = i1.getImage().getScaledInstance(100, 100, 1);
        final ImageIcon i3 = new ImageIcon(i2);
        final JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        this.add(l14);
        this.formno = formno;
        this.setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        (this.l1 = new JLabel("Page 2: Additonal Details")).setFont(new Font("Raleway", 1, 22));
        (this.l2 = new JLabel("Religion:")).setFont(new Font("Raleway", 1, 18));
        (this.l3 = new JLabel("Category:")).setFont(new Font("Raleway", 1, 18));
        (this.l4 = new JLabel("Income:")).setFont(new Font("Raleway", 1, 18));
        (this.l5 = new JLabel("Educational")).setFont(new Font("Raleway", 1, 18));
        (this.l11 = new JLabel("Qualification:")).setFont(new Font("Raleway", 1, 18));
        (this.l6 = new JLabel("Occupation:")).setFont(new Font("Raleway", 1, 18));
        (this.l7 = new JLabel("PAN Number:")).setFont(new Font("Raleway", 1, 18));
        (this.l8 = new JLabel("Aadhar Number:")).setFont(new Font("Raleway", 1, 18));
        (this.l9 = new JLabel("Senior Citizen:")).setFont(new Font("Raleway", 1, 18));
        (this.l10 = new JLabel("Existing Account:")).setFont(new Font("Raleway", 1, 18));
        (this.l12 = new JLabel("Form No:")).setFont(new Font("Raleway", 1, 13));
        (this.l13 = new JLabel(formno)).setFont(new Font("Raleway", 1, 13));
        (this.b = new JButton("Next")).setFont(new Font("Raleway", 1, 14));
        this.b.setBackground(Color.BLACK);
        this.b.setForeground(Color.WHITE);
        (this.t1 = new JTextField()).setFont(new Font("Raleway", 1, 14));
        (this.t2 = new JTextField()).setFont(new Font("Raleway", 1, 14));
        (this.r1 = new JRadioButton("Yes")).setFont(new Font("Raleway", 1, 14));
        this.r1.setBackground(Color.WHITE);
        (this.r2 = new JRadioButton("No")).setFont(new Font("Raleway", 1, 14));
        this.r2.setBackground(Color.WHITE);
        (this.r3 = new JRadioButton("Yes")).setFont(new Font("Raleway", 1, 14));
        this.r3.setBackground(Color.WHITE);
        (this.r4 = new JRadioButton("No")).setFont(new Font("Raleway", 1, 14));
        this.r4.setBackground(Color.WHITE);
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String category[] = {"General","OBC","SC","ST","Other"};
        c2 = new JComboBox(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        this.c5.setFont(new Font("Raleway", 1, 14));
        this.setLayout(null);
        this.l12.setBounds(700, 10, 60, 30);
        this.add(this.l12);
        this.l13.setBounds(760, 10, 60, 30);
        this.add(this.l13);
        this.l1.setBounds(280, 30, 600, 40);
        this.add(this.l1);
        this.l2.setBounds(100, 120, 100, 30);
        this.add(this.l2);
        this.c1.setBounds(350, 120, 320, 30);
        this.add(this.c1);
        this.l3.setBounds(100, 170, 100, 30);
        this.add(this.l3);
        this.c2.setBounds(350, 170, 320, 30);
        this.add(this.c2);
        this.l4.setBounds(100, 220, 100, 30);
        this.add(this.l4);
        this.c3.setBounds(350, 220, 320, 30);
        this.add(this.c3);
        this.l5.setBounds(100, 270, 150, 30);
        this.add(this.l5);
        this.c4.setBounds(350, 270, 320, 30);
        this.add(this.c4);
        this.l11.setBounds(100, 290, 150, 30);
        this.add(this.l11);
        this.l6.setBounds(100, 340, 150, 30);
        this.add(this.l6);
        this.c5.setBounds(350, 340, 320, 30);
        this.add(this.c5);
        this.l7.setBounds(100, 390, 150, 30);
        this.add(this.l7);
        this.t1.setBounds(350, 390, 320, 30);
        this.add(this.t1);
        this.l8.setBounds(100, 440, 180, 30);
        this.add(this.l8);
        this.t2.setBounds(350, 440, 320, 30);
        this.add(this.t2);
        this.l9.setBounds(100, 490, 150, 30);
        this.add(this.l9);
        this.r1.setBounds(350, 490, 100, 30);
        this.add(this.r1);
        this.r2.setBounds(460, 490, 100, 30);
        this.add(this.r2);
        this.l10.setBounds(100, 540, 180, 30);
        this.add(this.l10);
        this.r3.setBounds(350, 540, 100, 30);
        this.add(this.r3);
        this.r4.setBounds(460, 540, 100, 30);
        this.add(this.r4);
        this.b.setBounds(570, 640, 100, 30);
        this.add(this.b);
        this.b.addActionListener(this);
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(850, 750);
        this.setLocation(500, 120);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent ae) {
        final String religion = (String)this.c1.getSelectedItem();
        final String category = (String)this.c2.getSelectedItem();
        final String income = (String)this.c3.getSelectedItem();
        final String education = (String)this.c4.getSelectedItem();
        final String occupation = (String)this.c5.getSelectedItem();
        final String pan = this.t1.getText();
        final String aadhar = this.t2.getText();
        String scitizen = "";
        if (this.r1.isSelected()) {
            scitizen = "Yes";
        }
        else if (this.r2.isSelected()) {
            scitizen = "No";
        }
        String eaccount = "";
        if (this.r3.isSelected()) {
            eaccount = "Yes";
        }
        else if (this.r4.isSelected()) {
            eaccount = "No";
        }
        try {
            if (this.t2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }
            else {
                final conn c1 = new conn();
                final String q1 = "insert into signup2 values('" + this.formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + scitizen + "','" + eaccount + "')";
                c1.s.executeUpdate(q1);
                new Signup3(this.formno).setVisible(true);
                this.setVisible(false);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(final String[] args) {
        new Signup2("").setVisible(true);
    }
}

          
    