package GUI;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

import java.util.Arrays;

public class Graph {
    private String equation;
    private String type;
    public Graph(String equation,String t){
        this.type = t;
        this.equation = equation;

    }
    private int[][] linear(){
        equation = equation.replace(" ","");
        char[] bank = equation.toCharArray();
        bank = Arrays.copyOfRange(bank, 2,bank.length );
        int[][] points = new int[20][2];
        int Multiple = Integer.parseInt(Character.toString(bank[0])); int addition = Integer.parseInt(Character.toString(bank[3]));
        int index = 0;
        for (int x = -10; x < 10; x++,index++){
            int y = (x * Multiple) + addition;
            int[] r = {x,y};
            points[index] = r;
        }
        return points;
    }
    public Scene parse(){
        NumberAxis x = new NumberAxis("x",-20,20,1);
        NumberAxis y = new NumberAxis("y",-20,20,1);
        LineChart<Number,Number> graph = new LineChart<>(x,y);
        if (type.equals("linear")){ // current only supports y = mx + b // add support for y = mx - b// and negative numbers in general
            int[][] points = this.linear();
            XYChart.Series data = new XYChart.Series<>();
            for (int[] point : points){
                XYChart.Data p = new XYChart.Data<>(point[0],point[1]);
                data.getData().add(p);
            }
            graph.getData().addAll(data);
            graph.getStylesheets().add(getClass().getResource("Style.css").toString());
            return new Scene(graph,300,256);
        }
        return new Scene(new Pane(),100,100);
    }

}
