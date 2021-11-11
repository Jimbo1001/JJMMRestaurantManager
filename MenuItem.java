import java.util.ArrayList;

class MenuItem {
    String name;
    float price;
    ArrayList<MenuCustomizationItem> menuCustomizationItems = new ArrayList<MenuCustomizationItem>();
    
    MenuItem(String name, float price, ArrayList<MenuCustomizationItem> menuCustomizationItems) {
        this.name = name;
        this.price = price;
        this.menuCustomizationItems = menuCustomizationItems;

    }

    public void setPrice(float price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setCustoms(MenuCustomizationItem item) {
        if (item != null) {
            this.menuCustomizationItems.add(item);
        }
    }
    
    public String toString() {
        String results = "+";
        for (int i = 0; i < this.menuCustomizationItems.size(); i++) {
            results += " " + this.menuCustomizationItems.get(i);
        }
        return results;
    }
}
