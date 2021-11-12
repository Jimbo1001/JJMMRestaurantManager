import java.util.ArrayList;

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
    
    /*public boolean addNewMenuItem(String name, float price){
        //TODO
    }*/

    public String toString() {
        String results = "MENU NAME: " + name;
        results += " + ";
        for (int i = 0; i < this.menuItems.size(); i++) {
            results += " " + this.menuItems.get(i);
        }
        return results;
    }
}
