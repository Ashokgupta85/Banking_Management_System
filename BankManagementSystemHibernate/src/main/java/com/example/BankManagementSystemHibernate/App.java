package com.example.BankManagementSystemHibernate;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.example.AllOperation.AccountantOperation;
import com.example.AllOperation.CustomerOperation;
import com.example.entities.Accountant;
import com.example.exception.AccountantException;
import com.example.serviceImp.AccountantServiceImpl;
import com.example.services.AccountantService;


public class App {
	
    public static void main(String[] args) {
    	
    	/*---Initializing a Scanner object for user input----*/
        Scanner sc = new Scanner(System.in);
        
        /*---Initializing a boolean variable f with value true, used as a flag for looping--*/
        boolean f = true; 
       
        while (f) {
        	
        	// Displaying the main menu
        	System.out.println("-----------------------------------------------------------------");
        	System.out.println();
            System.out.println("----------------WELCOME TO ONLINE BANKING SYSTEM-----------------");
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            System.out.println();
            System.out.println("  1.  ACCOUNTANT REGISTRATION PORTAL\r\n"+"  2.  ACCOUNTANT LOGIN PORTAL \r\n" + "  3.  CUSTOMER LOGIN PORTAL\r\n");
            
          try {
        	  System.out.println("-----------------------------------------------------------------");
        	  System.out.print("  Choose Your Option : ");
        	  int choice = sc.nextInt();
        	  System.out.println();
        	  
                
                switch (choice) {
                    case 1:
                    	// Create an instance of AccountantDao
                        AccountantService accountantDao = new AccountantServiceImpl();
                    
						System.out.print("  Enter the Accountant FirstName  : ");
						String customerFirstName = sc.next();
						System.out.print("  Enter the Accountant LastName  : ");
						String customerLastName = sc.next();
						System.out.print("  Enter the Accountant Mail  : ");
						String customerMail = sc.next();
						System.out.print("  Enter the Password : ");
						String password = sc.next();
						
                        // Create an instance of Accountant with sample data
                        Accountant accountant = new Accountant(customerFirstName, customerLastName, customerMail, password);

                        try {
                            // Register the accountant
                            accountantDao.registerAccountant(accountant);
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.println("  Accountant registered successfully.");
                           
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                        } catch (AccountantException e) {
                        	System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.println("  Error registering accountant: " + e.getMessage());
                        }
                        break;
                    
                    case 2:
                        // Creating an instance of AccountantOperation and invoking the accountantOperation method
                        AccountantOperation acc_opera = new AccountantOperation();
                        acc_opera.accountantOperation();
                        break;

                    case 3:
                        // Creating an instance of CustomerOperation and invoking the customerOperation method
                        CustomerOperation co = new CustomerOperation();
                        co.customerOperation();
                        break;

                    default:
                        System.out.println("This Option is Not Exist...Please Choose Correct Option !!");
                }
                
                
            } catch (InputMismatchException e) {
                // Handling any unexpected exceptions and printing the error message
                System.out.println("Error Occurred: Invalid input! Please enter a valid integer.");
                // Consume the invalid input to avoid an infinite loop
                sc.next();
            }
          
         } 
        sc.close();
    }
}
