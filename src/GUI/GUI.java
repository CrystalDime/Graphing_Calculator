package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class GUI{
    private int width;
    private int height;
    private Button[] safe;
    private Button submit = new Button("wow");
    private String state;
    private TextField field;
    public GUI(int w,int h){
        this.width = w;
        this.height = h;
    }
    private Button[] newButtons(){
        Button linear = new Button("Linear");
        Button exponential = new Button("Exponential");
        Button quadratic = new Button("Quadratic");
        Button[] bank = {linear, exponential, quadratic};
        for (Button x : bank){
            x.setStyle("-fx-background-color: rgb(225, 228, 203)");
            x.setStyle("-fx-base: rgb(169,169,169)");
        }
        return bank;
    }
    private VBox format(){
        Button[] bank = this.newButtons();
        VBox layout = new VBox(8);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(bank);
        safe = bank;
        return layout;

    }
    public Scene make(){
        return  new Scene(this.format(),width,height);
    }
    private Scene line(){
        state = "linear";
        field = new TextField("Please enter equation here");
        field.setMaxWidth(246/1.3);
        Text title = new Text("Line Graph");
        title.setStyle(    "-fx-font: 20px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
        title.setTextAlignment(TextAlignment.CENTER);
        Text guide = new Text("y = mx + b");
        guide.setTextAlignment(TextAlignment.CENTER);
        submit = new Button("Graph!");
        submit.setStyle("-fx-background-color: rgb(225, 228, 203)");
        submit.setStyle("-fx-base: rgb(169,169,169)");
        submit.setAlignment(Pos.CENTER);
        field.setAlignment(Pos.CENTER);
        VBox base = new VBox(8);
        base.getChildren().addAll(title,guide,field,submit);
        base.setAlignment(Pos.CENTER);
        return new Scene(base,246,305);
    }
    private Scene exponential(){
        state = "exponential";
        field = new TextField("Please enter equation here");
        field.setMaxWidth(246/1.3);
        Text title = new Text("Exponential Graph");
        title.setStyle(    "-fx-font: 20px Tahoma;  -fx-stroke: black; -fx-stroke-width: 1;");
        title.setTextAlignment(TextAlignment.CENTER);
        Text guide = new Text("y = ab^x");
        guide.setTextAlignment(TextAlignment.CENTER);
        submit = new Button("Graph!");
        submit.setStyle("-fx-background-color: rgb(225, 228, 203)");
        submit.setStyle("-fx-base: rgb(169,169,169)");
        submit.setAlignment(Pos.CENTER);
        field.setAlignment(Pos.CENTER);
        VBox base = new VBox(8);
        base.getChildren().addAll(title,guide,field,submit);
        base.setAlignment(Pos.CENTER);
        return new Scene(base,246,305);
    }
    private Scene quad(){
        state = "quadratic";
        field = new TextField("Please enter equation here");
        field.setMaxWidth(246/1.3);
        Text title = new Text("Quadratic Graph");
        title.setStyle(    "-fx-font: 20px Tahoma;  -fx-stroke: black; -fx-stroke-width: 1;");
        title.setTextAlignment(TextAlignment.CENTER);
        Text guide = new Text("y = ax^2 + bx + c");
        guide.setTextAlignment(TextAlignment.CENTER);
        submit = new Button("Graph!");
        submit.setStyle("-fx-background-color: rgb(225, 228, 203)");
        submit.setStyle("-fx-base: rgb(169,169,169)");
        submit.setAlignment(Pos.CENTER);
        field.setAlignment(Pos.CENTER);
        VBox base = new VBox(8);
        base.getChildren().addAll(title,guide,field,submit);
        base.setAlignment(Pos.CENTER);
        return new Scene(base,246,305);
    }
    public Scene selection(Button x){
        if (x == safe[0]) {return this.line();}
        else if (x == safe[1]) {return this.exponential();}
        else if (x == safe[2]) {return this.quad();}
        return (new Scene(new StackPane(),246,305));
    }
    public Button[] germane(){
        return safe;
    }

    public Button relevant(){return submit;}

    public String state(){return state;}

    public TextField text(){return field;}





}