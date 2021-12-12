import java.util.ArrayList;
public class Receipt{
    ArrayList<MenuItem> itemList = new ArrayList<MenuItem>();
    float subTotal;
    float tax;
    float total;

    Receipt(){
        subTotal = 0;
        tax = 0;
        total = 0;
    }

    public float getSubTotal(){
        return calculateSubTotal();
    }

    public float calculateSubTotal(){
        subTotal = 0;
        if (itemList != null){
            for (int i = 0; i < itemList.size(); i++){
                subTotal += itemList.get(i).price;
            }
        }
        return subTotal;
    }
    
    public float calculateTax(){
        tax = subTotal * 0.07f;
        return tax;
    }

    public float getTax(){
        return calculateTax();
    }

    public float calculateTotal(){
        total = 0;
        calculateSubTotal();
        total += subTotal;
        calculateTax();
        total += tax;
        return total;
    }

    public float getTotal(){
        return calculateTotal();
    }
    
    /*
    public float getSplitTax( int n ) {
        float t = calculateTax();
        t = t/(float)n;
        return t;
    }

    /*
    public float getSplitSubTotal( int n ) {
        return 0f;
    }
    */

    
    /*
    public float getSplitTotal( int n ) {
        total = 0;
        calculateSubTotal();
        total += subTotal;
        calculateTax();
        total += tax;
        float splitTotal = 0;
        n = 0;
        if (total > 0) {
            for (int i = 0; i <= 100; i++) {
                n += i;
            }
            splitTotal = total/n;
        }
        return splitTotal;
    }
    */

}
