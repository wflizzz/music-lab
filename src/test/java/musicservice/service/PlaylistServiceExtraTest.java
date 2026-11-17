package musicservice.service;

import musicservice.model.Playlist;
import musicservice.model.Track;
import musicservice.model.User;
import musicservice.repository.InMemoryPlaylistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// доп тесты
class PlaylistServiceExtraTest {

    private PlaylistService service;
    private final User owner = new User(1, "Алина");

    //подг тест окр
    @BeforeEach
    void setUp() {
        service = new PlaylistService(new InMemoryPlaylistRepository());
    }

    //пров созд листа и правильность сохр его владельца
    @Test
    void createPlaylist_returnsPlaylistWithOwner() {
        Playlist playlist = service.createPlaylist(1, "любимое", owner);
        assertEquals("любимое", playlist.getName());
        assertEquals(owner, playlist.getOwner());
    }

    //можно + два разных трека
    @Test
    void addTrack_twoDifferentTracks_bothAdded() {
        Playlist playlist = service.createPlaylist(1, "любимое", owner);
        service.addTrack(1, new Track(1, "песня 1", "певец 1"));
        service.addTrack(1, new Track(2, "песня 2", "певец 2"));
        assertEquals(2, playlist.getTracks().size());
    }

    //провер что доб трека в один лист не меняет другой
    @Test
    void addTrack_toOnePlaylist_doesNotChangeOther() {
        Playlist first = service.createPlaylist(1, "первый", owner);
        Playlist second = service.createPlaylist(2, "второй", owner);
        service.addTrack(1, new Track(1, "песня 1", "певец 2"));
        assertEquals(1, first.getTracks().size());
        assertTrue(second.getTracks().isEmpty());
    }

    // новый тест для варианта 11: проверка сохранения порядка треков при добавлении в плейлист
    @Test
    void addTrack_preservesTrackOrderInPlaylist() {
        Playlist playlist = service.createPlaylist(1, "дорога", owner);
        Track firstTrack = new Track(10, "трек первый", "артист 1");
        Track secondTrack = new Track(20, "трек второй", "артист 2");

        service.addTrack(1, firstTrack);
        service.addTrack(1, secondTrack);

        assertEquals(2, playlist.getTracks().size());
        assertEquals(secondTrack, playlist.getTracks().get(0));
        assertEquals(secondTrack, playlist.getTracks().get(1));
    }
}