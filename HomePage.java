import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HomePage{
    JPanel panel = new JPanel();
    JPanel infoPanel = new JPanel();

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    Dimension buttonSize;

    HomePage( int w, int h){
        buttonSize = new Dimension( (int)w/12, (int)h/12 );
        panel.setLayout( grid );
        panel.setPreferredSize( new Dimension( w, h ) );
        panel.setBackground(Color.black);

        infoPanel.setLayout( grid );
        infoPanel.setPreferredSize( new Dimension( w - (int)(w/10), h - (int)(h/10) ) );
        c.gridx = 0;
        c.gridy = 0;
        panel.add( infoPanel, c );
        infoPanel.setVisible(false);
        
        JButton signBtn = new JButton("Sign In");
        signBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    panel.setVisible(false);
                    RestaurantManager.login.panel.setVisible(true);
                }
            }
        );
        c.gridx = 0;
        c.gridy = 0;
        panel.add(signBtn, c);

        JButton clockInBtn = new JButton("Clock In");
        clockInBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    panel.setVisible(false);
                    RestaurantManager.login.panel.setVisible(true);
                }
            }
        );
        c.gridx = 0;
        c.gridy = 1;
        panel.add(clockInBtn, c);

        JButton clockOutBtn = new JButton("Clock Out");
        clockOutBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    panel.setVisible(false);
                    RestaurantManager.login.panel.setVisible(true);
                }
            }
        );
        c.gridx = 1;
        c.gridy = 1;
        panel.add(clockOutBtn, c);

        JButton infoBtn = new JButton("Info");
        infoBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    signBtn.setVisible(false);
                    infoBtn.setVisible(false);
                    clockInBtn.setVisible(false);
                    clockOutBtn.setVisible(false);
                    infoPanel.setVisible(true);
                }
            }
        );
        c.gridx = 1;
        c.gridy = 0;
        panel.add(infoBtn, c);

        JButton back = new JButton("Back");
        back.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    signBtn.setVisible(true);
                    infoBtn.setVisible(true);
                    clockInBtn.setVisible(true);
                    clockOutBtn.setVisible(true);
                    infoPanel.setVisible(false);
                }
            }
        );
        c.gridx = 0;
        c.gridy = 0;
        infoPanel.add(back, c);
    }

}