import javax.swing.JPanel;
import javax.swing.JFrame;

import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
class RestaurantManager{
    //Restaurant object
    static Restaurant restaurant;
    //Home Page
    static HomePage homePage;
    //Login Page
    static Login login;
    //Table Page
    static TablePage tablePage;
    //Server Page
    static ServerPage serverPage;
    //Admin Page
    static AdminPage adminPage;
    //Printer Page
    static PrinterPage printerPage;
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
        homePage = new HomePage( pw, ph );
        printerPage = new PrinterPage( pw, ph );

        //set the feel and look
        /*try { 
            UIManager.setLookAndFeel( "javax.swing.plaf.nimbus.NimbusLookAndFeel"); //UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        frame = new JFrame();
        frame.setLayout( grid);
        frame.setMinimumSize( new Dimension( w, h ) );
        initPages();
        frame.pack();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }

    public static Restaurant getRestaurant(){
        return restaurant;
    }

    public static Menu getMenu( ){
        return restaurant.menu;
    }

    public static MenuItem getMenuItem( int i ){
        return restaurant.menu.menuItems.get(i);
    }

    public void initPages(){
        c.gridx = 0;
        c.gridy = 0;
        frame.add( homePage.panel, c );

        c.gridx = 0;
        c.gridy = 0;
        login.panel.setVisible( false );
        frame.add( login.panel, c );
        
        c.gridx = 0;
        c.gridy = 0;
        tablePage.panel.setVisible( false );
        frame.add( tablePage.panel, c );

        c.gridx = 0;
        c.gridy = 0;
        serverPage.panel.setVisible( false );
        frame.add( serverPage.panel, c );

        c.gridx = 0;
        c.gridy = 0;
        adminPage.panel.setVisible( false );
        frame.add( adminPage.panel, c );

        c.gridx = 0;
        c.gridy = 0;
        printerPage.panel.setVisible( false );
        frame.add( printerPage.panel, c );
        if ( verbose ){
            System.out.println( "Screens Initialized" );
        }
    }
    
    public static void exitToHome( JPanel panel ){
        panel.setVisible(false);
        homePage.panel.setVisible(true);
    }

    public static String floatToString(Float f, boolean b) {
        String num = "";
        if (b) {
            num = "$";
        }
        num += String.format("%.02f", f);
        return num;
    }
}