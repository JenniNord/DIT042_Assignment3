package assign3;

public class Director extends Manager {

    private String assignedDepartment;
    private double directorsBenefit;
    private double grossBonusBenefit;

    public Director(String id, String name, double grossSalary, String degreeLevel,
                    String assignedDepartment, double directorsBenefit) {

        super(id, name, grossSalary, degreeLevel);
        this.assignedDepartment = assignedDepartment;
        this.directorsBenefit = directorsBenefit;
        this.grossBonusBenefit = grossBonusBenefit;

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

    // method to calculate the combined base gross pay plus educational bonus from the Manager class
    // plus the director's benefit. I think separating this from the getNetSalary method eases readability
    public double calculateGrossBonusBenefit() {
        this.grossBonusBenefit = super.getGrossPlusBonus() + this.directorsBenefit;
        return grossBonusBenefit;
    }


    // Overrides the same method in Manager class
    // method to calculate the net salary. 10% for >30k, 20% for >50k, 20% + 40% for anything over 50k
    @Override
    public double getNetSalary() {
    double netSalary;
        if(calculateGrossBonusBenefit() < 30000.00) {
            netSalary = calculateGrossBonusBenefit() * 0.9;
        } else if((calculateGrossBonusBenefit() >= 30000.00) && (calculateGrossBonusBenefit() <= 50000.00)) {
            netSalary = calculateGrossBonusBenefit() * 0.8;
        } else {
           netSalary = ((calculateGrossBonusBenefit()-30000.00)*0.6) + (30000.00*0.8);
        }

        return netSalary;
    }

}
