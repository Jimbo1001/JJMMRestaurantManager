import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class RestaurantManager{
    //Restaurant object
    static Restaurant restaurant;
    //Login Page
    static Login login;
    //Table Page
    static TablePage tablePage;
    //Server Page
    static ServerPage serverPage;
    //Admin Page
    static AdminPage adminPage;
    //Jframe for GUI
    JFrame frame;
    GridBagLayout grid   = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    
    boolean verbose = true;

    static boolean admin = false;
    //width of frame
    int w = 1200; 
    //height of frame
    int h = 800;
    //width and height of the panel
    int pw, ph;

    RestaurantManager(){
        restaurant = new Restaurant();

        pw = (int)( w - (w/10) );
        ph = (int)( h - (h/10) );

        login = new Login( pw, ph, verbose );
        tablePage = new TablePage( pw, ph );
        serverPage = new ServerPage( pw, ph );
        adminPage = new AdminPage( pw, ph );

        frame = new JFrame();
        frame.setLayout( grid);
        frame.setMinimumSize( new Dimension( w, h ) );
        initScreens();
        frame.pack();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }

    public void initScreens(){
        c.gridx = 0;
        c.gridy = 0;
        frame.add( login.panel, c );
        
        c.gridx = 0;
        c.gridy = 0;
        tablePage.panel.setVisible( false );
        frame.add( tablePage.panel, c);

        c.gridx = 0;
        c.gridy = 0;
        serverPage.panel.setVisible( false );
        frame.add( serverPage.panel, c );

        c.gridx = 0;
        c.gridy = 0;
        serverPage.panel.setVisible( false );
        frame.add( adminPage.panel, c );
        if ( verbose ){
            System.out.println( "Screens Initialized" );
        }
    }

}