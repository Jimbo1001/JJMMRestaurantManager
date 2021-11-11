import java.util.ArrayList;

class Menu {
    String name;
    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    
    Menu(String name) {
        this.name = name;
    }
    
    public String toString() {
        String s = "MENU NAME: " + name;
        String results = "+";
        for (int i = 0; i < this.menuItem.size; i++) {
            results += " " + this.menuItem.get(i);
        }
        return s;
        return results;
    }
}
