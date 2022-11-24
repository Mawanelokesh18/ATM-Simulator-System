
package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BankManagementSystem extends JFrame  {
	
	private String cardNo;
	
	public BankManagementSystem()
	{}
	public BankManagementSystem(String cardNo) {
		JLabel l1;
		this.cardNo=cardNo;
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("All Serices");
        int y = fm.stringWidth(" ");
        int z = getWidth() - x;
        int w = z/y;
        String pad ="";
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"               All Services                  ");
        
        
        l1 = new JLabel("Welcome to CDGI Bank");
        l1.setFont(new Font("Osward", Font.BOLD, 48));
        
        
        getContentPane().setLayout(null);
        
        l1.setBounds(102,-50,550,368);
        getContentPane().add(l1);
        
        getContentPane().setBackground(new Color(0, 128, 255));
        
        JButton b2_1 = new JButton("Fast-Cash");
        b2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FastCash fc=new FastCash();
                fc.show();
                
                dispose();
        	}
        });
        b2_1.setForeground(Color.WHITE);
        b2_1.setFont(new Font("Arial", Font.BOLD, 14));
        b2_1.setBackground(Color.BLACK);
        b2_1.setBounds(485, 312, 199, 51);
        getContentPane().add(b2_1);
        
        JButton b2_2 = new JButton("Change-Pin");
        b2_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Pin pn=new Pin();
                pn.show();
                
                dispose();
        	}
        });
        b2_2.setForeground(Color.WHITE);
        b2_2.setFont(new Font("Arial", Font.BOLD, 14));
        b2_2.setBackground(Color.BLACK);
        b2_2.setBounds(51, 420, 199, 51);
        getContentPane().add(b2_2);
        
        JButton b2_3 = new JButton("withdrawl");
        b2_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	Withdrawl wd=new Withdrawl();
                wd.show();
                
                dispose();
        	}
        });
        b2_3.setForeground(Color.WHITE);
        b2_3.setFont(new Font("Arial", Font.BOLD, 14));
        b2_3.setBackground(Color.BLACK);
        b2_3.setBounds(485, 420, 199, 51);
        getContentPane().add(b2_3);
        
        JButton b2_2_1 = new JButton("Deposit");
        b2_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Deposit dp=new Deposit(cardNo);
                dp.show();
                
                dispose();
        	}
        });
        b2_2_1.setForeground(Color.WHITE);
        b2_2_1.setFont(new Font("Arial", Font.BOLD, 14));
        b2_2_1.setBackground(Color.BLACK);
        b2_2_1.setBounds(51, 312, 199, 51);
        getContentPane().add(b2_2_1);
        
        JButton b2_2_2 = new JButton("Mini-Statement");
        b2_2_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MiniStatement ms=new MiniStatement();
                ms.show();
                
                dispose();
        	}
        });
        b2_2_2.setForeground(Color.WHITE);
        b2_2_2.setFont(new Font("Arial", Font.BOLD, 14));
        b2_2_2.setBackground(Color.BLACK);
        b2_2_2.setBounds(266, 536, 199, 51);
        getContentPane().add(b2_2_2);
        
        setSize(750,650);
        setLocation(400,100);
        setVisible(true);
	}
	
	
    
    public static void main(String[] args) {
    	 new BankManagementSystem().setVisible(true);
    }
}
