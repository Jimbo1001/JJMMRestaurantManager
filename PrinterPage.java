import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class PrinterPage{
    JPanel panel = new JPanel();
    GridBagConstraints c = new GridBagConstraints();
    
    ArrayList<JPanel> receiptPanels;
    PrinterPage( int w, int h ){
        panel.setLayout( new GridBagLayout() );
        panel.setPreferredSize( new Dimension(w, h) );
        receiptPanels = new ArrayList<JPanel>();
    }

    public void drawReceipts(){
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }
}