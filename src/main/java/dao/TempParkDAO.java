package dao;

import model.Park;
import model.Tree;

import java.util.ArrayList;

public class TempParkDAO implements ParkDAO{

    private ArrayList<Park> parkList;

    /**
     * Fügt einen neuen Park hinzu
     * @param id Park ID
     * @param name Park Name
     * @return Erfolg
     */
    @Override
    public boolean addPark(int id, String name) {
        return false;
    }


    /**
     * Fügt einen Baum einem Park hinzu. Falls der Park noch nicht vorhanden ist,
     * oder das Speichern anderweitig nicht möglich war, wird false zurückgegeben
     * @param parkId Id des Parks
     * @param tree Baum
     */
    @Override
    public boolean addTreeToPark(int parkId, Tree tree){

         return false;
    }


    @Override
    public ArrayList<Tree> getAllTreesByParkId() {
        return null;
    }







}
