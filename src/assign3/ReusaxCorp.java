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
    //Registers a new manager, declaring base type
    public void registerManager(String id, String name, double grossSalary, String degreeLevel) {
    	Employee manager = new Manager(id, name, grossSalary, degreeLevel);
    	employees.add(manager);
    }
    
  //Registers a new intern, declaring descendant type 
    public void registerIntern(String id, String name, double grossSalary, int GPA) {
    	Intern intern = new Intern(id, name, grossSalary, GPA);
    	employees.add(intern);
    }
    
  //Registers a new director, declaring base type
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
    
    //TASK 5
    
	public void promoteToIntern(String id, int gpa) {
		Employee oldPosition = retrieveEmployee(id);
		Intern newPosition = new Intern(id, oldPosition.getName(), oldPosition.getGrossSalary(), gpa);
		removeEmployee(id);
		employees.add(newPosition);
	}

	public void promoteToManager(String id, String degreeLevel) {
		Employee oldPosition = retrieveEmployee(id);
		Manager newPosition = new Manager(id, oldPosition.getName(),oldPosition.getGrossSalary(), degreeLevel);
		removeEmployee(id);
		employees.add(newPosition);
	}

	public void promoteToEmployee(String id) {
		Employee oldPosition = retrieveEmployee(id);
		Employee newPosition = new Employee(id, oldPosition.getName(), oldPosition.getGrossSalary());
		removeEmployee(id);
		employees.add(newPosition);
	}

	public void promoteToDirector(String id, String degreeLevel, String assignedDepartment) {
		Employee oldPosition = retrieveEmployee(id);
		Director newPosition = new Director(id, oldPosition.getName(),oldPosition.getGrossSalary(), degreeLevel, assignedDepartment );
		removeEmployee(id);
		employees.add(newPosition);
	}

}
