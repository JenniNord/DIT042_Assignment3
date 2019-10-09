package assign3;

public class Director extends Manager {

    private String assignedDepartment;
    private double directorsBenefit;

    public Director(String id, String name, double grossSalary, String degreeLevel,
                    String assignedDepartment, double directorsBenefit) {

        super(id, name, grossSalary, degreeLevel);
        this.assignedDepartment = assignedDepartment;
        this.directorsBenefit = directorsBenefit;
    }

    public void setAssignedDepartment(String assignedDepartment) {
        this.assignedDepartment = assignedDepartment;
    }
    public String getAssignedDepartment() {
        return assignedDepartment;
    }


    public void setDirectorsBenefit(double directorsBenefit) {
        this.directorsBenefit = directorsBenefit;
    }
    public double getDirectorsBenefit() {
        return directorsBenefit;
    }

}
