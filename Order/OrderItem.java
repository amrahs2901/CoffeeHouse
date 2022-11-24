package Order;
import java.util.*;

public class OrderItem {
    private int productId;
    private String product;
    private Map<Integer, String> addOns = new HashMap<Integer, String>();
    private int quantity = 1;


    public OrderItem(int id, String productName, int addOnId,String addOnName, int quantity){
        productId = id;
        product = productName;
        addOns.put(addOnId, addOnName);
        this.quantity = quantity;
    }

    public void setAddOns (int addOnId,String addOnName){
        addOns.put(addOnId, addOnName);
    }

    public void setQuantity (int quantity){
        this.quantity = quantity;
    }

    public String getProductName () {
        return product;
    }

    public Map<Integer, String> getAddOns(){
        return addOns;
    }

    public int getQuantity () {
        return quantity;
    }

    public void displayOrder (int index, double price) {
        System.out.println();
        System.out.println(index+". "+product+"    "+price+"        "+"(quantity: "+quantity+")");
        System.out.print("Add Ons: ");
        for(Map.Entry<Integer, String> entry: addOns.entrySet()){
            System.out.print(entry.getValue()+ " ");
        }
        System.out.print("\n");
        System.out.println();
    }

}
