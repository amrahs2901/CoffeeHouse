package Price;

public class PriceItem {
    private String productName;
    private String addOns;
    private double price;
    
    PriceItem(String productName,String addOns,double price){
        this.productName = productName;
        this.addOns = addOns;
        this.price = price;
    }

    public double getPrice (){
        return price;
    }
    public String getProductName (){
        return productName;
    }
    public String getAddOns (){
        return addOns;
    }
}
