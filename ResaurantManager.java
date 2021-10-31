import javax.swing.JPanel;
import javax.swing.frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class ResaurantManager{

    Restaurant restaurant;
    Login login;

    JFrame frame;
    GridBagLayout grid   = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    int w = 850; 
    int h = 500;

    ResaurantManager(){
        frame = new JFrame();
        frame.setLayout( grid);
        frame.setSize( w, h );
        initScreens();
        restaurant = new Restaurant();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }

    public void initScreens(){
        c.gridx = 0;
        c.gridy = 0;
        panel.add(login.panel, c);
    }
}