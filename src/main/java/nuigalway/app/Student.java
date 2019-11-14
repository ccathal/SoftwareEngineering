package nuigalway.app;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
	
	private String fname;
	private String lname;
	private LocalDate dob;
	private String id;
	private ArrayList<Module> modules;
	private ArrayList<CourseProgramme> courses;

	public Student(String fname, String lname, LocalDate dob, String id) {
    	this.fname = fname;
    	this.lname = lname;
    	setDob(dob);
    	this.id = id;
    	// init module arraylist
    	this.modules = new ArrayList<Module>();
    	this.courses = new ArrayList<CourseProgramme>();
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
    	if(dob.isAfter(LocalDate.now())) {
			System.out.println("Date of birth in the future");
			throw new RuntimeException("Error with dates");
		} else {
			this.dob = dob;
		}
    }
    
    public int getAge() {
		LocalDate today = LocalDate.now();
        int age = today.getYear() - this.dob.getYear();
        return age;
    }
	
	public String getUsername() {
		return "" + this.getFname() + "" +  this.getLname() + "" + this.getAge();
	}
    
	public ArrayList<Module> getModules() {
        return modules;
    }
    
    public void addModule(Module module) {   
        if (modules.contains(module)) {
            throw new RuntimeException("module already registered for this student");
        } else {
        	modules.add(module);
        }
        //module.addStudent(this);
    }

    public void addModules(ArrayList<Module> newModules) {
    	for (Module newModule : newModules) {
    		//newModule.addStudent(this);
            if (modules.contains(newModule)) {
                throw new RuntimeException("A module is already registered for this student");
            } else {
            	modules.add(newModule);
            }
        }
    }

    public void removeModule(Module module) {
    	if (!modules.contains(module)) {
    		throw new RuntimeException("module has not been registered for this student");
    	} else {
    		int index = modules.indexOf(module);
        	modules.remove(index);
    	}
		//module.removeStudent(this);
    }
	
    public ArrayList<CourseProgramme> getCourse() {
        return courses;
    }

    public void addCourses(ArrayList<CourseProgramme> newCourses) {
    	for (CourseProgramme newCourse : newCourses) {
    		//newCourse.addStudent(this);
            if (courses.contains(newCourse)) {
                throw new RuntimeException("A courses is already registered for this module");
            } else {
            	courses.add(newCourse);
            }
        }
    }
    
    public void addCourse(CourseProgramme course) {
        if (courses.contains(course)) {
            throw new RuntimeException("Course already registered for this module");
        } else {
        	courses.add(course);
        }
    	//course.addStudent(this);
    }

    public void removeCourse(CourseProgramme course) {
    	if (!courses.contains(course)) {
    		throw new RuntimeException("Student has not been registered for this module");
    	} else {
    		int index = courses.indexOf(course);
            courses.remove(index);
    	}
		//course.removeStudent(this);
    }
}