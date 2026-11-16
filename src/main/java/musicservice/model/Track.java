package musicservice.model;

import java.util.Objects;

public class Track {
    private final int id;
    private final String title;
    private final String artist;

    public Track(int id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }

    //переопред
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //с самим собой =
        if (!(o instanceof Track)) return false; //не трек не равны
        return id == ((Track) o).id; // =  id 
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() { return artist + " - " + title; }
}
