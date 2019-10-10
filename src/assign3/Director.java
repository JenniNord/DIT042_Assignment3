package assign3;

public class Director extends Manager {

    private String assignedDepartment;
    public static double directorsBenefit;

    public Director(String id, String name, double grossSalary, String degreeLevel,
                    String assignedDepartment) {

        super(id, name, grossSalary, degreeLevel);
        this.assignedDepartment = assignedDepartment;
    }

    public void setAssignedDepartment(String assignedDepartment) {
        this.assignedDepartment = assignedDepartment;
    }
    public String getAssignedDepartment() {
        return assignedDepartment;
    }


    public static void setDirectorsBenefit(double directorsBenefit) {
        Director.directorsBenefit = directorsBenefit;
    }
    public static double getDirectorsBenefit() {
        return Director.directorsBenefit;
    }


    // method to calculate the combined base gross pay plus educational bonus from the Manager class
    // plus the director's benefit. I think separating this from the getNetSalary method eases readability
    public double calculateGrossBonusBenefit() {
        double grossBonusBenefit = super.calculateGrossPlusBonus() + Director.directorsBenefit;
        return grossBonusBenefit;
    }


    // Overrides the same method in Manager class
    // method to calculate the net salary. 10% for >30k, 20% for >50k,
    // 20% for the first 30k + 40% for any pay over 50k
    @Override
    public double calculateNetSalary() {
    double netSalary = 0;
    
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
