/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.InvoiceHeader;
import Model.InvoiceLine;
import Model.Invoice_Table_Model;
import Model.Line_Table_Model;
import View.InvoiceFrame;
import View.Invoice_Header_Dialogue;
import View.Invoice_Line_Dialogue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Manar
 */
public class ActionHandler implements ActionListener,ListSelectionListener {
    private InvoiceFrame frame;
    private DateFormat dateformat=new SimpleDateFormat("dd-mm-yyyy");
    
      public ActionHandler(InvoiceFrame frame) {
        this.frame = frame;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
         System.out.println("Action Handling called ");
        switch(e.getActionCommand()){
            case "Create new Invoice":
               System.out.println("Create New Invoice");
               addNewInvoice();
                break;
            case "createInvOK":
                createInvoiceOK();
                break;
            case "createInvCancel":
                createInvCancel();
                break;
            case "Delete Selected Invoice":
                System.out.println("Delete Invoice");
                deleteInvoice();
                break;
            case "Add New Item":
                System.out.println("New Item");
                newItem();
                break;
            case "createLineOK":
                createLineOK();
                break;
            case "createLineCancel":
                createLineCancel();
                break;
            case "Delete Selected Item":
                System.out.println("Delete Item");
                deleteItem();
                break;  
            case "Load Files":
                System.out.println("Load Files");
                loadfiles();
                break; 
            case "Save Files":
                System.out.println("Save Files");
                saveFiles();
                break;         
        }
    }
    private void addNewInvoice() {
        frame.setHeaderDialog(new Invoice_Header_Dialogue(frame));
        frame.getHeaderDialog().setVisible(true);
    }
    
