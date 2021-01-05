package ece325;

import java.lang.Math;
/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Song} class
 * assertFalse(songA.equals(songB));
        assertFalse(songA.equals(new Song("Different Artist", "Song A", (float)4.35)));
        assertFalse(songA.equals(new Song("Artist", "Different Title", (float)4.35)));
        assertFalse(songA.equals(new Song("Artist", "Song A", (float)8.97)));
 */

public class Song {
    // TODO: Assignment 6 -- complete this Song class to pass the tests

    private String artistName, artistSong;
    private Float Length;
    
    public Song(String name, String songTitle, float number){
        this.artistName = name.toLowerCase();
        this.artistSong = songTitle.toLowerCase();
        this.Length = number;
    }
    public Song(String name, String songTitle, double number){
        this.artistName = name.toLowerCase();
        this.artistSong = songTitle.toLowerCase();
        this.Length = (float) number;
    }
    @Override
    public boolean equals(Object obj) {
        //is itself
        if(obj == this){
            return true;
        }
        //of another class
        else if (!(obj instanceof Song)){
            return false;
        }
        //compare
        Song cObj = (Song) obj;
        return artistName.equals(cObj.artistName.toLowerCase()) && 
            artistSong.equals(cObj.artistSong.toLowerCase())
            && Length.equals(cObj.Length);
        
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result * Math.round(Length);
        result = prime * result + (( artistName == null) ? 0 : artistName.hashCode());
        result = prime * result + (( artistSong == null) ? 0 : artistSong.hashCode());
        return result;
    }

    public String getArtist(){
        return artistName;
    }

    public float getLength(){
        return Length;
    }

    public String getTitle(){
        return artistSong;
    }

    public boolean isArtist(String artist){
        return artistName.equals(artist.toLowerCase());
    }

    public boolean isTitle(String title){
        return artistSong.equals(title.toLowerCase());
    }}
