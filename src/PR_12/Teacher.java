package PR_12;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements Subject {
    private String name;
    private List<Observer> students;
    private String courseName;

    public Teacher(String name, String courseName) {
        this.name = name;
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!students.contains(observer)) {
            students.add(observer);
            System.out.println("Студент " + observer.getName() + " добавлен к курсу " + courseName);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        students.remove(observer);
        System.out.println("Студент " + observer.getName() + " удален из курса " + courseName);
    }

    @Override
    public void notifyObservers(String message) {
        String fullMessage = "[" + courseName + "] " + message + " (от " + name + ")";
        System.out.println("Рассылка уведомлений для " + students.size() + " студентов:");

        students.forEach(student -> student.update(fullMessage));
    }

    @Override
    public List<Observer> getObservers() {
        return new ArrayList<>(students);
    }

    public void createAssignment(String assignmentName, String description, String deadline) {
        String message = "НОВОЕ ЗАДАНИЕ: " + assignmentName +
                "\nОписание: " + description +
                "\nСрок сдачи: " + deadline;
        notifyObservers(message);
    }

    public void sendNotification(String notification) {
        notifyObservers("УВЕДОМЛЕНИЕ: " + notification);
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }
}