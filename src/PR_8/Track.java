package PR_8;

public class Track extends MusicApp implements Playable{
    private Artist artist;
    private Album album;
    private int playCount;
    private double duration;
    private boolean isLike;

    public Track(String name, int id, Artist artist, Album album, int playCount, boolean isLike, double duration) {
        super(name, id);
        this.artist = artist;
        this.album = album;
        this.playCount = playCount;
        this.isLike = isLike;
        this.duration = duration;
    }

    @Override
    public void play(){
        playCount++;
        System.out.println("Воспроизведение: " + name + " - " + artist.name);
    }

    @Override
    public void addToPlaylist(Playlist playlist){
        playlist.tracks.add(this);
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public int getPlayCount() {
        return playCount;
    }

    public boolean isLike() {
        return isLike;
    }

    public double getDuration() {return duration;}

    @Override
    public String getInfo() {
        int minutes = (int)duration / 60;
        int seconds = (int)duration % 60;
        return String.format("Трек - %s (ID - %d) | Исполнитель - %s (ID - %d) | Длительность: %.2f) | " +
                "Кол-во прослушиваний: %d", name, id, artist.name, artist.id, duration, playCount);
    }
}
