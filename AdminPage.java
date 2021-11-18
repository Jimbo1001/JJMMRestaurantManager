/*import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;*/
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
        JButton menuCustomizationItemBtn = new JButton( "Custom Items" );
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
                        employeePanel.setVisible( true );//pair 1-2/2

                        newMenuItemPanel.setVisible( false );//pair 2-1/2
                        menuPanel.setVisible( false );//pair 2-2/2

                        newMenuItemCustomPanel.setVisible(false);//pair 3-1/2
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
                        employeePanel.setVisible(false);//pair 1-2/2

                        newMenuItemPanel.setVisible(true);//pair 2-1/2
                        menuPanel.setVisible( true );//pair 2-2/2

                        newMenuItemCustomPanel.setVisible(false);//pair 3-1/2
                    }
                }
            );
            menuBtn.setPreferredSize( buttonSize );
            c.gridx = 1;
            c.gridy = 0;
            buttonPanel.add( menuBtn, c );
            
            menuItemBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        addNewEmployeePanel.setVisible(false);//pair 1-1/2
                        employeePanel.setVisible(false);//pair 1-2/2

                        newMenuItemPanel.setVisible(false);//pair 2-1/2
                        menuPanel.setVisible(false);//pair 2-2/2

                        newMenuItemCustomPanel.setVisible(true);//pair 3-1/2
                        //pair 3-2/2
                    }
                }
            );
            menuItemBtn.setPreferredSize( buttonSize );
            c.gridx = 2;
            c.gridy = 0;
            buttonPanel.add( menuItemBtn, c );
            //JButton menuCustomizationItemBtn = new JButton( "Custom Items" );
            exitBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        panel.setVisible( false );
                        RestaurantManager.login.panel.setVisible( true );
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
                        drawEmployeePanel( panelSize );
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
    JScrollPane employeePanel = new JScrollPane();//JPanel();
    JPanel displayPanel = new JPanel();
    //ScrollPanelLayout sgrid = new ScrollPaneLayout();
        public void drawEmployeePanel( Dimension panelSize ){
            displayPanel.removeAll();
            displayPanel.repaint();
            displayPanel.revalidate();
            //employeePanel
            employeePanel.setLayout( new ScrollPaneLayout() );
            employeePanel.setPreferredSize( panelSize );
            displayPanel.setLayout(grid);
            for (int i = 0; i < RestaurantManager.restaurant.employees.size(); i++){
                JButton empBtn = new JButton( RestaurantManager.restaurant.employees.get(i).name ); 
                c.gridx = 0;
                c.gridy = i;
                displayPanel.add(empBtn, c);
            }
            employeePanel.getViewport().add( displayPanel, null );
            //end employeePanel
            c.gridx = 1;
            c.gridy = 0;
            optionPanel.add( employeePanel, c );
        }
    //Visible with new menu item panel- Pair 2-1/2
    JPanel menuPanel = new JPanel();
        //Draw the menu panel
        private void drawMenuPanel( Dimension panelSize ){
            menuPanel.removeAll();
            menuPanel.repaint();
            menuPanel.revalidate();

            menuPanel.setLayout(grid);
            menuPanel.setPreferredSize( panelSize );
            for (int i = 0; i < RestaurantManager.getMenu().menuItems.size(); i++ ){
                JButton itemBtn = new JButton( RestaurantManager.getMenu().menuItems.get(i).name );
                /*itemBtn.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                    }
                });*/
                c.gridx = 0;
                c.gridy = i;
                menuPanel.add( itemBtn, c );
            }
            c.gridx = 1;
            c.gridy = 0;
            optionPanel.add( menuPanel, c );
            menuPanel.setVisible( false );
        }
    //Visible with menu panel - Pair 2-2/2
    JPanel newMenuItemPanel = new JPanel();
        JLabel addNewMenuItemNameLabel     = new JLabel( "Enter new menu item name:" );
        JTextField addNewMenuItemNameField = new JTextField("");
        JLabel addNewMenuItemPriceLabel    = new JLabel( "Enter new menu item price:" );
        JTextField addMenuItemPriceField   = new JTextField("");
        JButton enterNewMenuItemBtn        = new JButton( "Add New" );
        private void drawNewMenuItemPanel( Dimension panelSize, Dimension labelSize, Dimension buttonSize ){
            //new menu item panel
            newMenuItemPanel.setLayout( grid );
            newMenuItemPanel.setPreferredSize( panelSize );
        
            addNewMenuItemNameLabel.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = 0;
            newMenuItemPanel.add( addNewMenuItemNameLabel, c );

            addNewMenuItemNameField.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 1;
            newMenuItemPanel.add( addNewMenuItemNameField, c );

            addNewMenuItemPriceLabel.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = 2;
            newMenuItemPanel.add( addNewMenuItemPriceLabel, c );

            addMenuItemPriceField.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 3;
            newMenuItemPanel.add( addMenuItemPriceField, c );

            enterNewMenuItemBtn.setPreferredSize( buttonSize );
            /*enterNewMenuItemBtn.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent e){

                    }
                }
            );*/
            c.gridx = 0;
            c.gridy = 4;
            newMenuItemPanel.add( enterNewMenuItemBtn, c );
            
            //add the panel to the option panel
            c.gridx = 0;
            c.gridy = 0;
            optionPanel.add( newMenuItemPanel, c );
            newMenuItemPanel.setVisible( false );
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

            addNewMenuItemCustomNameField.setPreferredSize(buttonSize);
            c.gridx = 0;
            c.gridy = 1;
            newMenuItemCustomPanel.add(addNewMenuItemCustomNameField, c);

            addNewMenuItemCustomPriceLabel.setPreferredSize(labelSize); 
            c.gridx = 0;
            c.gridy = 2;
            newMenuItemCustomPanel.add(addNewMenuItemCustomPriceLabel, c);
            
            addMenuItemCustomPriceField.setPreferredSize(buttonSize); 
            c.gridx = 0;
            c.gridy = 3;
            newMenuItemCustomPanel.add(addMenuItemCustomPriceField, c);

            c.gridx = 0;
            c.gridy = 4;
            newMenuItemCustomPanel.add(enterNewMenuCustomBtn, c);
            
            c.gridx = 0;
            c.gridy = 0;
            optionPanel.add(newMenuItemCustomPanel, c);
            newMenuItemCustomPanel.setVisible(false);
        }
    //Vistible with new menu custom panel
    JPanel menuCustomPanel = new JPanel();

    AdminPage( int w, int h ){
        int secondPanelWidth = (int)(w/4);
        Dimension panelSize = new Dimension( w, h );
        Dimension buttonSize = new Dimension( (int)(w/10), (int)(h/15) );
        Dimension leftPanelSize = new Dimension( w - (int)(w/1.5), (int)(h - (h/5)) );
        Dimension secondaryPanelSize = new Dimension( secondPanelWidth, (int)(h - (h/5)) );
        Dimension optionPanelSize = new Dimension( (int)(w - (w/50)), (int)(h - (h/15)) );
        Dimension labelSize =  new Dimension( secondPanelWidth-(int)(secondPanelWidth/10), h - (int)(h/100) );//new Dimension((int)secondaryPanelSize.width/2, secondaryPanelSize.height);
        panel.setLayout( grid );
        panel.setPreferredSize( panelSize );
        //panel.setBackground(Color.black);

        
            
        //draw the button panel
        drawButtonPanel( new Dimension( (int)(w - (w/50)), (int)(h/15) ), buttonSize );

        ////Option Panel
        optionPanel.setLayout( grid );
        optionPanel.setPreferredSize( optionPanelSize );
        //draw the add new employee panel
        drawAddNewEmployeePanel( leftPanelSize, labelSize, buttonSize );//pair 1-1/2
        //draw the employee panel
        drawEmployeePanel( secondaryPanelSize );//pair 1-2/2
        //draw the new menu item panel
        drawNewMenuItemPanel( secondaryPanelSize, labelSize, buttonSize );//pair 2-1/2
        //draw the menu panel
        drawMenuPanel( secondaryPanelSize );//pair 2-2/2
        //draw the new menu customization item panel
        drawNewMenuCustomItemPanel(secondaryPanelSize, labelSize, buttonSize);//pair 3-1/2
        ////end Option Panel

        //Add Button Panel to panel
        c.gridx = 0;
        c.gridy = 0;
        panel.add( buttonPanel, c );

        //Add Option Panel to panel
        c.gridx = 0;
        c.gridy = 1;
        panel.add( optionPanel, c );
    }

    public void redrawAdminPage( int w, int h ){
        Dimension panelSize = new Dimension( w, h );
        Dimension buttonSize = new Dimension( (int)(w/10), (int)(h/20) );
        Dimension leftPanelSize = new Dimension( w - (int)(w/1.5), (int)(h - (h/5)) );
        Dimension secondaryPanelSize = new Dimension( (int)(w/4), (int)(h - (h/15)) );
        Dimension optionPanelSize = new Dimension( (int)(w - (w/50)), (int)(h - (h/15)) );
        Dimension labelSize = new Dimension( (int)(w/8), (int)(h/50));
        //draw the add new employee panel
        drawAddNewEmployeePanel( leftPanelSize, labelSize, buttonSize );//pair 1-1/2
        //draw the employee panel
        drawEmployeePanel( secondaryPanelSize );//pair 1-2/2
        //draw the new menu item panel
        drawNewMenuItemPanel( secondaryPanelSize, labelSize, buttonSize );//pair 2-1/2
        //draw the menu panel
        drawMenuPanel( secondaryPanelSize );//pair 2-2/2
        //draw the new menu customization item panel
        drawNewMenuCustomItemPanel(secondaryPanelSize, labelSize, buttonSize);//pair 3-1/2
    }

}