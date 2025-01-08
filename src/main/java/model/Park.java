package model;

import java.util.ArrayList;

public class Park {
    private int parkId;
    private ArrayList<Tree> treeList;
    private String name;

    public Park(int parkId, ArrayList<Tree> treeList, String name)
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

    public ArrayList<Tree> getTreeList(){
        return this.treeList;
    }

    public void setTreeIds( ArrayList<Tree> treeList ){
        this.treeList = treeList;
    }
}
