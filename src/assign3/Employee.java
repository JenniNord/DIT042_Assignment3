package assign3;

public class Employee {
    private String id;
    private String name;
    private double grossSalary;

    public Employee(String id, String name, double grossSalary) {
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    /**
     * Regular employees has a net income by paying 10% of taxes in his/her gross salary.
     */


    public double calculateNetSalary() {
        double netSalary = grossSalary - (grossSalary * 0.1);
        return netSalary;
    }

    /**
     * We might need to format grossSalary so we don't get too many decimals!
     */
    public String toString() {
        String result = getName() + "'s gross salary is of " + getGrossSalary() + " SEK per month.";
        return result;
    }
    
    @Override
	public boolean equals(Object other) {
        //Checks if other is the same object as "this one", aka same as itself
        if (other == this) {
            return true;
        }

        //Checks if other is null or an actual object
        if (other == null) {
            return false;
        }

        //Checks if other is an Employee or a subclass of Employee
        if (other instanceof Employee) {
            Employee otherEmployee = (Employee) other;

            if (getId().equals(otherEmployee.getId())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
	}
    
//	we did not include a hash code override because we did not use maps but if the program ever changed in the future 
//  it would be necessary 
    
}