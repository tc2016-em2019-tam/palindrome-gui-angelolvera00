package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class Palindromo extends JFrame {
    private JTextField text= new JTextField();
    private JLabel PLabel = new JLabel("Enter word");
    private JLabel Result = new JLabel("Is it a Palindrome?");
    private JLabel verification = new JLabel();


    private ArrayList<String> stack;


    public Palindromo(){
        stack = new ArrayList<>();



        this.setTitle("Palindromes");
        this.setSize(250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JButton Check = new JButton("Check if it's palindrome");

        Check.addActionListener(new ActionListener() {
            @Override

                public void actionPerformed(ActionEvent e){
                push(text.getText());
                    String clean = text.getText().replaceAll("\\s+","").toLowerCase();
                    int length= clean.length();
                    int forward =0;
                    int backward= length-1;
                    while(backward>forward){
                        char forwardc= clean.charAt(forward++);
                        char backwardc= clean.charAt(backward--);
                        if (forwardc!=backwardc){
                            verification.setText("Not a palindrome");

                        }else{verification.setText("It's a palindrome");}

                    }pop();

                }
            });

        JPanel panel1= new JPanel();
        panel1.setLayout(new GridLayout(2,2));

        panel1.add(PLabel);
        panel1.add(text);
        panel1.add(Result);
        panel1.add(verification);

        this.add(panel1,BorderLayout.CENTER);
        this.add(Check,BorderLayout.SOUTH);



        this.setVisible(true);
    }
    public void push(String text){stack.add(text);}

    public String pop(){
            return stack.remove(stack.size()-1);

    }
    }

