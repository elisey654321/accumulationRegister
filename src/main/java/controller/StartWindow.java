package controller;

import classes.TableReg;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Data;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Data
public class StartWindow {

    private Stage primaryStage;
    private AnchorPane rootLayout;

    @FXML
    private TableView<TableReg> tableView;

    @FXML
    private void initialize(){
        System.out.println("initialize");

        TableColumn<TableReg, String> column1 =
                new TableColumn<>("number");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("number"));


        TableColumn<TableReg, String> column2 =
                new TableColumn<>("item");

        column2.setCellValueFactory(
                new PropertyValueFactory<>("item"));

        TableColumn<TableReg, String> column3 =
                new TableColumn<>("count");

        column3.setCellValueFactory(
                new PropertyValueFactory<>("count"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);

    }

    @FXML
    private void ButtonOnClick(){
        System.out.println("test");

        //ObservableList<TableReg> list = getTableList();

        //tableView.setItems(list);
        tableView.getItems().add(new TableReg("Test11", "Test2111", "Test31111"));

    }

    private ObservableList<TableReg> getTableList() {

        TableReg tableReg = new TableReg("Test11", "Test2111", "Test31111");
        ObservableList<TableReg> tableRegs = FXCollections.observableArrayList(tableReg);
        return tableRegs;
    }
}
