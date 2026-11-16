//инт

package musicservice.repository;

import musicservice.model.Playlist;

public interface PlaylistRepository {
    void save(Playlist playlist);

    Playlist findById(int id);   
}
