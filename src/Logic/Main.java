package Logic;

// Iron out chained operator bugs


import GUI.GUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Main extends Application implements EventHandler<ActionEvent> {
        private DecimalFormat d = new DecimalFormat("0.#####");
        private String operator2 = "";
        private String operator = "";
        private String curr = "";
        private String first = "";
        private String second = "";
        private TextField bank;
        private Button clearAll;
        private Button clearCurr;
        private Button one;
        private Button zero;
        private Button two;
        private Button three;
        private Button four;
        private Button five;
        private Button six;
        private Button seven;
        private Button eight;
        private Button nine;
        private Button dot;
        private Button equals;
        private Button add;
        private Button subtract;
        private Button divide;
        private Button multiply;
        private Button square;
        private Button squareRoot;
        private Button pie;
        private Button negSquare;
        private Button e;
        private Button ln;
        private Button draw;
        private Button matrix;
        private Button sin;
        private Button cos;
        private Button tan;
        private Button blank; // Maybe radians/ degree button
        private DecimalFormat pFormat = new DecimalFormat("#.##########");
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage PrimaryStage) throws Exception{
        Stage window = PrimaryStage;
        createButtons();
        GridPane base = formatButtons();
        Scene layout = new Scene(base,246,305);
        window.setScene(layout);
        window.setResizable(false);
        window.setTitle("Calculator");
        window.show();
        watch();

    }
    @Override
    public void handle(ActionEvent event){
    }

    //Possibly add a function to display previous number in upper right hand corner of calculator

    private void createButtons(){
        blank = new Button("");
        sin = new Button("Sin");
        cos = new Button("Cos");
        tan = new Button("Tan");
        ln = new Button("ln");
        matrix = new Button("Matrix");
        matrix.setStyle("-fx-font-size: 10;");
        draw = new Button("Draw");
        negSquare = new Button("x⁻¹");
        e = new Button("e");
        pie = new Button("π");
        square = new Button("x²");
        squareRoot = new Button("√x");
        clearCurr = new Button("C");
        clearAll = new Button("AC");
        one = new Button("1");
        zero = new Button("0");
        two = new Button("2");
        three = new Button("3");
        four = new Button("4");
        five = new Button("5");
        six = new Button("6");
        seven = new Button("7");
        eight = new Button("8");
        nine = new Button("9");
        dot = new Button(".");
        add= new Button("+");
        subtract = new Button("-");
        equals = new Button("=");
        divide = new Button("/");
        multiply = new Button("*");
        Button[] store = {one,zero,two,three,four,five,six,seven,eight,nine,
                          multiply,divide,equals,subtract,add,dot,sin,cos,tan,blank};
        Button[] second = {clearAll,clearCurr,square,squareRoot,pie,e,negSquare,ln,matrix,draw};
        for (Button x: store){
            x.setPrefHeight(50);
            x.setPrefWidth(50);
            x.setStyle("-fx-background-color: rgb(225, 228, 203)");
            x.setStyle("-fx-base: rgb(169,169,169)");
        }
        for (Button x: second){
            x.setPrefHeight(25);
            x.setPrefWidth(50);
            x.setStyle("-fx-background-color: rgb(225, 228, 203)");
            x.setStyle("-fx-base: rgb(169,169,169)");
        }


    }
    private GridPane formatButtons(){
        GridPane base = new GridPane();
        bank = new TextField();
        bank.setPrefHeight(75.0);
        bank.setPrefColumnCount(4);
        bank.setStyle("-fx-font-size: 3em;"); // find good font
        bank.setAlignment(Pos.CENTER_RIGHT);
        bank.setEditable(false);
        StackPane frame = new StackPane();
        frame.getChildren().addAll(bank);
        base.setVgap(1);
        base.setHgap(1);
        base.add(frame,1,1,5,1);
        ///////////////////////////////////////////////
        base.add(draw,1,2);
        base.add(ln,2,2);
        base.add(e,3,2);
        base.add(pie,4,2);
        base.add(clearAll,5,2);
        ///////////////////////////////////////////////
        base.add(matrix,1,3);
        base.add(squareRoot,2,3);
        base.add(negSquare,3,3);
        base.add(square,4,3);
        base.add(clearCurr,5,3);
        ///////////////////////////////////////////////
        base.add(sin,1,4);
        base.add(seven,2,4);
        base.add(eight,3,4);
        base.add(nine,4,4);
        base.add(divide,5,4);
        ///////////////////////////////////////////////
        base.add(cos,1,5);
        base.add(four,2,5);
        base.add(five,3,5);
        base.add(six,4,5);
        base.add(multiply,5,5);
        ///////////////////////////////////////////////
        base.add(tan,1,6);
        base.add(one,2,6);
        base.add(two,3,6);
        base.add(three,4,6);
        base.add(subtract,5,6);
        ///////////////////////////////////////////////
        base.add(blank,1,7);
        base.add(zero,2,7);
        base.add(dot,3,7);
        base.add(equals,4,7);
        base.add(add,5,7);




        return base;
    }
    private void watch(){
        // Implement String Builder at later date to increase speed
        HashMap<Button,String> store2 = new HashMap<>();
        Button[] numbers = {zero,one,two,three,four,five,six,seven,eight,nine};
        String[] text = {"0","1","2","3","4","5","6","7","8","9"};
        for (int i = 0 ; i < numbers.length; i++){
            store2.put(numbers[i],text[i]);
        }
        for (Button x: store2.keySet()){
            x.setOnAction(event -> {
                if (curr.length() <= 11) {
                    bank.appendText(store2.get(x));
                    curr += store2.get(x);
                }
            });
        }
        draw.setOnAction(event -> {
            Stage secondary = new Stage();
            GUI option = new GUI(100,100);
            secondary.setScene(option.make());
            secondary.show();
        });
        dot.setOnAction(event -> {
            HashMap<Character,Integer> cycle = new HashMap<>();
            char[] storage = curr.toCharArray();
            for (char x: storage){
                cycle.put(x,1);
            }
            if (!cycle.containsKey('.')) {
                bank.appendText(".");
                curr += ".";
            }
        });
        clearAll.setOnAction(event -> {
            first = "";
            second = "";
            curr = "";
            operator = "";
            bank.setText("");
        });
        clearCurr.setOnAction(event -> {
            curr = "";
            bank.setText("");
        });
        //Maybe refactor using loops if more similar operations such as these appear.
        square.setOnAction(event -> {
            if (curr.length() > 0 && !operator.equals("Sin") && !operator.equals("Tan") &&!operator.equals("Cos") && !operator.equals("ln")) {
                double result = Math.pow(Double.parseDouble(curr), 2);
                System.out.println(operator);
                curr = d.format(result);
                bank.setText(curr);
            }
            else if (curr.length() > 0 && operator.equals("Sin") || operator.equals("Tan") || operator.equals("Cos") || operator.equals("ln")){
                double eval = 0;
                double result = 0;
                switch (operator){
                    case "Sin":
                        eval = Math.sin(Double.parseDouble(curr));
                        break;
                    case "Cos":
                        eval = Math.cos(Double.parseDouble(curr));
                        break;
                    case "Tan":
                        eval = Math.tan(Double.parseDouble(curr));
                        break;
                    case "ln":
                        eval = Math.log(Double.parseDouble(curr));
                        break;
                }
                result = Math.pow(eval,2);
                curr = pFormat.format(result);
                bank.setText(curr);
            }
        });
        squareRoot.setOnAction(event -> {
            if (curr.length() > 0 && !operator.equals("Sin") && !operator.equals("Tan") &&!operator.equals("Cos") && !operator.equals("ln") ) {
                double result = Math.pow(Double.parseDouble(curr), 0.5);
                curr = d.format(result);
                bank.setText(curr);
            }
            else if (curr.length() > 0 && operator.equals("Sin") || operator.equals("Tan") || operator.equals("Cos") || operator.equals("ln")){
                double eval = 0;
                double result = 0;
                switch (operator){
                    case "Sin":
                        eval = Math.sin(Double.parseDouble(curr));
                        break;
                    case "Cos":
                        eval = Math.cos(Double.parseDouble(curr));
                        break;
                    case "Tan":
                        eval = Math.tan(Double.parseDouble(curr));
                        break;
                    case "ln":
                        eval = Math.log(Double.parseDouble(curr));
                        break;
                }
                result = Math.pow(eval,0.5);
                curr = pFormat.format(result);
                bank.setText(curr);
            }
        });
        negSquare.setOnAction(event -> {
            if (curr.length() > 0 && !operator.equals("Sin") && !operator.equals("Tan") &&!operator.equals("Cos") && !operator.equals("ln")) {
                double result = Math.pow(Double.parseDouble(curr), -1);
                curr = d.format(result);
                bank.setText(curr);
            }
            else if (curr.length() > 0 && operator.equals("Sin") || operator.equals("Tan") || operator.equals("Cos") || operator.equals("ln")){
                double eval = 0;
                double result = 0;
                switch (operator){
                    case "Sin":
                        eval = Math.sin(Double.parseDouble(curr));
                        break;
                    case "Cos":
                        eval = Math.cos(Double.parseDouble(curr));
                        break;
                    case "Tan":
                        eval = Math.tan(Double.parseDouble(curr));
                        break;
                    case "ln":
                        eval = Math.log(Double.parseDouble(curr));
                        break;
                }
                result = Math.pow(eval,-1);
                curr = pFormat.format(result);
                bank.setText(curr);
            }
        });
        // Add functionality to directly multiply pie after selecting operator similar to above
        pie.setOnAction(event -> {
            if (curr.length() == 0){
                curr = pFormat.format(Math.PI);
                bank.setText(curr);
            }
        });
        e.setOnAction(event -> {
            if (curr.length() == 0){
                curr = pFormat.format(Math.E);
                bank.setText(curr);
            }
        });
        //Maybe come back and implement ln(x);
        ln.setOnAction(event -> {
            if (curr.length() > 0) {
                double result = Math.log(Double.parseDouble(curr));
                curr = pFormat.format(result);
                bank.setText(curr);

            }
            else{
                bank.setText("ln -> ");
                operator = "ln";
            }
        });
        sin.setOnAction(event -> {
            if (curr.length() > 0) {
                double result = Math.sin(Double.parseDouble(curr));
                curr = pFormat.format(result);
                bank.setText(curr);

            }
            else{
                bank.setText("Sin -> ");
                operator = "Sin";
            }
        });
        cos.setOnAction(event -> {
            if (curr.length() > 0) {
                double result = Math.cos(Double.parseDouble(curr));
                curr = pFormat.format(result);
                bank.setText(curr);

            }
            else{
                bank.setText("Cos -> ");
                operator = "Cos";
            }
        });
        tan.setOnAction(event -> {
            if (curr.length() > 0) {
                double result = Math.tan(Double.parseDouble(curr));
                curr = pFormat.format(result);
                bank.setText(curr);

            }
            else{
                bank.setText("Tan -> ");
                operator = "Tan";
            }
        });
        // Fix double dot chance


        add.setOnAction(event -> {
            if (curr.length() > 0 && first.length() == 0 && !operator.equals("Sin") && !operator.equals("Tan") &&!operator.equals("Cos") && !operator.equals("ln") ){
                first = curr;
                curr = "";
                bank.setText("");
                operator = "+";
            }
            // Multiple chained operations?
            else if (curr.length() > 0 && first.length() > 0 && operator == "+"){
                second = curr;
                double r = Double.parseDouble(first) + Double.parseDouble(second);
                curr = d.format(r);
                second = "";
                first = "";
                bank.setText(curr);
            }
            else if ((curr.length() > 0 && first.length() == 0 && operator.equals("Sin") || operator.equals("Tan") || operator.equals("Cos") || operator.equals("ln") )){
                double result;
                switch (operator){
                    case "Sin":
                        bank.setText("");
                        result = Math.sin(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "Cos":
                        bank.setText("");
                        result = Math.cos(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "Tan":
                        bank.setText("");
                        result = Math.tan(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "ln":
                        bank.setText("");
                        result = Math.log(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                }
                operator = "+";
                operator2 = "+";
            }

        });
        subtract.setOnAction(event -> {
            if (curr.length() > 0 && first.length() == 0 && !operator.equals("Sin") && !operator.equals("Tan") &&!operator.equals("Cos") && !operator.equals("ln") ){
                first = curr;
                curr = "";
                bank.setText("");
                operator = "-";
            }
            // Multiple chained operations?
            else if (curr.length() > 0 && first.length() > 0 && operator == "-"){
                second = curr;
                double r = Double.parseDouble(first) - Double.parseDouble(second);
                curr = d.format(r);
                second = "";
                first = "";
                bank.setText(curr);
            }
            else if ((curr.length() > 0 && first.length() == 0 && operator.equals("Sin") || operator.equals("Tan") || operator.equals("Cos") || operator.equals("ln") )){
                double result;
                switch (operator){
                    case "Sin":
                        bank.setText("");
                        result = Math.sin(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "Cos":
                        bank.setText("");
                        result = Math.cos(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "Tan":
                        bank.setText("");
                        result = Math.tan(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "ln":
                        bank.setText("");
                        result = Math.log(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                }
                operator = "-";
                operator2 = "-";
            }

        });
        multiply.setOnAction(event -> {
            if (curr.length() > 0 && first.length() == 0 && !operator.equals("Sin") && !operator.equals("Tan") &&!operator.equals("Cos") && !operator.equals("ln") ){
                first = curr;
                curr = "";
                bank.setText("");
                operator = "*";
            }
            // Multiple chained operations?
            else if (curr.length() > 0 && first.length() > 0 && operator == "*"){
                second = curr;
                double r = Double.parseDouble(first) * Double.parseDouble(second);
                curr = d.format(r);
                second = "";
                first = "";
                bank.setText(curr);
            }
            else if ((curr.length() > 0 && first.length() == 0 && operator.equals("Sin") || operator.equals("Tan") || operator.equals("Cos") || operator.equals("ln") )){
                double result;
                switch (operator){
                    case "Sin":
                        bank.setText("");
                        result = Math.sin(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "Cos":
                        bank.setText("");
                        result = Math.cos(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "Tan":
                        bank.setText("");
                        result = Math.tan(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "ln":
                        bank.setText("");
                        result = Math.log(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                }
                operator = "*";
                operator2 = "*";
            }

        });
        divide.setOnAction(event -> {
            if (curr.length() > 0 && first.length() == 0 && !operator.equals("Sin") && !operator.equals("Tan") &&!operator.equals("Cos") && !operator.equals("ln") ){
                first = curr;
                curr = "";
                bank.setText("");
                operator = "/";
            }
            // Multiple chained operations?
            else if (curr.length() > 0 && first.length() > 0 && operator.equals("/")){
                second = curr;
                double r = Double.parseDouble(first) / Double.parseDouble(second);
                curr = d.format(r);
                second = "";
                first = "";
                bank.setText(curr);
            }
            else if ((curr.length() > 0 && first.length() == 0 && operator.equals("Sin") || operator.equals("Tan") || operator.equals("Cos") || operator.equals("ln") )){
                double result;
                switch (operator){
                    case "Sin":
                        bank.setText("");
                        result = Math.sin(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "Cos":
                        bank.setText("");
                        result = Math.cos(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "Tan":
                        bank.setText("");
                        result = Math.tan(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                    case "ln":
                        bank.setText("");
                        result = Math.log(Double.parseDouble(curr));
                        first = pFormat.format(result);
                        curr = "";

                        break;
                }
                operator = "/";
                operator2 = "/";
            }

        });
        equals.setOnAction(event -> {
            double result = 0;
            if (curr.length() > 0 && first.length() > 0){
                if (!operator.equals("Sin") && !operator.equals("Tan") &&!operator.equals("Cos") && !operator.equals("ln")){
                    second = curr;
                }
                else if(operator.equals("Sin") || operator.equals("Tan") || operator.equals("Cos") || operator.equals("ln")){

                    switch (operator){
                        case "Sin":
                            second = Double.toString(Math.sin(Double.parseDouble(curr)));
                            break;
                        case "Cos":
                            second = Double.toString(Math.cos(Double.parseDouble(curr)));
                            break;
                        case "Tan":
                            second = Double.toString(Math.tan(Double.parseDouble(curr)));
                            break;
                        case "ln":
                            second = Double.toString(Math.log(Double.parseDouble(curr)));
                            break;
                    }
                }
                double num1 = Double.parseDouble(first);
                double num2 = Double.parseDouble(second);
                Calculator calc = new Calculator(num1,num2);
                operator = operator2;
                switch (operator) {
                    case "+":
                        result = calc.add();
                        operator = "";
                        break;
                    case "-":
                        result = calc.subtract();
                        operator = "";
                        break;
                    case "*":
                        result = calc.multiply();
                        operator = "";
                        break;
                    case "/":
                        result = calc.divide();
                        operator = "";
                        break;


                }
                second = "";
                first = "";
                curr = pFormat.format(result);
                bank.setText(curr);

            }
            else if(operator.equals("Sin") || operator.equals("Cos") || operator.equals("Tan") || operator.equals("ln") && first == ""){
                switch (operator){
                    case "Sin":
                        result = Math.sin(Double.parseDouble(curr));
                        break;
                    case "Cos":
                        result = Math.cos(Double.parseDouble(curr));
                        break;
                    case "Tan":
                        result = Math.tan(Double.parseDouble(curr));
                        break;
                    case "ln":
                        result = Math.log(Double.parseDouble(curr));
                        break;
                }
                operator = "";
                first = "";
                second = "";
                curr = pFormat.format(result);
                bank.setText(curr);
            }
        });

    }

}


// Add support for SIN/TAN/COS/LN operation to come after operator
// Thinking about cloning first addition operator with switch statements