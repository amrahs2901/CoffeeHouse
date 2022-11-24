package CoffeeHouse;
import java.util.*;

import Assets.Constants;
import Customer.Customer;
import Order.OrderItem;
import Price.Pricing;

public class CoffeeHouse {
    public static final Map<Integer, String> MAIN_MENU = new HashMap<Integer, String>();
    public static final Map<Integer, String> ADD_ONS = new HashMap<Integer, String>();
    public static final Pricing Cheque = new Pricing();

    // static block
    static {
        // initialising MAIN_MENU
        MAIN_MENU.put(1, Constants.ESPRESSO);
        MAIN_MENU.put(2, Constants.CAPPUCCINO);
        MAIN_MENU.put(3, Constants.LATTE);
        
        // initialising ADD_ONS
        ADD_ONS.put(1, Constants.MILK);
        ADD_ONS.put(2, Constants.CREAM);
        ADD_ONS.put(3, Constants.SYRUP);

        // initialising Cheque
        Cheque.addChequeItem(Constants.ESPRESSO, Constants.MILK, 60);
        Cheque.addChequeItem(Constants.ESPRESSO, Constants.CREAM, 75);
        Cheque.addChequeItem(Constants.ESPRESSO, Constants.SYRUP, 100);
        Cheque.addChequeItem(Constants.CAPPUCCINO, Constants.MILK, 80);
        Cheque.addChequeItem(Constants.CAPPUCCINO, Constants.CREAM, 90);
        Cheque.addChequeItem(Constants.CAPPUCCINO, Constants.SYRUP, 125);
        Cheque.addChequeItem(Constants.LATTE, Constants.MILK, 100);
        Cheque.addChequeItem(Constants.LATTE, Constants.CREAM, 125);
        Cheque.addChequeItem(Constants.LATTE, Constants.SYRUP, 150);
    }

    private List<Customer> customers = new ArrayList<Customer>();

    public void addCustomer (Customer customer) {
        customers.add(customer);
    }

    // public void addCustomerOrder (String email, int id, String productName, int addOnId,String addOnName){
    //     for(int i=0; i<customers.size(); i++){
    //         if(email.equals(customers.get(i).getEmail())){
    //             customers.get(i).addOrder(id, productName, addOnId, addOnName);
    //         }
    //     }
    // }

    // display MAIN_MENU
    public void showMainMenu () {
        System.out.println("Main Menu: ");
        for(Map.Entry<Integer, String> entry: MAIN_MENU.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    // display ADD_ONS
    public void showAddOns () {
        System.out.println("Add Ons: ");
        for(Map.Entry<Integer, String> entry: ADD_ONS.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public double getPriceByOrderItem (OrderItem order){
        double totalPrice = 0;

        for(Map.Entry<Integer, String> o: order.getAddOns().entrySet()){
            totalPrice += Cheque.getPrice(order.getProductName(), o.getValue());
        }

        return totalPrice*order.getQuantity();
    }
    public double getPriceByOrder (List<OrderItem> orders){
        double totalPrice = 0;

        for(int j=0; j<orders.size(); j++){
            totalPrice += getPriceByOrderItem(orders.get(j));
        }

        return totalPrice;
    }

    public void showBill(){
        System.out.println("--- BILLING ---\n");
        for(int i=0; i<customers.size(); i++){
            
            System.out.println("--- "+ customers.get(i).getEmail() +" ---");
            
            List<OrderItem> orders = customers.get(i).getOrders();
            for(int j=0; j<orders.size(); j++){
                orders.get(j).displayOrder(j+1, getPriceByOrderItem(orders.get(j)));
            }

            System.out.println("Total: "+ getPriceByOrder(orders));
            System.out.println("Bye! "+ customers.get(i).getName() +" ---");
            System.out.println("--- THANKS FOR VISITING ---\n");
        }


        System.out.println("--- EOB ---");
    }
}
