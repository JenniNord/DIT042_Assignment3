package assign3;

import java.util.ArrayList;

public class ReusaxCorp {
    private ArrayList<Employee> employees;

    public ReusaxCorp() {
        employees = new ArrayList<>();
    }

    /**
     * Registers a new employee after receiving id, name and grossSalary.
     * Adds it to the employees ArrayList.
     */
    public void registerEmployee(String id, String name, double grossSalary) {
        Employee employee = new Employee(id, name, grossSalary);
        employees.add(employee);
    }

    /**
     * Loops through all employees until an employee with matching ID is found.
     * Returns null and prints an error message if employee cannot be retrieved.
     */
    public Employee retrieveEmployee(String id) {
        for (Employee employee : employees) {
            Employee testEmployee = new Employee(id, "", 0);

            if (employee.equals(testEmployee)) {
                return employee;
            }
        }

        System.out.println("An employee of ID " + id + " is not registered in the system.");
        return null;
    }

    /**
     * Removes the employee with the same id from the employees ArrayList.
     */
    public void removeEmployee(String id) {
        Employee employeeToRemove = retrieveEmployee(id);

        if (employeeToRemove != null) {
            employees.remove(employeeToRemove); //do you use the employee object or the id to remove?
        }
    }

    /**
     * Updates the employee's name after retrieving it from id.
     */
    public void updateEmployeeName(String id, String name) {
        Employee employee = retrieveEmployee(id);

        if (employee != null) {
            employee.setName(name);
        }
    }

    /**
     * Update the employee's salary after retrieving it from id.
     */
    public void updateEmployeeSalary(String id, double salary) {
        Employee employee = retrieveEmployee(id);

        if (employee != null) {
            employee.setGrossSalary(salary);
        }
    }

    /**
     * Returns the number of employees registered in the employees ArrayList.
     */
    public int getTotalNumberOfEmployees() {
        return employees.size();
    }

    //Add methods for calculating the total expenses in by paying: 1) Gross salaries 2) Net salaries

    /**
     * Method to test/run ReusaxCorp
     * Might move this to a separate class later on depending on how big it becomes
     */
    public static void main(String[] args) {
        ReusaxCorp reusaxCorp = new ReusaxCorp();

        //Testing registerEmployee()
        reusaxCorp.registerEmployee("1","Fransisco", 10000);
        reusaxCorp.registerEmployee("2","Katja", 10000);

        //Testing retrieveEmployee()
        System.out.println("TEST 1");
        System.out.println(reusaxCorp.retrieveEmployee("2"));
        System.out.println();

        //Testing removeEmployee, retrieveEmployee() should return null since we deleted Katja
        System.out.println("TEST 2");
        reusaxCorp.removeEmployee("2");
        System.out.println(reusaxCorp.retrieveEmployee("2"));
        System.out.println();

        //Tests getTotalNumberOfEmployees, should be 3 since we delete Katja
        System.out.println("TEST 3");
        reusaxCorp.registerEmployee("3","Christian", 20000);
        reusaxCorp.registerEmployee("4","Richard", 20000);
        System.out.println("Total number of employees: " + reusaxCorp.getTotalNumberOfEmployees());
        System.out.println();

        //Tests updateSalary & updateName
        System.out.println("TEST 4");
        System.out.println(reusaxCorp.retrieveEmployee("4").getName());
        reusaxCorp.updateEmployeeName("4", "Alexander"); //Richard changes name to Alexander
        System.out.println(reusaxCorp.retrieveEmployee("4").getName());

        System.out.println(reusaxCorp.retrieveEmployee("1").getGrossSalary());
        reusaxCorp.updateEmployeeSalary("1", 20000); //Fransisco gets a raise
        System.out.println(reusaxCorp.retrieveEmployee("1").getGrossSalary());

        //Test registering intern with different types of GPA
        System.out.println("TEST 5");
        reusaxCorp.registerIntern("5", "Billy", 10000, 5);
        reusaxCorp.registerIntern("6", "Billie", 10000, 6);
        reusaxCorp.registerIntern("7", "Billi", 10000, 8);
        System.out.println();

        //Test registering manager
        System.out.println("TEST 6");
        reusaxCorp.registerManager("8", "Stephen", 50000, "BSc");
        reusaxCorp.registerManager("9", "Steven", 50000, "MSc");
        reusaxCorp.registerManager("10", "Steve", 50000, "phD");
        System.out.println();

        //Test registering director
        System.out.println("TEST 7");
        reusaxCorp.registerDirector("11", "Stefan", 20000, "BSc");
        reusaxCorp.registerDirector("12", "Stephan", 27000, "MSc");
        reusaxCorp.registerDirector("13", "Steph", 62000, "phD");
        System.out.println();

        //Retrieve intern, manager and director

        //Remove intern, manager and director

        //Update name/salary for intern, manager and director
    }
}
