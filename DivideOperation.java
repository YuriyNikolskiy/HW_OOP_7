package hw7;

public class DivideOperation implements ComplexOperation {
    public ComplexNumber operate(ComplexNumber a, ComplexNumber b) {
        
        double realPart = (a.getReal() / b.getReal());
        
        return new ComplexNumber(realPart);
    }
}
