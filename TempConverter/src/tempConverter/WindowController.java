package tempConverter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WindowController{

    @FXML
    private TextField input;
    @FXML
    private TextField output;

    private Stage dialogStage;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    private boolean isInputValid(){
        String errorMessage = "";

        if (input.getText() == null || input.getText().length() == 0){
            errorMessage += "You haven't entered data.\n";
        } else  {
            try {
                Integer.parseInt(input.getText());
            } catch (NumberFormatException e){
                errorMessage += "Please enter a number not text.\n";
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
}
