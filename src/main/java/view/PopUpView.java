package view;

import javafx.scene.control.Alert;

public class PopUpView {

     public void showInfoWindow( String message ) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Info");
         alert.setHeaderText("Ein Ereignis ist eingetreten");
         alert.setContentText(message);
         alert.showAndWait();
     }


}
