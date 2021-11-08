import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Login{
    JPanel panel = new JPanel();

    JTextField idField = new JTextField( "" );
    
    GridBagLayout grid   = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    boolean verbose = false;

    Dimension buttonSize  = new Dimension( 50, 50);
    Dimension idFieldSize = new Dimension( 50, 50);

    Login( int w, int h, boolean verbose ){
        this.verbose = verbose;
        panel.setLayout( grid );
        panel.setPreferredSize( new Dimension( w, h ) );
        panel.setBackground(Color.black);
        initPanel( w , h );
    }

    //init on first run
    //these are only things that wont change
    private void initPanel( int w, int h ){
        JButton clearBtn = new JButton( "Clear" );
        clearBtn.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" );
            }
        });
        c.gridx = 0;
        c.gridy = 0;
        clearBtn.setPreferredSize( buttonSize );
        panel.add( clearBtn, c );

        c.gridx = 1;
        c.gridy = 0;
        idField.setPreferredSize( idFieldSize );
        panel.add( idField, c );
        final int ww = w; final int hh = h;
        JButton enterBtn = new JButton( "Enter" );
        enterBtn.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                if ( RestaurantManager.restaurant.checkAdminID( idField.getText() ) ){
                    System.out.println("Opening Admin Tables:" + idField.getText() );
                    RestaurantManager.restaurant.activeID = idField.getText();//set the active ID
                    
                    
                    panel.setVisible( false );
                    RestaurantManager.tablePage.panel.setVisible(true);
                    RestaurantManager.tablePage.draw();
                } else if ( RestaurantManager.restaurant.checkID( idField.getText() ) ){
                    System.out.println("Opening User Tables:" + idField.getText() );
                    RestaurantManager.restaurant.activeID = idField.getText(); //set the active ID
                    
                    panel.setVisible( false );
                    RestaurantManager.tablePage.panel.setVisible(true);
                    RestaurantManager.tablePage.draw();
                }
                idField.setText("");
            }
        });
        c.gridx = 2;
        c.gridy = 0;
        enterBtn.setPreferredSize( buttonSize );
        panel.add( enterBtn, c );

        JButton btn1 = new JButton( "1" );
        btn1.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" + idField.getText() + 1 );
            }
        });
        btn1.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 1;
        panel.add( btn1, c );

        JButton btn2 = new JButton( "2" );
        btn2.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" + idField.getText() + 2 );
            }
        });
        btn2.setPreferredSize( buttonSize );
        c.gridx = 1;
        c.gridy = 1;
        panel.add( btn2, c );

        JButton btn3 = new JButton( "3" );
        btn3.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" + idField.getText() + 3 );
            }
        });
        btn3.setPreferredSize( buttonSize );
        c.gridx = 2;
        c.gridy = 1;
        panel.add( btn3, c );

        JButton btn4 = new JButton( "4" );
        btn4.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" + idField.getText() + 4 );
            }
        });
        btn4.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 2;
        panel.add( btn4, c );

        JButton btn5 = new JButton( "5" );
        btn5.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" + idField.getText() + 5 );
            }
        });
        btn5.setPreferredSize( buttonSize );
        c.gridx = 1;
        c.gridy = 2;
        panel.add( btn5, c );

        JButton btn6 = new JButton( "6" );
        btn6.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" + idField.getText() + 6 );
            }
        });
        btn6.setPreferredSize( buttonSize );
        c.gridx = 2;
        c.gridy = 2;
        panel.add( btn6, c );

        JButton btn7 = new JButton( "7" );
        btn7.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" + idField.getText() + 7 );
            }
        });
        btn7.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 3;
        panel.add( btn7, c );

        JButton btn8 = new JButton( "8" );
        btn8.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" + idField.getText() + 8 );
            }
        });
        btn8.setPreferredSize( buttonSize );
        c.gridx = 1;
        c.gridy = 3;
        panel.add( btn8, c );

        JButton btn9 = new JButton( "9" );
        btn9.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                idField.setText( "" + idField.getText() + 9 );
            }
        });
        btn9.setPreferredSize( buttonSize );
        c.gridx = 2;
        c.gridy = 3;
        panel.add( btn9, c );

        if ( verbose ){
            System.out.println( "Login Initialized" );
        }
    }
    //changes visibilty based on user access
    public void draw(){
        idField.setText( "" );
    } 
}