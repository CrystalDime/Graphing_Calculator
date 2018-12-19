package Logic;

public class Calculator {
    double num1;
    double num2;
    public Calculator(double first, double second){
        this.num1 = first;
        this.num2 = second;
    }
    public double add(){
        return num1 + num2;
    }
    public double subtract(){
        return num1 - num2;
    }
    public double divide(){
        return num1 / num2;
    }
    public double multiply(){
        return num1 * num2;
    }
}
