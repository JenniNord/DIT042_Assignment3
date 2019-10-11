package assign3;

public class Manager extends Employee {

    private String degreeLevel;


    public Manager(String id, String name, double grossSalary, String degreeLevel) {
        super(id, name, grossSalary);
        this.setDegreeLevel(degreeLevel);
    }


    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    //Sets the bonus rate to be added to a manager's gross pay based on education level
    public double calculateDegreeLevelBonus() {
    	double degreeLevelBonus = 0;

    	switch(degreeLevel.toLowerCase()) {
	    	case "bsc":
	    		degreeLevelBonus = 0.1;
	    		break;
	    	case "msc":
	    		degreeLevelBonus = 0.2;
	    		break;
	    	case "phd":
	    		degreeLevelBonus = 0.35;
	    		break;
	    	default:
	    		System.out.println("Invalid degree level");
    	}
        return degreeLevelBonus;
    }

    //This just calculates the gross pay plus the education bonus. Used in Manager AND Director classes
    @Override
    public double getGrossSalary () {
        double grossPlusBonus = super.getGrossSalary() + (super.getGrossSalary()* calculateDegreeLevelBonus());
        return grossPlusBonus;
    }

    //This overrides/overwrites the getNetSalary in the Employee class, taking the education bonus into account
    @Override
    public double calculateNetSalary() {
        double netSalary = this.getGrossSalary() * 0.9;
        return netSalary;

    }

}