import java.util.ArrayList;

class Menu {
    String name;
    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    
    Menu(String name) {
        this.name = name;
    }
    
    public String toString() {
        String results = "MENU NAME: " + name;
        results += " + ";
        for (int i = 0; i < this.menuItems.size(); i++) {
            results += " " + this.menuItems.get(i);
        }
        return results;
    }
}
