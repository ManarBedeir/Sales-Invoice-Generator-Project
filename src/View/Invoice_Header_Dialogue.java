/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Manar
 */
public class Invoice_Header_Dialogue extends JDialog{
    private JLabel customerNameLb;
    private JLabel invoiceDateLb;
    private JTextField customerName;
    private JTextField invoiceDate;
    private JButton ok;
    private JButton cancel;
    
    public Invoice_Header_Dialogue(InvoiceFrame frame) {
        customerNameLb = new JLabel("Customer Name:");
        customerName = new JTextField(20);
        invoiceDateLb = new JLabel("Invoice Date:");
        invoiceDate = new JTextField(20);
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        
        ok.setActionCommand("createInvOK");
        cancel.setActionCommand("createInvCancel");
        
        ok.addActionListener(frame.getListener());
        cancel.addActionListener(frame.getListener());
        setLayout(new GridLayout(3, 2));
        
        add(invoiceDateLb);
        add(invoiceDate);
        add(customerNameLb);
        add(customerName);
        add(ok);
        add(cancel);
        
        pack();
        
    }
    public JTextField getCustomerName() {
        return customerName;
    }

    public JTextField getInvoiceDate() {
        return invoiceDate;
    }
    
}
