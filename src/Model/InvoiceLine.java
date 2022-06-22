/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Manar
 */
public class InvoiceLine {
    private String itemName;
    private Double itemPrice;
    private int count;
    private InvoiceHeader invoiceHeader;
    
    
    public InvoiceLine(String itemName, Double itemPrice, int count, InvoiceHeader invoiceHeader){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.invoiceHeader = invoiceHeader;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(InvoiceHeader invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }
     public double getLineTotal() {
        return count * itemPrice;
    }
    
    public String getDataAsCSV() {
        return "" + getInvoiceHeader().getInvoiceNumber()+ "," + getItemName() + "," + getItemPrice() + "," + getCount();
    }
    
}
