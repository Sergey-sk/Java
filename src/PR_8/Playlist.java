package PR_8;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Playlist extends MusicApp implements Playable {
    protected List<Track> tracks;
    private User owner;

    public Playlist(String name, int id, User owner) {
        super(name, id);
        this.owner = owner;
        this.tracks = new LinkedList<>();
    }

    public User getOwner() {
        return owner;
    }

    public void showAllTracks() {
        System.out.println("Все треки: ");
        tracks.forEach(track -> System.out.print(track.name + " "));
    }

    public void addTrack(Track track) {
        if (track == null) throw new IllegalArgumentException("Указан неверный трек!");
        tracks.add(track);
        System.out.println("Трек: " + track.name + ", добвален в плейлист: " + this.name);
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) throw new IllegalArgumentException("Такого трека нет в плейлисте!");
        tracks.remove(track);
        System.out.println("Трек: " + track.name + ", удален из плейлиста: " + this.name);
    }

    @Override
    public void play() {
        if (tracks.isEmpty()) {
            System.out.println("Плейлист " + name + " пустой");
            return;
        }
        System.out.println("Воспроизводится плейлист: " + name);
        tracks.forEach(Track::play);
        System.out.println("Конец плейлиста");
    }

    @Override
    public void addToPlaylist(Playlist playlist) {
        System.out.println("Недьзя добавить один плейлист в другой!");
    }

    @Override
    public String getInfo() {
        return String.format("Название плейлиста - %s (ID - %d) | Хозяин - %s (ID - %d)",
                this.name, this.id, owner.name, owner.id);
    }
}
