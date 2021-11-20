//import javax.swing.JTextField;
//import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class TablePage{
    
    JPanel panel = new JPanel();

    JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton( "Add Table" );
        JButton removeBtn = new JButton( "Remove Table" );
        JButton exitBtn  = new JButton( "Exit" );
        JButton adminBtn = new JButton( "Admin" );
        private void drawButtonPanel(int w, int h){
            buttonPanel.setLayout(grid);
            buttonPanel.setPreferredSize( new Dimension( w - (int)(w/1.5), h - (int)(h/25) ) );
            addBtn.setPreferredSize( buttonSize );
            addBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        RestaurantManager.restaurant.tables.add( new Table() );
                        drawTablePanel(w, h);
                    }
                }
            );
            c.gridx = 0;
            c.gridy = 0;
            buttonPanel.add( addBtn, c );

            removeBtn.setPreferredSize( buttonSize );
            removeBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        if ( RestaurantManager.restaurant.tables.size() > 0 ){
                            RestaurantManager.restaurant.tables.remove( RestaurantManager.restaurant.tables.size() - 1);
                            
                            System.out.println( RestaurantManager.restaurant.tables.size() );
                            drawTablePanel(w, h);
                        }
                    }
                }
            );
            c.gridx = 0;
            c.gridy = 1;
            buttonPanel.add( removeBtn, c );
            
            exitBtn.setPreferredSize( buttonSize );
            exitBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        panel.setVisible( false );
                        RestaurantManager.login.panel.setVisible( true );
                        System.out.println("Exiting to login");
                    }
                }
            );
            c.gridx = 0;
            c.gridy = 2;
            buttonPanel.add( exitBtn, c );

            adminBtn.setPreferredSize( buttonSize );
            final int ww = w; final int hh = h;
            adminBtn.addActionListener( new ActionListener() {
                    public void actionPerformed( ActionEvent e ){
                        RestaurantManager.adminPage.drawAdminPage( );
                        RestaurantManager.adminPage.panel.setVisible( true );
                        panel.setVisible( false );
                    }
                }
            );
            c.gridx = 0;
            c.gridy = 3;
            buttonPanel.add( adminBtn, c );

            c.gridx = 1;
            c.gridy = 0;
            panel.add( buttonPanel, c );
        }

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    boolean verbose = false;

    Dimension buttonSize;

    TablePage( int w, int h ){
        panel.setLayout( grid );
        panel.setBackground(Color.black);
        panel.setPreferredSize( new Dimension( w, h ) );

        buttonSize = new Dimension( (int)(w/10), (int)(h/15) );

        drawButtonPanel(w, h);
        
        tableScrollPane.setLayout( new ScrollPaneLayout() );
        tableScrollPane.setPreferredSize( new Dimension( w - (int)(w/2), h - (int)(h/25)) );
        drawTablePanel(w, h);
    }
    JScrollPane tableScrollPane = new JScrollPane();
    JPanel tablePanel = new JPanel();
    public void drawTablePanel(int w, int h){
        tablePanel.setLayout(grid);
        tablePanel.removeAll();
        tablePanel.repaint();
        tablePanel.revalidate();

        int i = 0;
        for ( ; i < RestaurantManager.restaurant.tables.size(); i++ ){
            JButton tableBtn = new JButton( "Table " + (i + 1) );
            tableBtn.setPreferredSize( buttonSize );
            final int ii = i;

            tableBtn.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    panel.setVisible(false);
                    RestaurantManager.serverPage.setActiveTable( RestaurantManager.restaurant.tables.get(ii) );
                    RestaurantManager.serverPage.drawReceiptPanel();
                    RestaurantManager.serverPage.panel.setVisible( true );
                }
            });

            c.gridx = 0;
            c.gridy = i + 2;
            tablePanel.add( tableBtn, c );
        }
        tableScrollPane.getViewport().add(tablePanel, null);
        c.gridx = 0;
        c.gridy = 0;
        panel.add( tableScrollPane, c );
    }
}