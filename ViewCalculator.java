package hw7;

import java.util.Scanner;

public class ViewCalculator {   

    LoggingService loggingSv = new LoggingService();

    OperationFactory operationFactory = new ConcreteOperationFactory();

    ComplexOperation addOperation = operationFactory.createAddOperation();
    ComplexOperation subtractOperation = operationFactory.createSubtractOperation();
    ComplexOperation multiplyOperation = operationFactory.createMultiplyOperation();
    ComplexOperation divideOperation = operationFactory.createDivideOperation();

   
    public void run() {
        while (true) {
            int real1 = promptInt("Enter a valid number: ");
            
           
            while (true) {
                String cmd = prompt("Enter the command ( *, /, +, - ) : ");
                if (cmd.equals("*")) {
                    viewCalc(real1, multiplyOperation );                    
                    break;
                }
                if (cmd.equals("/")) {
                    viewCalc(real1, divideOperation );                   
                    break;
                }
                if (cmd.equals("+")) {
                    viewCalc(real1, addOperation );                    
                    break;
                }
                if (cmd.equals("-")) {
                    viewCalc(real1, subtractOperation );                    
                    break;
                } else {
                    loggingSv.logError("The wrong command is selected, try again!");
                }               
            }
            String cmd = prompt("More count (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }

    private void viewCalc(int real1, ComplexOperation operation){
        int real2 = promptInt("Enter a valid 2nd number: ");
        
        ComplexNumber num1 = new ComplexNumber(real1);
        ComplexNumber num2 = new ComplexNumber(real2);
       
        Calculator subtractCalculator = new Calculator(operation);
        logViewOperation(num1, num2, operation);      
        ComplexNumber result = subtractCalculator.calculate(num1, num2);
        loggingSv.logInfo("The result of the calculation: " + result);
    } 

    private void logViewOperation(ComplexNumber a, ComplexNumber b, ComplexOperation operation){
        if(operation.equals(addOperation)){
            loggingSv.logInfo("Addition has been performed: " + a + " and " + b); 
        }
        else if(operation.equals(subtractOperation)){
            loggingSv.logInfo("Subtraction has been performed: " + a + " and " + b); 
        }
        else if(operation.equals(multiplyOperation)){
            loggingSv.logInfo("Multiplication is performed: " + a + " and " + b); 
        }
        else if(operation.equals(divideOperation)){
            loggingSv.logInfo("The division has been completed: " + a + " and " + b); 
        }

    }
}
