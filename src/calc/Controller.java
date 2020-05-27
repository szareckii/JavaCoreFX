package calc;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {


    private double itog = 0;
    private int lenStr = 0;
    private String operation = "plus";
    private boolean error= false;

    @FXML
    public Label errorLabel;

    @FXML
    public TextField calcField;

    @FXML
    public Button multiplyButton;

    @FXML
    public Button minusButton;

    @FXML
    public Button dividedButton;

    @FXML
    public Button clearButton;

    @FXML
    public Button equallyButton;

    @FXML
    public Button plusButton;

    @FXML
    public void initialize() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                calcField.requestFocus();
                equallyButton.isDefaultButton();
            }
        });
    }

    public void btnOneClickAction(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();

        double arg = 0;


        if (calcField.getLength() != 0) {
            try {
                arg = Double.valueOf(calcField.getText().substring(lenStr));

            } catch (NumberFormatException e) {
                equallyButton.setDisable(true);
                plusButton.setDisable(true);
                dividedButton.setDisable(true);
                minusButton.setDisable(true);
                multiplyButton.setDisable(true);
                errorLabel.setText("Неверный формат строки!");
            }
            switch (operation) {
                case "plus":
                    itog += arg;
                    break;
                case "minus":
                    itog -= arg;
                    break;
                case "multiply":
                    itog *= arg;
                    break;
                case "divided":
                    itog /= arg;            //double на 0 делить можно (бесконечность)
                    break;
            }

            if (btn.getId().equals(plusButton.getId())) {
                calcField.appendText(btn.getText());
                operation = "plus";
            }
            else if (btn.getId().equals(minusButton.getId())) {
                calcField.appendText(btn.getText());
                operation = "minus";
            }
            else if (btn.getId().equals(multiplyButton.getId())) {
                calcField.appendText(btn.getText());
                operation = "multiply";
            }
            else if (btn.getId().equals(dividedButton.getId())) {
                calcField.appendText(btn.getText());
                operation = "divided";
            }
            else if (btn.getId().equals(clearButton.getId())) {
                calcField.clear();
                itog = 0;
                operation = "plus";
                errorLabel.setText("");
                equallyButton.setDisable(false);
                plusButton.setDisable(false);
                dividedButton.setDisable(false);
                minusButton.setDisable(false);
                multiplyButton.setDisable(false);
            }
            else if (btn.getId().equals(equallyButton.getId())) {
                calcField.appendText(btn.getText());
                calcField.appendText(Double.toString(itog));
            }

            lenStr = calcField.getLength();
        }
        calcField.requestFocus();
        calcField.positionCaret(lenStr);

    }
}
