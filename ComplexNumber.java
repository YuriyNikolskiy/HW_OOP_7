package hw7;

public class ComplexNumber {
    
    private double real;
    

    public ComplexNumber(double real) {
        this.real = real;
        
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

      

    @Override
    public String toString() {
        return real + "" +  "";
    }
}
