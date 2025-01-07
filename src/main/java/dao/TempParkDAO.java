package dao;

import model.Park;
import model.Tree;

import java.util.ArrayList;

public class TempParkDAO implements ParkDAO{

    private ArrayList<Park> parkList;

    @Override
    public ArrayList<Tree> getAllTreesByParkId() {
        return null;
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







}
