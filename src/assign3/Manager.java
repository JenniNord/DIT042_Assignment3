package assign3;

public class Manager extends Employee {

    private String degreeLevel;

    public Manager(int id, String name, double grossSalary, String degreeLevel) {
        super(id, name, grossSalary);
        this.degreeLevel = degreeLevel;

    }

    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }
    public String getDegreeLevel() {
        return degreeLevel;
    }

}
