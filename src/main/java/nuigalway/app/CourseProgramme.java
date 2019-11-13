package nuigalway.app;

import java.time.LocalDate;
import java.util.ArrayList;

public class CourseProgramme {

	private String cName;
	private ArrayList<Module> modules;
	private LocalDate sDate;
	private LocalDate eDate;

	public CourseProgramme(String cName, ArrayList<Module> modules, ArrayList<Student> students, LocalDate sDate, LocalDate eDate) {
		this.cName = cName;
		this.modules = modules;
		if(eDate.isBefore(sDate)) {
			System.out.println("End date before start date");
			throw new RuntimeException("Error with dates");
		} else {
			this.eDate = eDate;
			this.sDate = sDate;
		}

	}
	
	public void addModule(Module module) {
        this.modules.add(0, module);

        for(Student student: module.getStudents()) {
            student.setCourse(this);
        }
    }

    public void removeModule(Module module) {
        int index = this.modules.indexOf(module);
        this.modules.remove(index);
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

    public void setStartDate(LocalDate startDate) {
        this.sDate = startDate;
    }

    public LocalDate getEndDate() {
        return eDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.eDate = endDate;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
}
