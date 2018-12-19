package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GUI{
    int width = 0;
    int height = 0;
    public GUI(int w,int h){
        this.width = w;
        this.height = h;
    }
    public Button[] newButtons(){
        Button linear = new Button("Linear");
        Button exponential = new Button("Exponential");
        Button quadratic = new Button("Quadratic");
        Button[] bank = {linear, exponential, quadratic};
        return bank;
    }
    public VBox format(){
        Button[] bank = this.newButtons();
        VBox layout = new VBox(8);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(bank);
        return layout;

    }
    public Scene make(){
        Scene option = new Scene(this.format(),width,height);
        return option;
    }





}