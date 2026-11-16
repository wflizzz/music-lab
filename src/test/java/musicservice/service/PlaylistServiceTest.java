package musicservice.service;

import musicservice.model.Playlist;
import musicservice.model.Track;
import musicservice.model.User;
import musicservice.repository.InMemoryPlaylistRepository;
import musicservice.repository.PlaylistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistServiceTest {

    private PlaylistRepository repository;
    private PlaylistService service;
    private Track track;

    // чистое состояние перед каждым тестом
    @BeforeEach
    void setUp() {
        repository = new InMemoryPlaylistRepository();
        service = new PlaylistService(repository);
        service.createPlaylist(1, "любимое", new User(1, "Иван"));
        track = new Track(1, "песня 1", "певец 1");
    }

    // тест 1: успешный сценарий
    @Test
    void addTrack_success() {
        service.addTrack(1, track);   // плейлист с id 1 существует
        Playlist playlist = repository.findById(1);
        assertEquals(1, playlist.getTracks().size());
        assertTrue(playlist.containsTrack(track));
    }

    // тест 2: плейлиста не существует
    @Test
    void addTrack_playlistNotFound_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> service.addTrack(999, track));
    }

    // тест 3: нельзя добавить один трек дважды
    @Test
    void addTrack_duplicate_throws() {
        service.addTrack(1, track);
        assertThrows(IllegalStateException.class,
                () -> service.addTrack(1, track));
        assertEquals(1, repository.findById(1).getTracks().size());
    }
}