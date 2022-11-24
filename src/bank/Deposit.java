package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
	private String cardNo;
	
    JTextField amtTf;
    JButton deposit,back,exit;
    JLabel l1,l2;
    public Deposit(){
    	setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("DEPOSIT");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (6*x);
        int w = z/y;
        String pad ="";
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"DEPOSIT PAGE");
        
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("TO DEPOSIT");
        l2.setFont(new Font("System", Font.BOLD, 35));
        
        amtTf = new JTextField();
        amtTf.setFont(new Font("Raleway", Font.BOLD, 22));
        
        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("System", Font.BOLD, 18));
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
    
        back = new JButton("BACK");
        back.setFont(new Font("System", Font.BOLD, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        
        exit = new JButton("EXIT");
        exit.setFont(new Font("System", Font.BOLD, 18));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        
        
        getContentPane().setLayout(null);
        
        l1.setBounds(150,150,800,60);
        getContentPane().add(l1);
        
        l2.setBounds(290,210,800,60);
        getContentPane().add(l2);
        
        amtTf.setBounds(250,300,300,50);
        getContentPane().add(amtTf);
        
        deposit.setBounds(260,380,125,50);
        getContentPane().add(deposit);
        
        back.setBounds(415,380,125,50);
        getContentPane().add(back);
        
        exit.setBounds(300,550,200,50);
        getContentPane().add(exit);
        
        
        deposit.addActionListener(this);
        back.addActionListener(this);
        exit.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,650);
        setLocation(400,100);
        setVisible(true);
    }
    public Deposit(String cardNo){
    	this();
        this.cardNo=cardNo;
    }
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String amt = amtTf.getText();      
            
            
            if(ae.getSource()==deposit){
                if(amtTf.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                
                }else{
                    
                    conn c1 = new conn();
                    
                   
                    
                    String q1= "SELECT a.Balance,a.Account_Id,c.Card_Id FROM account as a INNER JOIN card as c ON a.Account_Id = c.Account_Id where Card_No="+cardNo;
             
                    
                    ResultSet rs=c1.s.executeQuery(q1);
                    rs.next();
                    int curBalance=rs.getInt(1);
                    int accId=rs.getInt(2);
                    int card_Id=rs.getInt(3);
                    
                    int newBalance = curBalance + Integer.parseInt(amt);
                    String sql="update account set Balance="+newBalance+" where Account_Id="+accId;
                    c1.s.executeUpdate(sql);
                                       
                    JOptionPane.showMessageDialog(null, "Rs. "+amt+" Deposited Successfully");
                                  
                    System.exit(0);
                    
                }
                
            }else if(ae.getSource()==back){
                
                new BankManagementSystem().setVisible(true);
                setVisible(false);
                
            }else if(ae.getSource()==exit){
                
                System.exit(0);
                
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
    public static void main(String[] args){
        new Deposit().setVisible(true);
    }

    
}
