package PR_9;

import java.util.List;

public class CinemaFacade {
    private MovieService movieService;
    private SubscriptionService subscriptionService;

    public CinemaFacade() {
        this.movieService = new MovieService();
        this.subscriptionService = new SubscriptionService();
    }

    public void buySubscription(User user, Payment payment){
        final double SUBSCRIPTION_PRICE = 300.0;

        boolean successPayment = payment.pay(SUBSCRIPTION_PRICE);

        if (successPayment){
            System.out.println("\nОплата прошла успешно, подписка активирована!");
            subscriptionService.activateSubscription(user);
            return;
        }
        System.out.println("Ошибка! Повторите оплату");
    }

    public void watchMovie(User user, String movieTitle) {
        if (!subscriptionService.hasSubscription(user)) {
            System.out.println("Пользователю " + user.getUserName() + " нужна подписка для просмотра фильмов");
            return;
        }

        System.out.println(user.getUserName() + " смотрит фильм: " + movieTitle);
    }

    public List<Movie> findMoviesByGenre(String genre){
        return movieService.getMoviesByGenre(genre);
    }

    public void showAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        System.out.println("Все фильмы:");
        for (Movie movie : movies) {
            System.out.println("- " + movie.getTitle() + " (" + movie.getGenre() + ") - " + movie.getPrice() + " руб.");
        }
    }
}
