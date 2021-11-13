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
        employees.add( new Employee( "Admin", "", true ) );
        employees.add( new Employee( "ID:1776", "1776", true ) );
        tables.add( new Table() );
    }
    
    /**
     * This method checks if the parameter id matches
     * an existing id from the employee list
     * @param id is the id that is being searched for
     */
    public boolean checkId( String id ){
        for (int i = 0; i < employees.size(); i++){
            if ( employees.get(i).id.equals( id ) ){
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