package assign3;

public class Employee {
    private int id;
    private String name;
    private double grossSalary;

    public Employee(int id, String name, double grossSalary) {
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    /**
     * Regular employees has a net income by paying 10% of taxes in his/her gross salary.
     */
    public double getNetSalary() {
        double netSalary = grossSalary - (grossSalary * 0.1);
        return netSalary;
    }

    /**
     * We might need to format grossSalary so we don't get too many decimals!
     */
    public String toString() {
        String result = name + "'s gross salary is of " + grossSalary + " SEK per month.";
        return result;
    }
}