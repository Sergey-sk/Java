package PR_11;

public interface FileAccess {
    void open(String filename, String user);
    void read(String filename, String user);
    void write(String filename, String user);
    void delete(String filename, String user);
}
