import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class TablePage{
    
    JPanel panel = new JPanel();
    JButton addBtn = new JButton( "Add Table" );
    JButton removeBtn = new JButton( "Remove Table" );
    JButton exitBtn  = new JButton( "Exit" );
    JButton adminBtn = new JButton( "Admin" );

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    boolean verbose = false;

    Dimension buttonSize  = new Dimension( 100, 50 );

    TablePage( int w, int h ){
        panel.setLayout( grid );
        panel.setBackground(Color.black);
        panel.setPreferredSize( new Dimension( w, h ) );
        
        addBtn.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                RestaurantManager.restaurant.tables.add( new Table() );
                draw();
            }
        });

        removeBtn.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                if ( RestaurantManager.restaurant.tables.size() > 0 ){
                    RestaurantManager.restaurant.tables.remove( RestaurantManager.restaurant.tables.size() - 1);
                    
                    System.out.println( RestaurantManager.restaurant.tables.size() );
                    draw();
                }
            }
        });
        
        exitBtn.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                panel.setVisible( false );
                RestaurantManager.login.panel.setVisible( true );
                System.out.println("Exiting to login");
            }
        });

        draw();
        
    }

    public void draw(){
        panel.removeAll();
        panel.repaint();
        panel.revalidate();

        //panel.setLayout( grid );

        System.out.println( "Drawing tables \nAdmin access: " + RestaurantManager.admin + "\nTable amount: " + RestaurantManager.restaurant.tables.size() );
        
        
        
        addBtn.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 0;
        panel.add( addBtn, c );

        
        removeBtn.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 1;
        panel.add( removeBtn, c );

        exitBtn.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = RestaurantManager.restaurant.tables.size() + 3;
        panel.add( exitBtn, c );
        
        int i = 0;
        for ( ; i < RestaurantManager.restaurant.tables.size(); i++ ){
            JButton tableBtn = new JButton( "Table " + (i + 1) );
            final int ii = i;

            tableBtn.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    RestaurantManager.serverPage.panel.setVisible( true );
                }
            });

            c.gridx = 0;
            c.gridy = i + 2;
            panel.add( tableBtn, c );
        }
        c.gridx = 0;
        c.gridy = i + 3;
        panel.add( exitBtn, c );

        adminBtn.setPreferredSize( buttonSize );
        adminBtn.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    RestaurantManager.adminPage.panel.setVisible( true );
                    panel.setVisible( false );
                }
            }
        );
        c.gridx = 0;
        c.gridy = i + 4;
        panel.add( adminBtn, c );
    }
}