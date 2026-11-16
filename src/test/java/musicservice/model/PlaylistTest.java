package musicservice.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// доп тесты
class PlaylistTest {

    private final User owner = new User(1, "Алина");
    private final Track track = new Track(1, "песня 1", "певец 1");

    @Test
    void newPlaylist_isEmpty() {
        Playlist playlist = new Playlist(1, "любимое", owner);
        assertTrue(playlist.getTracks().isEmpty());
    }

    @Test
    void getOwner_returnsOwner() {
        Playlist playlist = new Playlist(1, "любимое", owner);
        assertEquals(owner, playlist.getOwner());
    }
    // проверяем что добавленный трек находится в плейлисте
    @Test
    void containsTrack_afterAdd_true() {
        Playlist playlist = new Playlist(1, "любимое", owner);
        playlist.addTrack(track);
        assertTrue(playlist.containsTrack(track));
    }
    // проверяем что плейлист не содержит трек который не добавляли
    @Test
    void containsTrack_notAdded_false() {
        Playlist playlist = new Playlist(1, "любимое", owner);
        assertFalse(playlist.containsTrack(track));
    }
//попытка доб выз искл
    @Test
    void getTracks_isUnmodifiable() {
        Playlist playlist = new Playlist(1, "любимое", owner);
        List<Track> tracks = playlist.getTracks();
        assertThrows(UnsupportedOperationException.class, () -> tracks.add(track));
    }
}
