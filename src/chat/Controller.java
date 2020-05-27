package chat;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public TextField sendField;
    @FXML
    TextArea mainTextArea;
    @FXML
    public Button sendButton;

    @FXML
    public void initialize() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                sendField.requestFocus();
            }
        });
    }

    public void btnOneClickAction(ActionEvent actionEvent) {
        if (sendField.getLength() != 0) {
            mainTextArea.appendText(sendField.getText() + "\n");
            sendField.clear();
            //sendField.setFocusTraversable(true);
            sendField.requestFocus();
        }

//        Button thisButton = (Button)actionEvent.getSource(); // Вот так можно получить ссылку на кнопку, которая была нажата (например, если вы одно и то же действие повесили на десяток кнопок)
    }
}
