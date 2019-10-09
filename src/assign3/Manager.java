package assign3;

public class Manager extends Employee {

    private String degreeLevel;
    private double degreeLevelBonus;


    public Manager(String id, String name, double grossSalary, String degreeLevel) {
        super(id, name, grossSalary);
       // this.degreeLevel = degreeLevel;
      //  this.degreeLevelBonus = degreeLevelBonus;
        this.setDegreeLevel(degreeLevel);

    }

    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    //Sets the bonus rate to be added to a manager's gross pay based on education level
    public void calculateDegreeLevelBonus() {

        if(this.degreeLevel.contains("BSc")) {
            this.degreeLevelBonus = 0.1;
        }
        if(this.degreeLevel.contains("MSc")) {
            this.degreeLevelBonus = 0.2;
        }
        if(this.degreeLevel.contains("PhD")) {
            this.degreeLevelBonus = 0.35;
        }

    }

    public double getDegreeLevelBonus() {
        this.calculateDegreeLevelBonus();
        return this.degreeLevelBonus;
    }


    //This just calculates the gross pay plus the education bonus. Used in Manager AND Director classes
    public double calculateGrossPlusBonus () {
        double grossPlusBonus = super.getGrossSalary() + (super.getGrossSalary()* this.getDegreeLevelBonus());
        return grossPlusBonus;
    }

    //This overrides/overwrites the getNetSalary in the Employee class, taking the education bonus into account
    @Override
    public double calculateNetSalary() {
        double netSalary = calculateGrossPlusBonus() * 0.9;
        return netSalary;

    }

}