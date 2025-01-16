package dao;

import javafx.collections.ObservableList;
import model.Tree;
import model.TreeFamily;

import java.util.ArrayList;

public interface ParkDAO {

   ObservableList<Tree> getAllTreesByParkId(int parkId );

   boolean addPark( int id , String name);

   boolean addTreeToPark( int parkId, int treeId, String name, int treeAge, boolean sick, TreeFamily family);

   boolean removeParkById( int parkId );

}
