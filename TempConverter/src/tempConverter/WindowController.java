package tempConverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class WindowController{

    @FXML
    private TextField input;
    @FXML
    private TextField output;
    @FXML
    private RadioButton celsiusIn1;
    @FXML
    private RadioButton fahrenheitIn1;
    @FXML
    private RadioButton kelvinIn1;
    @FXML
    private RadioButton celsiusIn2;
    @FXML
    private RadioButton fahrenheitIn2;
    @FXML
    private RadioButton kelvinIn2;

    private Stage dialogStage;

    private Double result;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    private boolean isInputValid(){
        String errorMessage = "";

        if (input == null || input.getText() == null || input.getText().length() == 0){
            errorMessage += "You haven't entered data.\n";
        } else  {
            try {
                Double.parseDouble(input.getText());
            } catch (NumberFormatException e){
                errorMessage += "Please enter a number in format 0.0.\n";
            }
        }
        if (errorMessage.length() == 0)
            return true;
        else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    private void CelsiusToCelsius (TextField input){
        if(isInputValid())
            output.setText(input.getText() + " °C");
    }

    private void CelsiusToFahrenheit (TextField input){
        if(isInputValid()){
            result = (9./5) * Double.parseDouble(input.getText()) + 32 ;
            output.setText(Double.toString(result) + " °F");
        }

    }

    private void CelsiusToKelvin (TextField input){
        if(isInputValid()){
            result = Double.parseDouble(input.getText()) + 273.15 ;
            output.setText(Double.toString(result) + " °K");
        }

    }

    private void FahrenheitToFahrenheit (TextField input){
        if(isInputValid())
            output.setText(input.getText() + " °F");
    }

    private void FahrenheitToCelsius (TextField input){
        if(isInputValid()) {
            result = 5./9 * (Double.parseDouble(input.getText()) - 32);
            output.setText(Double.toString(result) + " °C");
        }
    }

    private void FahrenheitToKelvin(TextField input){
        if(isInputValid()) {
            result = (Double.parseDouble(input.getText()) + 459.67) * 5./9;
            output.setText(Double.toString(result) + " °K");
        }
    }

    private void KelvinToKelvin (TextField input){
        if(isInputValid())
            output.setText(input.getText() + " °K");
    }

    private void KelvinToCelsius (TextField input){
        if(isInputValid()) {
            result = Double.parseDouble(input.getText()) - 273.15;
            output.setText(Double.toString(result) + " °C");
        }
    }

    private void KelvinToFahrenheit (TextField input){
        if(isInputValid()) {
            result = Double.parseDouble(input.getText()) * 1.8 - 459.67;
            output.setText(Double.toString(result) + " °F");
        }
    }

    @FXML
    private void handleButtonAction (ActionEvent event){
        if (celsiusIn1.isSelected() && celsiusIn2.isSelected()){
            CelsiusToCelsius(input);
        } else if (fahrenheitIn1.isSelected() && fahrenheitIn2.isSelected()){
            FahrenheitToFahrenheit(input);
        } else if (kelvinIn1.isSelected() && kelvinIn2.isSelected()){
            KelvinToKelvin(input);
        } else if (celsiusIn1.isSelected() && fahrenheitIn2.isSelected()){
            CelsiusToFahrenheit(input);
        }  else if (celsiusIn1.isSelected() && kelvinIn2.isSelected()) {
            CelsiusToKelvin(input);
        } else if (fahrenheitIn1.isSelected() && celsiusIn2.isSelected()) {
            FahrenheitToCelsius(input);
        }  else if (fahrenheitIn1.isSelected() && kelvinIn2.isSelected()) {
            FahrenheitToKelvin(input);
        } else if (kelvinIn1.isSelected() && celsiusIn2.isSelected()) {
            KelvinToCelsius(input);
        }  else if (kelvinIn1.isSelected() && fahrenheitIn2.isSelected()) {
            KelvinToFahrenheit(input);
        }
    }
}
