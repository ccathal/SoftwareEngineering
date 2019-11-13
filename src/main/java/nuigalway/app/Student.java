package nuigalway.app;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
	
	private LocalDate dob;
	private ArrayList<Module> modules;
	private String fname;
	private String lname;
	private String id;
	private CourseProgramme course;

	public Student(String fname, String lname, LocalDate dob, String id) {
    	this.fname = fname;
    	this.lname = lname;
    	if(dob.isAfter(LocalDate.now())) {
			System.out.println("Date of birth in the future");
			throw new RuntimeException("Error with dates");
		} else {
			this.dob = dob;
		}
    	this.id = id;
    }
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    
    public void addModule(Module module) {
        this.modules.add(0, module);
    }
	
	public int getAge() {
		LocalDate today = LocalDate.now();
        int age = today.getYear() - this.dob.getYear();
        return age;
    }
	
	public String getUsername() {
		return "" + this.getFname() + "" +  this.getLname() + "" + this.getAge();
	}
	
	public CourseProgramme getCourse() {
        return course;
    }

	public void setCourse(CourseProgramme course) {
		this.course = course;
		
	}
	
}