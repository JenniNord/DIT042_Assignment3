package assign3;

public class Intern extends Employee{

    private int GPA;


    public Intern(int id, String name, double grossSalary, int GPA) {
        super(id, name, grossSalary);
        this.GPA = GPA;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }
}
