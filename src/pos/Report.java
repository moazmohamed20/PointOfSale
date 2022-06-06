package pos;

import javax.swing.JTable;

public class Report extends javax.swing.JDialog {

    private final DBManager dbManager = DBManager.getInstance();

    private String reportType;

    public Report(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        reportCB.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        reportCB = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reports");
        setMinimumSize(new java.awt.Dimension(700, 540));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setLabelFor(reportCB);
        jLabel1.setText("Report");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setLabelFor(totalLabel);
        jLabel2.setText("Total");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalLabel.setText("0.0");

        reportCB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reportCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Safe", "Expenses", "Sales", "Sale Invoices", "Returns", "Return Invoices", "Purchases", "Purchase Invoices" }));
        reportCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportCBActionPerformed(evt);
            }
        });

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        reportTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        reportTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(reportTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(reportCB, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(reportCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalLabel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reportCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportCBActionPerformed
        reportType = reportCB.getSelectedItem().toString();

        String reportQuery = "";
        String totalQuery = "";
        switch (reportType) {
            case "Purchase Invoices":
                reportQuery = "SELECT * FROM PURCHASE_INVOICES_VIEW";
                totalQuery = "SELECT SUM(TOTAL) FROM PURCHASE_INVOICES_VIEW";
                break;
                
            case "Purchases":
                reportQuery = "SELECT * FROM PURCHASES_VIEW";
                totalQuery = "SELECT SUM(TOTAL) FROM PURCHASES_VIEW";
                break;

            case "Return Invoices":
                reportQuery = "SELECT * FROM RETURN_INVOICES_VIEW";
                totalQuery = "SELECT SUM(TOTAL) FROM RETURN_INVOICES_VIEW";
                break;
                
            case "Returns":
                reportQuery = "SELECT * FROM RETURNS_VIEW";
                totalQuery = "SELECT SUM(TOTAL) FROM RETURNS_VIEW";
                break;

            case "Sale Invoices":
                reportQuery = "SELECT * FROM SALE_INVOICES_VIEW";
                totalQuery = "SELECT SUM(TOTAL) FROM SALE_INVOICES_VIEW";
                break;

            case "Sales":
                reportQuery = "SELECT * FROM SALES_VIEW";
                totalQuery = "SELECT SUM(TOTAL) FROM SALES_VIEW";
                break;

            case "Expenses":
                reportQuery = "SELECT * FROM EXPENSES_VIEW";
                totalQuery = "SELECT SUM(COST) FROM EXPENSES_VIEW";
                break;

            case "Safe":
                reportQuery = "SELECT * FROM SAFE_VIEW";
                totalQuery = "SELECT SUM(PRICE) FROM SAFE_VIEW";
                break;
        }
        totalLabel.setText(String.valueOf(calcReportTotal(totalQuery)));
        loadReport(reportQuery, reportTable);
    }//GEN-LAST:event_reportCBActionPerformed

    private void loadReport(String query, JTable resultTable) {
        dbManager.executeQuery(query);
        dbManager.fillTable(resultTable);
    }

    private double calcReportTotal(String query) {
        return dbManager.executeOperation(query);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> reportCB;
    private javax.swing.JTable reportTable;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables

}
