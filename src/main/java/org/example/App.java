package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class App 
{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Group1", 1, Arrays.asList(3, 4, 5)));
        students.add(new Student("Bob", "Group1", 1, Arrays.asList(2, 2, 2)));
        students.add(new Student("Charlie", "Group2", 2, Arrays.asList(4, 4, 4)));

        System.out.println("Before processing:");
        for (Student student : students) {
            System.out.println(student);
        }

        processStudents(students);

        System.out.println("\nAfter processing:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nStudents in course 2:");
        printStudents(students, 2);
    }

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            } else {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
