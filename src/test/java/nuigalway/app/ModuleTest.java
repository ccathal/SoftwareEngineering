package nuigalway.app;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModuleTest {
	private Module firstModule;
	private Module secondModule;
    private static ArrayList<Student> students;

    @Before
    public void init() {
        firstModule = new Module("Programming", "CT100");
        secondModule = new Module("Programming2", "CT200");
        
        students = new ArrayList<>();
        final LocalDate dob = LocalDate.of(1998, 10, 18);
        students.add(new Student("Tom", "Talker", dob, "123456789"));
        students.add(new Student("John", "Joker", dob, "123456788"));
        students.add(new Student("Mary", "May", dob, "123456787"));
        students.add(new Student("Lisa", "Linsie", dob, "123456786"));
    }

    @Test
    public void moduleRegistersStudent() throws Exception {
        firstModule.addStudent(students.get(0));
        ArrayList<Module> mod = students.get(0).getModules();
        assertTrue(mod.contains(firstModule));
        assertTrue(!mod.contains(secondModule));

        secondModule.addStudent(students.get(0));
        ArrayList<Module> mod2 = students.get(0).getModules();
        assertTrue(mod2.contains(firstModule));
        assertTrue(mod2.contains(secondModule));
    }

    @Test
    public void getModuleEnrollments() throws Exception {
        firstModule.addStudent(students.get(0));
        firstModule.addStudent(students.get(1));
        firstModule.addStudent(students.get(2));
        
        ArrayList<Student> enrolledStudents = firstModule.getStudents();
        String studentList = "";
        for (Student student : enrolledStudents) {
            studentList += student.getFname() + " " + student.getLname() + ", ";
        }

        assertTrue(studentList.contains("Tom Talker"));
        assertTrue(studentList.contains("Mary May"));
        assertTrue(studentList.contains("John Joker"));
        assertTrue(!studentList.contains("Lisa Linsie"));
    }

    @Test
    public void addDuplicateStudentException() throws Exception {
        assertEquals(firstModule.getStudents().size(), 0);
        firstModule.addStudent(students.get(0));
        assertEquals(firstModule.getStudents().size(), 1);
        try {
            firstModule.addStudent(students.get(0));
            fail("Student already registered for this module");
        } catch (RuntimeException ignored) {}
    }

    @Test
    public void removeAddStudents() throws Exception {
        firstModule.addStudents(students);
        assertEquals(firstModule.getStudents().size(), 4);

        firstModule.removeStudent(students.get(3));
        assertEquals(firstModule.getStudents().size(), 3);
        
        try {
            firstModule.addStudent(students.get(0));
            fail("Student already registered for this module");
        } catch (RuntimeException ignored) {}
        
        try {
            firstModule.removeStudent(students.get(3));
            fail("Student has not been registered for this module");
        } catch (RuntimeException ignored) {}
        System.out.println(firstModule.getStudents().size());
        assertEquals(firstModule.getStudents().size(), 3);

        firstModule.removeStudent(students.get(0));
        firstModule.removeStudent(students.get(1));
        firstModule.removeStudent(students.get(2));
        assertEquals(firstModule.getStudents().size(), 0);
    }

}