package model;

public class Tree {
    private int treeId;
    private String name;
    private int age;
    private boolean sick;
    private TreeFamily treeFamily;

    public Tree( int treeId, String name, int age, boolean sick,
                 TreeFamily treeFamily)
    {
        this.treeId = treeId;
        this.name = name;
        this.age = age;
        this.sick = sick;
        this.treeFamily = treeFamily;
    }

    public int getTreeId(){
        return this.treeId;
    }

    public void setTreeId( int treeId ){
        this.treeId = treeId;
    }

    public String getName(){
        return this.name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge( int age ){
        this.age = age;
    }

    public boolean getSick(){
        return this.sick;
    }

    public void setSick( boolean sick ){
        this.sick = sick;
    }

    public TreeFamily getTreeFamily(){
        return this.treeFamily;
    }

    public void setTreeFamily( TreeFamily treeFamily ){
        this.treeFamily = treeFamily;
    }
}
