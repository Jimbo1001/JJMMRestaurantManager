import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ServerPage{
    JPanel panel = new JPanel();

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    boolean verbose = false;
    Table activeTable;

    Dimension buttonSize;
    Dimension panelSize;
    Dimension leftPanelSize;
    Dimension rightPanelSize;
    ServerPage( int w, int h){
        activeTable = new Table();
        int leftPanelWidth = (int)(w/1.5);
        int secondPanelWidth = (int)(w/4);
        panelSize = new Dimension( w, h );
        buttonSize = new Dimension( (int)(w/5), (int)(h/15) );
        
        leftPanelSize = new Dimension( leftPanelWidth, (int)(h - (h/5)) );
        rightPanelSize = new Dimension( secondPanelWidth, (int)(h - (h/5)) );
        /*optionPanelSize = new Dimension( (int)(w - (w/50)), (int)(h - (h/15)) );
        labelSize =  new Dimension( leftPanelWidth-(int)(leftPanelWidth/10), (int)(h/15) );*/

        panel.setLayout( grid );
        panel.setPreferredSize( panelSize );

        drawReceiptPanel( );
        drawMenuPanel( );

        JButton exit = new JButton("Exit");
        exit.setPreferredSize( buttonSize );
        exit.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    RestaurantManager.login.panel.setVisible( true );
                    panel.setVisible( false );
                }
            }
        );
        c.gridx = 0;
        c.gridy = 100;
        menuPanel.add( exit, c );
        panel.setBackground( Color.red );
    }
    JScrollPane receiptPane = new JScrollPane();
    JPanel receiptPanel = new JPanel(); 
    public void drawReceiptPanel(){
        receiptPanel.removeAll();
        receiptPanel.repaint();
        receiptPanel.revalidate();
        receiptPanel.setBackground(Color.blue);

        receiptPane.setLayout( new ScrollPaneLayout() );
        receiptPane.setPreferredSize( leftPanelSize );

        receiptPanel.setLayout( grid );
        if(activeTable.receipt.itemList != null){
            int i = 0;
            for(; i < activeTable.receipt.itemList.size(); i++){
                JLabel item = new JLabel(activeTable.receipt.itemList.get(i).name 
                                        + " " + activeTable.receipt.itemList.get(i).price);
                c.gridx = 0;
                c.gridy = i;
                receiptPanel.add( item, c );
            }
            JLabel subTotalLabel = new JLabel( "Sub Total: " + activeTable.receipt.getSubTotal() );
            c.gridx = 0;
            c.gridy = i + 1;
            receiptPanel.add( subTotalLabel, c );

            JLabel taxLabel = new JLabel( "Tax: " + activeTable.receipt.getTax() );
            c.gridx = 0;
            c.gridy = i + 2;
            receiptPanel.add( taxLabel, c );
 
            JLabel totalLabel = new JLabel( "Total: " + activeTable.receipt.getTotal() );
            c.gridx = 0;
            c.gridy = i + 3;
            receiptPanel.add( totalLabel, c );
        }

        
        c.gridx = 0;
        c.gridy = 0;
        receiptPane.getViewport().add(receiptPanel, null);
        panel.add( receiptPane, c );
    }

    JScrollPane menuPane = new JScrollPane();
    JPanel menuPanel = new JPanel();
    public void drawMenuPanel(){
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();

        menuPane.setLayout( new ScrollPaneLayout() );

        menuPanel.setPreferredSize( rightPanelSize );
        menuPanel.setLayout( grid );
        int i = 0;
        for (; i < RestaurantManager.getMenu().menuItems.size(); i++){
            JButton itemBtn = new JButton( RestaurantManager.getMenu().menuItems.get(i).name );
            itemBtn.setPreferredSize(buttonSize);
            final int ii = i;
            itemBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        System.out.println("ok");
                        activeTable.receipt.itemList.add( RestaurantManager.getMenu().menuItems.get(ii) );
                        drawReceiptPanel();
                    }
                }
            );
            c.gridx = 0; 
            c.gridy = i;
            menuPanel.add( itemBtn, c );
        }
        menuPane.getViewport().add( menuPanel, null);
        c.gridx = 1;
        c.gridy = 0;
        panel.add( menuPane, c );
    }

    public void setActiveTable( Table t ){
        activeTable = t;
    }
}