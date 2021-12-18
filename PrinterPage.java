import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class PrinterPage {
    JPanel panel = new JPanel();
    GridBagConstraints c = new GridBagConstraints();

    JPanel buttonPanel  = new JPanel(); //panel with buttons
    JPanel splitPanel   = new JPanel(); //panel with bill splitting options
    JPanel receiptPanel = new JPanel(); //panel with receipt
    
    Dimension buttonSize;
    Dimension panelSize;
    Dimension leftPanelSize;
    Dimension rightPanelSize;

    static int tableIndex = 0;
    private int splitAmt = 1;

    Dimension labelSize;
    PrinterPage(int w, int h) {
        labelSize = new Dimension( (int)(w/5) / 2, (int)(h/15) / 2 );
        panel.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(w, h));
        
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setPreferredSize(new Dimension( new Dimension((int)(w - (w/50)), (int)(h/15))));
        JButton splitOneBtn = new JButton("Split Bill");
        splitReceiptBtn.setPreferredSize(labelSize);
        splitReceiptBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (splitAmt<=4) {
                    splitAmt++;
                }
            }
        });
        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add(splitReceiptBtn, c);

        JButton printReceiptBtn = new JButton("Print Bill");
        printReceiptBtn.setPreferredSize(labelSize);
        printReceiptBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("print receipt");
            }
        });
        c.gridx = 1;
        c.gridy = 0;
        buttonPanel.add(printReceiptBtn, c);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(buttonPanel, c);

        drawReceipt(w, h);
    }

    public void drawReceipt(int w, int h) {
        receiptPanel.removeAll();
        receiptPanel.repaint();
        receiptPanel.revalidate();
        receiptPanel.setLayout(new GridBagLayout());
        Table activeTable = RestaurantManager.restaurant.tables.get(tableIndex);
        int i = 0;
        for (; i < activeTable.receipt.itemList.size(); i++) { //RestaurantManager.restaurant.tables.get(tableIndex).receipt.itemList.size(); i++){
            JLabel itemName = new JLabel(RestaurantManager.restaurant.tables.get(tableIndex).receipt.itemList.get(i).name + "");
            c.gridx = 0;
            c.gridy = i;
            receiptPanel.add(itemName, c);

            JLabel itemPrice = new JLabel((RestaurantManager.restaurant.tables.get(tableIndex).receipt.itemList.get(i).price / splitAmt) + "");
            c.gridx = 1;
            c.gridy = i;
            receiptPanel.add(itemPrice, c);
        }

        JLabel subTotalLabel1 = new JLabel("Subtotal: ");
        subTotalLabel1.setHorizontalAlignment( SwingConstants.LEFT);
        subTotalLabel1.setPreferredSize(labelSize);
        c.gridx = 0;
        c.gridy = i + 1;
        receiptPanel.add(subTotalLabel1, c);

        JLabel subTotalLabel2 = new JLabel("" + RestaurantManager.floatToString(RestaurantManager.restaurant.tables.get(tableIndex).receipt.getSubTotal(), true));
        subTotalLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        subTotalLabel2.setPreferredSize(labelSize);
        c.gridx = 1;
        c.gridy = i + 1;
        receiptPanel.add(subTotalLabel2, c);

        JLabel taxLabel1 = new JLabel("Tax: ");
        taxLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        taxLabel1.setPreferredSize(labelSize);
        c.gridx = 0;
        c.gridy = i + 2;
        receiptPanel.add(taxLabel1, c);

        JLabel taxLabel2 = new JLabel("" + RestaurantManager.floatToString(activeTable.receipt.getTax(), true));
        taxLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        taxLabel2.setPreferredSize(labelSize);
        c.gridx = 1;
        c.gridy = i + 2;
        receiptPanel.add(taxLabel2, c);

        JLabel totalLabel1 = new JLabel("Total: ");
        totalLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        totalLabel1.setPreferredSize(labelSize);
        c.gridx = 0;
        c.gridy = i + 3;
        receiptPanel.add(totalLabel1, c);

        JLabel totalLabel2 = new JLabel("" + RestaurantManager.floatToString(activeTable.receipt.getTotal(), true));
        totalLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        totalLabel2.setPreferredSize(labelSize);
        c.gridx = 1;
        c.gridy = i + 3;
        receiptPanel.add(totalLabel2, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(receiptPanel, c);
    }
}
