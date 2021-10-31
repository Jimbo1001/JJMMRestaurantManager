class Table{

    boolean open;
    String tableActiveID;
    
    Table(){
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