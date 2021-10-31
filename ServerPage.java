import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ServerPage{
    JPanel panel = new JPanel();

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    boolean verbose = false;

    Dimension buttonSize  = new Dimension( 100, 50 );

    ServerPage( int w, int h ){
        panel.setLayout( grid );
        panel.setPreferredSize( new Dimension( w, h ) );
        int mw = w - (int)(w / 1.5f);
        int rw = w - (int)(w / 1.75f);
        int ph = h - (int)(h / 10);

        JPanel receiptPanel = new JPanel();
        receiptPanel.setPreferredSize( new Dimension( mw, ph ) );
        c.gridx = 0;
        c.gridy = 0;
        receiptPanel.setBackground(Color.blue);
        panel.add( receiptPanel, c );

        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize( new Dimension( rw, ph) );
        c.gridx = 1;
        c.gridy = 0;
        panel.add( menuPanel, c );

        JButton exit = new JButton("Exit");
        exit.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ){
                RestaurantManager.login.panel.setVisible( true );
                panel.setVisible( false );
            }
        });
        c.gridx = 0;
        c.gridy = 100;
        menuPanel.add( exit, c );
        panel.setBackground( Color.red );
    }
}