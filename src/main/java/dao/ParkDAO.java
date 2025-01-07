package dao;

import model.Tree;

import java.util.ArrayList;

public interface ParkDAO {

   ArrayList<Tree> getAllTreesByParkId();

   void addTreeToPark( int parkId, Tree tree);



}
