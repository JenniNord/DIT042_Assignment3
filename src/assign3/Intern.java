package assign3;

public class Intern extends Employee{

    private int GPA;


    public Intern(String id, String name, double grossSalary, int GPA) {
        super(id, name, grossSalary);
        this.GPA = GPA;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }
    
    @Override //annotation, not required but advised
    public double calculateNetSalary() {
    	double adjustedGrossSalary = getGrossSalary();
    	double netSalary = adjustedGrossSalary - (adjustedGrossSalary * 0.1);
    
    	if (GPA <= 5) {
    		adjustedGrossSalary = 0;
    	} else {
    		if (GPA >= 8) {
    			adjustedGrossSalary = getGrossSalary() + 1000;
    		}
    	}
    	return netSalary;
    }
}


