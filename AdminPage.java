import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class AdminPage{
    JPanel panel = new JPanel();
    GridBagConstraints c = new GridBagConstraints();
    GridBagLayout grid = new GridBagLayout();
    
    JPanel optionPanel = new JPanel();
    //Always Visible
    JPanel buttonPanel = new JPanel();
        JButton employeeBtn              = new JButton( "Employees" );
        JButton menuBtn                  = new JButton( "Menu" );
        JButton menuItemBtn              = new JButton( "Items" );
        JButton menuCustomizationItemBtn = new JButton( "Extras" );
        JButton exitBtn                  = new JButton( "Exit" );
        public void drawButtonPanel( Dimension panelSize, Dimension buttonSize ){
            buttonPanel.removeAll();
            buttonPanel.repaint();
            buttonPanel.revalidate();
            //Button Panel
            buttonPanel.setLayout( grid );
            buttonPanel.setPreferredSize( panelSize );

            employeeBtn = new JButton("Employees");
            employeeBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        addNewEmployeePanel.setVisible( true );//pair 1-1/2
                        employeePane.setVisible( true );//pair 1-2/2

                        newMenuItemPanel.setVisible( false );//pair 2-1/2
                        menuPane.setVisible( false );//pair 2-2/2

                        newMenuItemCustomPanel.setVisible(false);//pair 3-1/2
                        menuCustomPane.setVisible(false);//pair 3-2/2
                    }
                }
            );
            employeeBtn.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 0;
            buttonPanel.add( employeeBtn, c );
            
            menuBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        addNewEmployeePanel.setVisible(false);//pair 1-1/2
                        employeePane.setVisible(false);//pair 1-2/2

                        newMenuItemPanel.setVisible(true);//pair 2-1/2
                        menuPane.setVisible( true );//pair 2-2/2

                        newMenuItemCustomPanel.setVisible(false);//pair 3-1/2
                        menuCustomPane.setVisible(false);//pair 3-2/2
                    }
                }
            );
            menuBtn.setPreferredSize( buttonSize );
            c.gridx = 1;
            c.gridy = 0;
            buttonPanel.add( menuBtn, c );
            
            //JButton for making extras pane visible
            menuItemBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        addNewEmployeePanel.setVisible(false);//pair 1-1/2
                        employeePane.setVisible(false);//pair 1-2/2

                        newMenuItemPanel.setVisible(false);//pair 2-1/2
                        menuPane.setVisible(false);//pair 2-2/2

                        newMenuItemCustomPanel.setVisible(true);//pair 3-1/2
                        menuCustomPane.setVisible(true);//pair 3-2/2
                    }
                }
            );
            menuItemBtn.setPreferredSize( buttonSize );
            c.gridx = 2;
            c.gridy = 0;
            buttonPanel.add( menuItemBtn, c );

            //JButton for exiting to home page
            exitBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        RestaurantManager.exitToHome( panel );
                    }
                }
            );
            exitBtn.setPreferredSize( buttonSize );
            c.gridx = 5;
            c.gridy = 0;
            buttonPanel.add( exitBtn, c );
            //End Button Panel
        }
    //Visible with employeePanel - Pair 1-1/2
    JPanel addNewEmployeePanel = new JPanel();
        JLabel addNewEmployeeNameLabel     = new JLabel( "Enter new employee name:", SwingConstants.LEFT );
        JTextField addNewEmployeeNameField = new JTextField("");
        JLabel addNewEmployeeIdLabel       = new JLabel( "Enter new employee ID:", SwingConstants.LEFT  );
        JTextField addNewEmployeeIDField   = new JTextField("");
        JLabel isAdminLabel                = new JLabel( "Admin:", SwingConstants.LEFT  );
        JCheckBox isAdmin                  = new JCheckBox();
        JButton enterNewEmployeeBtn;//        = new JButton( "Add New" );
        private void drawAddNewEmployeePanel( Dimension panelSize, Dimension labelSize, Dimension buttonSize ){
            addNewEmployeePanel.removeAll();
            addNewEmployeePanel.repaint();
            addNewEmployeePanel.revalidate();
            addNewEmployeePanel.setBackground(Color.red);
            //Add New Employee Panel
            addNewEmployeePanel.setLayout( grid );
            addNewEmployeePanel.setPreferredSize( panelSize );
            
            addNewEmployeeNameLabel.setPreferredSize(labelSize);
            c.gridx = 0;
            c.gridy = 0;
            addNewEmployeePanel.add( addNewEmployeeNameLabel, c );

            addNewEmployeeNameField.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = 1;
            addNewEmployeePanel.add( addNewEmployeeNameField, c );

            addNewEmployeeIdLabel.setPreferredSize(labelSize);
            c.gridx = 0;
            c.gridy = 2;
            addNewEmployeePanel.add( addNewEmployeeIdLabel, c );
            
            addNewEmployeeIDField.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = 3;
            addNewEmployeePanel.add( addNewEmployeeIDField, c );
            
            isAdminLabel.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = 4;
            addNewEmployeePanel.add( isAdminLabel, c );
            
            c.gridx = 0;
            c.gridy = 5;
            addNewEmployeePanel.add( isAdmin, c );

            enterNewEmployeeBtn = new JButton("add");
            enterNewEmployeeBtn.setPreferredSize( buttonSize );
            enterNewEmployeeBtn.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String name = (String)addNewEmployeeNameField.getText();
                        String id = (String)addNewEmployeeIDField.getText();
                        boolean admin = isAdmin.isSelected();
                        Employee newEmp = new Employee(name, id, admin);
                        if ( !RestaurantManager.restaurant.checkEmployee( newEmp ) ){
                            RestaurantManager.getRestaurant().employees.add( newEmp );
                        }
                        addNewEmployeeNameField.setText(""); // clear text
                        addNewEmployeeIDField.setText(""); // clear text
                        isAdmin.setSelected(false);
                        drawAdminPage( );
                    }
                }
            );
            c.gridx = 0;
            c.gridy = 6;
            addNewEmployeePanel.add( enterNewEmployeeBtn, c );
            //End Add New Employee Panel

            c.gridx = 0;
            c.gridy = 0;
            optionPanel.add( addNewEmployeePanel, c );
        }
    //Visible with addNewEmployeePanel - Pair 1-2/2
    JScrollPane employeePane = new JScrollPane();//JPanel();
    JPanel displayPanel = new JPanel();
    //ScrollPanelLayout sgrid = new ScrollPaneLayout();
        public void drawEmployeePanel( Dimension panelSize ){
            displayPanel.removeAll();
            displayPanel.repaint();
            displayPanel.revalidate();
            //employeePanel
            employeePane.setLayout( new ScrollPaneLayout() );
            employeePane.setPreferredSize( panelSize );
            displayPanel.setLayout(grid);
            for (int i = 0; i < RestaurantManager.restaurant.employees.size(); i++){
                JButton empBtn = new JButton( RestaurantManager.restaurant.employees.get(i).name ); 
                final int ii = i;
                empBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        /*String name  = RestaurantManager.restaurant.employees.get(ii).name;
                        String price = 
                        addNewEmployeeNameField.setText(""); // clear text
                        addNewEmployeeIDField.setText(""); // clear text*/
                    }
                });
                c.gridx = 0;
                c.gridy = i;
                displayPanel.add(empBtn, c);
            }
            employeePane.getViewport().add( displayPanel, null );
            //end employeePane
            c.gridx = 1;
            c.gridy = 0;
            optionPanel.add( employeePane, c );
        }
    //Visible with menu panel - Pair 2-1/2
    JPanel newMenuItemPanel = new JPanel();
        JLabel addNewMenuItemNameLabel     = new JLabel( "Enter new menu item name:" );
        JTextField addNewMenuItemNameField = new JTextField("");
        JLabel addNewMenuItemPriceLabel    = new JLabel( "Enter new menu item price:" );
        JTextField addMenuItemPriceField   = new JTextField("");
        JButton enterNewMenuItemBtn;//        = new JButton( "Add New" );
        private void drawNewMenuItemPanel( Dimension panelSize, Dimension labelSize, Dimension buttonSize ){
            newMenuItemPanel.removeAll();
            newMenuItemPanel.repaint();
            newMenuItemPanel.revalidate();
            //new menu item panel
            newMenuItemPanel.setLayout( grid );
            newMenuItemPanel.setPreferredSize( panelSize );
        
            addNewMenuItemNameLabel.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = 0;
            newMenuItemPanel.add( addNewMenuItemNameLabel, c );

            addNewMenuItemNameField.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = 1;
            newMenuItemPanel.add( addNewMenuItemNameField, c );

            addNewMenuItemPriceLabel.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = 2;
            newMenuItemPanel.add( addNewMenuItemPriceLabel, c );

            addMenuItemPriceField.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = 3;
            newMenuItemPanel.add( addMenuItemPriceField, c );

            enterNewMenuItemBtn = new JButton("Add New Menu Item");
            enterNewMenuItemBtn.setPreferredSize( buttonSize );
            enterNewMenuItemBtn.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if ( isNumeric( addMenuItemPriceField.getText() ) && !addNewMenuItemNameField.getText().equals("") ) {
                            String name = addNewMenuItemNameField.getText();
                            float price = Float.parseFloat( addMenuItemPriceField.getText() );
                            MenuItem m = new MenuItem( name, price );
                            int i = RestaurantManager.restaurant.menu.indexOfItem( m, RestaurantManager.restaurant.menu.menuItems );
                            if ( i == -1 ) {
                                RestaurantManager.restaurant.menu.menuItems.add( m );
                            } else {
                                RestaurantManager.restaurant.menu.menuItems.remove(i);
                                RestaurantManager.restaurant.menu.menuItems.add( m );
                            }
                            drawAdminPage();
                        }
                        addNewMenuItemNameField.setText("");
                        addMenuItemPriceField.setText("");
                    }
                }
            );
            c.gridx = 0;
            c.gridy = 4;
            newMenuItemPanel.add( enterNewMenuItemBtn, c );
            
            //add the panel to the option panel
            c.gridx = 0;
            c.gridy = 0;
            optionPanel.add( newMenuItemPanel, c );
        }
        //code from https://www.baeldung.com/java-check-string-number
        public static boolean isNumeric(String strNum) {
            if (strNum == null) {
                return false;
            }
            try {
                double d = Double.parseDouble(strNum);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }
        //end code from https://www.baeldung.com/java-check-string-number

         //Visible with new menu item panel- Pair 2-2/2
    JScrollPane menuPane = new JScrollPane();
    JPanel menuPanel = new JPanel();
        //Draw the menu panel
        private void drawMenuPanel( Dimension panelSize ){
            menuPanel.removeAll();
            menuPanel.repaint();
            menuPanel.revalidate();
            
            menuPane.setLayout( new ScrollPaneLayout() );
            
            menuPanel.setLayout(grid);
            menuPane.setPreferredSize( panelSize );
            for (int i = 0; i < RestaurantManager.getMenu().menuItems.size(); i++ ){
                //JButton itemBtn = new JButton( RestaurantManager.getMenu().menuItems.get(i).name );
                JButton itemBtn = new JButton( RestaurantManager.getMenu().menuItems.get(i).name 
                                        + " " +  RestaurantManager.floatToString( RestaurantManager.getMenu().menuItems.get(i).price, false) );
                final int ii = i;
                itemBtn.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String name = RestaurantManager.getMenu().menuItems.get(ii).name;
                        String price = RestaurantManager.getMenu().menuItems.get(ii).price + "";
                        addNewMenuItemNameField.setText(name);
                        addMenuItemPriceField.setText(price);
                    }
                }
                );
                c.gridx = 0;
                c.gridy = i;
                menuPanel.add( itemBtn, c );
            }

            menuPane.getViewport().add( menuPanel, null );
            c.gridx = 1;
            c.gridy = 0;
            optionPanel.add( menuPane, c );
        }
    //Visible with menu custom panel
    JPanel newMenuItemCustomPanel = new JPanel();
        JLabel addNewMenuItemCustomNameLabel     = new JLabel( "Enter new custom item name:" );
        JTextField addNewMenuItemCustomNameField = new JTextField("");
        JLabel addNewMenuItemCustomPriceLabel    = new JLabel( "Enter new custom item price:" );
        JTextField addMenuItemCustomPriceField   = new JTextField("");
        JButton enterNewMenuCustomBtn            = new JButton( "Add New" );
        private void drawNewMenuCustomItemPanel(Dimension panelSize, Dimension labelSize, Dimension buttonSize){
            newMenuItemCustomPanel.setLayout( grid );
            newMenuItemCustomPanel.setPreferredSize( panelSize );

            addNewMenuItemCustomNameLabel.setPreferredSize(labelSize);
            c.gridx = 0;
            c.gridy = 0;
            newMenuItemCustomPanel.add(addNewMenuItemCustomNameLabel, c);

            addNewMenuItemCustomNameField.setPreferredSize(labelSize);
            c.gridx = 0;
            c.gridy = 1;
            newMenuItemCustomPanel.add(addNewMenuItemCustomNameField, c);

            addNewMenuItemCustomPriceLabel.setPreferredSize(labelSize); 
            c.gridx = 0;
            c.gridy = 2;
            newMenuItemCustomPanel.add(addNewMenuItemCustomPriceLabel, c);
            
            addMenuItemCustomPriceField.setPreferredSize(labelSize); 
            c.gridx = 0;
            c.gridy = 3;
            newMenuItemCustomPanel.add(addMenuItemCustomPriceField, c);

            enterNewMenuCustomBtn.setPreferredSize(buttonSize); 
            enterNewMenuCustomBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        //first check if the price is numeric and the name is not blank
                        if ( isNumeric( addMenuItemCustomPriceField.getText() ) && !addNewMenuItemCustomNameField.getText().equals("") ) {
                            //name of the new menu item from text field 
                            String name = addNewMenuItemCustomNameField.getText();
                            //price from price text box
                            float price = Float.parseFloat( addMenuItemCustomPriceField.getText() );
                            //RestaurantManager.restaurant.menu.customItems.add( new MenuItem( name, price ));
                            //
                            //new menu item object from input text box values
                            MenuItem m = new MenuItem( name, price );
                            //index of item to remove if the same item exists
                            int i = RestaurantManager.restaurant.menu.indexOfItem( m, RestaurantManager.restaurant.menu.customItems );
                            if ( i == -1 ) {
                                RestaurantManager.restaurant.menu.customItems.add( m );
                            } else {
                                RestaurantManager.restaurant.menu.customItems.remove(i);
                                RestaurantManager.restaurant.menu.customItems.add( m );
                            }
                            //
                            drawAdminPage();
                        }
                        addNewMenuItemCustomNameField.setText("");
                        addMenuItemCustomPriceField.setText("");

                    }
                }
            );
            c.gridx = 0;
            c.gridy = 4;
            newMenuItemCustomPanel.add(enterNewMenuCustomBtn, c);
            
            c.gridx = 0;
            c.gridy = 0;
            optionPanel.add(newMenuItemCustomPanel, c);
        }
    //Visible with new menu custom panel
    JScrollPane menuCustomPane = new JScrollPane();
    JPanel menuCustomPanel = new JPanel(); //pair 3 - 2/2
        private void drawMenuCustomPanel(Dimension panelSize){
            menuCustomPanel.removeAll();
            menuCustomPanel.repaint();
            menuCustomPanel.revalidate();
            
            menuCustomPane.setLayout( new ScrollPaneLayout() );
            
            menuCustomPanel.setLayout(grid);
            menuCustomPane.setPreferredSize( panelSize );
            for (int i = 0; i < RestaurantManager.getMenu().customItems.size(); i++ ){
                //JButton itemBtn = new JButton( RestaurantManager.getMenu().menuItems.get(i).name );
                JButton customItemBtn = new JButton( RestaurantManager.getMenu().customItems.get(i).name 
                                        + " " +  RestaurantManager.getMenu().customItems.get(i).price);
                final int ii = i;
                customItemBtn.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String name = RestaurantManager.getMenu().customItems.get(ii).name;
                        String price = RestaurantManager.getMenu().customItems.get(ii).price + "";
                        addNewMenuItemCustomNameField.setText( name );
                        addMenuItemCustomPriceField.setText( price);
                    }
                }
                );
                c.gridx = 0;
                c.gridy = i;
                menuCustomPanel.add( customItemBtn, c );
            }

            menuCustomPane.getViewport().add( menuCustomPanel, null );
            c.gridx = 1;
            c.gridy = 0;
            optionPanel.add( menuCustomPane, c );
        }
        int secondPanelWidth;// = (int)(w/4);
        int leftPanelWidth;// = (int)(w/3);
        Dimension panelSize;// = new Dimension( w, h );
        Dimension buttonSize;// = new Dimension( (int)(w/10), (int)(h/15) );
        Dimension leftPanelSize;// = new Dimension( leftPanelWidth, (int)(h - (h/5)) );
        Dimension secondaryPanelSize;// = new Dimension( secondPanelWidth, (int)(h - (h/5)) );
        Dimension optionPanelSize;// = new Dimension( (int)(w - (w/50)), (int)(h - (h/15)) );
        Dimension labelSize;// =  new Dimension( secondPanelWidth-(int)(secondPanelWidth/10), h - (int)(h/100) );
        
    AdminPage( int w, int h ){
        leftPanelWidth = (int)(w/1.5);
        secondPanelWidth = (int)(w/4);
        panelSize = new Dimension( w, h );
        buttonSize = new Dimension( (int)(w/10), (int)(h/15) );
        leftPanelSize = new Dimension( leftPanelWidth, (int)(h - (h/5)) );
        secondaryPanelSize = new Dimension( secondPanelWidth, (int)(h - (h/5)) );
        optionPanelSize = new Dimension( (int)(w - (w/50)), (int)(h - (h/15)) );
        labelSize =  new Dimension( leftPanelWidth-(int)(leftPanelWidth/10), (int)(h/15) );


        panel.setLayout( grid );
        panel.setPreferredSize( panelSize );
        panel.setBackground(Color.black);
            
        //draw the button panel
        drawButtonPanel( new Dimension( (int)(w - (w/50)), (int)(h/15) ), buttonSize );

        ////Option Panel
        optionPanel.setLayout( grid );
        optionPanel.setPreferredSize( optionPanelSize );
        
        
        drawAdminPage( );

        addNewEmployeePanel.setVisible(true);//pair 1-1/2
        employeePane.setVisible(true);//pair 1-2/2

        newMenuItemPanel.setVisible(false);//pair 2-1/2
        menuPane.setVisible(false);//pair 2-2/2

        newMenuItemCustomPanel.setVisible(false);//pair 3-1/2
        menuCustomPane.setVisible(false);//pair 3-2/2
        //Add Button Panel to panel
        c.gridx = 0;
        c.gridy = 0;
        panel.add( buttonPanel, c );

        //Add Option Panel to panel
        c.gridx = 0;
        c.gridy = 1;
        panel.add( optionPanel, c );
    }

    public void drawAdminPage( ){
        //draw the add new employee panel
        drawAddNewEmployeePanel( leftPanelSize, labelSize, buttonSize );//pair 1-1/2
        //draw the employee panel
        drawEmployeePanel( secondaryPanelSize );//pair 1-2/2
        //draw the new menu item panel
        drawNewMenuItemPanel( leftPanelSize, labelSize, buttonSize );//pair 2-1/2
        //draw the menu panel
        drawMenuPanel( secondaryPanelSize );//pair 2-2/2
        //draw the new menu customization item panel
        drawNewMenuCustomItemPanel(leftPanelSize, labelSize, buttonSize);//pair 3-1/2
        drawMenuCustomPanel(secondaryPanelSize);
    }

}