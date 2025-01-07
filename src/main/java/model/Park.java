package model;

import java.util.ArrayList;

public class Park {
    private int parkId;
    private ArrayList<Integer> treeIds;
    private String name;

    public Park(int parkId, ArrayList<Integer> treeIds, String name)
    {
        this.parkId = parkId;
        this.treeIds = treeIds;
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

    public ArrayList<Integer> getTreeIds(){
        return this.treeIds;
    }

    public void setTreeIds( ArrayList<Integer> treeIds ){
        this.treeIds = treeIds;
    }
}
