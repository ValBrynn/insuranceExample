/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import Controller.CustomerController;
import Controller.InsuranceController;
import model.CustomerModel;
import model.InsuranceModel;

/**
 *
 * @author Administrator
 */
public class view {

    /**
     * @param args the command line arguments
     */
    private final Scanner scan = new Scanner(System.in);
    private CustomerController cc = new CustomerController();
    private InsuranceController insuranceC = new InsuranceController();

    /**
     * Prints Menu
     */
    public void printMenu() {
        System.out.println("---Menu---");
        System.out.println("A To Add a Customer");
        System.out.println("R To Remove a Customer");
        System.out.println("I To get a Customer by a given SSN");
        System.out.println("G To get All Customers");
        System.out.println("U To update a Customer");
        System.out.println("M To Add Insurance for a customer");
        System.out.println("B To get Insurance");
        System.out.println("J To delete insurance");
        System.out.println("X Exit");
        System.out.println("----------");
    }

    public void run() throws ClassNotFoundException, IOException {
        char choice = ' ';
        //String answer;

        try {
            do {
                printMenu();
                choice = scan.next().charAt(0);

                switch (choice) {
                    case 'A':

                        System.out.println("Enter FirsName:  ");
                        String firstName = scan.next();
                        System.out.println("Enter LastName:  ");
                        String lastName = scan.next();
                        System.out.println("Enter SSN:  ");
                        long ssn = scan.nextLong();
                        CustomerModel customer = new CustomerModel(firstName, lastName, ssn);
                        cc.insertCustomer(customer);
                        break;
                    case 'R':
                        System.out.println("Enter SSN:  ");
                        cc.deleteCustomer(scan.nextInt());
                        break;

                    case 'I':
                        System.out.println("Enter SSN:  ");
                        System.out.println(cc.getCustomer(scan.nextInt()));
                        break;
                    case 'G':
                        System.out.println(cc.getAllCustomers());

                        break;
                    case 'U':
                        System.out.println("Enter FirsName:  ");
                        String fName = scan.next();
                        System.out.println("Enter LastName:  ");
                        String lName = scan.next();
                        System.out.println("Enter SSN:  ");
                        long ssn2 = scan.nextLong();
                        CustomerModel c = new CustomerModel(fName, lName, ssn2);
                        cc.updatetCustomer(c);
                        break;
                    case 'M':
                        System.out.println("Enter SSN:");
                        long ssnInsuranceInsert = scan.nextLong();
                        System.out.println("Enter cost:");
                        double cost = scan.nextDouble();
                        System.out.println("Enter Insurance type with Car,Home or Health:");
                        String insuranceType = scan.next();
                        InsuranceModel iM = new InsuranceModel(cost, insuranceType, 0);
                        insuranceC.insertInsurance(iM, ssnInsuranceInsert);
                        break;
                    case 'B':
                        System.out.println("Enter SSN:");
                        System.out.println(insuranceC.getInsurance(scan.nextLong()));
                        break;
                    case 'J':
                        System.out.println("Eneter SSN:");
                        long ssnDelete = scan.nextLong();
                        System.out.println("Enter insurance type:");
                        String insuranceTypeDelete = scan.next();
                        insuranceC.deleteInsurance(insuranceTypeDelete, ssnDelete);
                    case 'X':
                        System.out.println("Exiting..!");
                        break;
                    default:
                        System.out.println("Unknown command");
                }
            } while (choice != 'X');

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // TODO code application logic here
        view menu = new view();
        menu.run();
    }
}
