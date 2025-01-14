package dao;

import model.Tree;

import java.util.ArrayList;

public interface ParkDAO {

   ArrayList<Tree> getAllTreesByParkId( int parkId );

   boolean addPark( int id , String name);

   boolean addTreeToPark( int parkId, Tree tree);

   boolean removeParkById( int parkId );



}
