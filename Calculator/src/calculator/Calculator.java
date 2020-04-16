/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Mustafa Khaled 407802 C4I
 */
public class Calculator extends Application {

    private final Button nums[];
    private final Button plus, minus, comma, divided, buttonDelete, equals, times, change;
    private final String operatorsStyle = "-fx-background-radius: 0; -fx-background-color: #FE9340; -fx-text-fill: #ffffff;  -fx-font-family: \"Helvetica Neue Light\"; -fx-font-size: 21px;";
    private final String btnStyle = "-fx-background-radius: 0; -fx-background-color:  #E0E0E0; -fx-font-family: \"Helvetica Neue Light\"; -fx-font-size: 21px;";
    private final TextArea display;

    private Boolean[] operator = new Boolean[5];
    private int operatorCount = 0;
    double[] temporary = {0, 0};
    private String actualText;

    public Calculator() {
        this.display = new TextArea();
        display.setEditable(false);
        this.display.setStyle("-fx-font-size: 25px; -fx-font-family: \"Helvetica Neue Light\"; ");
        this.display.setPrefSize(20.0, 20.0);
        this.plus = new Button("+");
        this.plus.setOnAction(new OperationAction());
        this.plus.setStyle(operatorsStyle);
        this.plus.setPrefSize(59.0, 47.0);
        this.minus = new Button("-");
        this.minus.setOnAction(new OperationAction());
        this.minus.setStyle(operatorsStyle);
        this.minus.setPrefSize(59.0, 47.0);
        this.divided = new Button("/");
        this.divided.setOnAction(new OperationAction());
        this.divided.setStyle(operatorsStyle);
        this.divided.setPrefSize(59.0, 47.0);
        this.times = new Button("╳");
        this.times.setOnAction(new OperationAction());
        this.times.setStyle(operatorsStyle);
        this.times.setPrefSize(59.0, 47.0);
        this.equals = new Button("=");
        this.equals.setOnAction(new Reslut());
        this.equals.setStyle(operatorsStyle);
        this.equals.setPrefSize(59.0, 47.0);
        this.comma = new Button(".");
        this.comma.setOnAction(new numsAction());
        this.comma.setStyle(btnStyle);
        this.comma.setPrefSize(59.0, 47.0);
        this.buttonDelete = new Button("AC");
        this.buttonDelete.setOnAction(new Reslut());
        this.buttonDelete.setStyle(operatorsStyle);
        this.buttonDelete.setPrefSize(119.0, 47.0);
        this.change = new Button("+/-");
        this.change.setOnAction(new Reslut());
        this.change.setStyle(operatorsStyle);
        this.change.setPrefSize(59.0, 47.0);
        this.nums = new Button[10];
        for (int i = 0; i < 10; ++i) {
            this.nums[i] = new Button("" + i);
            this.nums[i].setPrefSize(59.0, 47.0);
            this.nums[i].setStyle(btnStyle);
            this.nums[i].setOnAction(new numsAction());
        }
        nums[0].setPrefWidth(119.0);

        display.setText("0");
        for (int i = 0; i < 4; i++) {
            operator[i] = false;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(2);
        gridPane.setVgap(2);

        gridPane.add(buttonDelete, 0, 0, 2, 1);
        gridPane.addRow(0, change, divided);
        gridPane.addRow(1, nums[7], nums[8], nums[9], times);
        gridPane.addRow(2, nums[4], nums[5], nums[6], minus);
        gridPane.addRow(3, nums[1], nums[2], nums[3], plus);
        gridPane.add(nums[0], 0, 4, 2, 1);
        gridPane.addRow(4, comma, equals);

        root.setTop(display);
        root.setCenter(gridPane);

        Scene scene = new Scene(root, 245, 326);
        primaryStage.setTitle("Calculator !");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private class numsAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            actualText = display.getText();
            if (display.getText().equals("0") || display.getText() == "0") {
                buttonDelete.setText("C");
                display.setText("");
                System.out.println("actualText: " + actualText);
                actualText = "";
            }
            Button btn = (Button) event.getSource();
            display.appendText(btn.getText());
        }
    }

    private class OperationAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            operatorCount++;
            System.out.println("operatorCount: " + operatorCount);
            if (display.getText() != "") {
                actualText = display.getText();
            }
            Button btn = (Button) event.getSource();
            if (btn.equals(plus)) {
                operator[1] = true;
                temporary[0] = Double.parseDouble(display.getText());
            } else if (btn.equals(minus)) {
                operator[2] = true;
                temporary[0] = Double.parseDouble(display.getText());
            } else if (btn.equals(times)) {
                operator[3] = true;
                temporary[0] = Double.parseDouble(display.getText());
            } else if (btn.equals(divided)) {
                operator[4] = true;
                temporary[0] = Double.parseDouble(display.getText());
            }
            display.setText("");
        }
    }

    private class Reslut implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Button btn = (Button) event.getSource();
            if (btn.equals(buttonDelete)) {
                buttonDelete.setText("AC");
                display.setText("0");
                for (int i = 0; i < 2; i++) {
                    temporary[i] = 0;
                }
                for (int i = 0; i < 4; i++) {
                    operator[i] = false;
                }
            } else if (btn.equals(equals)) {
                double result = 0;
                temporary[1] = Double.parseDouble(display.getText());
                String temp0 = Double.toString(temporary[0]);
                String temp1 = Double.toString(temporary[1]);
                if (operator[1]) {
                    result = temporary[0] + temporary[1];
                } else if (operator[2]) {
                    result = temporary[0] - temporary[1];
                } else if (operator[3]) {
                    result = temporary[0] * temporary[1];
                } else if (operator[4]) {
                    result = temporary[0] / temporary[1];
                }
                System.out.println("result: " + result);
                display.setText(Double.toString(result));
            } else if (btn.equals(change)) {
                double number = Double.parseDouble(display.getText());
                if (number != 0) {
                    number = number * (-1);
                    display.setText(Double.toString(number));
                    System.out.println(number);
                }
            }
        }

    }
}
