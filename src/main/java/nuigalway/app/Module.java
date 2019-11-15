package nuigalway.app;

import java.util.ArrayList;

public class Module {

	private String mName;
	private String mCode;
	private ArrayList<Student> students;
	private ArrayList<CourseProgramme> courses;

	public Module(String mName, String mCode) {
		this.mName = mName;
		this.mCode = mCode;
		// init arraylist of students
		this.students = new ArrayList<Student>();
		this.courses = new ArrayList<CourseProgramme>();
	}

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String mCode) {
        this.mCode = mCode;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudents(ArrayList<Student> newStudents) {
    	for (Student newStudent : newStudents) {
    		newStudent.addModule(this);
            if (students.contains(newStudent)) {
                throw new RuntimeException("A student is already registered for this module");
            } else {
            	students.add(newStudent);
            }
        }
    }
    
    public void addStudent(Student student) {
    	System.out.println(students.contains(student));
        if (students.contains(student)) {
            throw new RuntimeException("Student already registered for this module");
        } else {
            students.add(student);
        }
        student.addModule(this);
    }

    public void removeStudent(Student student) {
    	if (!students.contains(student)) {
    		throw new RuntimeException("Student has not been registered for this module");
    	} else {
    		int index = students.indexOf(student);
            students.remove(index);
    	}
    	student.removeModule(this);
    }
    
    public ArrayList<CourseProgramme> getCourse() {
        return courses;
    }

    public void addCourses(ArrayList<CourseProgramme> newCourses) {
    	for (CourseProgramme newCourse : newCourses) {
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
    }

    public void removeCourse(CourseProgramme course) {
    	if (!courses.contains(course)) {
    		throw new RuntimeException("Student has not been registered for this module");
    	} else {
    		int index = courses.indexOf(course);
            courses.remove(index);
    	}
    }
	
}
