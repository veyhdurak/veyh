package com.typee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Typee {
    private JTextField textField1;
    private JPanel panel1;
    private JTextField burakingTextField;

    static String def = "veyseler";
    static int i = 0;
    boolean correctness = true;
    static StringBuilder typed = new StringBuilder();

    public void changeColorWithCorrectness()
    {
        if(typed.length()<=def.length() && typed.toString().equals(def.substring(0,typed.length())))
        {
            correctness = true;
            textField1.setForeground(Color.GREEN);
        }
        else
        {
            correctness = false;
            textField1.setForeground(Color.RED);
        }
    }

    public Typee() {
        burakingTextField.setText(def);
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //super.keyTyped(e);
                char enteredCh = e.getKeyChar();
                //Delete
                if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
                    if(typed.length()!=0)
                    {
                        typed.setLength(typed.length()-1);
                        changeColorWithCorrectness();
                    }
                }
                //Add char
                else{
                    typed.append(enteredCh);
                    if(typed.toString().equals(def)){
                        JOptionPane.showMessageDialog(null,"Correct");
                    }
                    changeColorWithCorrectness();

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Typee");
        frame.setContentPane(new Typee().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
