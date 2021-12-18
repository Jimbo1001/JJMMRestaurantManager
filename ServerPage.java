import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ServerPage{
    static int tableIndex;
    JPanel panel = new JPanel();

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    boolean verbose = false;
    Table activeTable;

    Dimension buttonSize;
    Dimension panelSize;
    Dimension leftPanelSize;
    Dimension rightPanelSize;
    Dimension labelSize;
    ServerPage( int w, int h ){
        tableIndex = 0;
        activeTable = new Table();
        int leftPanelWidth = (int)(w/1.5);
        int secondPanelWidth = (int)(w/4);
        panelSize = new Dimension( w, h );
        buttonSize = new Dimension( (int)(w/5), (int)(h/15) );
        
        leftPanelSize = new Dimension( leftPanelWidth, (int)(h - (h/5)) );
        rightPanelSize = new Dimension( secondPanelWidth, (int)(h - (h/5)) );
        //optionPanelSize = new Dimension( (int)(w - (w/50)), (int)(h - (h/15)) );
        labelSize  = new Dimension( (int)(w/5) / 2, (int)(h/15) / 2 );

        panel.setLayout( grid );
        panel.setPreferredSize( panelSize );

        drawReceiptPanel( );
        drawMenuPanel( );
        drawClosePanel( );
        drawMenuCustomPanel( );

        panel.setBackground( Color.red );
    }
    JScrollPane receiptPane = new JScrollPane();
    JPanel receiptPanel = new JPanel(); 
    public void drawReceiptPanel(){
        receiptPanel.removeAll();
        receiptPanel.repaint();
        receiptPanel.revalidate();

        receiptPane.setLayout( new ScrollPaneLayout() );
        receiptPane.setPreferredSize( leftPanelSize );

        receiptPanel.setLayout( grid );
        if(activeTable.receipt.itemList != null){
            int i = 0;
            for(; i < activeTable.receipt.itemList.size(); i++){
                JLabel itemName = new JLabel(activeTable.receipt.itemList.get(i).name);
                itemName.setHorizontalAlignment( SwingConstants.LEFT );
                itemName.setPreferredSize( labelSize );
                c.gridx = 0;
                c.gridy = i;
                receiptPanel.add( itemName, c );
                JLabel itemPrice = new JLabel( "" + RestaurantManager.floatToString( activeTable.receipt.itemList.get(i).price, false) );
                itemPrice.setHorizontalAlignment( SwingConstants.RIGHT );
                itemPrice.setPreferredSize( labelSize );
                c.gridx = 1;
                c.gridy = i;
                receiptPanel.add( itemPrice, c );
                //remove item
                final int ii = i;
                JButton remove = new JButton("X");
                remove.addActionListener( new ActionListener(){
                        public void actionPerformed( ActionEvent e ){
                            RestaurantManager.restaurant.tables.get(tableIndex).receipt.itemList.remove(ii);
                            RestaurantManager.serverPage.drawReceiptPanel();
                        }
                    }
                );
                c.gridx = 2;
                c.gridy = i;
                receiptPanel.add(remove, c);
            }
            
            JLabel subTotalLabel1 = new JLabel( "Sub Total: " );
            subTotalLabel1.setHorizontalAlignment( SwingConstants.LEFT);
            subTotalLabel1.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = i + 1;
            receiptPanel.add( subTotalLabel1, c );

            JLabel subTotalLabel2 = new JLabel( "" + RestaurantManager.floatToString( activeTable.receipt.getSubTotal(), true ) );
            subTotalLabel2.setHorizontalAlignment( SwingConstants.RIGHT);
            subTotalLabel2.setPreferredSize( labelSize );
            c.gridx = 1;
            c.gridy = i + 1;
            receiptPanel.add( subTotalLabel2, c );

            JLabel taxLabel1 = new JLabel( "Tax: " );
            taxLabel1.setHorizontalAlignment( SwingConstants.LEFT);
            taxLabel1.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = i + 2;
            receiptPanel.add( taxLabel1, c );

            JLabel taxLabel2 = new JLabel( "" + RestaurantManager.floatToString( activeTable.receipt.getTax(), true ) );
            taxLabel2.setHorizontalAlignment( SwingConstants.RIGHT);
            taxLabel2.setPreferredSize( labelSize );
            c.gridx = 1;
            c.gridy = i + 2;
            receiptPanel.add( taxLabel2, c );
 
            JLabel totalLabel1 = new JLabel( "Total: " );
            totalLabel1.setHorizontalAlignment( SwingConstants.LEFT);
            totalLabel1.setPreferredSize( labelSize );
            c.gridx = 0;
            c.gridy = i + 3;
            receiptPanel.add( totalLabel1, c );

            JLabel totalLabel2 = new JLabel( "" + RestaurantManager.floatToString( activeTable.receipt.getTotal(), true ) );
            totalLabel2.setHorizontalAlignment( SwingConstants.RIGHT);
            totalLabel2.setPreferredSize( labelSize );
            c.gridx = 1;
            c.gridy = i + 3;
            receiptPanel.add( totalLabel2, c );
        }
        
        
        c.gridx = 0;
        c.gridy = 0;
        receiptPane.getViewport().add(receiptPanel, null);
        panel.add( receiptPane, c );
    }

    JScrollPane menuPane = new JScrollPane();
    JPanel menuPanel = new JPanel();
    public void drawMenuPanel(){
        //Remove, repaint, revalidate
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();

        //sort the menu items
        RestaurantManager.getMenu().menuItems = RestaurantManager.getMenu().sortByName( RestaurantManager.getMenu().menuItems, "ascending" );
        
        //set the layout of the menu pane
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

                        //drawMenuCustomPanel();
                        menuCustomPane.setVisible(true);
                        menuPane.setVisible(false);
                        closePanel.setVisible(false);
                        
                    }
                }
            );
            c.gridx = 0; 
            c.gridy = i;
            menuPanel.add( itemBtn, c );
        }

        //ask are you sure (doesnt yet)
        JButton closeBill = new JButton("Close Bill");
        closeBill.setPreferredSize( buttonSize );
        closeBill.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    closePanel.setVisible( true );
                    menuPane.setVisible(false);
                }
            }
        );
        c.gridx = 0;
        c.gridy = i + 1;
        menuPanel.add( closeBill, c );
        //ask are you sure (doesnt yet)

        JButton exit = new JButton("Exit");
        exit.setPreferredSize( buttonSize );
        exit.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    RestaurantManager.exitToHome( panel );
                }
            }
        );
        c.gridx = 0;
        c.gridy = i + 2;
        menuPanel.add( exit, c );

        menuPane.getViewport().add( menuPanel, null);
        c.gridx = 1;
        c.gridy = 0;
        panel.add( menuPane, c );
        menuPane.setVisible(true);
    }

    JScrollPane menuCustomPane = new JScrollPane();
    JPanel menuCustomPanel = new JPanel();
    public void drawMenuCustomPanel(){
        menuCustomPanel.removeAll();
        menuCustomPanel.repaint();
        menuCustomPanel.revalidate();
        
        //sort the menu items
        RestaurantManager.getMenu().customItems = RestaurantManager.getMenu().sortByName( RestaurantManager.getMenu().customItems, "ascending" );

        menuCustomPane.setLayout( new ScrollPaneLayout() );

        menuCustomPanel.setPreferredSize( rightPanelSize );
        menuCustomPanel.setLayout( grid );
        int i = 0;
        for (; i < RestaurantManager.getMenu().customItems.size(); i++){
            JButton itemBtn = new JButton( RestaurantManager.getMenu().customItems.get(i).name );
            itemBtn.setPreferredSize(buttonSize);
            final int ii = i;
            itemBtn.addActionListener( new ActionListener(){
                    public void actionPerformed( ActionEvent e ){
                        System.out.println("ok2");
                        activeTable.receipt.itemList.add( RestaurantManager.getMenu().customItems.get(ii) );
                        drawReceiptPanel();
                    }
                }
            );
            c.gridx = 0; 
            c.gridy = i;
            menuCustomPanel.add( itemBtn, c );
        }

        JButton doneBtn = new JButton("Done");
        doneBtn.setPreferredSize( buttonSize );
        doneBtn.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    menuPane.setVisible(true);
                    menuCustomPane.setVisible(false);
                }
            }
        );
        c.gridx = 0;
        c.gridy = i + 2;
        menuCustomPanel.add( doneBtn, c );

        menuCustomPane.getViewport().add( menuCustomPanel, null);
        c.gridx = 1;
        c.gridy = 0;
        panel.add( menuCustomPane, c );
    }

    JPanel closePanel = new JPanel();
    public void drawClosePanel(){
        closePanel.removeAll();
        closePanel.repaint();
        closePanel.revalidate();

        closePanel.setPreferredSize( rightPanelSize );
        closePanel.setLayout( grid );

        JButton printReceiptBtn = new JButton("Print Receipt");
        printReceiptBtn.setPreferredSize(buttonSize);
        printReceiptBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    RestaurantManager.printerPage.tableIndex = tableIndex;
                    panel.setVisible(false);
                    RestaurantManager.printerPage.panel.setVisible(true);
                }
            }
        );
        c.gridx = 0;
        c.gridy = 2;
        closePanel.add( printReceiptBtn, c );

        JButton closeTableBtn = new JButton("Close Table");
        closeTableBtn.setPreferredSize(buttonSize);
        closeTableBtn.addActionListener( new ActionListener(){
                public void actionPerformed( ActionEvent e ){
                    RestaurantManager.restaurant.tables.get(tableIndex).receipt = new Receipt();
                    RestaurantManager.exitToHome( panel );
                    
                    menuCustomPane.setVisible(true);
                    menuPane.setVisible(false);
                    closePanel.setVisible(false);
                }
            }
        );
        c.gridx = 0;
        c.gridy = 3;
        closePanel.add( closeTableBtn, c );

        JButton back = new JButton("Back");
        back.setPreferredSize( buttonSize );
        back.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                    menuPane.setVisible(true);
                    closePanel.setVisible(false);
                }
            }
        );
        c.gridx = 0;
        c.gridy = 4;
        closePanel.add( back, c );

        c.gridx = 1;
        c.gridy = 0;
        panel.add( closePanel, c );
        closePanel.setVisible(false);
    }

    public void setActiveTable( Table t ){
        activeTable = t;
    }
}