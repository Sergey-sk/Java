package PR_12;

public class Demo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Доктор Иванов", "Программирование на Java");

        // Создаем студентов
        Student student1 = new Student("Алексей Петров", "alexey@university.edu");
        Student student2 = new Student("Мария Сидорова", "maria@university.edu");
        Student student3 = new Student("Иван Козлов", "ivan@university.edu");

        teacher.registerObserver(student1);
        teacher.registerObserver(student2);
        teacher.registerObserver(student3);

        System.out.println("\n=== Демонстрация работы платформы ===\n");

        teacher.createAssignment(
                "Лабораторная работа №1",
                "Реализация паттерна Observer",
                "15.12.2023"
        );

        teacher.sendNotification("Следующая лекция переносится на пятницу");

        teacher.removeObserver(student2);

        teacher.sendNotification("Дополнительные материалы выложены в системе");

        Student student4 = new Student("Елена Новикова", "elena@university.edu");
        teacher.registerObserver(student4);

        teacher.createAssignment(
                "Курсовой проект",
                "Разработка учебной платформы",
                "30.12.2023"
        );
    }
}