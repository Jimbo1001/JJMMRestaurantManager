import java.io.FileWriter;
import java.io.IOException; 
import java.util.ArrayList;

public class WriterTest {
    public static void main(String [] args) {
        MenuCustomizationItem cheese = new MenuCustomizationItem("cheese", 0.99f);
        MenuCustomizationItem tomato = new MenuCustomizationItem("tomato", 1.09f);

        ArrayList<MenuCustomizationItem> customs = new ArrayList<MenuCustomizationItem>();
        customs.add(cheese);
        customs.add(tomato);

        MenuItem burger = new MenuItem("burger", 5.99f, customs);
        MenuItem sandwich = new MenuItem("sandwich", 6.99f);

        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(burger);
        menuItems.add(sandwich);

        String name = "MenuTest";
        
        try {
            FileWriter myWriter = new FileWriter("C:/Users/jpsch/JJMMRestaurantManager/JJMMRestaurantManager/Menu.txt");
            myWriter.write(toString(name, menuItems));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          
    }

    public static String toString(String name, ArrayList<MenuItem> menuItems) {
        String results = "MENU NAME*" + name + "~";
        for (int i = 0; i < menuItems.size(); i++) {
            results += menuItems.get(i).name + "," + menuItems.get(i).price;
            if(menuItems.get(i).menuCustomizationItems != null) {
                for (int j = 0; j < menuItems.get(i).menuCustomizationItems.size(); j++) {
                    results += "*" + menuItems.get(i).menuCustomizationItems.get(j).name + "," + menuItems.get(i).menuCustomizationItems.get(j).price;
                }
            }
            results += "~";
        }
        return results;
    }
}
/*class MenuItem {
    String name;
    float price;
    ArrayList<MenuCustomizationItem> menuCustomizationItems = new ArrayList<MenuCustomizationItem>();


    MenuItem(String name, float price, ArrayList<MenuCustomizationItem> menuCustomizationItems) {
        this.name = name;
        this.price = price;
        this.menuCustomizationItems = menuCustomizationItems;

    }
    MenuItem(String name, float price ) {
        this.name = name;
        this.price = price;
    }
}

class Menu {
    String name;
    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    
    Menu(String name) {
        this.name = name;
        menuItems.add( new MenuItem( "Burger", 7.99f ) );
        menuItems.add( new MenuItem( "BLT", 5.99f ) );
        menuItems.add( new MenuItem( "Fries", 2.99f ) );
        menuItems.add( new MenuItem( "Cheese Fries", 3.99f ) );
    }
}
class MenuCustomizationItem {
    String name;
    float price;
    
    MenuCustomizationItem(String name, float price) {
        this.name = name;
        this.price = price;
    }
}*/
