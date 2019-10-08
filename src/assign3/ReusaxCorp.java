package assign3;

import java.util.ArrayList;

public class ReusaxCorp {
    ArrayList<Employee> employees;

    public ReusaxCorp() {
        employees = new ArrayList<>();
    }

    /**
     * Registers a new employee after receiving id, name and grossSalary.
     * Adds it to the employees ArrayList.
     */
    public void registerEmployee(int id, String name, double grossSalary) {
        Employee employee = new Employee(id, name, grossSalary);
        employees.add(employee);
    }

    /**
     * Add logic for retrieving an employee by id.
     */
    public Employee retrieveEmployee(int id) {
        //Find the employee with matching id from employees ArrayList
        //Return null if nothing is found and return the employee object if found
        return null;
    }

    /**
     * Removes the employee with the same id from the employees ArrayList.
     */
    public void removeEmployee(int id) {
        Employee employeeToRemove = retrieveEmployee(id);

        if (employeeToRemove != null) {
            employees.remove(employeeToRemove); //do you use the employee object or the id to remove?
        }
    }

    /**
     * Updates the employee's name after retrieving it from id.
     */
    public void updateEmployeeName(int id, String name) {
        Employee employee = retrieveEmployee(id);

        if (employee != null) {
            employee.setName(name);
        }
    }

    /**
     * Update the employee's salary after retrieving it from id.
     */
    public void updateEmployeeSalary(int id, double salary) {
        Employee employee = retrieveEmployee(id);

        if (employee != null) {
            employee.setGrossSalary(salary);
        }
    }

    /**
     * Returns the number of employees registered in the employees ArrayList.
     */
    public int totalNumberOfEmployees() {
        return employees.size();
    }

    //Add methods for calculating the total expenses in by paying: 1) Gross salaries 2) Net salaries

    /**
     * Method to test/run ReusaxCorp
     * Might move this to a separate class later on depending on how big it becomes
     */
    public static void main(String[] args) {
        ReusaxCorp reusaxCorp = new ReusaxCorp();
    }
}
