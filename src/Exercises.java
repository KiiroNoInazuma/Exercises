import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;
import java.util.function.UnaryOperator;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

public class Exercises extends Application {

    Label express;
    TextField answer;
    Label quest;
    Button apply, res;

    int selectNum1;
    int selectNum2;
    int result;
    int counterTrue;
    int counterFalse;

    FileInputStream fis1, fis2, fis3, fis4, fis5, fis6, fis7, fis8, fis9, fisN;
    Image img1, img2, img3, img4, img5, img6, img7, img8, img9, imgN;


    Label multi;
    ImageView iv;
    ImageView iv2;


    @Override
    public void start(Stage ex) throws Exception {
        ex.setResizable(false);
        ex.setTitle("Учим таблицу умножения ");
        GridPane go = new GridPane();
        go.setAlignment(Pos.CENTER);
        Scene quad = new Scene(go, 550, 400);
        ex.setScene(quad);
        express = new Label();
        answer = new TextField("");
        quest = new Label("");


        quest.setTranslateY(-150);
        quest.setTranslateX(20);
        answer.setPrefColumnCount(2);
        answer.setMaxSize(45, 20);
        answer.setAlignment(Pos.CENTER);
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?") && newText.length() < 4) {
                return change;
            }
            return null;
        };

        answer.setTextFormatter(
                new TextFormatter<>(new IntegerStringConverter(), null, integerFilter));
        answer.setTranslateX(70);
        answer.setTranslateY(100);

        apply = new Button("Дальше");
        apply.setPrefSize(60, 35);
        apply.setTranslateX(62.5);
        apply.setTranslateY(135);

        selectNum1 = (int) (1 + Math.random() * 9);
        selectNum2 = (int) (1 + Math.random() * 9);
        fis1 = new FileInputStream("img/1.png");
        fis2 = new FileInputStream("img/2.png");
        fis3 = new FileInputStream("img/3.png");
        fis4 = new FileInputStream("img/4.png");
        fis5 = new FileInputStream("img/5.png");
        fis6 = new FileInputStream("img/6.png");
        fis7 = new FileInputStream("img/7.png");
        fis8 = new FileInputStream("img/8.png");
        fis9 = new FileInputStream("img/9.png");
        fisN = new FileInputStream("img/tom.jpg");

        img1 = new Image(fis1);
        img2 = new Image(fis2);
        img3 = new Image(fis3);
        img4 = new Image(fis4);
        img5 = new Image(fis5);
        img6 = new Image(fis6);
        img7 = new Image(fis7);
        img8 = new Image(fis8);
        img9 = new Image(fis9);
        imgN = new Image(fisN);

        iv = new ImageView(imgN);
        multi = new Label("");
        multi.setFont(Font.font("stone", FontWeight.BOLD, FontPosture.REGULAR, 50));
        multi.setTranslateX(80);
        iv2 = new ImageView();
        iv.setTranslateX(0);
        iv2.setTranslateX(120);
        iv.setTranslateY(0);
        iv2.setTranslateY(-10);
        iv.setFitHeight(410);
        iv2.setFitHeight(170);
        iv.setFitWidth(560);
        iv2.setFitWidth(180);

        apply.setOnAction(event -> {
            iv.setFitHeight(170);
            iv.setFitWidth(180);
            iv.setTranslateX(-110);
            iv.setTranslateY(-10);
            multi.setText("X");
            apply.setVisible(false);
            res.setVisible(true);
            iv.setVisible(true);
            iv2.setVisible(true);
            multi.setVisible(true);
            quest.setText("Сколько будет:");
            quest.setFont(Font.font("stone", FontWeight.BOLD, FontPosture.REGULAR, 20));
            quest.setStyle("-FX-Text-Fill: MediumBlue");
            quest.setTranslateX(20);
            selectNum1 = (int) (1 + Math.random() * 9);
            selectNum2 = (int) (1 + Math.random() * 9);
            switch (selectNum1) {
                case 1:
                    iv.setImage(img1);
                    break;
                case 2:
                    iv.setImage(img2);
                    break;
                case 3:
                    iv.setImage(img3);
                    break;
                case 4:
                    iv.setImage(img4);
                    break;
                case 5:
                    iv.setImage(img5);
                    break;
                case 6:
                    iv.setImage(img6);
                    break;
                case 7:
                    iv.setImage(img7);
                    break;
                case 8:
                    iv.setImage(img8);
                    break;
                case 9:
                    iv.setImage(img9);
                    break;
                default:
                    System.out.println(error);
            }
            switch (selectNum2) {
                case 1:
                    iv2.setImage(img1);
                    break;
                case 2:
                    iv2.setImage(img2);
                    break;
                case 3:
                    iv2.setImage(img3);
                    break;
                case 4:
                    iv2.setImage(img4);
                    break;
                case 5:
                    iv2.setImage(img5);
                    break;
                case 6:
                    iv2.setImage(img6);
                    break;
                case 7:
                    iv2.setImage(img7);
                    break;
                case 8:
                    iv2.setImage(img8);
                    break;
                case 9:
                    iv2.setImage(img9);
                    break;
                default:
                    System.out.println(error);
            }
            answer.setVisible(true);

        });


        res = new Button("Нажми меня!");
        res.setPrefSize(110, 35);
        res.setTranslateX(225);
        res.setTranslateY(-70);
        answer.setText("1");
        res.setOnAction(event -> {
            res.setText("OK");
            res.setPrefSize(60, 35);
            res.setTranslateX(62.5);
            res.setTranslateY(135);
            result = selectNum1 * selectNum2;

            if (Integer.parseInt(answer.getText()) == result && Integer.parseInt(answer.getText()) != 1) {
                quest.setFont(Font.font("stone", FontWeight.BOLD, FontPosture.REGULAR, 20));
                quest.setStyle("-FX-Text-Fill: Red");
                quest.setText("ПРАВИЛЬНО!");
                quest.setTranslateX(30);
                counterTrue++;

            } else if (Integer.parseInt(answer.getText()) != 1) {
                quest.setText("НЕ ПРАВИЛЬНО!");
                quest.setFont(Font.font("stone", FontWeight.BOLD, FontPosture.REGULAR, 20));
                quest.setStyle("-FX-Text-Fill: Red");
                quest.setTranslateX(20);
                counterFalse++;

            }

            answer.setText("");
            apply.setVisible(true);
            res.setVisible(false);
            iv.setVisible(false);
            iv2.setVisible(false);
            multi.setVisible(false);
            answer.setVisible(false);
            if (counterFalse == 20 || counterTrue == 20) {
                //grade = good/(good+bad)*5;
                answer.setText("");
                apply.setVisible(false);
                res.setVisible(false);
                iv.setVisible(false);
                iv2.setVisible(false);
                multi.setVisible(false);
                answer.setVisible(false);
                quest.setTranslateY(0);
                int exm;
                if (counterTrue > counterFalse && counterTrue > 18 && counterFalse <= 1) {
                    exm = 5;
                    quest.setText("\t   Отлично!!!\n Правильных ответов:     " + counterTrue + "\n Неправильных ответов:    " + counterFalse + "\n\t    Оценка: " + exm);
                } else if (counterTrue > counterFalse && counterTrue > 16 && counterFalse <= 4) {
                    exm = 4;
                    quest.setText("\t   ХОРОШО!\n Правильных ответов:     " + counterTrue + "\n Неправильных ответов:    " + counterFalse + "\n\t    Оценка: " + exm);
                } else if (counterTrue > counterFalse && counterTrue > 12 && counterFalse <= 6) {
                    exm = 3;
                    quest.setText("\t   СТАРАЙСЯ ЛУЧШЕ.\n Правильных ответов:     " + counterTrue + "\n Неправильных ответов:    " + counterFalse + "\n\t    Оценка: " + exm);
                } else {
                    exm = 2;
                    quest.setText("\t    ПЛОХО!!!\n Правильных ответов:     " + counterTrue + "\n Неправильных ответов:    " + counterFalse + "\n\t    Оценка: " + exm);
                }
            }
        });

        go.getChildren().addAll(quest, express, answer, apply, iv, multi, iv2, res);
        ex.show();
    }

    public static void main(String[] start) {
        launch(start);


    }
}


