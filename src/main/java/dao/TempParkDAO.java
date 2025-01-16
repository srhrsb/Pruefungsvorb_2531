package dao;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import model.Park;
import model.Tree;
import model.TreeFamily;

import java.util.*;

public class TempParkDAO implements ParkDAO{

    private final int PARK_MIN_LENGTH = 6;
    private ArrayList<Park> parkList;

    public TempParkDAO(){
        parkList = new ArrayList<>();
    }

    /**
     * Fügt einen neuen Park hinzu
     * @param id Park ID
     * @param name Park Name
     * @return Erfolg
     */
    @Override
    public boolean addPark( int id, String name ) {

        if(id <= 0 || !isParkUnique(id) || name.length() < PARK_MIN_LENGTH) return false;

        Park park = new Park(id, new ObservableList<Tree>() {
            @Override
            public void addListener(ListChangeListener<? super Tree> listChangeListener) {

            }

            @Override
            public void removeListener(ListChangeListener<? super Tree> listChangeListener) {

            }

            @Override
            public boolean addAll(Tree... trees) {
                return false;
            }

            @Override
            public boolean setAll(Tree... trees) {
                return false;
            }

            @Override
            public boolean setAll(Collection<? extends Tree> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Tree... trees) {
                return false;
            }

            @Override
            public boolean retainAll(Tree... trees) {
                return false;
            }

            @Override
            public void remove(int i, int i1) {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Tree> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(Tree tree) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Tree> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends Tree> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Tree get(int i) {
                return null;
            }

            @Override
            public Tree set(int i, Tree tree) {
                return null;
            }

            @Override
            public void add(int i, Tree tree) {

            }

            @Override
            public Tree remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Tree> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Tree> listIterator(int i) {
                return null;
            }

            @Override
            public List<Tree> subList(int i, int i1) {
                return null;
            }

            @Override
            public void addListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void removeListener(InvalidationListener invalidationListener) {

            }
        }, name);
        return parkList.add( park );
    }

    /**
     * Prüft, ob die gegebene parkId noch nicht vergeben ist
     * @param id ParkID
     * @return true falls unique
     */
    private boolean isParkUnique( int id ){
        for( var park : parkList){
            if(id == park.getParkId()){
                return false;
            }
        }

        return true;
    }

    /**
     * Prüft, ob die gegebene parkId noch nicht vergeben ist
     * @param treeId TreeID
     * @param parkId TreeID
     * @return true falls unique
     */
    private boolean isTreeUnique( int parkId, int treeId ){

        for( var park : parkList){
            if( parkId == park.getParkId() ){ //Park gefunden
                 for( Tree tree : park.getTreeList() ){
                     if(tree.getTreeId() == treeId ){ //Baum in diesem Park gefunden
                         return false;
                     }
                 }
            }
        }

        return true;
    }

    /**
     * Fügt einen Baum einem Park hinzu. Falls der Park noch nicht vorhanden ist,
     * oder das Speichern anderweitig nicht möglich war, wird false zurückgegeben
     * @param parkId Id des Parks
     * @param treeId Baum
     * @return Erfolg
     */
    @Override
    public boolean addTreeToPark(int parkId, int treeId, String name, int treeAge, boolean sick, TreeFamily family){

        for( var park : parkList){
            if( parkId == park.getParkId() && isTreeUnique(parkId, treeId) ){

                Tree tree = new Tree(treeId, name, treeAge, sick, family);
                return park.getTreeList().add(tree);

            }
        }

        return false;
    }

    /**
     * Löscht den Park mit der gegeben ID
     * @param parkId Id des Parks
     * @return Erfolg
     */
    @Override
    public boolean removeParkById(int parkId) {

        for( var park : parkList){
            if( parkId == park.getParkId() ){
                return parkList.remove(park);
            }
        }
        return false;
    }

    /**
     * Gibt eine Liste aller Bäume eines Parks zurück
     * @return
     */
    @Override
    public ObservableList<Tree> getAllTreesByParkId(int parkId ) {

        for( var park : parkList){
            if( parkId == park.getParkId() ){
                return park.getTreeList();
            }
        }

        return null;
    }




}
