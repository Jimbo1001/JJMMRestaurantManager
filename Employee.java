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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Employee {
    String name;
    String id;
    boolean admin;
    long timeWorked; //tracks the amount of time a worker has
    private long  startTime;

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

    public boolean WritetoLogin(Employee employee) {
        try {
            FileReader fr = new FileReader("Login.txt");
            BufferedReader br = new BufferedReader(fr);
            String content = "";
            if (br.ready()) {
                content = br.readLine();
            }
            FileWriter myWriter = new FileWriter("Login.txt");
            myWriter.write(content + employee.id + "*");
            myWriter.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
