import java.util.*;
import java.util.stream.Collectors;

// Data model
record Student(String name, String group, double gpa) {}

public class StudentStreamTask {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Aisulu", "COMFCI", 3.8),
                new Student("Sanjar", "COMSEH", 2.9),
                new Student("Alina", "COMCE", 3.2),
                new Student("Diana", "COMFCI", 4.0),
                new Student("Meder", "MATH", 3.6),
                new Student("Daniel", "COMSE", 3.1)
        );

        // 8. Group a list of Student objects by their group field.
        Map<String, List<Student>> byGroup = students.stream()
                .collect(Collectors.groupingBy(Student::group));
        System.out.println("8. Группировка по группам: " + byGroup);

        // 9. Calculate the average GPA of all students.
        double avgGpa = students.stream()
                .mapToDouble(Student::gpa)
                .average()
                .orElse(0.0);
        System.out.printf("9. Средний GPA: %.2f\n", avgGpa);

        // 10. Find the first 3 student that matches a condition (e.g., first student with GPA > 3.5).
        List<Student> top3 = students.stream()
                .filter(s -> s.gpa() > 3.5)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("10. Топ-3 (GPA > 3.5): " + top3);

        // 11. Find how many students who have a GPA greater than 3.5.
        long countHighGpa = students.stream()
                .filter(s -> s.gpa() > 3.5)
                .count();
        System.out.println("11. Кол-во студентов с GPA > 3.5: " + countHighGpa);
    }
}