/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ActionHandler;
import Model.InvoiceHeader;
import Model.Invoice_Table_Model;
import Model.Line_Table_Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author Manar
 */
public class InvoiceFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public InvoiceFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        HeaderTable = new javax.swing.JTable();
        HeaderTable.getSelectionModel().addListSelectionListener(handler);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        InvoiceDatetxt = new javax.swing.JTextField();
        CstNametxtField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        INVTOTlbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Linetable = new javax.swing.JTable();
        NewInvBtn = new javax.swing.JButton();
        NewInvBtn.addActionListener(handler);
        DeleteInvBtn = new javax.swing.JButton();
        DeleteInvBtn.addActionListener(handler);
        AddItemBtn = new javax.swing.JButton();
        AddItemBtn.addActionListener(handler);
        DeleteSelectedItemBtn = new javax.swing.JButton();
        DeleteSelectedItemBtn.addActionListener(handler);
        invNumlbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LoadFileBtn = new javax.swing.JMenuItem();
        LoadFileBtn.addActionListener(handler);
        SaveFilesBtn = new javax.swing.JMenuItem();
        SaveFilesBtn.addActionListener(handler);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        HeaderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeaderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(HeaderTable);

        jLabel1.setText("Invoice NO#");

        jLabel3.setText("Invoice Date");
        jLabel3.setToolTipText("");

        jLabel5.setText("Customer Name");

        jLabel7.setText("Invoice Total");

        jLabel9.setText("Invoice Data");
        jLabel9.setToolTipText("");

        INVTOTlbl.setText("0.00");

        Linetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Linetable);

        NewInvBtn.setText("Create new Invoice");
        NewInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewInvBtnActionPerformed(evt);
            }
        });

        DeleteInvBtn.setText("Delete Selected Invoice");

        AddItemBtn.setText("Add New Item");
        AddItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemBtnActionPerformed(evt);
            }
        });

        DeleteSelectedItemBtn.setText("Delete Selected Item");

        jMenu1.setText("File");

        LoadFileBtn.setText("Load Files");
        LoadFileBtn.setToolTipText("");
        LoadFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileBtnActionPerformed(evt);
            }
        });
        jMenu1.add(LoadFileBtn);

        SaveFilesBtn.setText("Save Files");
        jMenu1.add(SaveFilesBtn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CstNametxtField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(invNumlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(InvoiceDatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 7, Short.MAX_VALUE)))
                                .addGap(83, 83, 83))
                            .addComponent(INVTOTlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(NewInvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteInvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(AddItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(DeleteSelectedItemBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invNumlbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(InvoiceDatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(CstNametxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(INVTOTlbl)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewInvBtn)
                    .addComponent(DeleteInvBtn)
                    .addComponent(AddItemBtn)
                    .addComponent(DeleteSelectedItemBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HeaderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderTableMouseClicked

    }//GEN-LAST:event_HeaderTableMouseClicked

    private void LoadFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFileBtnActionPerformed

    }//GEN-LAST:event_LoadFileBtnActionPerformed

    private void NewInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewInvBtnActionPerformed

    private void AddItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddItemBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }
    
    
    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItemBtn;
    private javax.swing.JTextField CstNametxtField;
    private javax.swing.JButton DeleteInvBtn;
    private javax.swing.JButton DeleteSelectedItemBtn;
    private javax.swing.JTable HeaderTable;
    private javax.swing.JLabel INVTOTlbl;
    private javax.swing.JTextField InvoiceDatetxt;
    private javax.swing.JTable Linetable;
    private javax.swing.JMenuItem LoadFileBtn;
    private javax.swing.JButton NewInvBtn;
    private javax.swing.JMenuItem SaveFilesBtn;
    private javax.swing.JLabel invNumlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
   
    private List<InvoiceHeader> invoicesList = new ArrayList<>();
    private Invoice_Table_Model invoiceHeaderTableModel;
    private Line_Table_Model invoiceLinesTableModel;
    private Invoice_Header_Dialogue headerDialog;
    private Invoice_Line_Dialogue lineDialog;
    private ActionHandler handler = new ActionHandler(this);

    public ActionHandler getListener() {
        return handler;
    }

    public void setHeaderDialog(Invoice_Header_Dialogue headerDialog) {
        this.headerDialog = headerDialog;
    }

    public void setLineDialog(Invoice_Line_Dialogue lineDialog) {
        this.lineDialog = lineDialog;
    }

    public void setInvoiceHeaderTableModel(Invoice_Table_Model invoiceHeaderTableModel) {
        this.invoiceHeaderTableModel = invoiceHeaderTableModel;
    }

    public void setInvoiceLinesTableModel(Line_Table_Model invoiceLinesTableModel) {
        this.invoiceLinesTableModel = invoiceLinesTableModel;
    }

    public JButton getCreateInvBtn() {
        return NewInvBtn;
    }

    public JButton getCreateLineBtn() {
        return AddItemBtn;
    }

    public JTextField getCustNameTF() {
        return CstNametxtField;
    }

    public JButton getDeleteInvBtn() {
        return DeleteInvBtn;
    }

    public JButton getDeleteLineBtn() {
        return DeleteSelectedItemBtn;
    }

    public JTextField getInvDateTF() {
        return InvoiceDatetxt;
    }

    public JTable getInvLinesTable() {
        return Linetable;
    }

    public JLabel getInvNumLbl() {
        return invNumlbl;
    }

    public JLabel getInvTotalLbl() {
        return INVTOTlbl;
    }

    public JTable getInvoicesTable() {
        return HeaderTable;
    }

    public JMenuItem getLoadMenuItem() {
        return LoadFileBtn;
    }

    public JMenuItem getSaveMenuItem() {
        return SaveFilesBtn;
    }

    public List<InvoiceHeader> getInvoicesList() {
        return invoicesList;
    }

    public Invoice_Table_Model getInvoiceHeaderTableModel() {
        return invoiceHeaderTableModel;
    }

    public Line_Table_Model getInvoiceLinesTableModel() {
        return invoiceLinesTableModel;
    }

    public Invoice_Header_Dialogue getHeaderDialog() {
        return headerDialog;
    }

    public Invoice_Line_Dialogue getLineDialog() {
        return lineDialog;
    }

}
