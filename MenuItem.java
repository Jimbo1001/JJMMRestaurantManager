import java.util.ArrayList;

class MenuItem {
    String name;
    float price;
    ArrayList<MenuCustomizationItem> menuCustomizationItems = new ArrayList<MenuCustomizationItem>();
    
    MenuItem(String name, float price ) {
        this.name = name;
        this.price = price;
    }

    MenuItem(String name, float price, ArrayList<MenuCustomizationItem> menuCustomizationItems) {
        this.name = name;
        this.price = price;
        this.menuCustomizationItems = menuCustomizationItems;

    }
    /*public float getPrice(){
        //TODO
    }*/
    public void setPrice(float price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    /*public boolean addCustomItem(MenuCustomizationItem item) {
        //TODO
    }*/
    /*
    @Override
    public boolean equals( MenuItem o ){
        //TODO
    }*/
    
    public String toString() {
        String results = "MENU NAME: " + name;
        results += "+";
        for (int i = 0; i < this.menuCustomizationItems.size(); i++) {
            results += " " + this.menuCustomizationItems.get(i);
            if (i != this.menuCustomizationItems.size() - 1) {
                results += ",";
            }
        }
        return results;
    }
}
