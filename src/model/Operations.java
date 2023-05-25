package model;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Operations {

    public static Polynomial Addition(Polynomial P1, Polynomial P2){
        HashMap<Integer,Double> result=new HashMap<>();
        result.putAll(P1.getCoefficients());

        for(Map.Entry<Integer,Double> newentry: P2.coefficients.entrySet()){
            Integer key= newentry.getKey(); //the power of the monomial
            Double value= newentry.getValue(); //the coefficient of the monomial
                if(result.containsKey(key)==true) //we check if we have the same key in the polynomial
                    result.put(key, value+ result.get(key)); //if true, we add the coeff
                else
                    result.put(key,value);
                if(result.get(key)==0.0)
                {
                    result.remove(key); //if the coefficient generated is 0, we eliminate it
                }

        }
        return new Polynomial(result);
    }

    public static Polynomial Subtraction(Polynomial P1, Polynomial P2){
        HashMap<Integer,Double> result=new HashMap<>();
        result.putAll(P1.getCoefficients());

        for(Map.Entry<Integer,Double> newentry: P2.coefficients.entrySet()){
            Integer key= newentry.getKey();
            Double value= newentry.getValue();
            if(result.containsKey(key)==true)
                result.put(key, result.get(key)-value);
            else
                result.put(key,value);
            if(result.get(key)==0.0)
            {
                result.remove(key);
            }

        }
        return new Polynomial(result);
    }

    public static Polynomial Differentiation(Polynomial P){
        HashMap<Integer,Double> result=new HashMap<>();

        for(Map.Entry<Integer,Double> newentry: P.coefficients.entrySet()){
            Integer key= newentry.getKey(); //variables that get the key and the value
            Double value= newentry.getValue();
            if(key!=0) {
                result.put(newentry.getKey()-1, value*key);
            }
        }
        return new Polynomial(result);
    }
    public static Polynomial Integration(Polynomial P){
        HashMap<Integer,Double> result=new HashMap<>();

        for(Map.Entry<Integer,Double> newentry: P.coefficients.entrySet()){
            Integer key= newentry.getKey();
            Double value= newentry.getValue();
                result.put(newentry.getKey()+1, value/(key+1));
        }
        return new Polynomial(result);
    }





}
