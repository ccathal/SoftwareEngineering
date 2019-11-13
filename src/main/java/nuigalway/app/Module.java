package nuigalway.app;

import java.util.ArrayList;

public class Module {

	private String mName;
	private String mCode;
	private ArrayList<Student> students;

	public Module(String mName, String mCode, ArrayList<Student> students) {
		this.mName = mName;
		this.mCode = mCode;
		this.students = students;
	}
	
	public void addStudent(Student student) {
        this.students.add(student);
        student.addModule(this);
    }

    public void removeStudent(Student student) {
        int index = this.students.indexOf(student);
        this.students.remove(index);
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

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
	
}
