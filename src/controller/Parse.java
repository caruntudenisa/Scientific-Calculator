package controller;

import model.Polynomial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parse {
    public static Polynomial fromStringToPolynomial(String s){
        HashMap<Integer,Double> hashMap = new HashMap<>();
        s=s.replaceAll("-","+-");
        List<String> list = List.of(s.split("\\+"));
        for(String string:list){
            if(string.equals("")){
                continue;
            }
            List<String> numbers = List.of(string.split("x\\^"));
            if(numbers.get(0).equals("")){
                hashMap.put(Integer.parseInt(numbers.get(1)),1.0);
            }else if(numbers.get(0).equals("-")){
                hashMap.put(Integer.parseInt(numbers.get(1)),-1.0);
            }else{
                hashMap.put(Integer.parseInt(numbers.get(1)),Double.parseDouble(numbers.get(0)));
            }
        }
        return new Polynomial(hashMap);
    }
    public static String fromPolynomialToString(Polynomial polynomial){
        StringBuilder stringBuilder = new StringBuilder();
        if(polynomial.getCoefficients().isEmpty()){
            stringBuilder.append("0");
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
