package dao;

import model.Tree;

import java.util.ArrayList;

public interface ParkDAO {

   ArrayList<Tree> getAllTreesByParkId();

   boolean addPark( int id , String name);

   boolean addTreeToPark( int parkId, Tree tree);



}
