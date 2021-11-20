/**
 * <pre>
 * File name: Table.java
 * Author: James Miller
 * Date: 10/11/2021
 * </pre>
 * Detailed description: 
 * This class is a Table object which has a boolean open
 * which is whether the table is occupied, and a tableActiveId
 * which matches the employee id that opened the table
 */
class Table{
    /**
     * The boolean that controls when table is open.
     * True if it is open and unoccupied.
     * False if it is closed and occupied.
     */
    boolean open;
    /**
     * String that represents the id of the employee 
     * with customers at the table. Null if the table 
     * is not open.
     */
    String tableActiveID;
    Receipt receipt;
    
    /** The ctor for a table */
    Table(){
        receipt = new Receipt();
        open = true;
        tableActiveID = "";
    }

    Table( boolean open, String tableActiveID ){
        this.open = open;
        this.tableActiveID = tableActiveID;
    }

    public void setID( String id ){
        tableActiveID = id;
    }
    public void setOpen( boolean o ){
        open = o;
    }
}