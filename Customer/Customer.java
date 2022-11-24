package Customer;

import java.util.ArrayList;
import java.util.List;

import Order.OrderItem;

public class Customer {
    private String customerName = "";
    private String customerEmail = "";

    private List<OrderItem> orders = new ArrayList<OrderItem>();


    public Customer(String name, String email) {
        customerName = name;
        customerEmail = email;
    }

    public void addOrder (int id, String productName, int addOnId,String addOnName, int quantity){
        orders.add(new OrderItem(id, productName, addOnId, addOnName, quantity));
    }

    public String getName(){
        return customerName;
    }

    public String getEmail(){
        return customerEmail;
    }

    public List<OrderItem> getOrders() {
        return orders;
    }
}