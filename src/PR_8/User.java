package PR_8;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends MusicApp {
    private String email;
    private String password;
    private List<Track> history;
    private Map<String, Playlist> playlistMap;

    public User(String name, int id, String email, String password) {
        super(name, id);
        Pattern pattern = Pattern.compile("[\\w.-]+@[\\w.-]+\\.(com|ru)");
        Matcher matcher = pattern.matcher(email);
        if (password == null || !matcher.matches()) throw new IllegalArgumentException("Введен неверный пароль или почта!");
        this.email = email;
        this.password = password;
        this.history = new LinkedList<>();
        this.playlistMap = new HashMap<>();
    }

    public void createPlaylist(String name, int id) {
        if (playlistMap.containsKey(name))
            throw new IllegalArgumentException("Плейлист с таким именем уже существует!");
        playlistMap.put(name, new Playlist(name, id, this));
        System.out.println("Создан плейлист: " + name);
    }

    public void removePlaylist(String name) {
        if (!playlistMap.containsKey(name))
            throw new IllegalArgumentException("Плейлистa с таким именем не существует!");
        playlistMap.remove(name);
        System.out.println("Удален плейлист: " + name);
    }

    public void addToPlaylist(String playlistName, Track track){
        Playlist playlist = playlistMap.get(playlistName);
        if (playlist == null) throw new NoSuchElementException("Плейлист '" + playlistName + "' не найден");
        playlist.addTrack(track);
    }

    public void playPlaylist(String playlistName) {
        Playlist playlist = playlistMap.get(playlistName);
        if (playlist == null) throw new NoSuchElementException("Плейлист " + playlistName + " не найден!");
        playlist.play();
        history.addAll(playlist.tracks);
    }

    public void playTrack(Track track){
        track.play();
        history.add(track);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("В истории ничего нет");
            return;
        }
        history.forEach(System.out::println);
    }

    public void showStats(){
        System.out.println("Статистика пользователя");
        System.out.println("Всего прослушиваний:" + history.size());

        Map<Artist, Integer> artistStats = new HashMap<>();
        for(Track track : history){
            artistStats.merge(track.getArtist(), 1, Integer::sum);
        }

        if (!artistStats.isEmpty()){
            System.out.println("Топ исполнителей: ");
            artistStats.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(5)
                    .forEach(entry -> System.out.println(entry.getKey().name + ": " + entry.getValue()));

        }
        System.out.println("Кол-во плейлистов: " + playlistMap.size());
    }

    public String getUserName(){
        return name;
    }

    public Collection<Playlist> getPlaylist(){
        return playlistMap.values();
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getInfo() {
        return String.format("Пользователь - %s (ID - %d)", this.name, this.id);
    }
}
