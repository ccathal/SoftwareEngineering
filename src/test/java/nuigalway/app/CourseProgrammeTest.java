package nuigalway.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CourseProgrammeTest {
	private Module firstModule;
	private Module secondModule;
	private Module thirdModule;
    private ArrayList<Student> students;
    private LocalDate dob;
    private CourseProgramme firstCourse;
    private CourseProgramme secondCourse;
    
	@Before
    public void init() {
        firstCourse = new CourseProgramme("CS & IT", LocalDate.of(2019, 9, 1), LocalDate.of(2020, 5, 1));
        secondCourse = new CourseProgramme("EEng", LocalDate.of(2019, 9, 1), LocalDate.of(2020, 5, 1));
        firstModule = new Module("Programming", "CT100");
        secondModule = new Module("Programming2", "CT200");
        thirdModule = new Module("Programming3", "CT300");
        students = new ArrayList<>();
        dob = LocalDate.of(1998, 10, 18);
        students.add(new Student("Tom", "Talker", dob, "123456789"));
        students.add(new Student("John", "Joker", dob, "123456788"));
        students.add(new Student("Mary", "May", dob, "123456787"));
        students.add(new Student("Lisa", "Linsie", dob, "123456786"));
    }

    @Test
    public void courseRegistersModules() {
        firstCourse.addModule(firstModule);
        ArrayList<Module> mod = firstCourse.getModules();
        assertTrue(mod.contains(firstModule));
        assertTrue(!mod.contains(secondModule));

        firstCourse.addModule(secondModule);
        ArrayList<Module> mod2 = firstCourse.getModules();
        assertTrue(mod2.contains(firstModule));
        assertTrue(mod2.contains(secondModule));
    }
    
    @Test
    public void moduleRegistersCourses() {
    	firstModule.addCourse(firstCourse);
    	ArrayList<CourseProgramme> cor = firstModule.getCourse();
    	assertTrue(cor.contains(firstCourse));
        assertTrue(!cor.contains(secondCourse));
        
        firstModule.addCourse(secondCourse);
    	ArrayList<CourseProgramme> cor2 = firstModule.getCourse();
    	assertTrue(cor2.contains(firstCourse));
        assertTrue(cor2.contains(secondCourse)); 	
    }
    
    @Test
    public void testDateExcpetion() throws RuntimeException {
    	try {
    		CourseProgramme thirdCourse = new CourseProgramme("EEng", LocalDate.of(2020, 5, 1), LocalDate.of(2019, 9, 1));
            fail("Error with dates");
        } catch (RuntimeException ignored) {}
    }
    

    @Test
    public void getCourseEnrollments() throws Exception {
        firstCourse.addStudent(students.get(0));
        firstCourse.addStudent(students.get(1));
        firstCourse.addStudent(students.get(2));
        
        ArrayList<Student> enrolledStudents = firstCourse.getStudents();
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
        assertEquals(firstCourse.getStudents().size(), 0);
        firstCourse.addStudent(students.get(0));
        assertEquals(firstCourse.getStudents().size(), 1);
        try {
            firstCourse.addStudent(students.get(0));
            fail("Student already registered for this course");
        } catch (RuntimeException ignored) {}
    }

    @Test
    public void removeAddModules() throws Exception {
        firstCourse.addModule(firstModule);
        firstCourse.addModule(secondModule);
        assertEquals(firstCourse.getModules().size(), 2);

        firstCourse.removeModule(firstModule);
        assertEquals(firstCourse.getModules().size(), 1);
        
        try {
        	firstCourse.addModule(secondModule);
            fail("Module already registered for this course");
        } catch (RuntimeException ignored) {}
        
        try {
        	firstCourse.removeModule(thirdModule);
            fail("Module has not been registered for this course");
        } catch (RuntimeException ignored) {}
        assertEquals(firstCourse.getModules().size(), 1);

        firstCourse.removeModule(secondModule);
        assertEquals(firstModule.getStudents().size(), 0);
    }
}
