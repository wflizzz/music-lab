//реализация инт

package musicservice.repository;

import musicservice.model.Playlist;

import java.util.HashMap;
import java.util.Map;




public class InMemoryPlaylistRepository implements PlaylistRepository {
//хранилище (кл знач - объект)

    private final Map<Integer, Playlist> storage = new HashMap<>();

    @Override
    public void save(Playlist playlist) {
        storage.put(playlist.getId(), playlist);
    }

    @Override
    public Playlist findById(int id) {
        return storage.get(id);
    }
}
