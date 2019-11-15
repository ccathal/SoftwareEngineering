package nuigalway.app;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.time.LocalDate;

public class StudentTest {
	private LocalDate dob;
	private CourseProgramme course;
	private Student student;
	private Module module;
	
	
	@Before
	public void init() {
		dob = LocalDate.of(1998, 10, 18);
		student = new Student("Cathal", "Corbett", dob, "16321973"); 
		course = new CourseProgramme("CS & IT", LocalDate.of(2019, 9, 1), LocalDate.of(2020, 5, 1));
        module = new Module("Programming", "CT123");		
	}

    @Test
    public void getUsername() throws Exception {
    	assertEquals(student.getAge(), 21);
        assertEquals(student.getUsername(), "CathalCorbett21");
    }

    @Test
    public void addModuleCourse() throws Exception {
        
        student.addModule(module);
        student.addCourse(course);      
        
        assertEquals(student.getModules().size(), 1);
        assertEquals(student.getCourse().get(0).getName(), "CS & IT");
    }

    @Test
    public void testDateException() {
    	try {
    		student.setDob(LocalDate.of(2020, 10, 18));
            fail("Error with dates");
        } catch (RuntimeException ignored) {}
    }

}
