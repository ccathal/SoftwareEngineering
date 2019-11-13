package nuigalway.app;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Student 
{
    private String name;
	private int age;
	private String dob;
	private String uname;
	private List courses;
	private List modules;

	public Student(String name, int age, String dob, String uname, List courses, List modules) {
    	this.name = name;
    	this.age = age;
    	this.dob = dob;
    	this.uname = uname;
    	this.courses = courses;
    	this.modules = modules;
    }
}
