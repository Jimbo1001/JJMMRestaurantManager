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
    
    JPanel buttonPanel = new JPanel();
        JButton employeeBtn              = new JButton( "Employees" );
        JButton menuBtn                  = new JButton( "Menu" );
        JButton menuItemBtn              = new JButton( "Items" );
        JButton menuCustomizationItemBtn = new JButton( "Custom Items" );
        JButton exitBtn                  = new JButton( "Exit" );

    JPanel optionPanel = new JPanel();

    JPanel addNewEmployeePanel = new JPanel();
        JLabel addNewEmployeeNameLabel     = new JLabel( "Enter new employee name:" );
        JTextField addNewEmployeeNameField = new JTextField("");
        JLabel addNewEmployeeIdLabel       = new JLabel( "Enter new employee ID:" );
        JTextField addNewEmployeeIDField   = new JTextField("");
        JLabel isAdminLabel                = new JLabel( "Admin:" );
        JCheckBox isAdmin                  = new JCheckBox();
        JButton enterNewEmployeeBtn        = new JButton( "Add New" );
        private void drawAddNewEmployeePanel( Dimension panelSize, Dimension buttonSize ){
            //Add New Employee Panel
            addNewEmployeePanel.setLayout( grid );
            addNewEmployeePanel.setPreferredSize( panelSize );
            
            addNewEmployeeIdLabel.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 0;
            addNewEmployeePanel.add( addNewEmployeeNameLabel, c );

            addNewEmployeeNameField.setPreferredSize( buttonSize );
            c.gridx = 1;
            c.gridy = 0;
            addNewEmployeePanel.add( addNewEmployeeNameField, c );

            addNewEmployeeIdLabel.setPreferredSize( buttonSize );
            c.gridx = 0;
            c.gridy = 1;
            addNewEmployeePanel.add( addNewEmployeeIdLabel, c );
            
            addNewEmployeeIDField.setPreferredSize( buttonSize );
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
            c.gridx = 2;
            c.gridy = 1;
            addNewEmployeePanel.add( enterNewEmployeeBtn, c );
            //End Add New Employee Panel

            c.gridx = 0;
            c.gridy = 0;
            optionPanel.add( addNewEmployeePanel, c );
        }
    JPanel employeePanel = new JPanel();
        
    JPanel menuPanel = new JPanel();
        //Draw the menu panel
        private void drawMenuPanel( Dimension s ){
            menuPanel.setLayout(grid);
            menuPanel.setPreferredSize( s );
            for (int i = 0; i < RestaurantManager.getMenu().menuItems.size(); i++ ){
                JButton itemBtn = new JButton( RestaurantManager.getMenu().menuItems.get(i).name );
                c.gridx = 0;
                c.gridy = i;
                menuPanel.add( itemBtn, c );
            }
            c.gridx = 1;
            c.gridy = 0;
            optionPanel.add( menuPanel, c );
            menuPanel.setVisible( false );
        }

    JPanel newMenuItemPanel = new JPanel();
        JLabel addNewMenuItemNameLabel     = new JLabel( "Enter new menu item name:" );
        JTextField addNewMenuItemNameField = new JTextField("");
        JLabel addNewMenuItemPriceLabel    = new JLabel( "Enter new menu item price:" );
        JTextField addMenuItemPriceField   = new JTextField("");
        JButton enterNewMenuItemBtn        = new JButton( "Add New" );
    JPanel newMenuItemCustomPanel = new JPanel();
        JLabel addNewMenuItemCustomNameLabel     = new JLabel( "Enter new menu item name:" );
        JTextField addNewMenuItemCustomNameField = new JTextField("");
        JLabel addNewMenuItemCustomPriceLabel    = new JLabel( "Enter new menu item price:" );
        JTextField addMenuItemCustomPriceField   = new JTextField("");
        JButton enterNewMenuCustomBtn            = new JButton( "Add New" );

    AdminPage( int w, int h ){
        Dimension panelSize = new Dimension( w, h );
        Dimension buttonSize = new Dimension( (int)(w/10), (int)(h/20) );
        Dimension secondaryPanelSize = new Dimension( (int)(w/4), (int)(h - (h/15)) );
        Dimension optionPanelSize = new Dimension( (int)(w - (w/50)), (int)(h - (h/15)) );
        panel.setLayout( grid );
        panel.setPreferredSize( panelSize );
        panel.setBackground(Color.black);
        
        //Button Panel
        buttonPanel.setLayout( grid );
        buttonPanel.setPreferredSize( new Dimension( (int)(w - (w/50)), (int)(h/15) ) );

        employeeBtn = new JButton("Employees");
        employeeBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    addNewEmployeePanel.setVisible(true);
                    newMenuItemPanel.setVisible(false);
                }
            }
        );
        employeeBtn.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add( employeeBtn, c );
        
        menuBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    addNewEmployeePanel.setVisible(false);
                    newMenuItemPanel.setVisible(true);
                    menuPanel.setVisible( true );
                }
            }
        );
        menuBtn.setPreferredSize( buttonSize );
        c.gridx = 1;
        c.gridy = 0;
        buttonPanel.add( menuBtn, c );
        
        menuItemBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    addNewEmployeePanel.setVisible(false);
                    newMenuItemPanel.setVisible(false);
                    
                }
            }
        );
        menuItemBtn.setPreferredSize( buttonSize );
        c.gridx = 2;
        c.gridy = 0;
        buttonPanel.add( menuItemBtn, c );
        //JButton menuCustomizationItemBtn = new JButton( "Custom Items" );*/
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
        
        ////Option Panel
        optionPanel.setLayout( grid );
        optionPanel.setPreferredSize( optionPanelSize );
            
            //EmployeePanel
            employeePanel.setLayout( grid );
            employeePanel.setPreferredSize( secondaryPanelSize );
            //End EmployeePanel
            
            //new menu item panel
            newMenuItemPanel.setLayout( grid );
            newMenuItemPanel.setPreferredSize( secondaryPanelSize );
        
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
            
        
        c.gridx = 0;
        c.gridy = 0;
        optionPanel.add( newMenuItemPanel, c );
        newMenuItemPanel.setVisible( false );

        drawAddNewEmployeePanel( secondaryPanelSize, buttonSize );
        drawMenuPanel( secondaryPanelSize );


        c.gridx = 1;
        c.gridy = 0;
        optionPanel.add( employeePanel, c );
        ////EndOption Panel
       

        //Add Button Panel to panel
        c.gridx = 0;
        c.gridy = 0;
        panel.add( buttonPanel, c );

        //Add Option Panel to panel
        c.gridx = 0;
        c.gridy = 1;
        panel.add( optionPanel, c );
    }

}