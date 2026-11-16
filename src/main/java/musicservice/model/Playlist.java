package musicservice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Playlist {
    private final int id;
    private final String name;
    private final User owner;
    private final List<Track> tracks = new ArrayList<>();


    //к созд новый лист 
    public Playlist(int id, String name, User owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public User getOwner() { return owner; }



    //возвращаем список треков но нельзя изменить снаружи


    public List<Track> getTracks() { 
        return Collections.unmodifiableList(tracks); }


//трек есть?
    public boolean containsTrack(Track track) 
    { return tracks.contains(track); }

    public void addTrack(Track track) { tracks.add(track); }
}
