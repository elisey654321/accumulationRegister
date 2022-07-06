package JForm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class newMaket extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/maket/LoginForm.fxml");
        loader.setLocation(xmlUrl);

        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("My test App");
        primaryStage.show();
    }

    private void onMouseClicked(){

    }

}
