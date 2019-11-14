package nuigalway.app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentTest {

    @Test
    public void getUsername() throws Exception {
        LocalDate dob = LocalDate.of(1998, 10, 18);
        Student student = new Student("Cathal", "Corbett", dob, "16321973");
       
        String generatedUsername = student.getUsername();
        String expectedUsername = "CathalCorbett21";
        assertEquals(expectedUsername, generatedUsername);
    }

    @Test
    public void addModuleCourse() throws Exception {
//    	CourseProgramme cp = new CourseProgramme(
//        		"CS & IT", new ArrayList<Module>(), new ArrayList<Student>(), LocalDate.of(2019, 9, 1), LocalDate.of(2020, 5, 1));
        Student student = new Student("Cathal", "Corbett", LocalDate.of(1998, 10, 18), "16321973"); 
        Module module = new Module("Programming", "CT123");
        
        student.addModule(module);
        //student.setCourse(cp);      
        
        assertEquals(student.getModules().size(), 1);
        //assertEquals(student.getCourses()[0], "CS & IT");
    }

    @Test(expected = RuntimeException.class)
    public void testDateException() {
    	Student student = new Student("Cathal", "Corbett", LocalDate.of(2020, 10, 18), "16321973");
    }

}
