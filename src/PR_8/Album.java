package PR_8;

public class Album extends MusicApp {
    private Artist artist;
    private int year;

    public Album(String name, int id, Artist artist, int year) {
        super(name, id);
        this.artist = artist;
        this.year = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getInfo() {
        return String.format("Альбом - %s, (ID: %d) | Исполнитель - %s, (ID: %d) | Год - %d",
                name, id, artist.name, artist.id, year);
    }
}
