import java.util.ArrayList;

class Restaurant{

    //NAME
    String name;
    //EMPLOYEES
    ArrayList<Employee> employees = new ArrayList<Employee>();
    //TABLES
    ArrayList<Table> tables = new ArrayList<Table>();
    //MENU
    Menu menu = new Menu( "Menu" );
    //CURRENT Employee using system
    Employee activeEmployee = new Employee( null, null, false );
    //Is it the first time running the software
    boolean first;
    Restaurant(){ 
        first = true;
        employees.add( new Employee( "Admin", "1776", true ) );
        tables.add( new Table() );
        name = null;
    }
    
    //returns true if there is an employee with this id
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
}