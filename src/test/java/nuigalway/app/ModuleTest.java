package nuigalway.app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModuleTest {
//	private Module testModule;
//    private static ArrayList<Student> students;
//
//    @BeforeClass
//    public static void setup() {
//        students = new ArrayList<>();
//        final LocalDate dob = LocalDate.of(1998, 10, 18);
//        students.add(new Student("Jane", "Doe", dob, "12345"));
//        students.add(new Student("John", "Doe", dob, "12346"));
//        students.add(new Student("Mary", "Doe", dob, "12347"));
//        students.add(new Student("Lisa", "Doe", dob, "12348"));
//    }
//
//    @Before
//    public void init() {
//        testModule = new Module("Programming", "CT101");
//    }

    @Test
    public void studentKnowsListOfModules() throws Exception {
    	LocalDate dob = LocalDate.of(1998, 10, 18);
    	Student jane = new Student("Jane", "Doe", dob, "12345");
    	Module testModule = new Module("Programming", "CT101");
        Module secondModule = new Module("Programming2", "CT102");

        testModule.addStudent(jane);
        ArrayList<Module> mod = jane.getModules();
        assertTrue(mod.contains(testModule));
        assertTrue(!mod.contains(secondModule));

        secondModule.addStudent(jane);
        ArrayList<Module> mod2 = jane.getModules();
        assertTrue(mod2.contains(testModule));
        assertTrue(mod2.contains(secondModule));
    }

    @Test
    public void getModuleRoster() throws Exception {
    	LocalDate dob = LocalDate.of(1998, 10, 18);
    	Module testModule = new Module("Programming", "CT101");
        testModule.addStudent(new Student("Jane", "Doe", dob, "12345"));
        testModule.addStudent(new Student("John", "Doe", dob, "12346"));
        testModule.addStudent(new Student("Mary", "Doe", dob, "12347"));
        
        ArrayList<Student> enrolled = testModule.getStudents();
        String studentList = "";
        for (Student student : enrolled) {
            studentList += student.getFname() + " " + student.getLname() + ", ";
        }

        assertTrue(studentList.contains("Jane Doe"));
        assertTrue(studentList.contains("Mary Doe"));
        assertTrue(studentList.contains("John Doe"));
        assertTrue(!studentList.contains("Lisa Doe"));
    }

    @Test
    public void enrollStudent() throws Exception {
    	LocalDate dob = LocalDate.of(1998, 10, 18);
    	Module testModule = new Module("Programming", "CT101");
        assertEquals(testModule.getStudents().size(), 0);
        Student jane = new Student("Jane", "Doe", dob, "12345");
        testModule.addStudent(jane);
        assertEquals(testModule.getStudents().size(), 1);
        System.out.println(testModule.getStudents().get(0).getFname());
        try {
            testModule.addStudent(jane);
            fail("Student already registered for this module");
        } catch (RuntimeException ignored) {}
    }

    @Test
    public void enrollStudentList() throws Exception {
    	Module testModule = new Module("Programming", "CT101");
    	ArrayList<Student> students = new ArrayList<>();
        final LocalDate dob = LocalDate.of(1998, 10, 18);
        students.add(new Student("Jane", "Doe", dob, "12345"));
        students.add(new Student("John", "Doe", dob, "12346"));
        students.add(new Student("Mary", "Doe", dob, "12347"));
        students.add(new Student("Lisa", "Doe", dob, "12348"));
        assertEquals(testModule.getStudents().size(), 0);
        testModule.addStudents(students);
        assertEquals(testModule.getStudents().size(), students.size());

        try {
            testModule.addStudent(students.get(2));
            fail("Student already registered for this module");
        } catch (RuntimeException ignored) {}
    }

    @Test
    public void removeStudent() throws Exception {
    	Module testModule = new Module("Programming", "CT101");
    	ArrayList<Student> students = new ArrayList<>();
        final LocalDate dob = LocalDate.of(1998, 10, 18);
        students.add(new Student("Jane", "Doe", dob, "12345"));
        students.add(new Student("John", "Doe", dob, "12346"));
        students.add(new Student("Mary", "Doe", dob, "12347"));
        students.add(new Student("Lisa", "Doe", dob, "12348"));
        testModule.addStudent(students.get(0));
        testModule.addStudent(students.get(1));
        testModule.addStudent(students.get(2));
        assertEquals(testModule.getStudents().size(), 3);

        testModule.removeStudent(students.get(2));
        assertEquals(testModule.getStudents().size(), 2);

        // Delete student not in module throws an exception
        try {
            testModule.removeStudent(students.get(3));
            fail("Expected exception when student does was never registered for module");
        } catch (RuntimeException ignored) {}
        assertEquals(testModule.getStudents().size(), 2);

        // Cannot remove a student again
        try {
            testModule.removeStudent(students.get(2));
            fail("Expected exception when student has already been removed");
        } catch (RuntimeException ignored) {}
        assertEquals(testModule.getStudents().size(), 2);

        testModule.removeStudent(students.get(0));
        testModule.removeStudent(students.get(1));
        assertEquals(testModule.getStudents().size(), 0);
    }

}