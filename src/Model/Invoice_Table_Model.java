/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Manar
 */
public class Invoice_Table_Model extends AbstractTableModel {
    private ArrayList<InvoiceHeader> invoiceList;
    DateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
            

    public Invoice_Table_Model(ArrayList<InvoiceHeader> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public ArrayList<InvoiceHeader> getInvoiceList() {
        return invoiceList;
    }
    
    
    
    @Override
    public int getRowCount() {
        return invoiceList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Invoice Number";
            case 1:
                return "Customer Name";
            case 2:
                return "Invoice Date";
            case 3:
                return "Invoice Total";
            default:
                return "";
        }
    }


    

    @Override
    public Object getValueAt(int row, int column) {
         InvoiceHeader Row = invoiceList.get(row);
        
        switch (column) {
            case 0:
                return Row.getInvoiceNumber();
            case 1:
                return Row.getCustomerName();
            case 2:
                return dateformat.format(Row.getInvoiceDate());
            case 3:
                return Row.getTotal();
            default:
                return "";
        }
    }

    
}
