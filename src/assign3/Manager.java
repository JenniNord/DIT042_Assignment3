package assign3;

public class Manager extends Employee {

    private String degreeLevel;
    private double degreeLevelBonus;


    public Manager(int id, String name, double grossSalary, String degreeLevel) {
        super(id, name, grossSalary);
        this.degreeLevel = degreeLevel;
        this.degreeLevelBonus = degreeLevelBonus;

    }

    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }
    public String getDegreeLevel() {
        return degreeLevel;
    }

    //Sets the bonus rate to be added to a manager's gross pay based on education level
    public double setDegreeLevelBonus() {

        if(this.degreeLevel.contains("BSc")) {
            this.degreeLevelBonus = 0.1;
        }
        if(this.degreeLevel.contains("MSc")) {
            this.degreeLevelBonus = 0.2;
        }
        if(this.degreeLevel.contains("phD")) {
            this.degreeLevelBonus = 0.35;
        }
        return this.degreeLevelBonus;
    }

    public double getDegreeLevelBonus() {   return this.degreeLevelBonus; }

    //This overrides/overwrites the getNetSalary in the Employee class, taking the education bonus into account
    @Override
    public double getNetSalary() {

        double netSalary = (super.getGrossSalary() + (super.getGrossSalary() * this.degreeLevelBonus)) * 0.9;
        return netSalary;

    }

}
