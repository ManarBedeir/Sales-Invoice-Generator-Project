/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Manar
 */
public class Line_Table_Model extends AbstractTableModel{
     private ArrayList<InvoiceLine> LinesList;
    private DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

    public Line_Table_Model(ArrayList<InvoiceLine> LinesList) {
        this.LinesList = LinesList;
    }
    

    @Override
    public int getRowCount() {
       return LinesList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

   
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Item Name";
            case 1:
                return "Item Price";
            case 2:
                return "Count";
            case 3:
                return "Line Total";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Integer.class;
            case 3:
                return Double.class;
            default:
                return Object.class;
        }
    }

  
    @Override
    public Object getValueAt(int row, int column) {
        InvoiceLine Row = LinesList.get(row);
        
        switch (column) {
            case 0:
                return Row.getItemName();
            case 1:
                return Row.getItemPrice();
            case 2:
                return Row.getCount();
            case 3:
                return Row.getLineTotal();
            default:
                return "";
        }
        
    }
    
    public ArrayList<InvoiceLine> getLineLines() {
        return LinesList;
    }
    
}
