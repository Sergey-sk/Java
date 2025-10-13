package PR_8;

public class Artist extends MusicApp {
    private String genre;

    public Artist(String name, int id, String genre) {
        super(name, id);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String getInfo() {
        return String.format("Исполнитель - %s, (ID: %d) | Жанр - %s", name, id, genre);
    }
}
