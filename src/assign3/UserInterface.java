package assign3;

import java.util.Scanner;

public class UserInterface {

    private static final int REGISTER_EMPLOYEE = 1;
    private static final int REMOVE_EMPLOYEE = 2;
    private static final int RETRIEVE_EMPLOYEE = 3;
    private static final int UPDATE_EMPLOYEE = 4;
    private static final int SHOW_GROSS_SALARIES = 5;
    private static final int SHOW_NET_SALARIES = 6;
    private static final int TOTAL_EMPLOYEES = 7;
    private static final int QUIT = 8;

    private Scanner input;


    public void run() {

        int option;
        do {
            printMenuOptions();
            System.out.print(" Type the option number: ");
            option = input.nextInt();
            input.nextLine(); // this skips the enter
            // that the user types after
            // typing the integer option.

            switch (option) {
                case REGISTER_EMPLOYEE:


                    break;

                case REMOVE_EMPLOYEE:

                    break;

                case RETRIEVE_EMPLOYEE:

                    break;

                case UPDATE_EMPLOYEE:

                    break;

                case SHOW_GROSS_SALARIES:

                    break;

                case SHOW_NET_SALARIES:

                    break;

                case TOTAL_EMPLOYEES:

                    break;

                case QUIT:
                    System.out.println("Thank you for utilising Reusaxology.");
                    System.out.println();
                    break;

                default:
                    System.out.println("Option " + option + " is not valid.");
                    System.out.println();
                    break;
            }
        } while (option != QUIT);
    }


    private void printMenuOptions() {
        System.out.println(" === Welcome to Reusaxology === ");
        System.out.println(" Choose an option below: ");
        System.out.println(" ");
        System.out.println(" 1. Register an employee. ");
        System.out.println(" 2. Remove an employee from the system. ");
        System.out.println(" 3. Retrieve an employee's data. ");
        System.out.println(" 4. Update an employee's data. ");
        System.out.println(" 5. Show the total gross salary for all employees ");
        System.out.println(" 6. Show the net salary for all employees");
        System.out.println(" 7. Show the total number of employees ");
        System.out.println(" 8. Quit this program. ");
        System.out.println();
    }


    public void Main() {

        this.input = new Scanner(System.in);

    }

    public static void main(String[] args) {
        UserInterface program = new UserInterface();
        program.run();

    }

}
