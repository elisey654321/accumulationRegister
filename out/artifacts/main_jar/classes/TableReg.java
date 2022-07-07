package classes;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class TableReg {

    private String number;
    private String item;
    private String count;

    public TableReg() {
    }

    public TableReg(String number, String item, String count) {
        this.number = number;
        this.item = item;
        this.count = count;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
