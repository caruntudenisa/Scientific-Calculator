package controller;

import model.Operations;
import model.Polynomial;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    public Controller(View view){
        this.view=view;
        this.view.setAdditionButtonActionListener(new additionButton());
        this.view.setSubtractionButtonActionListener(new subtractionButton());
        this.view.setIntegrationButtonActionListener(new integrationButton());
        this.view.setDifferentiationButtonActionListener(new differentiationButton());
    }
    class additionButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String polynomial1 = view.getTextField1();
            String polynomial2 = view.getTextField2();
            Polynomial p1 = Parse.fromStringToPolynomial(polynomial1);
            Polynomial p2 = Parse.fromStringToPolynomial(polynomial2);
            Polynomial result = Operations.Addition(p1,p2);
            view.setResultLabel(Parse.fromPolynomialToString(result));
        }
    }
    class subtractionButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String polynomial1 = view.getTextField1();
            String polynomial2 = view.getTextField2();
            Polynomial p1 = Parse.fromStringToPolynomial(polynomial1);
            Polynomial p2 = Parse.fromStringToPolynomial(polynomial2);
            Polynomial result = Operations.Subtraction(p1,p2);
            view.setResultLabel(Parse.fromPolynomialToString(result));
        }
    }
    class differentiationButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String polynomial1 = view.getTextField1();
            Polynomial p1 = Parse.fromStringToPolynomial(polynomial1);
            Polynomial result = Operations.Differentiation(p1);
            view.setResultLabel(Parse.fromPolynomialToString(result));
        }
    }
    class integrationButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String polynomial1 = view.getTextField1();
            Polynomial p1 = Parse.fromStringToPolynomial(polynomial1);
            Polynomial result = Operations.Integration(p1);
            view.setResultLabel(Parse.fromPolynomialToString(result));
        }
    }
}

