import java.util.ArrayList;

class Restaurant{

    //NAME
    String name;
    //EMPLOYEE IDS
    ArrayList<String> IDs = new ArrayList<String>();
    //ADMIN IDS
    ArrayList<String> adminIDs = new ArrayList<String>();
    //TABLES
    ArrayList<Table> tables = new ArrayList<Table>();
    //MENU
    ArrayList<Menu> menuList = new ArrayList<Menu>();
    //CURRENT USER's ID
    String activeID = "";
    //Is it the first time running the software
    boolean first;
    Restaurant(){ 
        first = true;
        adminIDs.add( "1776" );
        IDs.add( "1234" );
        tables.add( new Table() );
        name = null;
    }

    public boolean checkAdminID( String s ){
        System.out.println("input: " + s);
        for (int i = 0; i < adminIDs.size(); i++){
            if (adminIDs.get(i).equals(s)){
                RestaurantManager.admin = true; //make admin true
                return true;
            }
        }
        RestaurantManager.admin = false;       //make admin false
        return false;
    }

    public boolean checkID( String s ){
        System.out.println("input: " + s);
        for (int i = 0; i < IDs.size(); i++){
            if (IDs.get(i).equals(s)){
                return true;
            }
        }
        return false;
    }
}