package assign3;

import java.util.ArrayList;

public class TestReusaxCorp {

    /**
     * This isn't in any way a "proper" test class but it tests the basic functionality required for Assignment 3.
     */
    public static void main(String[] args) {
        ReusaxCorp reusaxCorp = new ReusaxCorp();

        //Testing registerEmployee()
        reusaxCorp.registerEmployee("1","Fransisco", 10000);
        reusaxCorp.registerEmployee("2","Katja", 10000);

        //Testing retrieveEmployee(), should print Katjas toString()
        System.out.println("TEST 1 - Retrieve");
        System.out.println(reusaxCorp.retrieveEmployee("2"));
        System.out.println();

        //Testing removeEmployee, retrieveEmployee() should return null since we deleted Katja
        System.out.println("TEST 2 - Remove");
        reusaxCorp.removeEmployee("2");
        System.out.println(reusaxCorp.retrieveEmployee("2"));
        System.out.println();

        //Tests getTotalNumberOfEmployees, should be 3 since we delete Katja
        System.out.println("TEST 3 - Total");
        reusaxCorp.registerEmployee("3","Christian", 20000);
        reusaxCorp.registerEmployee("4","Richard", 20000);
        System.out.println("Total number of employees: " + reusaxCorp.getTotalNumberOfEmployees());
        System.out.println();

        //Tests updateSalary & updateName
        System.out.println("TEST 4 - Update");
        System.out.println(reusaxCorp.retrieveEmployee("4").getName());
        reusaxCorp.updateEmployeeName("4", "Alexander"); //Richard changes name to Alexander
        System.out.println(reusaxCorp.retrieveEmployee("4").getName());

        System.out.println(reusaxCorp.retrieveEmployee("1").getGrossSalary());
        reusaxCorp.updateEmployeeSalary("1", 20000); //Fransisco gets a raise
        System.out.println(reusaxCorp.retrieveEmployee("1").getGrossSalary());
        System.out.println();

        //Test registering intern with different types of GPA & retrieving
        System.out.println("TEST 5 - Intern CR"); //CR stands for Create/Read which is the same as register/retrieve
        reusaxCorp.registerIntern("5", "Billy", 10000, 5);
        reusaxCorp.registerIntern("6", "Billie", 10000, 6);
        reusaxCorp.registerIntern("7", "Billi", 10000, 8);

        System.out.println(reusaxCorp.retrieveEmployee("5"));
        System.out.println(reusaxCorp.retrieveEmployee("6"));
        System.out.println(reusaxCorp.retrieveEmployee("7"));
        System.out.println();

        //Test registering manager & retrieving
        System.out.println("TEST 6 - Manager CR");
        reusaxCorp.registerManager("8", "Stephen", 10000, "BSc");
        reusaxCorp.registerManager("9", "Steven", 10000, "MSc");
        reusaxCorp.registerManager("10", "Steve", 10000, "PhD");

        System.out.println(reusaxCorp.retrieveEmployee("8"));
        System.out.println(reusaxCorp.retrieveEmployee("9"));
        System.out.println(reusaxCorp.retrieveEmployee("10"));
        System.out.println();

        //Test registering & retrieving director
        System.out.println("TEST 7 - Director CR");
        reusaxCorp.registerDirector("11", "Stefan", 20000, "BSc", "HR");
        reusaxCorp.registerDirector("12", "Stephan", 27000, "MSc", "HR");
        reusaxCorp.registerDirector("13", "Steph", 62000, "PhD", "HR");

        System.out.println(reusaxCorp.retrieveEmployee("11"));
        System.out.println(reusaxCorp.retrieveEmployee("12"));
        System.out.println(reusaxCorp.retrieveEmployee("13"));
        System.out.println();

        //Test calculateNetSalary for all employee types
        System.out.println("TEST 8 - Net salary");
        //Employee, Gross: 20000, Net: 18000
        Employee fransisco = reusaxCorp.retrieveEmployee("1");
        System.out.println(fransisco.getName() + "'s net salary is: " + fransisco.calculateNetSalary());

        //Intern with 5 GPA, Gross:10000 , Net: 0
        Intern billy = (Intern) reusaxCorp.retrieveEmployee("5");
        System.out.println(billy.getName() + "'s net salary is: " + billy.calculateNetSalary());

        //Intern with 6 GPA, Gross: 10000, Net: 10000
        Intern billie = (Intern) reusaxCorp.retrieveEmployee("6");
        System.out.println(billie.getName() + "'s net salary is: " + billie.calculateNetSalary());

        //Intern with 8 GPA, Gross: 10000, Net: 11000
        Intern billi = (Intern) reusaxCorp.retrieveEmployee("7");
        System.out.println(billi.getName() + "'s net salary is: " + billi.calculateNetSalary());

        //Manager with BSc, Gross: 10000 , Bonus: 1000, Net: too lazy to mafs
        Manager stephen = (Manager) reusaxCorp.retrieveEmployee("8");
        System.out.println(stephen.getName() + "'s net salary is: " + stephen.calculateNetSalary());

        //Manager with MSc, Gross: 10000, Bonus: 2000, Net: too lazy to mafs
        Manager steven = (Manager) reusaxCorp.retrieveEmployee("9");
        System.out.println(steven.getName() + "'s net salary is: " + steven.calculateNetSalary());

        //Manager with PhD, Gross: 10000, Bonus: 2000, Net: too lazy to mafs
        Manager steve = (Manager) reusaxCorp.retrieveEmployee("10");
        System.out.println(steve.getName() + "'s net salary is: " + steve.calculateNetSalary());

        //Director with BSc, Gross: 20000 , Net: 24300
        Director stefan = (Director) reusaxCorp.retrieveEmployee("11");
        System.out.println(stefan.getName() + "'s net salary is: " + stefan.calculateNetSalary());

        //Director with MSc, Gross: 27000, Net: 29920
        Director stephan = (Director) reusaxCorp.retrieveEmployee("12");
        System.out.println(stephan.getName() + "'s net salary is: " + stephan.calculateNetSalary());

        //Director with PhD, Gross: 62000, Net: 59220
        Director steph = (Director) reusaxCorp.retrieveEmployee("13");
        System.out.println(steph.getName() + "'s net salary is: " + steph.calculateNetSalary());
        System.out.println();

        //Test total expenses gross/net
        System.out.println("TEST 9 - Total expenses");
        //Creating another company for testing with fewer employees so it'll be easier to see if the calculations are
        //correct.
        ReusaxCorp tempReusaxCorp = new ReusaxCorp();
        tempReusaxCorp.registerEmployee("1", "Test1", 100);
        tempReusaxCorp.registerIntern("2", "Test2", 100, 5);//Shouldnt get paid
        tempReusaxCorp.registerManager("3", "Test3", 100, "BSc");
        tempReusaxCorp.registerDirector("4", "Test4", 100, "MSc", "HR");
        //Gross expenses: 400
        System.out.println("Total Gross Salaries: " + tempReusaxCorp.calculateTotalGrossSalaries());
        //Net expenses: 4797
        System.out.println("Total Net Salaries: " + tempReusaxCorp.calculateTotalNetSalaries());
        System.out.println();

        //Tests directors benefit
        System.out.println("TEST 10 - Directors benefit");
        reusaxCorp.updateDirectorsBenefit(10000);
        reusaxCorp.registerDirector("14","Per",60000,"MSc","Technology");
        System.out.println("ReusaxCorp pays a total of " + reusaxCorp.calculateTotalGrossSalaries() + " SEK in gross salaries");
        System.out.println("ReusaxCorp pays a total of " + reusaxCorp.calculateTotalNetSalaries() + " SEK in Net salaries");
        System.out.println();

        //Tests to promote to intern
        System.out.println("TEST 11 - Promote to Intern");
        reusaxCorp.registerManager("15", "PromoteToIntern", 10000, "MSc");
        Manager managerToPromote = (Manager) reusaxCorp.retrieveEmployee("15");
        System.out.println(managerToPromote.getName() + " gets manager net salary: " + managerToPromote.calculateNetSalary());
        System.out.println(managerToPromote);
        reusaxCorp.promoteToIntern("15", 5);
        Intern promotedManager = (Intern) reusaxCorp.retrieveEmployee("15");
        System.out.println(promotedManager + " gets intern net salary: " + promotedManager.calculateNetSalary());
        System.out.println(promotedManager);
        System.out.println();

        //Test promote to manager
        System.out.println("TEST 12 - Promote to Manager");
        reusaxCorp.registerIntern("16", "PromoteToManager", 10000, 5);
        Intern internToPromote = (Intern) reusaxCorp.retrieveEmployee("16");
        System.out.println(internToPromote.getName() + " gets intern net salary: " + internToPromote.calculateNetSalary());
        System.out.println(internToPromote);
        reusaxCorp.promoteToManager("16", "BSc");
        Manager promotedIntern = (Manager) reusaxCorp.retrieveEmployee("16");
        System.out.println(promotedIntern.getName() + " gets manager net salary: " + promotedIntern.calculateNetSalary());
        System.out.println(promotedIntern);
        System.out.println();

        //Test promote to employee
        System.out.println("TEST 13 - Promote to Employee");
        reusaxCorp.registerIntern("17", "PromoteToEmployee", 10000, 5);
        Intern anotherInternToPromote = (Intern) reusaxCorp.retrieveEmployee("17");
        System.out.println(anotherInternToPromote.getName() + " gets intern net salary: " + anotherInternToPromote.calculateNetSalary());
        System.out.println(anotherInternToPromote);
        reusaxCorp.promoteToEmployee("17");
        Employee promotedToEmployee = reusaxCorp.retrieveEmployee("17");
        System.out.println(promotedToEmployee.getName() + " gets employee net salary: " + promotedToEmployee.calculateNetSalary());
        System.out.println(promotedToEmployee);
        System.out.println();

        //Test promote to director
        System.out.println("TEST 14 - Promote to Director");
        reusaxCorp.registerEmployee("18", "PromoteToDirector", 10000);
        Employee employeeToPromote = reusaxCorp.retrieveEmployee("18");
        System.out.println(employeeToPromote.getName() + " gets employee net salary: " + employeeToPromote.calculateNetSalary());
        System.out.println(employeeToPromote);
        reusaxCorp.promoteToDirector("18", "BSc", "HR");
        Director promotedToDirector = (Director) reusaxCorp.retrieveEmployee("18");
        System.out.println(promotedToDirector.getName() + " gets director net salary: " + promotedToDirector.calculateNetSalary());
        System.out.println(promotedToDirector);
        System.out.println();

        //Remove intern, manager and director
        System.out.println("TEST 15 - Remove Intern/Manager/Director");
        reusaxCorp.removeEmployee("7");
        System.out.println(reusaxCorp.retrieveEmployee("7"));
        reusaxCorp.removeEmployee("10");
        System.out.println(reusaxCorp.retrieveEmployee("10"));
        reusaxCorp.removeEmployee("13");
        System.out.println(reusaxCorp.retrieveEmployee("13"));
        System.out.println();
    }
}
