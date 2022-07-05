package JForm;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

public class MainController {

    @FXML
    private Button mainButton;
    @FXML
    private Button refresh;
    @FXML
    private TableView<ListNamePassword> Table;
    @FXML
    private TableColumn<ListNamePassword,String> passwordTC;
    @FXML
    private TableColumn<ListNamePassword,String> nameTC;
    @FXML
    private TextField name;
    @FXML
    private TextField password;

    @FXML
    private void initialize(){
        passwordTC.setCellValueFactory(cellData -> cellData.getValue().getPasswordTC());
        nameTC.setCellValueFactory(cellData -> cellData.getValue().getNameTC());
    }

    public void buttonClicked(ActionEvent actionEvent) {

        ListNamePassword namePassword = new ListNamePassword();

        namePassword.setNameTC(getStringProperty(name));
        namePassword.setPasswordTC(getStringProperty(password));

        ObservableList<ListNamePassword> personData = Table.getItems();
        personData.add(namePassword);

        Table.setItems(personData);
    }

    @NotNull
    private StringProperty getStringProperty(TextField field) {
        CharSequence nameCharacters = field.getCharacters();
        String nameString = nameCharacters.toString();
        StringProperty stringProperty = new SimpleStringProperty(nameString);
        return stringProperty;
    }

    public void buttonRefreshClicked(ActionEvent actionEvent) {
        ObservableList<ListNamePassword> personData = Table.getItems();
        personData.add(new ListNamePassword(new SimpleStringProperty("test"),new SimpleStringProperty("test")));

        Table.setItems(personData);
    }

}
