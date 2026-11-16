package musicservice;

import musicservice.model.Playlist;
import musicservice.model.Track;
import musicservice.model.User;
import musicservice.repository.InMemoryPlaylistRepository;
import musicservice.repository.PlaylistRepository;
import musicservice.service.PlaylistService;

public class Application {
    //т внедр зав
    public static void main(String[] args) {

        PlaylistRepository repository = new InMemoryPlaylistRepository();
        //созд сервис и передаем ему реп через к
        //!!! 
        PlaylistService service = new PlaylistService(repository);




        User user = new User(1, "алина");
        Track track1 = new Track(1, "песня 1", "певец 1");
        Track track2 = new Track(2, "песня 2", "певец 2");

        service.createPlaylist(1, "любимые треки", user);

        service.addTrack(1, track1);
        service.addTrack(1, track2);
        System.out.println("добавлено 2 трека в плейлист 'любимые треки'");



        try {
            service.addTrack(1, track1);
        } catch (IllegalStateException e) {
            System.out.println("ошибка трек уже есть такой (так и должно быть): " + e.getMessage());
        }

        Playlist playlist = repository.findById(1);
        System.out.println("треки в плейлисте: " + playlist.getTracks());
    }
}
