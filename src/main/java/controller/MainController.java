package controller;

import dao.ParkDAO;
import dao.TempParkDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Tree;
import model.TreeFamily;
import view.PopUpView;

public class MainController {

    //Tree UI----------------------------------------------
    @FXML
    private TextField treeIdTf;

    @FXML
    private TextField treeNameTf;

    @FXML
    private TextField treeAgeTf;

    @FXML
    private ComboBox treeFamilyCombo;

    @FXML
    private CheckBox treeSickCheckbox;

    //UI Park ----------------------------------------
    @FXML
    private TextField parkIdTf;

    @FXML
    private TextField parkNameTf;

    @FXML
    private TextField parkIdListTf;

    @FXML
    private TableView parkTableView;

    private ParkDAO database;
    private PopUpView popUp;

    @FXML
    private void initialize(){

        database = new TempParkDAO();
        popUp = new PopUpView();


    }

    /**
     * Wird aufgerufen, wenn der Button "Baum hinzufügen" gedrückt wird
     */
    @FXML
    protected void onClickTreeAdd(){

        //Daten besorgen
        //Darauf achten: Exception Handling
        //Objekt erzeugen und hinzufügen

        int parkId = 0;
        int treeId = 0;
        int treeAge = 0;
        try{
            parkId = Integer.parseInt( parkIdTf.getText() );
            if(parkId <= 0)
                throw new NumberFormatException();

            treeId = Integer.parseInt( treeIdTf.getText() );
            if(treeId <= 0)
                throw new NumberFormatException();

            treeAge = Integer.parseInt( treeAgeTf.getText() );
            if(treeAge < 0)
                throw new NumberFormatException();
        }
        catch( NumberFormatException e){
            System.err.println("Error: " + e.getMessage() );
        }

        String name = treeNameTf.getText();
        boolean sick = treeSickCheckbox.isSelected();

        //ToDo: Daten von Checkbox holen
        TreeFamily family = TreeFamily.CONIFER;

        Tree tree = new Tree(parkId,  name, treeAge, sick, family );
        boolean sucess = database.addTreeToPark( parkId, tree );

        if(sucess){
            popUp.showInfoWindow("Ein Baum wurde hinzugefügt.\nName: "+name+"\nId: "+treeId+"\n Park Id: "+parkId);
        }
        else{
            popUp.showErrorWindow("Der Baum konnte nicht hinzugefügt. " +
                    "Möglicherweise wird die ID bereits verwendet oder der Park existiert nicht.");
        }
    }

    /**
     * Wird aufgerufen, wenn der Button "Neuen Park hinzufügen" gedrückt wird
     */
    @FXML
    protected void onClickAddPark(){

        int parkId = getCurrentParkId();

        String parkName =  parkNameTf.getText();
        boolean success = database.addPark(parkId, parkName);
        System.out.println("Park der Liste hinzugefügt: "+success);

        if(success){
            popUp.showInfoWindow("Ein Park wurde hinzugefügt.\nName: "+parkName+"\n Id: "+parkId);
        }
        else{
           popUp.showErrorWindow("Der Park konnte nicht hinzugefügt. " +
                   "Möglicherweise die ID bereits verwendet. ");
        }
    }

    /**
     * Wird aufgerufen wenn der Button "Bäume des Parks auflisten" gedrückt wird
     */
    @FXML
    protected void onClickListPark(){

    }

    /**
     * Wird aufgerufen wenn der Button "Park löschen" gedrückt wird
     */
    @FXML
    protected void onClickRemovePark(){

        int parkId = getCurrentParkId();

        if(popUp.showConfirmWindow("Soll der Park wirklich gelöscht werden")) {
            boolean success = database.removeParkById( parkId );

            if(success){
                popUp.showInfoWindow("Der Park mit der ID: " +parkId+ "gelöscht");
            }
            else{
                popUp.showErrorWindow("Der Park konnte nicht gefunden werden, " +
                        "möglicherweise wurde er bereits gelöscht.");
            }
        }
    }

    private int getCurrentParkId(){

        int parkId = 0;
        try{
            parkId = Integer.parseInt( parkIdListTf.getText() );
            if(parkId <= 0)
                throw new NumberFormatException();
        }
        catch( NumberFormatException e){
            System.err.println("Error: " + e.getMessage() );
        }
        return parkId;
    }
}