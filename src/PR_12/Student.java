package PR_12;

public class Student implements Observer {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Студент " + name + " получил уведомление: " + message);
        System.out.println("Email отправлен на: " + email+"\n");
    }

    @Override
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}