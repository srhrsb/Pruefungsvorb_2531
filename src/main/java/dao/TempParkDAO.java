package dao;

import model.Park;
import model.Tree;

import java.util.ArrayList;

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

        Park park = new Park( id, new ArrayList<Tree>(), name);
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
     * Fügt einen Baum einem Park hinzu. Falls der Park noch nicht vorhanden ist,
     * oder das Speichern anderweitig nicht möglich war, wird false zurückgegeben
     * @param parkId Id des Parks
     * @param tree Baum
     * @return Erfolg
     */
    @Override
    public boolean addTreeToPark(int parkId, Tree tree){

        if( tree == null ) {
            System.err.println("the given instance of tree cannot be null");
            return false;
        }

        for( var park : parkList){
            if( parkId == park.getParkId() ){
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
    public ArrayList<Tree> getAllTreesByParkId( int parkId ) {

        for( var park : parkList){
            if( parkId == park.getParkId() ){
                return park.getTreeList();
            }
        }

        return null;
    }




}
