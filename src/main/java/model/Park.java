package model;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Park {
    private int parkId;
    private ObservableList<Tree> treeList;
    private String name;

    public Park(int parkId, ObservableList<Tree> treeList, String name)
    {
        this.parkId = parkId;
        this.treeList = treeList;
        this.name = name;
    }

    public int getParkId(){
        return this.parkId;
    }

    public void setParkId( int parkId ){
        this.parkId = parkId;
    }

    public String getName(){
        return this.name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public ObservableList<Tree> getTreeList(){
        return this.treeList;
    }

    public void setTreeIds( ObservableList<Tree> treeList ){
        this.treeList = treeList;
    }
}
