/**
 * <pre>
 * File name: Restaurant.java
 * Author: James Miller
 * Date: 10/9/2021
 * </pre>
 * Detailed description: 
 * This class is a restaurant object which has a name,
 * employees, tables, and a menu
 */
import java.util.ArrayList;
class Restaurant{

    /**
     * The name of the restuarant. Can't be null or longer than 35 characters.
     */
    String name;
    /**
     * The employees list of the restaurant. Can't be empty or greater than 20.
     */
    ArrayList<Employee> employees = new ArrayList<Employee>();
    /**
     * The tables list of the restaurant. Can't be empty or greater than 50.
     */
    ArrayList<Table> tables = new ArrayList<Table>();
    /**
     * The menu the restaurant offers.
     */
    Menu menu = new Menu( "Menu" );

    //CURRENT Employee using system
    Employee activeEmployee = new Employee( null, null, false );

    /** The ctor for a new default Restaurant*/
    Restaurant(){ 
        name = "Restaurant";
        employees.add( new Employee( "Employee 00", "", true ) );
        employees.add( new Employee( "Employee 01", "01", true ) );
        employees.add( new Employee( "Employee 02", "02", true ) );
        employees.add( new Employee( "Employee 03", "03", true ) );
        employees.add( new Employee( "Employee 04", "04", true ) );
        employees.add( new Employee( "Employee 05", "05", true ) );
        employees.add( new Employee( "Employee 06", "06", true ) );
        employees.add( new Employee( "Employee 07", "07", true ) );
        employees.add( new Employee( "Employee 08", "08", true ) );
        employees.add( new Employee( "Employee 09", "09", true ) );
        employees.add( new Employee( "Employee 10", "10", true ) );
        employees.add( new Employee( "Employee 11", "11", true ) );
        employees.add( new Employee( "Employee 12", "12", true ) );
        employees.add( new Employee( "Employee 13", "13", true ) );
        employees.add( new Employee( "Employee 14", "14", true ) );
        employees.add( new Employee( "Employee 15", "15", true ) );
        employees.add( new Employee( "Employee 16", "16", true ) );
        employees.add( new Employee( "Employee 17", "17", true ) );
        employees.add( new Employee( "Employee 18", "18", true ) );
        employees.add( new Employee( "Employee 19", "19", true ) );
        employees.add( new Employee( "Employee 20", "20", true ) );
        employees.add( new Employee( "Employee 21", "21", true ) );
        employees.add( new Employee( "Employee 22", "22", true ) );
        for (int i = 0; i < 10; i++){ //Add ten tables
           tables.add( new Table() );
        }
    }
    public Menu getMenu(){
        return menu;
    }
    /**
     * This method checks if the parameter id matches
     * an existing id from the employee list
     * @param e is the employee that is being searched for
     */
     public boolean checkId( String id ){
        for (int i = 0; i < employees.size(); i++){
            if ( employees.get(i).id.equals( id ) ){
                return true;
            }
        }
        return false;
    }
    public boolean checkEmployee( Employee e ){
        for (int i = 0; i < employees.size(); i++){
            if ( employees.get(i).equals( e ) ){
                return true;
            }
        }
        return false;
    }
    //returns the employee with the input id
    //null if no employee with the input id
    public Employee getEmployeeById( String id ){
        for (int i = 0; i < employees.size(); i++){
            if ( employees.get(i).equals( id ) ){
                return employees.get(i);
            }
        }
        return null;
    }

    public void setActiveEmployeeById( Employee ae ){
        activeEmployee = ae;
    }

    public String toString(){
        String str = name + "\n";
        for (int i = 0; i < employees.size(); i++){
            str += employees.get(i) + "\n";
        }
        for (int i = 0; i < tables.size(); i++){
            str += tables.get(i) + "\n";
        }
        str += menu;
        return str;
    }
}