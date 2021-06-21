/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator.system;

/**
 *
 * @author V saal
 */
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class FastCash extends JFrame implements ActionListener
{
    JLabel l1;
    JLabel l2;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    JTextField t1;
    String pin;
    
    FastCash(final String pin) {
        this.pin = pin;
        final ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/icons/atm.jpg"));
        final Image i2 = i1.getImage().getScaledInstance(1000, 1180, 1);
        final ImageIcon i3 = new ImageIcon(i2);
        final JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        this.add(l3);
        (this.l1 = new JLabel("SELECT WITHDRAWL AMOUNT")).setForeground(Color.WHITE);
        this.l1.setFont(new Font("System", 1, 16));
        this.b1 = new JButton("Rs 100");
        this.b2 = new JButton("Rs 500");
        this.b3 = new JButton("Rs 1000");
        this.b4 = new JButton("Rs 2000");
        this.b5 = new JButton("Rs 5000");
        this.b6 = new JButton("Rs 10000");
        this.b7 = new JButton("BACK");
        this.setLayout(null);
        this.l1.setBounds(235, 400, 700, 35);
        l3.add(this.l1);
        this.b1.setBounds(170, 499, 150, 35);
        l3.add(this.b1);
        this.b2.setBounds(390, 499, 150, 35);
        l3.add(this.b2);
        this.b3.setBounds(170, 543, 150, 35);
        l3.add(this.b3);
        this.b4.setBounds(390, 543, 150, 35);
        l3.add(this.b4);
        this.b5.setBounds(170, 588, 150, 35);
        l3.add(this.b5);
        this.b6.setBounds(390, 588, 150, 35);
        l3.add(this.b6);
        this.b7.setBounds(390, 633, 150, 35);
        l3.add(this.b7);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.b3.addActionListener(this);
        this.b4.addActionListener(this);
        this.b5.addActionListener(this);
        this.b6.addActionListener(this);
        this.b7.addActionListener(this);
        this.setSize(960, 1080);
        this.setLocation(500, 0);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent ae) {
        try {
            final String amount = ((JButton)ae.getSource()).getText().substring(3);
            final conn c = new conn();
            final ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + this.pin + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            final String num = "17";
            if (ae.getSource() != this.b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }
            if (ae.getSource() == this.b7) {
                this.setVisible(false);
                new Transactions(this.pin).setVisible(true);
            }
            else {
                final Date date = new Date();
                c.s.executeUpdate("insert into bank values('" + this.pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                this.setVisible(false);
                new Transactions(this.pin).setVisible(true);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(final String[] args) {
        new FastCash("").setVisible(true);
    }
}
