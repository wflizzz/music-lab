package musicservice.repository;

import musicservice.model.Playlist;
import musicservice.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// доп тесты
class InMemoryPlaylistRepositoryTest {

    private final User owner = new User(1, "Алина");
//поиск несущ листа возвр null
    @Test
    void findById_missing_returnsNull() {
        PlaylistRepository repository = new InMemoryPlaylistRepository();
        assertNull(repository.findById(42));
    }

    //сохр лист можно найти по его айди

    @Test
    void saveThenFind_returnsSamePlaylist() {
        PlaylistRepository repository = new InMemoryPlaylistRepository();
        Playlist playlist = new Playlist(1, "любимое", owner);
        repository.save(playlist);
        assertSame(playlist, repository.findById(1));
    }
//нов лист с таким же айди заменит предыдущий
    @Test
    void save_sameId_overwritesPlaylist() {
        PlaylistRepository repository = new InMemoryPlaylistRepository();
        repository.save(new Playlist(1, "старое", owner));
        repository.save(new Playlist(1, "новое", owner));
        assertEquals("новое", repository.findById(1).getName());
    }
}
