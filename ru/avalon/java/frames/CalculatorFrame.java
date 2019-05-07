package ru.avalon.java.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ru.avalon.java.ui.AbstractFrame;

public class CalculatorFrame extends AbstractFrame {
    
    private JPanel outputPanel = new JPanel();
    private JPanel buttonsPanel = new JPanel();
    private JPanel equalsPanel = new JPanel();

    @Override
    protected void onCreate() {
        setTitle("Calculator");
        setSize(300, 500);
        setLayout(new GridLayout(3, 1, 5, 5));
        outputPanel = outputPanelCreator();
        add(outputPanel);
        
        buttonsPanel = buttonsPanelCreator();
        add(buttonsPanel);
        
        equalsPanel = equalsPanelCreator();
        add(equalsPanel);


    }

    private JPanel outputPanelCreator() {

        JLabel output = new JLabel();
        outputPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
        outputPanel.setBackground(Color.white);
        output.setVisible(true);
        output.setText("0");
        outputPanel.add(output);
     
        return outputPanel;
        
    }

    private JPanel buttonsPanelCreator() {
        
        buttonsPanel.setLayout(new GridLayout(4, 4, 5, 5));

        JButton one = new JButton();
        JButton two = new JButton();
        JButton three = new JButton();
        JButton four = new JButton();
        JButton five = new JButton();
        JButton six = new JButton();
        JButton seven = new JButton();
        JButton eight = new JButton();
        JButton nine = new JButton();
        JButton zero = new JButton();
        JButton plus = new JButton();
        JButton divide = new JButton();
        JButton minus = new JButton();
        JButton multiply = new JButton();
        JButton ce = new JButton();
        JButton dot = new JButton();
        
        one.setText("1");
        two.setText("2");
        three.setText("3");
        four.setText("4");
        five.setText("5");
        six.setText("6");
        seven.setText("7");
        eight.setText("8");
        nine.setText("9");
        zero.setText("0");
        plus.setText("+");
        minus.setText("-");
        multiply.setText("*");
        divide.setText("/");
        dot.setText(".");
        ce.setText("CE");
   
 
        buttonsPanel.add(seven);
        buttonsPanel.add(eight);
        buttonsPanel.add(nine);
        buttonsPanel.add(plus);
        buttonsPanel.add(four);
        buttonsPanel.add(five);
        buttonsPanel.add(six);
        buttonsPanel.add(minus);
        buttonsPanel.add(one);
        buttonsPanel.add(two);
        buttonsPanel.add(three);
        buttonsPanel.add(multiply);
        buttonsPanel.add(ce);
        buttonsPanel.add(zero);
        buttonsPanel.add(dot);
        buttonsPanel.add(divide);
        
        return buttonsPanel;
        
    }

    private JPanel equalsPanelCreator() {
        JButton equals = new JButton();
        equals.setText("=");
        equalsPanel.add(equals);
        
        return equalsPanel;
    }
    
    
    
    
}
