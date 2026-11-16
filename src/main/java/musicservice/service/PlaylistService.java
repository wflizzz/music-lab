package musicservice.service;
//бизнес-логика
import musicservice.model.Playlist;
import musicservice.model.Track;
import musicservice.model.User;
import musicservice.repository.PlaylistRepository;

public class PlaylistService {
//поле для хранения репозитория (для внедрения разных реализаций)
    private final PlaylistRepository repository;
//к с внедрением зависимости - подм реп
//!!! сл св
    public PlaylistService(PlaylistRepository repository) {
        this.repository = repository;
    }



    public Playlist createPlaylist(int id, String name, User owner) {
        Playlist playlist = new Playlist(id, name, owner);
        repository.save(playlist);
        return playlist;
    }

//в несущ плейлист трек добавить нельзя

    public void addTrack(int playlistId, Track track) {
        Playlist playlist = repository.findById(playlistId);
        //не нашли - исключение
        if (playlist == null) {
            throw new IllegalArgumentException("Плейлист с id " + playlistId + " не найден");
        }


        if (playlist.containsTrack(track)) {
            throw new IllegalStateException("Композиция '" + track + "' уже есть в плейлисте");
        }

        playlist.addTrack(track);
        repository.save(playlist);
    }
}
