package controller;

import model.Polynomial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parse {
    public static Polynomial fromStringToPolynomial(String s){
        HashMap<Integer,Double> hashMap = new HashMap<>(); //hashmap cu coef si var
        s=s.replaceAll("-","+-");//inlocuim - cu +-
        List<String> list = List.of(s.split("\\+"));//split in functie de + pentru a face o lista de monoame
        for(String string:list){
            if(string.equals("")){
                continue; //daca primul element e empty
            }
            List<String> numbers = List.of(string.split("x\\^")); //split the coeff si keys
            if(numbers.get(0).equals("")){
                hashMap.put(Integer.parseInt(numbers.get(1)),1.0); //coef monomului e 1
            }else if(numbers.get(0).equals("-")){
                hashMap.put(Integer.parseInt(numbers.get(1)),-1.0);//coef monomului e -1
            }else{
                hashMap.put(Integer.parseInt(numbers.get(1)),Double.parseDouble(numbers.get(0))); //pun elementele in hashmap
            }
        }
        return new Polynomial(hashMap);
    }
    public static String fromPolynomialToString(Polynomial polynomial){
        StringBuilder stringBuilder = new StringBuilder();
        if(polynomial.getCoefficients().isEmpty()){
            stringBuilder.append("0"); //nimic=0
        }
        for(Map.Entry<Integer,Double> newEntry : polynomial.getCoefficients().entrySet()) {
            if (newEntry.getValue() != 0) {
                if (!newEntry.toString().equals("") && newEntry.getValue() > 0) {
                    if(!stringBuilder.toString().equals("")){
                        stringBuilder.append("+");
                    }
                }
                if (newEntry.getValue() != 1 && newEntry.getValue() != -1) {
                    stringBuilder.append(Double.valueOf(newEntry.getValue())); //we place in the string the coeff
                }
                if (newEntry.getValue() == -1) {
                    stringBuilder.append("-"); //string builder and the append adds things to the string
                }
                stringBuilder.append("x^").append(newEntry.getKey());
            }
        }

        return stringBuilder.toString();
    }

}
