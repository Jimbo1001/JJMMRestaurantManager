import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class TablePage{
    
    JPanel panel = new JPanel();
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
        
    }

    public void draw(){
        panel.removeAll();
        panel.repaint();
        panel.revalidate();

        panel.setLayout( grid );

        System.out.println( "Drawing tables \nAdmin access: " + RestaurantManager.admin + "\nTable amount: " + RestaurantManager.restaurant.tables.size() );
        
        
        JButton addBtn = new JButton( "Add Table" );
        addBtn.setPreferredSize( buttonSize );
        addBtn.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                RestaurantManager.restaurant.tables.add( new Table() );
            }
        });
        c.gridx = 0;
        c.gridy = 0;
        panel.add( addBtn, c );
        addBtn.setVisible( RestaurantManager.admin );

        JButton removeBtn = new JButton( "Remove Table" );
        removeBtn.setPreferredSize( buttonSize );
        removeBtn.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                if ( RestaurantManager.restaurant.tables.size() >= 0 ){
                    RestaurantManager.restaurant.tables.remove( RestaurantManager.restaurant.tables.size() - 1);
                    
                    System.out.println( RestaurantManager.restaurant.tables.size() );
                }
                draw();
            }
        });
        c.gridx = 0;
        c.gridy = 1;
        panel.add( removeBtn, c );
        removeBtn.setVisible( RestaurantManager.admin );

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
        c.gridx = 0;
        c.gridy = i + 3;
        panel.add( exitBtn, c );
    }
}