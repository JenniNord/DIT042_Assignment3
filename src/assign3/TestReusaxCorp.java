package assign3;

import java.util.ArrayList;

public class TestReusaxCorp {

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

        //Test registering manager
        System.out.println("TEST 6");
        reusaxCorp.registerManager("8", "Stephen", 50000, "BSc");
        reusaxCorp.registerManager("9", "Steven", 50000, "MSc");
        reusaxCorp.registerManager("10", "Steve", 50000, "phD");
        System.out.println();

        //Test registering director
        System.out.println("TEST 7");
        reusaxCorp.registerDirector("11", "Stefan", 20000, "BSc", "HR");
        reusaxCorp.registerDirector("12", "Stephan", 27000, "MSc", "HR");
        reusaxCorp.registerDirector("13", "Steph", 62000, "phD", "HR");
        System.out.println();

        //Retrieve intern, manager and director

        //Remove intern, manager and director

        //Update name/salary for intern, manager and director
        
        //Tests directors benefit
        System.out.println("TEST 8");
        reusaxCorp.updateDirectorsBenefit(10000);
        reusaxCorp.registerDirector("14","Per",60000,"MSc","Technology");
        System.out.println("ReusaxCorp pays a total of " + reusaxCorp.calculateTotalGrossSalaries() + " SEK in gross salaries");
        System.out.println("ReusaxCorp pays a total of " + reusaxCorp.calculateTotalNetSalaries() + " SEK in Net salaries");
        System.out.println();

        //Tests calculateGrossSalary and calculateNetSalary

        //Tests to promote to intern
        System.out.println("TEST 9");
        reusaxCorp.registerManager("15", "TestManager", 10000, "MSc");
        Manager test = (Manager) reusaxCorp.retrieveEmployee("15");
        System.out.println("Manager net salary: " + test.calculateNetSalary());
        System.out.println(test);

        reusaxCorp.promoteToIntern("15", 5);
        Intern test2 = (Intern) reusaxCorp.retrieveEmployee("15");
        System.out.println("Intern net salary: " + test2.calculateNetSalary());
        System.out.println(test2);

    }
}
