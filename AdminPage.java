import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
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
        JLabel addNewEmployeeNameLabel     = new JLabel( "Enter new employee name:" );
        JTextField addNewEmployeeNameField = new JTextField("");
        JLabel addNewEmployeeIdLabel       = new JLabel( "Enter new employee ID:" );
        JTextField addNewEmployeeIDField   = new JTextField("");
        JLabel isAdminLabel                = new JLabel( "Admin:" );
        JCheckBox isAdmin                  = new JCheckBox();
        JButton enterNewEmployeeBtn        = new JButton( "Add New" );
        private void drawAddNewEmployeePanel( Dimension panelSize, Dimension buttonSize ){
            addNewEmployeePanel.removeAll();
            addNewEmployeePanel.repaint();
            addNewEmployeePanel.revalidate();
            //Add New Employee Panel
            addNewEmployeePanel.setLayout( grid );
            addNewEmployeePanel.setPreferredSize( panelSize );
            
            addNewEmployeeIdLabel.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 0;
            addNewEmployeePanel.add( addNewEmployeeNameLabel, c );

            addNewEmployeeNameField.setPreferredSize( new Dimension(100,50) );
            c.gridx = 1;
            c.gridy = 0;
            addNewEmployeePanel.add( addNewEmployeeNameField, c );

            addNewEmployeeIdLabel.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 1;
            addNewEmployeePanel.add( addNewEmployeeIdLabel, c );
            
            addNewEmployeeIDField.setPreferredSize( new Dimension(100,50) );
            c.gridx = 1;
            c.gridy = 1;
            addNewEmployeePanel.add( addNewEmployeeIDField, c );
            
            isAdminLabel.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 2;
            addNewEmployeePanel.add( isAdminLabel, c );
            
            isAdmin.setPreferredSize( buttonSize );
            c.gridx = 1;
            c.gridy = 2;
            addNewEmployeePanel.add( isAdmin, c );

            enterNewEmployeeBtn.setPreferredSize( buttonSize );
            c.gridx = 1;
            c.gridy = 3;
            addNewEmployeePanel.add( enterNewEmployeeBtn, c );
            //End Add New Employee Panel

            c.gridx = 0;
            c.gridy = 0;
            optionPanel.add( addNewEmployeePanel, c );
        }
    //Visible with addNewEmployeePanel - Pair 1-2/2
    JPanel employeePanel = new JPanel();
        public void drawEmployeePanel( Dimension panelSize ){
            //EmployeePanel
            employeePanel.setLayout( grid );
            employeePanel.setPreferredSize( panelSize );
            //End EmployeePanel
            c.gridx = 1;
            c.gridy = 0;
            optionPanel.add( employeePanel, c );
        }
    //Visible with new menu item panel- Pair 2-1/2
    JPanel menuPanel = new JPanel();
        //Draw the menu panel
        private void drawMenuPanel( Dimension s ){
            menuPanel.removeAll();
            menuPanel.repaint();
            menuPanel.revalidate();
            menuPanel.setLayout(grid);
            menuPanel.setPreferredSize( s );
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
        private void drawNewMenuItemPanel( Dimension panelSize, Dimension buttonSize ){
            //new menu item panel
            newMenuItemPanel.setLayout( grid );
            newMenuItemPanel.setPreferredSize( panelSize );
        
            addNewMenuItemNameLabel.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 0;
            newMenuItemPanel.add( addNewMenuItemNameLabel, c );

            addNewMenuItemNameField.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 1;
            newMenuItemPanel.add( addNewMenuItemNameField, c );

            addNewMenuItemPriceLabel.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 2;
            newMenuItemPanel.add( addNewMenuItemPriceLabel, c );

            addMenuItemPriceField.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 3;
            newMenuItemPanel.add( addMenuItemPriceField, c );

            enterNewMenuItemBtn.setPreferredSize( buttonSize );
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
        Dimension panelSize = new Dimension( w, h );
        Dimension buttonSize = new Dimension( (int)(w/10), (int)(h/20) );
        Dimension secondaryPanelSize = new Dimension( (int)(w/4), (int)(h - (h/15)) );
        Dimension optionPanelSize = new Dimension( (int)(w - (w/50)), (int)(h - (h/15)) );
        Dimension labelSize = new Dimension((int)secondaryPanelSize.width/2, secondaryPanelSize.height);
        panel.setLayout( grid );
        panel.setPreferredSize( panelSize );
        //panel.setBackground(Color.black);

        
            
        //draw the button panel
        drawButtonPanel( new Dimension( (int)(w - (w/50)), (int)(h/15) ), buttonSize );

        ////Option Panel
        optionPanel.setLayout( grid );
        optionPanel.setPreferredSize( optionPanelSize );
        //draw the add new employee panel
        drawAddNewEmployeePanel( secondaryPanelSize, buttonSize );
        //draw the menu panel
        drawMenuPanel( secondaryPanelSize );
        //draw the employee panel
        drawEmployeePanel( secondaryPanelSize );
        //draw the new menu item panel
        drawNewMenuItemPanel( secondaryPanelSize, buttonSize );

        drawNewMenuCustomItemPanel(secondaryPanelSize, labelSize, buttonSize);
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
        Dimension secondaryPanelSize = new Dimension( (int)(w/4), (int)(h - (h/15)) );
        Dimension optionPanelSize = new Dimension( (int)(w - (w/50)), (int)(h - (h/15)) );
        //draw the add new employee panel
        drawAddNewEmployeePanel( secondaryPanelSize, buttonSize );
        //draw the menu panel
        drawMenuPanel( secondaryPanelSize );
        //draw the employee panel
        drawEmployeePanel( secondaryPanelSize );
        //draw the new menu item panel
        drawNewMenuItemPanel( secondaryPanelSize, buttonSize );
    }

}