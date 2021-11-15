/**
 * <pre>
 * File name: Employee.java
 * Author: James Miller
 * Date: 11/11/2021
 * </pre>
 * Detailed description: 
 * This class is an Employee object which has a name,
 * id, and a admin boolean whether it has admin access
 */

import java.util.ArrayList;
class Employee {
    String name;
    String id;
    boolean admin;

    Employee() {
        this.name = null;
        this.id = null;
        this.admin = false;
    }
    
    Employee(String name, String id, boolean admin) {
        this.name = name;
        this.id = id;
        this.admin = admin;
    }
    
    public boolean getAdmin() {
        return admin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String toString() {
        String s = "";
        s += name + " ";
        s += id + " ";
        s += admin + " ";
        return s;
    }
    
    public boolean equals(Employee other) {
        if ((this.name.equals(other.name)) && (this.id.equals(other.id))) {
            return true;
        } else {
            return false;
        }
    }
}