    private void createInvoiceOK() {
        String customerName = frame.getHeaderDialog().getCustomerName().getText();
        String invDateStr = frame.getHeaderDialog().getInvoiceDate().getText();
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
        try {
            Date invDate = dateformat.parse(invDateStr);
            int invNum = getNextInvoiceNum();
            InvoiceHeader invHead = new InvoiceHeader (invNum, customerName, invDate);
            frame.getInvoicesList().add(invHead);
            frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        displayInvoices();
    }
      private void newItem() {
        frame.setLineDialog(new Invoice_Line_Dialogue(frame));
        frame.getLineDialog().setVisible(true);
    }
      private void createLineOK() {
        String itemName = frame.getLineDialog().getItemNameField().getText();
        String itemCountStr = frame.getLineDialog().getItemCountField().getText();
        String itemPriceStr = frame.getLineDialog().getItemPriceField().getText();
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice = Double.parseDouble(itemPriceStr);
        int headerIndex = frame.getInvoicesTable().getSelectedRow();
        InvoiceHeader invoice = frame.getInvoiceHeaderTableModel().getInvoiceList().get(headerIndex);

        InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
        invoice.addLine(invoiceLine);
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.getInvTotalLbl().setText("" + invoice.getTotal());
        displayInvoices();
    }

 

    private void deleteItem() {
         int lineIndex = frame.getInvLinesTable().getSelectedRow();
        InvoiceLine line = frame.getInvoiceLinesTableModel().getLineLines().get(lineIndex);
        frame.getInvoiceLinesTableModel().getLineLines().remove(lineIndex);
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.getInvTotalLbl().setText("" + line.getInvoiceHeader().getTotal());
        displayInvoices();
    }

    private void loadfiles() {
        JOptionPane.showMessageDialog(null," Please Select Invoice Header File First","Invoice Header",JOptionPane.INFORMATION_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try {
                FileReader headerFilereader = new FileReader(headerFile);
                BufferedReader headerBuferreader = new BufferedReader(headerFilereader);
                String headerLine = null;

                while ((headerLine = headerBuferreader.readLine()) != null) {
                    String[] headerParts = headerLine.split(",");
                    String invoiceHNumStr = headerParts[0];
                    String invoiceDateStr = headerParts[1];
                    String customerName = headerParts[2];

                    int invoiceNum = Integer.parseInt(invoiceHNumStr);
                    Date invDate = dateformat.parse(invoiceDateStr);

                    InvoiceHeader inv = new InvoiceHeader(invoiceNum, customerName, invDate);
                    frame.getInvoicesList().add(inv);
                }

                JOptionPane.showMessageDialog(frame, "Please, select lines file!", "Attension", JOptionPane.INFORMATION_MESSAGE);
                result = openFile.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBuferreader = new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBuferreader.readLine()) != null) {
                        String[] lineParts = linesLine.split(",");
                        String invoiceNumStr = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];

                        int invNum = Integer.parseInt(invoiceNumStr);
                        double itemPrice = Double.parseDouble(itemPriceStr);
                        int itemCount = Integer.parseInt(itemCountStr);
                        InvoiceHeader header = findInvoiceNum(invNum);
                        InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                        header.getLines().add(invLine);
                    }
                    frame.setInvoiceHeaderTableModel(new Invoice_Table_Model((ArrayList<InvoiceHeader>) frame.getInvoicesList()));
                    frame.getInvoicesTable().setModel(frame.getInvoiceHeaderTableModel());
                    frame.getInvoicesTable().validate();
                }
                System.out.println("Check");
            } catch (ParseException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Date Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Number Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "File Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Read Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        displayInvoices();
    }

    private void saveFiles() {
        String headers = "";
        String lines = "";
        for (InvoiceHeader header : frame.getInvoicesList()) {
            headers += header.getDataAsCSV();
            headers += "\n";
            for (InvoiceLine line : header.getLines()) {
                lines += line.getDataAsCSV();
                lines += "\n";
            }
        }
        JOptionPane.showMessageDialog(frame, "Please,  save headerFile data (you can save it in old file or create a new one)", "Attension", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();
            try {
                FileWriter headerFileWriter = new FileWriter(headerFile);
                headerFileWriter.write(headers);
                headerFileWriter.flush();
                headerFileWriter.close();

                JOptionPane.showMessageDialog(frame, "Please,  save Lines File data (you can save it in old file or create a new one)", "Attension", JOptionPane.INFORMATION_MESSAGE);
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    FileWriter linesFileWriter = new FileWriter(linesFile);
                    linesFileWriter.write(lines);
                    linesFileWriter.flush();
                    linesFileWriter.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(frame, "Data saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void deleteInvoice() {
         int invIndex = frame.getInvoicesTable().getSelectedRow();
        InvoiceHeader header = frame.getInvoiceHeaderTableModel().getInvoiceList().get(invIndex);
        frame.getInvoiceHeaderTableModel().getInvoiceList().remove(invIndex);
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.setInvoiceLinesTableModel(new Line_Table_Model(new ArrayList<InvoiceLine>()));
        frame.getInvLinesTable().setModel(frame.getInvoiceLinesTableModel());
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getCustNameTF().setText("");
        frame.getInvDateTF().setText("");
        frame.getInvNumLbl().setText("");
        frame.getInvTotalLbl().setText("");
        displayInvoices();
    }

   @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Invoice Selected!");
        invoicesTableRowSelected();
    }
     private void invoicesTableRowSelected() {
        int selectedRowIndex = frame.getInvoicesTable().getSelectedRow();
        if (selectedRowIndex >= 0) {
            InvoiceHeader row = frame.getInvoiceHeaderTableModel().getInvoiceList().get(selectedRowIndex);
            frame.getCustNameTF().setText(row.getCustomerName());
            frame.getInvDateTF().setText(dateformat.format(row.getInvoiceDate()));
            frame.getInvNumLbl().setText("" + row.getInvoiceNumber());
            frame.getInvTotalLbl().setText("" + row.getTotal());
            ArrayList<InvoiceLine> lines = row.getLines();
            frame.setInvoiceLinesTableModel(new Line_Table_Model(lines));
            frame.getInvLinesTable().setModel(frame.getInvoiceLinesTableModel());
            frame.getInvoiceLinesTableModel().fireTableDataChanged();
        }
    }
    
     private InvoiceHeader findInvoiceNum(int invNum) {
        InvoiceHeader header = null;
        for (InvoiceHeader inv : frame.getInvoicesList()) {
            if (invNum == inv.getInvoiceNumber()) {
               header = inv;
                break;
            }
        }
        return header;
    }
       private int getNextInvoiceNum() {
        int max = 0;
        for (InvoiceHeader header : frame.getInvoicesList()) {
            if (header.getInvoiceNumber()> max) {
                max = header.getInvoiceNumber();
            }
        }
        return max + 1;
    }
    private void displayInvoices() {
        System.out.println("***************************");
        for (InvoiceHeader header : frame.getInvoicesList()) {
            System.out.println(header);
        }
        System.out.println("***************************");
    }

    private void createInvCancel() {
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
    }

    private void createLineCancel() {
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
    }
    

   
}
