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

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String id) {
        this.id = id;
    }
}