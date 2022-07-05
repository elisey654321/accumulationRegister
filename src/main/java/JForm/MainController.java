package JForm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button mainButton;

    public void buttonClicked(ActionEvent actionEvent) {
        System.out.println("test");
    }
}
