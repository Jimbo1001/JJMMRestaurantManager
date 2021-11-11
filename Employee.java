import java.util.ArrayList;
class Employee{
    String name;
    String id;
    boolean admin;

    Employee() {
        this.name = null;
        this.id = null;
        this.admin = false;
    }
    
    Employee( String name, String id, boolean admin ) {
        this.name = name;
        this.id = id;
        this.admin = admin;
    }

    public boolean getAdmin(){
        return admin;
    }
}