import java.util.ArrayList;

class MenuItem {
    String name;
    float price;
    
    MenuItem(String name, float price ) {
        this.name = name;
        this.price = price;
    }
    
    public void setPrice(float price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    /*
    @Override
    public boolean equals( MenuItem o ){
        //TODO
    }*/
    
    /*public String toString() {
        String results = name;
        results += "+";
        for (int i = 0; i < this.menuCustomizationItems.size(); i++) {
            results += " " + this.menuCustomizationItems.get(i);
            if (i != this.menuCustomizationItems.size() - 1) {
                results += ",";
            }
        }
        return results;
    }*/
}
