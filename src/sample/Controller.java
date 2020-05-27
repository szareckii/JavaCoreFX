package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    TextArea mainTextArea;

    public void btnOneClickAction(ActionEvent actionEvent) {
        mainTextArea.appendText("1\n");
//        Button thisButton = (Button)actionEvent.getSource(); // Вот так можно получить ссылку на кнопку, которая была нажата (например, если вы одно и то же действие повесили на десяток кнопок)
    }
}
