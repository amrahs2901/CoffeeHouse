package Price;
import java.util.ArrayList;
import java.util.List;

public class Pricing {
    private List<PriceItem> cheque = new ArrayList<PriceItem>();

    public void addChequeItem (String productName,String addOns,double price) { 
        cheque.add(new PriceItem(productName, addOns, price));
    }

    public double getPrice (String productName, String addOns){
        double price = 0;

        for(PriceItem item: cheque){
            if(productName.equals(item.getProductName()) && addOns.equals(item.getAddOns())){
                price = item.getPrice();
                break;
            }
        }

        return price;

    }

}
