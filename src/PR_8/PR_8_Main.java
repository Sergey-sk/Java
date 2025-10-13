package PR_8;

public class PR_8_Main {
    public static void main(String[] args) {
        try {
            Artist artist1 = new Artist("The Weeknd", 1, "R&B/Pop");
            Artist artist2 = new Artist("Daft Punk", 2, "Electronic");
            Artist artist3 = new Artist("Arctic Monkeys", 3, "Rock");

            Album album1 = new Album("After Hours", 101, artist1, 2020);
            Album album2 = new Album("Random Access Memories", 102, artist2, 2013);
            Album album3 = new Album("AM", 103, artist3, 2013);

            Track track1 = new Track("Blinding Lights", 1001, artist1, album1, 0, true, 3.20);
            Track track2 = new Track("Save Your Tears", 1002, artist1, album1, 0, true, 3.35);
            Track track3 = new Track("In Your Eyes", 1003, artist1, album1, 0, false, 3.57);
            Track track4 = new Track("Get Lucky", 1004, artist2, album2, 0, true, 4.08);
            Track track5 = new Track("Instant Crush", 1005, artist2, album2, 0, true, 5.37);
            Track track6 = new Track("Lose Yourself to Dance", 1006, artist2, album2, 0, false, 5.53);

            User user = new User("Alex", 10001, "alex@example.com", "alex123");

            System.out.println("=== Информация о созданных объектах ===");
            System.out.println(artist1);
            System.out.println(album1);
            System.out.println(track1);
            System.out.println(user);

            user.createPlaylist("Favorite Pop", 2001);
            user.createPlaylist("Rock Collection", 2002);

            user.addToPlaylist("Favorite Pop", track1);
            user.addToPlaylist("Favorite Pop", track2);
            user.addToPlaylist("Favorite Pop", track3);
            user.addToPlaylist("Rock Collection", track5);
            user.addToPlaylist("Rock Collection", track6);

            System.out.println("\n=== Воспроизведение отдельных треков ===");
            user.playTrack(track1);
            user.playTrack(track4);
            user.playTrack(track5);

            System.out.println("\n=== Воспроизведение плейлистов ===");
            user.playPlaylist("Favorite Pop");
            user.playPlaylist("Rock Collection");
            user.showStats();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
