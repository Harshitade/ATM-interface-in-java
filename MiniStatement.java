/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator.system;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.awt.LayoutManager;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MiniStatement extends JFrame implements ActionListener
{
    JButton b1;
    JButton b2;
    JLabel l1;
    
    MiniStatement(final String pin) {
        super("Mini Statement");
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(400, 600);
        this.setLocation(20, 20);
        this.add(this.l1 = new JLabel());
        final JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150, 20, 100, 20);
        this.add(l2);
        final JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        this.add(l3);
        final JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        this.add(l4);
        try {
            final conn c = new conn();
            final ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pin + "'");
            while (rs.next()) {
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }
        catch (Exception ex) {}
        try {
            int balance = 0;
            final conn c2 = new conn();
            final ResultSet rs2 = c2.s.executeQuery("SELECT * FROM bank where pin = '" + pin + "'");
            while (rs2.next()) {
                this.l1.setText(this.l1.getText() + "<html>" + rs2.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs2.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs2.getString("amount") + "<br><br><html>");
                if (rs2.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs2.getString("amount"));
                }
                else {
                    balance -= Integer.parseInt(rs2.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs " + balance);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.setLayout(null);
        this.add(this.b1 = new JButton("Exit"));
        this.b1.addActionListener(this);
        this.l1.setBounds(20, 140, 400, 200);
        this.b1.setBounds(20, 500, 100, 25);
    }
    
    @Override
    public void actionPerformed(final ActionEvent ae) {
        this.setVisible(false);
    }
    
    public static void main(final String[] args) {
        new MiniStatement("").setVisible(true);
    }
}