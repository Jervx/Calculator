package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage mainStg) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("clc.fxml"));
        mainStg.setTitle("Calculator");
        mainStg.setScene(new Scene(root,464 , 542));
        mainStg.setResizable(false);
        mainStg.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
