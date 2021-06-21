/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator.system;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Withdrawal extends JFrame implements ActionListener
{
    JTextField t1;
    JTextField t2;
    JButton b1;
    JButton b2;
    JButton b3;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    String pin;
    
    Withdrawal(final String pin) {
        this.pin = pin;
        final ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/icons/atm.jpg"));
        final Image i2 = i1.getImage().getScaledInstance(1000, 1180, 1);
        final ImageIcon i3 = new ImageIcon(i2);
        final JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        this.add(l3);
        (this.l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000")).setForeground(Color.WHITE);
        this.l1.setFont(new Font("System", 1, 16));
        (this.l2 = new JLabel("PLEASE ENTER YOUR AMOUNT")).setForeground(Color.WHITE);
        this.l2.setFont(new Font("System", 1, 16));
        (this.t1 = new JTextField()).setFont(new Font("Raleway", 1, 25));
        this.b1 = new JButton("WITHDRAW");
        this.b2 = new JButton("BACK");
        this.setLayout(null);
        this.l1.setBounds(190, 350, 400, 20);
        l3.add(this.l1);
        this.l2.setBounds(190, 400, 400, 20);
        l3.add(this.l2);
        this.t1.setBounds(190, 450, 330, 30);
        l3.add(this.t1);
        this.b1.setBounds(390, 588, 150, 35);
        l3.add(this.b1);
        this.b2.setBounds(390, 633, 150, 35);
        l3.add(this.b2);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.setSize(960, 1080);
        this.setLocation(500, 0);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent ae) {
        try {
            final String amount = this.t1.getText();
            final Date date = new Date();
            if (ae.getSource() == this.b1) {
                if (this.t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }
                else {
                    final conn c1 = new conn();
                    final ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + this.pin + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("mode").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        }
                        else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    c1.s.executeUpdate("insert into bank values('" + this.pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    this.setVisible(false);
                    new Transactions(this.pin).setVisible(true);
                }
            }
            else if (ae.getSource() == this.b2) {
                this.setVisible(false);
                new Transactions(this.pin).setVisible(true);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: " + e);
        }
    }
    
    public static void main(final String[] args) {
        new Withdrawal("").setVisible(true);
    }
}