package JForm;

import classes.Users_new;
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
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;

import static modules.getOpenSession.getOpenSession;

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

        Session session = getOpenSession();
        session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("select * from users_new").addEntity(Users_new.class);;
        ArrayList<Users_new> arr = (ArrayList<Users_new>) sqlQuery.list();
        try {
            for (Users_new user: arr) {
                if (user instanceof Users_new){
                    ListNamePassword namePassword = new ListNamePassword();

                    namePassword.setNameTC(new SimpleStringProperty(user.getName()));
                    namePassword.setPasswordTC(new SimpleStringProperty(user.getPassword()));

                    ObservableList<ListNamePassword> personData = Table.getItems();
                    personData.add(namePassword);

                    Table.setItems(personData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void buttonClicked(ActionEvent actionEvent) {

        Boolean create = true;

        Session session = getOpenSession();
        session.beginTransaction();

        Users_new user_last = session.get(Users_new.class,name.getCharacters().toString());
        if (user_last != null){
            create = false;
        }

        Users_new users_new = new Users_new(name.getCharacters().toString(), password.getCharacters().toString());

        session.saveOrUpdate(users_new);
        session.getTransaction().commit();

        if (create){
            ListNamePassword namePassword = new ListNamePassword();

            namePassword.setNameTC(getStringProperty(name));
            namePassword.setPasswordTC(getStringProperty(password));

            ObservableList<ListNamePassword> personData = Table.getItems();
            personData.add(namePassword);

            Table.setItems(personData);
        }
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
