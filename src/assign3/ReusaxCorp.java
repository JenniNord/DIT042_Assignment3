package assign3;

import java.util.ArrayList;

public class ReusaxCorp {
    private ArrayList<Employee> employees;

    // Reusax object is being initialised with an ArrayList called employees and the attribute directorsBenefit
    // set at 5000 as default
    public ReusaxCorp() {
        employees = new ArrayList<>();
        updateDirectorsBenefit(5000);
    }

    /**
     * Registers a new employee after receiving id, name and grossSalary.
     * Adds it to the employees ArrayList.
     */
    public void registerEmployee(String id, String name, double grossSalary) {
        Employee employee = new Employee(id, name, grossSalary);
        employees.add(employee);
    }
    //Registers a new manager 
    public void registerManager(String id, String name, double grossSalary, String degreeLevel) {
    	Employee manager = new Manager(id, name, grossSalary, degreeLevel);
    	employees.add(manager);
    }
    
  //Registers a new intern 
    public void registerIntern(String id, String name, double grossSalary, int GPA) {
    	Intern intern = new Intern(id, name, grossSalary, GPA);
    	employees.add(intern);
    }
    
  //Registers a new director 
    public void registerDirector(String id, String name, double grossSalary, String degreeLevel,
            String assignedDepartment) {
    	Employee director = new Director(id, name, grossSalary, degreeLevel, assignedDepartment);
    	employees.add(director);
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

    //  Method to calculate the total gross salaries for all employees, using the
    //  getGrossSalary method
    public double calculateTotalGrossSalaries() {

        double totalGross = 0;

        for (int i = 0; i < employees.size(); i++) {
            totalGross = totalGross + employees.get(i).getGrossSalary();
        }
        return totalGross;
    }

    //  Method to calculate the total net salaries for all employees, using the
    //  calculateNetSalary methods from each class
    public double calculateTotalNetSalaries() {

        double totalNet = 0;
        for (int i = 0; i < employees.size(); i++) {
            totalNet = totalNet + employees.get(i).calculateNetSalary();
        }
        return totalNet;
    }


    public void updateDirectorsBenefit (double directorsBenefit) {
        Director.setDirectorsBenefit(directorsBenefit);
    }


    /**
     * Method to test/run ReusaxCorp
     * Might move this to a separate class later on depending on how big it becomes
     */
    public static void main(String[] args) {
        ReusaxCorp reusaxCorp = new ReusaxCorp();




        //Tests calculateTotalGrossSalaries and calculateTotalNetSalaries

        System.out.println("TEST 5");
        double directorsBenefit = 10000;
        reusaxCorp.updateDirectorsBenefit(directorsBenefit);
        reusaxCorp.registerDirector("6","Per",60000,"MSc","Technology");
        System.out.println("ReusaxCorp pays a total of " + reusaxCorp.calculateTotalGrossSalaries() + " SEK in gross salaries");
        System.out.println("ReusaxCorp pays a total of " + reusaxCorp.calculateTotalNetSalaries() + " SEK in Net salaries");

        //Tests calculateGrossSalary and calculateNetSalary

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
        reusaxCorp.registerDirector("11", "Stefan", 20000, "BSc", "HR");
        reusaxCorp.registerDirector("12", "Stephan", 27000, "MSc", "Tech");
        reusaxCorp.registerDirector("13", "Steph", 62000, "phD", "Business");
        System.out.println();

        //Retrieve intern, manager and director

        //Remove intern, manager and director

        //Update name/salary for intern, manager and director
    }

}
