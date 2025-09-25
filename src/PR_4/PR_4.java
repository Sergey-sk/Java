package PR_4;

public class PR_4 {
    public interface BookInterface {
        String getFullTitle();

        String getAuthorName();

        int getPublicYear();

        String getPublisher();

        double getPrice();

        void printInfo();
    }

    static class Book implements BookInterface {
        private String title;
        private String author;
        private int year;
        private String publish;
        private double costPrice;
        private double price;
        private double profit;

        public Book(String title, String author, int year, String publish,
                    double costPrice, double price, double profit) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.publish = publish;
            this.costPrice = costPrice;
            this.price = price;
            this.profit = profit;
        }

        @Override
        public String getFullTitle() {
            return title;
        }

        @Override
        public String getAuthorName() {
            return author;
        }

        @Override
        public int getPublicYear() {
            return year;
        }

        @Override
        public String getPublisher() {
            return author;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public void printInfo() {
            System.out.println("Книга: " + title + ", aвтор: " + author + ", год выхода: " + year +
                    ", издательство: " + publish + ", цена: " + price);
        }
    }

    public static void main(String[] args) {
        Book[] books = {new Book("Война и мир", "Лев Толстой", 1869, "Эксмо", 500.0, 1000.0, 500.0),
                new Book("Преступление и наказание", "Фёдор Достоевский", 1866, "Руссикй вестник", 800.0, 1200.0, 400.0),
                new Book("Мастер и маргарита", "Михаил Булгаков", 1967, "Московский рабочий", 700.0, 1500.0, 800.0)};

        System.out.println("=== ВСЕ КНИГИ ===");
        for (Book book : books) {
            book.printInfo();
        }

        System.out.println("\n=== КНИГИ ДО 1900 ГОДА ===");
        for (Book book : books) {
            if (book.getPublicYear() < 1900) {
                book.printInfo();
            }
        }

        System.out.println("\n=== КНИГИ С ЦЕНОЙ БОЛЬШЕ 1000 ===");
        for (Book book : books) {
            if (book.getPrice() > 1000) {
                book.printInfo();
            }
        }
    }
}

