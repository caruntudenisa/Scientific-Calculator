package controller;

import model.Polynomial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parse {
    public static Polynomial fromStringToPolynomial(String s){
        HashMap<Integer,Double> hashMap = new HashMap<>(); //we create a hashmap with keys and variables
        s=s.replaceAll("-","+-");
        List<String> list = List.of(s.split("\\+"));//we will split based on + to generate a list of monomials
        for(String string:list){
            if(string.equals("")){
                continue; //if the first element is empty
            }
            List<String> numbers = List.of(string.split("x\\^")); //we split here the coefficients and keys
            if(numbers.get(0).equals("")){
                hashMap.put(Integer.parseInt(numbers.get(1)),1.0); //the coefficient of the monomial is 1 because it is positive
            }else if(numbers.get(0).equals("-")){
                hashMap.put(Integer.parseInt(numbers.get(1)),-1.0);//the coefficient of the monomial is -1
            }else{
                hashMap.put(Integer.parseInt(numbers.get(1)),Double.parseDouble(numbers.get(0))); //we place the elements into the hashmap
            }
        }
        return new Polynomial(hashMap);
    }
    public static String fromPolynomialToString(Polynomial polynomial){
        StringBuilder stringBuilder = new StringBuilder();
        if(polynomial.getCoefficients().isEmpty()){
            stringBuilder.append("0"); //if there are no coefficients, therefore the answer is 0
        }
        for(Map.Entry<Integer,Double> newEntry : polynomial.getCoefficients().entrySet()) {
            if (newEntry.getValue() != 0) {
                if (!newEntry.toString().equals("") && newEntry.getValue() > 0) {
                    if(!stringBuilder.toString().equals("")){
                        stringBuilder.append("+");
                    }
                }
                if (newEntry.getValue() != 1 && newEntry.getValue() != -1) {
                    stringBuilder.append(Double.valueOf(newEntry.getValue()));
                }
                if (newEntry.getValue() == -1) {
                    stringBuilder.append("-");
                }
                stringBuilder.append("x^").append(newEntry.getKey());
            }
        }

        return stringBuilder.toString();
    }

}