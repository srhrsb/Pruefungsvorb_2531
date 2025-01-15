package view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class PopUpView {

    public void showInfoWindow( String message ){
         Alert alert = new Alert( Alert.AlertType.INFORMATION );
         alert.setTitle("Info");
         alert.setHeaderText("Ein Ereignis ist eingetreten");
         alert.setContentText(message);
         alert.showAndWait();
    }

    //ToDo: ErrorWindow Methode erstelle
    public void showErrorWindow( String message ){
        Alert alert = new Alert( Alert.AlertType.ERROR );
        alert.setTitle("Fehler");
        alert.setHeaderText("Es ist ein Fehler aufgetreten");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean showConfirmWindow( String message ) {
        Alert alert = new Alert( Alert.AlertType.CONFIRMATION );
        alert.setTitle("Bitte bestätigen");
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

}
