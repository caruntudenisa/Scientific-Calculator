package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    JTextField textField1;
    JTextField textField2;
    JLabel resultLabel;
    JButton Addition;
    JButton Subtraction;
    JButton Differentiation;
    JButton Integration;

    public String getTextField1() {
        return textField1.getText();
    }

    public String getTextField2() {
        return textField2.getText();
    }
    public void setResultLabel(String s){
        resultLabel.setText(s);
    }

    public View() {

        this.setBounds(100, 100, 1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel Polynom1 = new JLabel("Polynom1:");
        Polynom1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Polynom1.setBounds(24, 140, 123, 36);
        this.getContentPane().add(Polynom1);

        JLabel Polynom2 = new JLabel("Polynom2:");
        Polynom2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Polynom2.setBounds(24, 204, 123, 36);
        this.getContentPane().add(Polynom2);

        textField1 = new JTextField();
        textField1.setBounds(192, 144, 222, 36);
        this.getContentPane().add(textField1);
        textField1.setColumns(10);

        textField2 = new JTextField();
        textField2.setColumns(10);
        textField2.setBounds(192, 204, 222, 36);
        this.getContentPane().add(textField2);

        JLabel Result = new JLabel("Result:");
        Result.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Result.setBounds(466, 169, 123, 36);
        this.getContentPane().add(Result);

        Addition = new JButton("Addition");
        Addition.setBounds(121, 325, 185, 50);
        this.getContentPane().add(Addition);

        Subtraction = new JButton("Subtraction");
        Subtraction.setBounds(122, 406, 185, 50);
        this.getContentPane().add(Subtraction);

        Differentiation = new JButton("Differentiation");
        Differentiation.setBounds(374, 324, 185, 50);
        this.getContentPane().add(Differentiation);

        Integration = new JButton("Integration");
        Integration.setBounds(376, 406, 185, 50);
        this.getContentPane().add(Integration);

        JLabel Calculator = new JLabel("Calculator");
        Calculator.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        Calculator.setBounds(415, 35, 200, 48);
        this.getContentPane().add(Calculator);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        resultLabel.setBounds(545, 165, 500, 56);
        this.getContentPane().add(resultLabel);
        this.setVisible(true);
    }
    public void setAdditionButtonActionListener(ActionListener additionButtonActionListener){
        Addition.addActionListener(additionButtonActionListener);
    }
    public void setSubtractionButtonActionListener(ActionListener subtractionButtonActionListener){
        Subtraction.addActionListener(subtractionButtonActionListener);
    }
    public void setDifferentiationButtonActionListener(ActionListener differentiationButtonActionListener){
        Differentiation.addActionListener(differentiationButtonActionListener);
    }
    public void setIntegrationButtonActionListener(ActionListener integrationButtonActionListener){
        Integration.addActionListener(integrationButtonActionListener);
    }
}

