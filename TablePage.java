import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class TablePage{
    
    JPanel panel = new JPanel();

    JButton addBtn = new JButton("Add Table");
    JButton removeBtn = new JButton("Remove Table");
    JButton exitBtn  = new JButton( "Exit" );

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    boolean verbose = false;

    Dimension buttonSize  = new Dimension( 100, 50 );

    TablePage( int w, int h ){
        panel.setLayout( grid );
        panel.setBackground(Color.black);
        panel.setPreferredSize( new Dimension( w, h ) );
        
        draw();
        addBtn.setPreferredSize( buttonSize );
        addBtn.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                RestaurantManager.restaurant.tables.add( new Table() );
                draw();
            }
        });
        c.gridx = 0;
        c.gridy = 0;
        panel.add( addBtn, c );
        addBtn.setVisible( RestaurantManager.admin );

        removeBtn.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 1;
        panel.add( removeBtn, c );
        removeBtn.setVisible( RestaurantManager.admin );
        /*
        int i = 0;
        for ( ; i < RestaurantManager.restaurant.tables.size(); i++ ){
            JButton tableBtn = new JButton( "Table " + (i + 1) );
            final int ii = i;
            tableBtn.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    if ( RestaurantManager.restaurant.tables.get(ii).open ){
                        System.out.println( "Table is open" );
                        //Set the tables id to the current users id
                        RestaurantManager.restaurant.tables.get(ii).setID( RestaurantManager.restaurant.activeID );
                        //set the table to closed
                        RestaurantManager.restaurant.tables.get(ii).setOpen( false );
                        RestaurantManager.serverPage.panel.setVisible( true );
                        panel.setVisible( false );
                    } else if ( RestaurantManager.restaurant.activeID.equals(RestaurantManager.restaurant.tables.get(ii).tableActiveID) ){
                        System.out.println( "This is this users table" );
                        RestaurantManager.serverPage.panel.setVisible( true );
                        panel.setVisible( false );
                    } else {
                        System.out.println( "Table is not the current users" );
                    }
                }
            });
            c.gridx = 0;
            c.gridy = i + 2;
            panel.add( tableBtn, c );
        }
        */

        exitBtn.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                panel.setVisible( false );
                RestaurantManager.login.panel.setVisible( true );
                System.out.println("Exiting to login");
            }
        });
        c.gridx = 0;
        c.gridy = RestaurantManager.restaurant.tables.size() + 3;
        panel.add( exitBtn, c );
    }

    public void updateAdminAccess( boolean admin ){
        addBtn.setVisible( admin );
        removeBtn.setVisible( admin );
    }

    public void draw(){
        System.out.println( RestaurantManager.admin );
        updateAdminAccess( RestaurantManager.admin );
        int i = 0;
        for ( ; i < RestaurantManager.restaurant.tables.size(); i++ ){
            JButton tableBtn = new JButton( "Table " + (i + 1) );
            final int ii = i;

            tableBtn.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    if ( RestaurantManager.restaurant.tables.get(ii).open ){
                        System.out.println( "Table is open" );
                        //Set the tables id to the current users id
                        RestaurantManager.restaurant.tables.get(ii).setID( RestaurantManager.restaurant.activeID );
                        //set the table to closed
                        RestaurantManager.restaurant.tables.get(ii).setOpen( false );
                        RestaurantManager.serverPage.panel.setVisible( true );
                        panel.setVisible( false );
                    } else if ( RestaurantManager.restaurant.activeID.equals(RestaurantManager.restaurant.tables.get(ii).tableActiveID) ){
                        System.out.println( "This is this users table" );
                        RestaurantManager.serverPage.panel.setVisible( true );
                        panel.setVisible( false );
                    } else {
                        System.out.println( "Table is not the current users" );
                    }
                }
            });

            c.gridx = 0;
            c.gridy = i + 2;
            panel.add( tableBtn, c );

            /*c.gridx = 0;
            c.gridy = i + 3;
            panel.add( exitBtn, c );*/

        }
    }
}