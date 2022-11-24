import java.util.Scanner;

import CoffeeHouse.*;
import Customer.Customer;

public class Street {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CoffeeHouse LaraCoffeeHouse = new CoffeeHouse();


        boolean isLastCustomer = false;
        
        while(!isLastCustomer){
            // customer
            System.out.print("Enter customer name: ");
            String customerName = sc.next();
            System.out.print("Enter customer email: ");
            String customerEmail = sc.next();

            Customer presentCustomer = new Customer(customerName, customerEmail);
            
            boolean isOrderConfirmed = false;

            while (!isOrderConfirmed) {
                // show menu
                LaraCoffeeHouse.showMainMenu();
                System.out.print("Select Product: ");
                int productId = sc.nextInt();

                // show addons
                LaraCoffeeHouse.showAddOns();
                System.out.print("Select Add-on: ");
                int addOnId = sc.nextInt();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                presentCustomer.addOrder(productId, LaraCoffeeHouse.MAIN_MENU.get(productId), addOnId, LaraCoffeeHouse.ADD_ONS.get(addOnId), quantity);

                System.out.print("Add more to the order (y/n): ");
                char orderIndicator = sc.next().charAt(0);

                if(orderIndicator == 'n'){
                    isOrderConfirmed = true;
                }else if(orderIndicator == 'y'){
                    isOrderConfirmed = false;
                }else{
                    isOrderConfirmed = true;
                }

            }

            System.out.print("More customer in line (y/n): ");
            char orderIndicator = sc.next().charAt(0);
            if(orderIndicator == 'n'){
                isLastCustomer = true;
            }else if(orderIndicator == 'y'){
                isLastCustomer = false;
            }else{
                isLastCustomer = true;
            }

            // add customer
            LaraCoffeeHouse.addCustomer(presentCustomer);
        }

        LaraCoffeeHouse.showBill();

    }
}
