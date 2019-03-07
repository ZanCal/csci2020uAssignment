package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;


public class Main extends Application {

    Line line1 = new Line();
    Line line2 = new Line();
    //done
    Line line3 = new Line();
    //done
    Circle circle = new Circle();
    Circle dot1 = new Circle(8);
    Circle dot2 = new Circle(8);
    Circle dot3 = new Circle(8);
    double x1;
    double x2;
    double x3;
    double y1;
    double y2;
    double y3;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        q1(primaryStage);
        //q2(primaryStage);
        //q3(primaryStage);
        //q4(primaryStage);
    }

    public void q1(Stage primaryStage) {
        HBox cards = new HBox();
        Random rand = new Random();
        int n = rand.nextInt(53) + 1;
        Image card1 = new Image("Cards/" + n + ".png");
        n = rand.nextInt(53) + 1;

        Image card2 = new Image("Cards/" + n + ".png");
        n = rand.nextInt(53) + 1;

        Image card3 = new Image("Cards/" + n + ".png");

        ImageView Card1 = new ImageView(card1);
        ImageView Card2 = new ImageView(card2);
        ImageView Card3 = new ImageView(card3);

        cards.getChildren().addAll(Card1, Card2, Card3);

        Scene scene = new Scene(cards);
        primaryStage.setTitle("Cards");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void q2(Stage primaryStage) {
        GridPane stuff = new GridPane();

        Label inAmt = new Label("Investment Amount");
        stuff.add(inAmt, 0, 0);
        TextField inAmtVal = new TextField();
        stuff.add(inAmtVal, 1, 0);
        Label years = new Label("Years");
        stuff.add(years, 0, 1);
        TextField yearsVal = new TextField();
        stuff.add(yearsVal, 1, 1);
        Label air = new Label("Annual Interest Rate");
        stuff.add(air, 0, 2);
        TextField airVal = new TextField();
        stuff.add(airVal, 1, 2);
        Label futVal = new Label("Future Value");
        stuff.add(futVal, 0, 3);
        TextField futValRes = new TextField();
        stuff.add(futValRes, 1, 3);


        Button calc = new Button("Calculate");


        calc.setOnAction(e -> {


            double temp;
            double invstAmnt = Double.valueOf(inAmtVal.getText());
            System.out.println(invstAmnt);
            double airAmnt = (Double.valueOf(airVal.getText()) / 100) / 12 + 1;
            System.out.println(airAmnt);
            double yearCount = Double.valueOf(yearsVal.getText()) * 12;
            System.out.println(yearCount);
            temp = invstAmnt * Math.pow(airAmnt, yearCount);

            DecimalFormat money = new DecimalFormat("#.00");

            futValRes.setText(money.format(temp));

            //futureValue = investmentAmount * (1 + monthlyInterestRate)years*12

        });


        stuff.add(calc, 1, 4);

        Scene scene = new Scene(stuff);
        primaryStage.setTitle("InvestmentCalc");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void q3(Stage primaryStage) {
        int radius = 100;
        AnchorPane anchorPane = new AnchorPane();


        circle.setRadius(radius);
        circle.setCenterX(300);
        circle.setStroke(Color.BLACK);
        circle.setCenterY(300);
        circle.setFill(Color.TRANSPARENT);

        Random rng = new Random();
        rng.setSeed(System.currentTimeMillis());

        double angle1 = rng.nextDouble() * Math.PI * 2;
        x1 = 300 + 100 * Math.cos(angle1);
        y1 = 300 + 100 * Math.sin(angle1);
        dot1.setFill(Color.RED);
        dot1.setCenterY(y1);
        dot1.setCenterX(x1);

        y1 = dot1.getCenterY();
        x1 = dot1.getCenterX();

        dot1.setOnMouseDragged(e ->
        {
            dot1.setCenterX(e.getX());
            dot1.setCenterY(e.getY());
            drawLines();
        });


        double angle2 = rng.nextDouble() * Math.PI * 2;
        x2 = 300 + 100 * Math.cos(angle2);
        y2 = 300 + 100 * Math.sin(angle2);
        dot2.setFill(Color.RED);
        dot2.setCenterY(y2);
        dot2.setCenterX(x2);

        dot2.setOnMouseDragged(e ->
        {
            dot2.setCenterX(e.getX());
            dot2.setCenterY(e.getY());
            drawLines();
        });

        x2 = dot2.getCenterX();
        y2 = dot2.getCenterY();


        double angle3 = rng.nextDouble() * Math.PI * 2;
        x3 = 300 + 100 * Math.cos(angle3);
        y3 = 300 + 100 * Math.sin(angle3);
        dot3.setFill(Color.RED);
        dot3.setCenterY(y3);
        dot3.setCenterX(x3);
        x3 = dot3.getCenterX();
        y3 = dot3.getCenterY();

        dot3.setOnMouseDragged(e ->
        {
            dot3.setCenterX(e.getX());
            dot3.setCenterY(e.getY());
            drawLines();
        });

        System.out.println(x1 + " " + y1);

        drawLines();


        anchorPane.getChildren().addAll(circle, line1, line2, line3, dot1, dot2, dot3);

        Scene scene = new Scene(anchorPane, 1280, 720);
        primaryStage.setTitle("Circle Dragger");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    //not started
    public void drawLines() {
        System.out.println(dot1.getCenterX());
        line1.setStartX(dot1.getCenterX());
        line1.setStartY(dot1.getCenterY());
        line2.setStartX(dot2.getCenterX());
        line2.setStartY(dot2.getCenterY());
        line3.setStartX(dot3.getCenterX());
        line3.setStartY(dot3.getCenterY());


        line1.setEndX(dot3.getCenterX());
        line1.setEndY(dot3.getCenterY());
        line2.setEndX(dot1.getCenterX());
        line2.setEndY(dot1.getCenterY());
        line3.setEndX(dot2.getCenterX());
        line3.setEndY(dot2.getCenterY());
    }
    //in progress
    //letter count found, just need to graph it and do selectable file

    public void q4(Stage primaryStage) throws Exception {

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        for (int i = 0; i < 26; i++) {
            counts.put(alphabet[i], 0);
        }

        Button enter = new Button("view");
        enter.setLayoutX(20);
        enter.setLayoutY(375);

        TextField tf = new TextField();
        tf.setPromptText("Enter a filename here: ");
        tf.setLayoutX(20);
        tf.setLayoutY(350);
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Characters");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount");
        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series characterChart = new XYChart.Series();

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    InputStream in = new FileInputStream(tf.getText());

                    Reader r = new InputStreamReader(in, StandardCharsets.US_ASCII);


                    int check;
                    while ((check = r.read()) != -1) {
                        char currentChar = (char) check;
                        if (counts.containsKey(currentChar)) {
                            counts.put(currentChar, counts.get(currentChar) + 1);
                        }
                    }
                    r.close();
                    in.close();

                    for (int i = 0; i < alphabet.length; i++) {
                        characterChart.getData().addAll(new XYChart.Data(Character.toString(alphabet[i]), counts.get(alphabet[i])));
                    }

                    counts.clear();
                    for (int i = 0; i < 26; i++) {
                        counts.put(alphabet[i], 0);
                    }
                } catch (IOException e) {
                    System.out.println("test");
                }
            }
        });


        AnchorPane pane = new AnchorPane();


        barChart.getData().add(characterChart);

        pane.getChildren().addAll(barChart, enter, tf);


        Scene scene = new Scene(pane, 1280, 720);
        primaryStage.setTitle("Histogram");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
