import java.util.ArrayList;

class MenuItem{
    String name;
    float price;
    ArrayList<MenuCustomizationItem> menuCustomizationItems = new ArrayList<MenuCustomizationItem>();
    
    MenuItem( String name, float price ){
        this.name = name;
        this.price = price;
    }

    public void setPrice( float price ){
        if ( price >= 0 ){
            this.price = price;
        }
    }
}