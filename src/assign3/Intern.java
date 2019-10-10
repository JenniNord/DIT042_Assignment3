package assign3;

public class Intern extends Employee{

    private int gpa;


    public Intern(String id, String name, double grossSalary, int gpa) {
        super(id, name, grossSalary);
        this.gpa = gpa;
    }

    public int getGPA() {
        return gpa;
    }

    public void setGPA(int gpa) {
        this.gpa = gpa;
    }
    
    @Override //annotation, not required but advised
    public double calculateNetSalary() {
    	double netSalary;
    
    	if (gpa <= 5) {
    		netSalary = 0;
    		
    	} else  if (gpa >= 8) {
    		netSalary = getGrossSalary() + 1000;
    		
    	} else { 
    		netSalary = getGrossSalary();
    	}
    	return netSalary;
    }
}


