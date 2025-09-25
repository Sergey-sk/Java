package PR_3;

public class PR_3 {
    static class Book {
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

        public String getName() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }

        public String getPublish() {
            return publish;
        }

        public double getCostPrice() {
            return costPrice;
        }

        public double getPrice() {
            return price;
        }

        public double getProfit() {
            return profit;
        }

        public void printInfo() {
            System.out.println("Книга: " + title + ", aвтор: " + author + ", год выхода: " + year +
                    ", издательство: " + publish + ", себестоимость: " + costPrice + ", цена: " + price +
                    ", прибыль: " + profit);
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
            if (book.getYear() < 1900) {
                book.printInfo();
            }
        }

        System.out.println("\n=== КНИГИ С ЦЕНОЙ БОЛЬШЕ 1000 ===");
        for (Book book : books) {
            if (book.price > 1000) {
                book.printInfo();
            }
        }
    }
}

