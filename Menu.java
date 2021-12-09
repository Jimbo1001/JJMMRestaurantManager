import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException; 

class Menu {
    String name;
    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();   //list of item
    ArrayList<MenuItem> customItems = new ArrayList<MenuItem>(); //list of customization/extra items
    
    Menu(String name) {
        this.name = name;
        menuItems.add( new MenuItem( "Burger", 7.99f ) );
        menuItems.add( new MenuItem( "BLT", 5.99f ) );
        menuItems.add( new MenuItem( "Fries", 2.99f ) );
        menuItems.add( new MenuItem( "Cheese Fries", 3.99f ) );

        customItems.add( new MenuItem( "Extra Cheese", 0.99f ) );
        customItems.add( new MenuItem( "Bacon", 1.99f ) );
        customItems.add( new MenuItem( "Tomato", 0f ) );
        /*customItems = TextReader.ReadCustomItems( new Menu("s") );
        menuItems = TextReader.ReadMenuItems( new Menu("s") );*/
    }
    
    /*
    Alphabetically order sort 
    */
    // Returns a sorted array list of menuItems either in ascending or descending
	// order of the names
	public static ArrayList<MenuItem> sortByName(ArrayList<MenuItem> items,
			String sortBy) {
		// using lambda expression to sort in ascending order
		if (sortBy.toLowerCase() == "descending") {
			Collections.sort(items, (p1, p2) -> {
				return p2.name.compareTo(p1.name);
			});
		}
		// sorting in ascending order by default
		else {
			Collections.sort(items, (p1, p2) -> {
				return p1.name.compareTo(p2.name);
			});
		}
		return items;
	}

	// Returns a sorted array list of menuItems either in ascending or descending
	// order of the prices
	public static ArrayList<MenuItem> sortByPrice(ArrayList<MenuItem> menuItems,
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
    //--------------------END of sorting----------------------

    public int indexOfItem( MenuItem o, ArrayList<MenuItem> m ){
        for (int i = 0; i < m.size(); i++ ){
            if ( m.get(i).name.equals(o.name) ) {
                return i;
            }
        }
        return -1;
    }

    /*public String toString() {
        String results = "MENU NAME: " + name;
        results += " + ";
        for (int i = 0; i < this.menuItems.size(); i++) {
            results += " " + this.menuItems.get(i);
        }
        return results;
    }*/

    public String toString() {
        String results = "";
        for ( int i = 0; i < menuItems.size(); i++ ) {
            results += menuItems.get( i ).name + "," + menuItems.get( i ).price;
            results += "*";
        }
        results += "~";
        for ( int j = 0; j < customItems.size(); j++ ) {
            results += customItems.get(j).name + "," + customItems.get(j).price;
            results += "*";
        }
        results += "~";
        return results;
    }

    public boolean WriteToMenu(Menu menu) { //should run whenever something is added to the menu
        try {
            FileWriter myWriter = new FileWriter("Menu.txt");
            myWriter.write(menu.toString());
            myWriter.close();
            return true;
          } catch (IOException e) {
            e.printStackTrace();
            return false;
          }
    }
 }
