package JForm;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListNamePassword {

    private StringProperty nameTC;
    private StringProperty passwordTC;

}
