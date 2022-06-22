/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Manar
 */
public class InvoiceHeader {
    private int InvoiceNum;
    private Date InvoiceDate;
    private String CustomerName;
    private ArrayList <InvoiceLine> InvoiceLines;
    
    // InvoiceHeader Class constructor
    public InvoiceHeader(int num, String CustomerName,Date date)
    {
        this.InvoiceNum = num;
        this.InvoiceDate = date;
        this.CustomerName = CustomerName;
    }
    
    
    // setters and getters
    // customer name setter and getter
    public void setCustomerName(String CustomerName){
        this.CustomerName = CustomerName;
    }
    
    public String getCustomerName(){
        return CustomerName;
    }
    
    
    // InvoiceNumber setter and getter
    public void setInvoiceNumber(int invNumber){
        this.InvoiceNum = invNumber;
    }
    
    public int getInvoiceNumber(){
        return InvoiceNum;
    }
    
    
    // Invoice Date setter and getter
    public void setInvoiceDate(Date invDate){
        this.InvoiceDate = invDate;
    }
    
    public Date getInvoiceDate(){
        return InvoiceDate;
    }
    
    
    // Invoice lines setter and getter
    public void setLines(ArrayList <InvoiceLine> InvoiceLines) {
        this.InvoiceLines = InvoiceLines;
    }
    
    public ArrayList <InvoiceLine> getLines() {
        if (InvoiceLines== null){
            InvoiceLines= new ArrayList<>();}
        return InvoiceLines;
    }
     @Override
    public String toString() {
        String str = "Header{" + "invoice Number =" + InvoiceNum + ", customer Name=" + CustomerName + ", invoice Date=" + InvoiceDate + '}';
        for (InvoiceLine line : getLines()) {
            str += "\n\t" + line;
        }
        return str;
    }
    
        public double getTotal() {
        double total = 0.0;
        for (InvoiceLine line : getLines()) {
            total += line.getLineTotal();
        }
        return total;
    }
        
    public void addLine(InvoiceLine line) {
        getLines().add(line);
    }
    
    public String getDataAsCSV() {
        DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvoiceNumber() + "," + dateformat.format(getInvoiceDate()) + "," + getCustomerName();
    }

}
