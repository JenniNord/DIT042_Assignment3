package assign3;

import java.util.ArrayList;

public class TestReusaxCorp {

    /**
     * This isn't in any way a "proper" test class but it tests the basic functionality of Assignment 3.
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
        reusaxCorp.registerManager("10", "Steve", 10000, "phD");

        System.out.println(reusaxCorp.retrieveEmployee("8"));
        System.out.println(reusaxCorp.retrieveEmployee("9"));
        System.out.println(reusaxCorp.retrieveEmployee("10"));
        System.out.println();

        //Test registering & retrieving director
        System.out.println("TEST 7 - Director CR");
        reusaxCorp.registerDirector("11", "Stefan", 20000, "BSc", "HR");
        reusaxCorp.registerDirector("12", "Stephan", 27000, "MSc", "HR");
        reusaxCorp.registerDirector("13", "Steph", 62000, "phD", "HR");

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




        //Test total expenses gross/net


        //Tests directors benefit
        //System.out.println("TEST 8");
        //reusaxCorp.updateDirectorsBenefit(10000);
        //reusaxCorp.registerDirector("14","Per",60000,"MSc","Technology");
        //System.out.println("ReusaxCorp pays a total of " + reusaxCorp.calculateTotalGrossSalaries() + " SEK in gross salaries");
        //System.out.println("ReusaxCorp pays a total of " + reusaxCorp.calculateTotalNetSalaries() + " SEK in Net salaries");
        //System.out.println();

        //Tests to promote to intern
        //System.out.println("TEST 9");
        //reusaxCorp.registerManager("15", "TestManager", 10000, "MSc");
        //Manager test = (Manager) reusaxCorp.retrieveEmployee("15");
        //System.out.println("Manager net salary: " + test.calculateNetSalary());
        //System.out.println(test);

        //reusaxCorp.promoteToIntern("15", 5);
        //Intern test2 = (Intern) reusaxCorp.retrieveEmployee("15");
        //System.out.println("Intern net salary: " + test2.calculateNetSalary());
        //System.out.println(test2);
        //System.out.println();

        //Test promote to manager

        //Test promote to employee

        //Test promote to director

        //Remove intern, manager and director
        /*System.out.println("TEST 8 - Remove Intern/Manager/Director");
        reusaxCorp.removeEmployee("7");
        System.out.println(reusaxCorp.retrieveEmployee("7"));
        reusaxCorp.removeEmployee("10");
        System.out.println(reusaxCorp.retrieveEmployee("10"));
        reusaxCorp.removeEmployee("13");
        System.out.println(reusaxCorp.retrieveEmployee("13"));
        System.out.println();*/


    }
}
