package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage mainStg) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("clc.md"));

        Parent root = loader.load();
        mainStg.setTitle("Calculator");

        Scene sc = new Scene(root,464 , 470);

        Controller controller = (Controller)loader.getController();
        controller.currentScene = sc;

        mainStg.setScene(sc);
        mainStg.setResizable(false);
        mainStg.show();

        controller.changeStyle();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
