package JForm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SwingButtonController {

    @FXML
    public AnchorPane mainLayout;
    @FXML
    private Button myButton;

    public void clickButton(ActionEvent actionEvent) {
        myButton.setLayoutX(mainLayout.getWidth()*Math.random());
        myButton.setLayoutY(mainLayout.getHeight()*Math.random());
    }

    public void mouseMove(MouseEvent mouseEvent) {
        myButton.setLayoutX((mainLayout.getWidth() - myButton.getWidth())*Math.random());
        myButton.setLayoutY((mainLayout.getHeight() - myButton.getHeight())*Math.random());
    }

    @FXML
    private void initialize(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1);
                        Button myButton = SwingButtonController.this.myButton;

                        myButton.setLayoutX((mainLayout.getWidth() - myButton.getWidth()) * Math.random());
                        myButton.setLayoutY((mainLayout.getHeight() - myButton.getHeight())*Math.random());
                    }catch (Exception e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

}
