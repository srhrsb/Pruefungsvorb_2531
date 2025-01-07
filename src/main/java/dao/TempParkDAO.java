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
     * wird dieser zuvor erzeugt
     * @param parkId
     * @param tree
     */
    @Override
    public void addTreeToPark(int parkId, Tree tree) {






    }







}
