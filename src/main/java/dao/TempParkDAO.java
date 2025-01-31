package dao;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import model.Park;
import model.Tree;
import model.TreeFamily;

import java.util.*;

public class TempParkDAO implements ParkDAO{

    private final int PARK_MIN_LENGTH = 6;
    private ArrayList<Park> parkList;

    public TempParkDAO(){
        parkList = new ArrayList<>();
    }

    /**
     * Fügt einen neuen Park hinzu
     * @param id Park ID
     * @param name Park Name
     * @return Erfolg
     */
    @Override
    public boolean addPark( int id, String name ) {

        if(id <= 0 || !isParkUnique(id) || name.length() < PARK_MIN_LENGTH) return false;

        Park park = new Park(id, FXCollections.observableArrayList(), name);
        return parkList.add( park );
    }

    /**
     * Prüft, ob die gegebene parkId noch nicht vergeben ist
     * @param id ParkID
     * @return true falls unique
     */
    private boolean isParkUnique( int id ){
        for( var park : parkList){
            if(id == park.getParkId()){
                return false;
            }
        }

        return true;
    }

    /**
     * Prüft, ob die gegebene parkId noch nicht vergeben ist
     * @param treeId TreeID
     * @param parkId TreeID
     * @return true falls unique
     */
    private boolean isTreeUnique( int parkId, int treeId ){

        for( var park : parkList){
            if( parkId == park.getParkId() ){ //Park gefunden
                 for( Tree tree : park.getTreeList() ){
                     if(tree.getTreeId() == treeId ){ //Baum in diesem Park gefunden
                         return false;
                     }
                 }
            }
        }

        return true;
    }

    /**
     * Fügt einen Baum einem Park hinzu. Falls der Park noch nicht vorhanden ist,
     * oder das Speichern anderweitig nicht möglich war, wird false zurückgegeben
     * @param parkId Id des Parks
     * @param treeId Baum
     * @return Erfolg
     */
    @Override
    public boolean addTreeToPark(int parkId, int treeId, String name, int treeAge, boolean sick, TreeFamily family){

        for( var park : parkList){
            if( parkId == park.getParkId() && isTreeUnique(parkId, treeId) ){

                Tree tree = new Tree(treeId, name, treeAge, sick, family);
                return park.getTreeList().add(tree);

            }
        }

        return false;
    }

    /**
     * Löscht den Park mit der gegeben ID
     * @param parkId Id des Parks
     * @return Erfolg
     */
    @Override
    public boolean removeParkById(int parkId) {

        for( var park : parkList){
            if( parkId == park.getParkId() ){
                return parkList.remove(park);
            }
        }
        return false;
    }

    /**
     * Gibt eine Liste aller Bäume eines Parks zurück
     * @return
     */
    @Override
    public ObservableList<Tree> getAllTreesByParkId(int parkId ) {

        for( var park : parkList){
            if( parkId == park.getParkId() ){
                return park.getTreeList();
            }
        }

        return null;
    }

    /**
     * Löscht den Baum mit dem gegebenen Index im Park mit der gegebenen ParkID
     * @param parkId ParkId
     * @param index BaumIndex
     * @return Erfolg
     */
    public boolean deleteTreeByIndex( int parkId, int index ){

        for( var park : parkList){
            if( parkId == park.getParkId() ){ //Park gefunden
                 Tree removedTree = park.getTreeList().remove(index);
                 return removedTree != null;
            }
        }
        return false;
    }
}
