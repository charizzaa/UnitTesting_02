import org.example.Student;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {
    private static List<Student> students;

    @BeforeAll
    public static void initClass() {
        students = new ArrayList<>();
        System.out.println("Before all is called");
    }

    @AfterAll
    public static void cleanClass() {
        students.clear();
        System.out.println("After all is called");
    }

    @BeforeEach
    public void initMethod() {
        Student student = new Student("Caca", 19);
        students.add(student);
        System.out.println("Before each is called");
    }

    @AfterEach
    public void cleanMethod() {
        students.clear();
        System.out.println("After each is called");
    }

    @Test
    public void testDataCreation() {
        Student student = students.get(0);
        assertEquals("Caca", student.getName());
        assertEquals(19, student.getAge());
        System.out.println("Test data creation - passed");
    }

    @Test
    public void testStudentEnrollment() {
        Student student = students.get(0);
        student.enrollCourse("PPPL");
        assertTrue(student.getEnrolledCourses().contains("PPPL"));
        System.out.println("Test student enrollment - passed");
    }

    @Test
    public void testStudentGrade() {
        Student student = students.get(0);
        student.setGrade("PPPL", "A");
        assertEquals("A", student.getGrade("PPPL"));
        System.out.println("Test student grade - passed");
    }
}

