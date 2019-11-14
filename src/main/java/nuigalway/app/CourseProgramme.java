package nuigalway.app;

import java.time.LocalDate;
import java.util.ArrayList;

public class CourseProgramme {

	private String cName;
	private LocalDate sDate;
	private LocalDate eDate;
	private ArrayList<Student> students;
	private ArrayList<Module> modules;

	public CourseProgramme(String cName, LocalDate sDate, LocalDate eDate) {
		this.cName = cName;
		setDates(sDate, eDate);
		// init arraylists
		this.modules = new ArrayList<Module>();
		this.students = new ArrayList<Student>();
	}

    public String getName() {
        return cName;
    }

    public void setName(String cName) {
        this.cName = cName;
    }

    public LocalDate getStartDate() {
        return sDate;
    }

    public LocalDate getEndDate() {
        return eDate;
    }

    public void setDates(LocalDate sDate, LocalDate eDate) {
    	if(eDate.isBefore(sDate)) {
			System.out.println("End date before start date");
			throw new RuntimeException("Error with dates");
		} else {
			this.eDate = eDate;
			this.sDate = sDate;
		}
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
    
    public void addModule(Module module) {   
        if (modules.contains(module)) {
            throw new RuntimeException("module already registered for this course");
        } else {
        	modules.add(module);
        }
        module.addCourse(this);
    }

    public void addModules(ArrayList<Module> newModules) {
    	for (Module newModule : newModules) {
    		newModule.addCourse(this);
            if (modules.contains(newModule)) {
                throw new RuntimeException("A module is already registered for this course");
            } else {
            	modules.add(newModule);
            }
        }
    }

    public void removeModule(Module module) {
    	if (!modules.contains(module)) {
    		throw new RuntimeException("module has not been registered for this cpurse");
    	} else {
    		int index = modules.indexOf(module);
        	modules.remove(index);
    	}
		module.removeCourse(this);
    }

    
    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudents(ArrayList<Student> newStudents) {
    	for (Student newStudent : newStudents) {
    		newStudent.addCourse(this);
            if (students.contains(newStudent)) {
                throw new RuntimeException("A student is already registered for this course");
            } else {
            	students.add(newStudent);
            }
        }
    }
    
    public void addStudent(Student student) {
        if (students.contains(student)) {
            throw new RuntimeException("Student already registered for this course");
        } else {
        	students.add(student);
        }
        student.addCourse(this);
    }

    public void removeStudent(Student student) {
    	if (!students.contains(student)) {
    		throw new RuntimeException("Student has not been registered for this course");
    	} else {
        	int index = students.indexOf(student);
            students.remove(index);
    	}
    	student.removeCourse(this);

    }
}
