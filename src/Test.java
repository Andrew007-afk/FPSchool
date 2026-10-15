
import java.time.LocalDate;
import java.time.LocalTime;


import Academic.*;

public class Test {
    public static void main(String[] args){
        // ---- Students ----
        Student s1 = new Student(1, "Laura Gomez", "laura.gomez@mail.com");
        Student s2 = new Student(2, "Carlos Ruiz", "carlos.ruiz@mail.com");

        // ---- Teachers ----
        Teacher t1 = new Teacher(1, "Ana Martinez", "Programacion");
        Teacher t2 = new Teacher(2, "Pedro Sanchez", "Bases de Datos");

        // ---- Subjects ----
        Subject m1 = new Subject(1, "Programacion", "DAM", Subject.Course.First);
        Subject m2 = new Subject(2, "Bases de Datos", "DAM", Subject.Course.Second);

        // ---- Enrollments (Student + Subject) ----
        Enrollment e1 = new Enrollment(1, 1, LocalDate.of(2025, 9, 1));
        Enrollment e2 = new Enrollment(2, 2, LocalDate.of(2025, 9, 2));

        // ---- Schedules (Teacher + Subject) ----
        Schedule h1 = new Schedule(1, 1, LocalTime.of(8, 30));
        Schedule h2 = new Schedule(2, 2, LocalTime.of(10, 15));

        // ---- Grades (Student + Subject) ----
        Grade g1 = new Grade(1, 1, 9);
        Grade g2 = new Grade(2, 2, 7);

        // ---- Attendances (Student + Subject) ----
        Attendance a1 = new Attendance(1, 1, LocalDate.of(2025, 9, 15));
        Attendance a2 = new Attendance(2, 2, LocalDate.of(2025, 9, 16));

        // ---- Output ----
        System.out.println(s1); System.out.println(s2);
        System.out.println(t1); System.out.println(t2);
        System.out.println(m1); System.out.println(m2);
        System.out.println(e1); System.out.println(e2);
        System.out.println(h1); System.out.println(h2);
        System.out.println(g1); System.out.println(g2);
        System.out.println(a1); System.out.println(a2);
    }
}
