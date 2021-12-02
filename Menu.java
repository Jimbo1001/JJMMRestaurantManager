import java.util.ArrayList;
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
    }
    
    /*public boolean addNewMenuItem(String name, float price){
        //TODO
    }*/

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
            /*if(menuItems.get(i).menuCustomizationItems != null) {
                for (int j = 0; j < menuItems.get(i).menuCustomizationItems.size(); j++) {
                    results += "*" + menuItems.get(i).menuCustomizationItems.get(j).name + "," + menuItems.get(i).menuCustomizationItems.get(j).price;
                }
            }*/
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
