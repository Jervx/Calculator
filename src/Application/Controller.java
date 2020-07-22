package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class Controller implements Initializable{

    @FXML private TextArea res;
    @FXML private TextArea in;
    calcLg eval = new calcLg();

    private String input = "";

    public void clicked(ActionEvent event){
        Button EventSource = (Button)event.getSource();
        if(EventSource.getText().equals("=")) evaluateInfix(validateASCII(in.getText()));
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

    public void evaluateInfix(String infix){
        stackHistory.push(infix + " \n= " + eval.formated(infix.replaceAll("\n",""))+"\n");
        if(!stackHistory.isEmpty())
            res.appendText( "\n"+stackHistory.peek());
        input = "";
    }

    public void updateView(){ in.setText(input); }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        res.setFocusTraversable(false);
        in.requestFocus();
    }
}