class MenuCustomizationItem{
    String name;
    float price;
    MenuCustomizationItem( String name, float price ){
        this.name = name;
        this.price = price;
    }

    public void setPrice( float price ){
        if ( price >= 0 ){
            this.price = price;
        }
    }
}