package Application;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class Controller implements Initializable{
    @FXML AnchorPane root;
    @FXML ImageView catPane;
    @FXML ImageView catPane1;
    @FXML ImageView catPane2;
    @FXML private TextArea res;
    @FXML private TextArea in;
    @FXML private ToggleButton toggle_btn;
    @FXML Button b1;
    @FXML Button b2;
    @FXML Button b3;
    @FXML Button b4;
    @FXML Button b5;
    @FXML Button b6;
    @FXML Button b7;
    @FXML Button b8;
    @FXML Button b9;
    @FXML Button b0;
    @FXML Button dot;
    @FXML Button opar;
    @FXML Button clpar;
    @FXML Button add;
    @FXML Button div;
    @FXML Button mult;
    @FXML Button sub;
    @FXML Button raise;
    @FXML Button del;

    Button [] buttons;
    calcLg eval = new calcLg();

    private String input = "";
    Scene currentScene;

    public void clicked(ActionEvent event){
        Button EventSource = (Button)event.getSource();
        input = in.getText();
        if(EventSource.getText().equals("=")){
            evaluateInfix(validateASCII(in.getText()));
        }
        else input += EventSource.getText();
        updateView();
    }

    public void delBtn(){
        if(input.isEmpty()) return;
        input = input.substring(0,input.length()-1);
        updateView();
    }

    public void PI(ActionEvent event){
        input = in.getText();
        input += Math.PI;
        updateView();
    }

    public String validateASCII(String input){
        String str = input.replaceAll("÷","/");
        str = str.replaceAll("×","*");
        return str;
    }

    private Stack<String> stackHistory= new Stack<String>();

    public void CE(ActionEvent event){
        input = "";
        res.clear();
        stackHistory.clear();
        updateView();
    }

    public void startShowAnimationV(ImageView cat){
        if(!stackHistory.isEmpty())
            res.appendText( "\n"+ stackHistory.peek());
        cat.setVisible(true);
        FadeTransition ft = new FadeTransition(Duration.millis(3000), cat);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(2);
        ft.setAutoReverse(true);
        ft.play();
        ft.setOnFinished(evr->{
            in.setText("");
            if(!stackHistory.isEmpty())
                if(stackHistory.peek().contains("Cat Exception"))return;
            stackHistory.push("Cat Exception Occured"+"\n");
            if(!stackHistory.isEmpty())
                res.appendText( "\n"+ stackHistory.peek());
            cat.setVisible(false);
        });
    }

    public void evaluateInfix(String infix){
        if(infix.contains("CAT") || infix.contains("cat") || infix.contains("Cat")){
            startShowAnimationV(catPane);
            startShowAnimationV(catPane1);
            startShowAnimationV(catPane2);
            return;
        }
        stackHistory.push(infix + " = " + eval.formated(infix.replaceAll("\n",""))+"\n");
        if(!stackHistory.isEmpty())
            res.appendText( "\n"+ stackHistory.peek());
        input = "";
    }

    public void updateView(){ in.setText(input); }

    boolean isLight = true;

    public void changeStyle(){
        currentScene.getStylesheets().clear();
        if(isLight) {
            System.out.println("Changing Theme 1");
            currentScene.getStylesheets().add(getClass().getResource("styles/light.css").toExternalForm());
            toggle_btn.setText("Light");
        }else{
            System.out.println("Changing Theme 2");
            currentScene.getStylesheets().add(getClass().getResource("styles/dark.css").toExternalForm());
            toggle_btn.setText("Dark");
        }
        isLight = !isLight;
    }

    public void remoClicked(String num){
        for(int x = 0 ; x < buttons.length; x++)
            if(!buttons[x].getText().equals(num))
                buttons[x].getStyleClass().remove("clicked");
    }

    public void addClicked(String num){
        for(int x = 0 ; x < buttons.length; x++)
           if(buttons[x].getText().equals(num))
               buttons[x].getStyleClass().add("clicked");
        remoClicked(num);
    }

    public void enterd(KeyEvent ev){
        KeyCode pressed = ev.getCode();
        TextArea obj = (TextArea)ev.getSource();
        String objstr = obj.getText();
        if(pressed == KeyCode.ENTER ){
            input = in.getText();
            in.clear();
            in.setText(in.getText().replaceAll("\n",""));
            evaluateInfix(validateASCII(input.replaceAll("\n","")));
            updateView();
            remoClicked("Enter");
        }else if(pressed == KeyCode.DIGIT1){
            addClicked("1");
        }else if(pressed == KeyCode.DIGIT2){
            addClicked("2");
        }else if(pressed == KeyCode.DIGIT3){
            addClicked("3");
        }else if(pressed == KeyCode.DIGIT4){
            addClicked("4");
        }else if(pressed == KeyCode.DIGIT5){
            addClicked("5");
        }else if(pressed == KeyCode.DIGIT6){
            addClicked("6");
        }else if(pressed == KeyCode.DIGIT7){
            addClicked("7");
        }else if(pressed == KeyCode.DIGIT8){
            addClicked("8");
        }else if(pressed == KeyCode.DIGIT9){
            addClicked("9");
        }else if(pressed == KeyCode.DIGIT0){
            addClicked("0");
        }else if(pressed == KeyCode.PERIOD){
            addClicked(".");
        }else if(pressed == KeyCode.LEFT_PARENTHESIS){
            addClicked("(");
        }else if(pressed == KeyCode.RIGHT_PARENTHESIS){
            addClicked(")");
        }else if(pressed == KeyCode.EQUALS){
            addClicked("=");
        }else if(pressed == KeyCode.ASTERISK){
            addClicked("*");
        }else if(pressed == KeyCode.SUBTRACT){
            addClicked("-");
        }else if(pressed == KeyCode.ADD){
            addClicked("+");
        }else if(pressed == KeyCode.DIVIDE){
            addClicked("/");
        }else if(pressed == KeyCode.CIRCUMFLEX){
            addClicked("^");
        }else if(pressed == KeyCode.X){
            addClicked("X");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        res.setFocusTraversable(false);
        in.requestFocus();
        buttons = new Button[]{b1,b2,b3,b4,b5,b6,b7,b8,b8,b9,b0,dot,clpar,add,div,mult,sub,raise,del};
        catPane.setVisible(false);
        catPane1.setVisible(false);
        catPane2.setVisible(false);
    }
}