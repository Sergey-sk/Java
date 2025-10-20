package PR_9;

public class Cinema {
    public static void main(String[] args) {
        CinemaFacade cinema = new CinemaFacade();

        // Создаем пользователей
        User user1 = new User("Иван", "ivan@mail.ru");
        User user2 = new User("Мария", "maria@mail.ru");

        System.out.println("=== ДОБРО ПОЖАЛОВАТЬ В КИНОТЕАТР ===\n");

        // Показываем все фильмы
        cinema.showAllMovies();

        System.out.println("\n=== ПОКУПКА ПОДПИСКИ ===");

        // Иван покупает подписку картой
        Payment cardPayment = new CardPayment("1234-5678-9012-3456");
        cinema.buySubscription(user1, cardPayment);

        // Мария покупает подписку через PayPal
        Payment paypalPayment = new PayPalPayment("maria@mail.ru");
        cinema.buySubscription(user2, paypalPayment);

        System.out.println("\n=== ПРОСМОТР ФИЛЬМОВ ===");

        // Иван смотрит фильм (есть подписка)
        cinema.watchMovie(user1, "Матрица");

        // Новый пользователь без подписки пытается смотреть фильм
        User user3 = new User("Петр", "petr@mail.ru");
        cinema.watchMovie(user3, "Крепкий орешек");

        System.out.println("\n=== ПОИСК ФИЛЬМОВ ===");

        // Поиск фильмов по жанру
        java.util.List<Movie> sciFiMovies = cinema.findMoviesByGenre("фантастика");
        System.out.println("Фантастические фильмы:");
        for (Movie movie : sciFiMovies) {
            System.out.println("- " + movie.getTitle());
        }
    }
}
