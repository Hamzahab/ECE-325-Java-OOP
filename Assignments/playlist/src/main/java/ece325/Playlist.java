package ece325;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Playlist} class
 */
// @SuppressWarnings("serial")
public class Playlist<E extends Song> extends java.util.ArrayList<E> {
    java.util.Iterator<E> itr = this.iterator();       // Generic Iterator; Use it whenever you need it!
    // TODO: Assignment 6 -- complete this Playlist class to pass the tests
    private String title;
    ArrayList<E> myPlaylist = new ArrayList<E>();
    
    public Playlist(String songTitle){
        this.title = songTitle;
    }

    public Boolean addtoPlist(E subSong){
        if (subSong != null && !(myPlaylist.contains(subSong))){
            myPlaylist.add(subSong);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return myPlaylist.size();
    }
    public int findSong(E subSong){
        return myPlaylist.indexOf(subSong);
    }

    public E getSong(int index){
        return myPlaylist.get(index);
    }
    
    public String getTitle(){
        return title;
    }

    public Boolean hasArtist(String Name){
        for(E song:myPlaylist){
            String retrievedSong = song.getArtist().toLowerCase();
            if (retrievedSong.equals(Name.toLowerCase())){
                return true;
            }
        }
        //found no song with that name
        return false;
    }

    public Boolean hasTitle(String providedTitle){
        return title.equals(providedTitle);
    }

    public int numberOfArtists(){
        ArrayList<String> myArtists = new ArrayList<>();
        for(E song:myPlaylist){
            String retrievedArtist = song.getArtist();
            myArtists.add(retrievedArtist);
        }
        HashSet<String> nonRedundant = new HashSet<>(myArtists);
        
        return nonRedundant.size();
    }
    
    public int numberOfSongs(){
        return myPlaylist.size();
    }

    public int numberOfTitles(){
        ArrayList<String> myTitles = new ArrayList<>();
        for(E song:myPlaylist){
            String retrievedTitle = song.getTitle();
            myTitles.add(retrievedTitle);
        }
        HashSet<String> nonRedundant = new HashSet<>(myTitles);
        
        return nonRedundant.size();
    }

    public double playTime(){
        double total = 0;
        for(E song:myPlaylist){
            total += song.getLength();
        }
        return total;
    }

    public Boolean removeFromPlist(E subsong){
        if (subsong == null){
            return false;
        }
        return myPlaylist.remove(subsong);
    }
    
    public Boolean contains(E subsong) {
        itr = myPlaylist.iterator();
        while(itr.hasNext()){
            if(itr.next().equals(subsong)){
                return true;
            }
        }
        return false;
    }

    public void sortByTitle(){
        //implementing comparator
        myPlaylist.sort(new Comparator<E>(){
            public int compare(E one, E two) {
                return one.getTitle().compareTo(two.getTitle());
            };
        } );
    }

    public void sortByArtist(){
        //implementing comparator
        myPlaylist.sort(new Comparator<E>(){
            public int compare(E one, E two) {
                return one.getArtist().compareTo(two.getArtist());
            };
        } );
    }
}


