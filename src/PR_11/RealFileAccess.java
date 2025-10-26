package PR_11;

public class RealFileAccess implements FileAccess{

    @Override
    public void open(String filename, String user) {
        System.out.println("Файл " + filename + " открыть пользователем " + user);
    }

    @Override
    public void read(String filename, String user) {
        System.out.println("Пользователь " + user + " читает файл: " + filename);
    }

    @Override
    public void write(String filename, String user) {
        System.out.println("Пользователь " + user + " записывает в файл: " + filename);
    }

    @Override
    public void delete(String filename, String user) {
        System.out.println("Файл: " + filename + " удален пользователем " + user);
    }
}
