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
/* Returns a sorted array list of menuItems either in ascending or descending
	// order of the names
	public static ArrayList<MenuCustomizationItem> sortByName(ArrayList<MenuCustomizationItem> menuItems,
			String sortBy) {
		// using lambda expression to sort in ascending order
		if (sortBy.toLowerCase() == "descending") {
			Collections.sort(menuItems, (p1, p2) -> {
				return p2.name.compareTo(p1.name);
			});
		}
		// sorting in ascending order by default
		else {
			Collections.sort(menuItems, (p1, p2) -> {
				return p1.name.compareTo(p2.name);
			});
		}
		return menuItems;
	}

	// Returns a sorted array list of menuItems either in ascending or descending
	// order of the prices
	public static ArrayList<MenuCustomizationItem> sortByPrice(ArrayList<MenuCustomizationItem> menuItems,
			String sortBy) {
		// using lambda expression to sort in ascending order
		if (sortBy.toLowerCase() == "descending") {
			Collections.sort(menuItems, (p1, p2) -> Float.compare(p2.price, p1.price));
		}
		// sorting in ascending order by default
		else {
			Collections.sort(menuItems, (p1, p2) -> Float.compare(p1.price, p2.price));
		}
		return menuItems;
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
