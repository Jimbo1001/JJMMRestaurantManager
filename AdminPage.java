import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class AdminPage{
    JPanel panel = new JPanel();
 
    GridBagConstraints c = new GridBagConstraints();
    GridBagLayout grid = new GridBagLayout();
    
    JPanel buttonPanel = new JPanel();
    Dimension buttonSize;
    JLabel promptField = new JLabel();
    JTextField inputField = new JTextField();

    JPanel adminPanel = new JPanel();
        JLabel adminLabel = new JLabel( "Enter new admin ID" );
        JTextField adminField = new JTextField("");
        JButton adminEnterButton = new JButton();

    AdminPage( int w, int h ){
        Dimension panelSize = new Dimension( w, h );
        buttonSize = new Dimension( (int)(w/15), (int)(h/20) );
        panel.setLayout( grid );
        panel.setPreferredSize( panelSize );
        panel.setBackground(Color.black);
        
        //Button Panel
        buttonPanel.setLayout( grid );
        buttonPanel.setPreferredSize( new Dimension( (int)(w - (w/50)), (int)(h/15) ) );
        
        //Admin Panel
        c.gridx = 0;
        c.gridy = 0;
        adminPanel.add( adminLabel, c );
        adminField.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 1;
        adminPanel.add( adminField, c );
        adminEnterButton.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 2;
        adminPanel.add( adminEnterButton, c );

        c.gridx = 0;
        c.gridy = 1;
        adminPanel.setPreferredSize( new Dimension( (int)(w - (w/50)), h - (int)(h/5)) );
        panel.add( adminPanel, c );
       
        JButton adminEmployeeBtn = new JButton("Admins");
        adminEmployeeBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    adminPanel.setVisible(true);
                }
            }
        );
        adminEmployeeBtn.setPreferredSize( buttonSize );
        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add( adminEmployeeBtn );
        
        c.gridx = 0;
        c.gridy = 0;
        panel.add( buttonPanel, c );
    }

}