package model;
import java.util.HashMap;
public class Polynomial {
    public HashMap<Integer,Double> coefficients;

    public Polynomial(HashMap<Integer, Double> coefficients) {
        this.coefficients = new HashMap<>();
        this.coefficients.putAll(coefficients);
    }

    public HashMap<Integer, Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(HashMap<Integer, Double> coefficients) {
        this.coefficients = coefficients;
    }
}
