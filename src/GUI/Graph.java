package GUI;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

import java.util.Arrays;
//add support for large numbers
public class Graph {
    private String equation;
    private String type;
    private double[] vPoint = {1,1};
    public Graph(String equation,String t){
        this.type = t;
        this.equation = equation;

    }
    private int[][] linear(){
        equation = equation.replace(" ","");
        char[] bank = equation.toCharArray();
        bank = Arrays.copyOfRange(bank, 2,bank.length );
        int index = 0;
        for (int i = 0; i < bank.length; i++){
            if (bank[i] == 'x' || bank[i] == 'X'){
                index = i;
            }
        }
        System.out.println(Arrays.toString(bank));
        int[][] points = new int[20][2];
        String firstHalf = new String(Arrays.copyOfRange(bank,0,index));
        String secondHalf = new String(Arrays.copyOfRange(bank,index + 2,bank.length));
        int Multiple = Integer.parseInt(firstHalf);
        int addition = Integer.parseInt(secondHalf);
        if (bank[index + 1] == '-') {addition *= -1;}
        //add support for ( and ) by adding if statements instead of just converting to Strings
        int j = 0;
        for (int x = -10; x < 10; x++,j++){
            int y = (x * Multiple) + addition;
            int[] r = {x,y};
            points[j] = r;
        }
        return points;
    }
    private int[][] exponential(){
        // add support for ( and ) I.E : 5 ^ (x + 3)
        equation = equation.replace(" ","");
        char[] bank = equation.toCharArray();
        bank = Arrays.copyOfRange(bank, 2,bank.length );
        int index = 0;
        for (int i = 0; i < bank.length; i++){
            if (bank[i] == '^'){
                index = i;
            }
        }
        int[][] points = new int[6][2];
        String firstHalf = new String(Arrays.copyOfRange(bank,0,index));
        String secondHalf;
        if (bank[index + 1] == '-') {
            secondHalf = new String(Arrays.copyOfRange(bank, index + 3, bank.length));
        }
        else{
            secondHalf = new String(Arrays.copyOfRange(bank, index + 2, bank.length));
        }
        int shift = 0;
        int base = Integer.parseInt(firstHalf);
        if (!secondHalf.equals("")) {shift = Integer.parseInt(secondHalf);}
        int j = 0;
        for (int x = -3; x < 3; x ++,j++){
            if (bank[index + 1] == '-'){
                int y = (int) Math.pow(base, (x * -1));
                int[] point = {x, y + shift};
                points[j] = point;
            }
            else {
                int y = (int) Math.pow(base, x);
                int[] point = {x, y + shift};
                points[j] = point;
            }
        }
        return points;

    }
    private double[][] quadratic(){
        equation = equation.replace(" ","");
        char[] bank = equation.toCharArray();
        char[] operations = new char[2];
        bank = Arrays.copyOfRange(bank, 2,bank.length );
        char[] placeholder = Arrays.copyOfRange(bank,1,bank.length);
        int local = 0;
        for (char x : placeholder){
            if (x == '+' || x == '-'){
                operations[local] = x;
                local++;
            }
        }
        int j = 0;
        int index = 0;
        char[] unit1 = {'1'};
        char[] unit2 = {'1'};
        char[] unit3 = {'0'};
        for (int i = 0; i < bank.length;i++){
            if (bank[i] == 'x' && j == 0){
                unit1 = Arrays.copyOfRange(bank,0,i);
                index = i;
                j++;
            }
            else if (bank[i] == 'x' || bank[i] =='X' && j == 1){
                unit2 = Arrays.copyOfRange(bank,index + 4,i);
                index = i;
                j++;
                if (!(index >= bank.length - 1)) {
                    unit3 = Arrays.copyOfRange(bank, index + 2, bank.length);
                }




            }
        }
        String first = new String(unit1);
        String second = new String(unit2);
        String third = new String(unit3);
        int num1 = 1; int num2 = 1; int num3 = 0;
        if (!first.equals("")){ num1 = Integer.parseInt(first);}
        if (!second.equals("")){ num2 = Integer.parseInt(second);}
        if (!third.equals("")){ num3 = Integer.parseInt(third);}
        double vertex;
        if (operations[0] == '+') {
            vertex = (double) (num2 * -1) / (2 * num1);
        }
        else{
            vertex = (double) (num2) / (2 * num1);
        }
        double[][] points = new double[22][2];
        int w = 1;
        for (double x = vertex - 5; x < vertex + 5.5;w++,x+= 0.5){
            if (operations[0] == '+' && operations[1] == '+'){
                double y = num1 * Math.pow(x, 2) + num2 * x + num3;
                double[] r = {x, y};
                vPoint[1] = num1 * Math.pow(vertex, 2) + num2 * vertex + num3;
                vPoint[0] = vertex;
                points[w] = r;
            }
            else if (operations[0] == '+' && operations[1] == '-'){
                double y = num1 * Math.pow(x, 2) + num2 * x - num3;
                double[] r = {x, y};
                vPoint[1] = num1 * Math.pow(vertex, 2) + num2 * vertex - num3;
                vPoint[0] = vertex;
                points[w] = r;
            }
            else if (operations[0] == '-' && operations[1] == '+'){
                double y = num1 * Math.pow(x, 2) - num2 * x + num3;
                double[] r = {x, y};
                vPoint[1] = num1 * Math.pow(vertex, 2) - num2 * vertex + num3;
                vPoint[0] = vertex;
                points[w] = r;
            }
            else if (operations[0] == '-' && operations[1] == '-'){
                double y = num1 * Math.pow(x, 2) - num2 * x - num3;
                double[] r = {x, y};
                vPoint[1] = num1 * Math.pow(vertex, 2) - num2 * vertex - num3;
                vPoint[0] = vertex;
                points[w] = r;
            }
            else if (operations[0] == '+'){
                double y = num1 * Math.pow(x, 2) + num2 * x;
                double[] r = {x, y};
                vPoint[1] = num1 * Math.pow(vertex, 2) + num2 * vertex;
                vPoint[0] = vertex;
                points[w] = r;
            }
            else if (operations[0] == '-'){
                double y = num1 * Math.pow(x, 2) - num2 * x;
                double[] r = {x, y};
                vPoint[1] = num1 * Math.pow(vertex, 2) - num2 * vertex;
                vPoint[0] = vertex;
                points[w] = r;
            }


        }
        points[0] = vPoint;
        return points;

    }
    public Scene parse(){
        int minx = 0;
        int maxx = 0;
        int miny = 0;
        int maxy = 0;
        if (type.equals("linear")){ // current only supports y = mx + b // add support for y = mx - b// and negative numbers in general
            int[][] points = this.linear();
            XYChart.Series data = new XYChart.Series<>();
            for (int[] point : points){
                XYChart.Data p = new XYChart.Data<>(point[0],point[1]);
                data.getData().add(p);
                if (point[0] > maxx) {maxx = point[0];}
                else if (point[0] < minx) {minx = point[0];}
                if (point[1] > maxy) {maxy = point[1];}
                else if (point[1] < miny) {miny = point[1];}
            }
            NumberAxis x = new NumberAxis("x",minx * 1.3,maxx * 1.3,1);
            NumberAxis y = new NumberAxis("y",miny * 1.3,maxy * 1.3,1);
            LineChart<Number,Number> graph = new LineChart<>(x,y);
            graph.getData().addAll(data);
            graph.getStylesheets().add(getClass().getResource("Style.css").toString());
            return new Scene(graph,300,256);
        }
        else if (type.equals("exponential")){ // current only supports y = mx + b // add support for y = mx - b// and negative numbers in general
            int[][] points = this.exponential();
            XYChart.Series data = new XYChart.Series<>();
            for (int[] point : points){
                XYChart.Data p = new XYChart.Data<>(point[0],point[1]);
                data.getData().add(p);
                if (point[0] > maxx) {maxx = point[0];}
                else if (point[0] < minx) {minx = point[0];}
                if (point[1] > maxy) {maxy = point[1];}
                else if (point[1] < miny) {miny = point[1];}
            }
            NumberAxis x = new NumberAxis("x",minx * 1.3,maxx * 1.3,1);
            NumberAxis y = new NumberAxis("y",miny * 1.3,maxy * 1.3,1);
            LineChart<Number,Number> graph = new LineChart<>(x,y);
            graph.getData().addAll(data);
            graph.getStylesheets().add(getClass().getResource("Style.css").toString());
            return new Scene(graph,300,256);
        }
        else if (type.equals("quadratic")){
            double minxd = 0;
            double maxxd = 0;
            double minyd = 0;
            double maxyd = 0;
            double[][] points = this.quadratic();
            XYChart.Series data = new XYChart.Series<>();
            System.out.println(Arrays.toString(vPoint));
            for (double[] point : points){
                XYChart.Data c = new XYChart.Data<>(point[0],point[1]);
                data.getData().add(c);
                if (point[0] > maxxd) {maxxd = point[0];}
                else if (point[0] < minxd) {minxd = point[0];}
                if (point[1] > maxyd) {maxyd = point[1];}
                else if (point[1] < minyd) {minyd = point[1];}
            }
            NumberAxis x = new NumberAxis("x",minxd * 1.3,maxxd * 1.3,0.5);
            NumberAxis y = new NumberAxis("y",minyd * 1.3,maxyd * 1.3,0.5);
            LineChart<Number,Number> graph = new LineChart<>(x,y);
            graph.getData().addAll(data);
            graph.getStylesheets().add(getClass().getResource("Style.css").toString());
            return new Scene(graph,300,256);
        }
        return new Scene(new Pane(),100,100);
    }

}
