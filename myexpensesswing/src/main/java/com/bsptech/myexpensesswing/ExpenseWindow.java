package com.bsptech.myexpensesswing;



import com.bsptechs.service.impl.ExpenseCategoryService;
import com.bsptechs.service.impl.ExpenseService;
import com.bsptechs.service.impl.ExpenseTypeService;
import com.bsptechs.service.inter.IExpenseCategoryService;
import com.bsptechs.service.inter.IExpenseService;
import com.bsptechs.service.inter.IExpenseTypeService;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class ExpenseWindow extends javax.swing.JFrame {
    IExpenseService expenseDAO = new ExpenseService();
    IExpenseTypeService typeDAO = new ExpenseTypeService();
    IExpenseCategoryService catogoryDAO = new ExpenseCategoryService();
    

    

    public ExpenseWindow() {
        initComponents();
        allExpenses();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableExpenses = new javax.swing.JTable();
        panelTop = new javax.swing.JPanel();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        textFieldTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textFieldSearch = new javax.swing.JTextField();
        labelSearch = new javax.swing.JLabel();
        labelDescription = new javax.swing.JLabel();
        textFieldDescription = new javax.swing.JTextField();
        labelCost = new javax.swing.JLabel();
        textFieldCost = new javax.swing.JTextField();
        labelTypeId = new javax.swing.JLabel();
        labelCategoryId = new javax.swing.JLabel();
        cmbTypeId = new javax.swing.JComboBox<>();
        cmbCategoryId = new javax.swing.JComboBox<>();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tableExpenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableExpenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableExpensesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableExpenses);

        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        textFieldTitle.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                textFieldTitleInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                textFieldTitleCaretPositionChanged(evt);
            }
        });
        textFieldTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTitleActionPerformed(evt);
            }
        });
        textFieldTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldTitleKeyReleased(evt);
            }
        });

        jLabel2.setText("Title");

        textFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSearchActionPerformed(evt);
            }
        });
        textFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldSearchKeyReleased(evt);
            }
        });

        labelSearch.setText("Search");

        labelDescription.setText("Description");

        labelCost.setText("Cost");

        labelTypeId.setText("Type ");

        labelCategoryId.setText("Category ");

        cmbTypeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTopLayout.createSequentialGroup()
                        .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTopLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTopLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelCost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldCost, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelTypeId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTypeId, 0, 123, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(labelCategoryId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTopLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescription)
                    .addComponent(textFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCost)
                    .addComponent(textFieldCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTypeId)
                    .addComponent(labelCategoryId)
                    .addComponent(cmbTypeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonDelete)
                    .addComponent(buttonEdit)
                    .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSearch))
                .addGap(35, 35, 35))
        );

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReturn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturn)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed

        try {
            String title = textFieldTitle.getText();
            String description = textFieldDescription.getText();
            double cost = Double.valueOf(textFieldCost.getText());
            int typeId = typeDAO.findIdByName(String.valueOf(cmbTypeId.getSelectedItem()));
            int categoryId = catogoryDAO.findIdByName(String.valueOf(cmbCategoryId.getSelectedItem()));

            if (title.equals(null) || title.equals("")) {
                throw new Exception("Title is empty");
            } else if (description.equals(null) || description.equals("")) {
                throw new Exception("Description is empty");
            }

            Expense expense = new Expense();
            expense.setTitle(title);
            expense.setDescription(description);
            expense.setCost(cost);
            expense.setTypeId(typeId);
            expense.setCategoryId(categoryId);

            expenseDAO.addExpense(expense);

        } catch (NumberFormatException e) {
            System.out.println("Incorrect double or integer format in fields.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            allExpenses();
            refreshFields();
        }

    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.OK_OPTION) {
            int selectedRow = tableExpenses.getSelectedRow();
            int id = Integer.valueOf(String.valueOf(tableExpenses.getValueAt(selectedRow, 0)));
            expenseDAO.deleteExpense(id);
            allExpenses();
            refreshFields();
    }//GEN-LAST:event_buttonDeleteActionPerformed
    }
    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        int selectedRow = tableExpenses.getSelectedRow();
        int id = Integer.valueOf(String.valueOf(tableExpenses.getModel().getValueAt(selectedRow, 0)));
        String title = textFieldTitle.getText();
        String description = textFieldDescription.getText();
        double cost = Double.valueOf(textFieldCost.getText());
        int typeId = typeDAO.findIdByName(String.valueOf(cmbTypeId.getSelectedItem()));
        int categoryId = catogoryDAO.findIdByName(String.valueOf(cmbCategoryId.getSelectedItem()));

        Expense expense = new Expense();
        expense.setTitle(title);
        expense.setDescription(description);
        expense.setCost(cost);
        expense.setTypeId(typeId);
        expense.setCategoryId(categoryId);

        expenseDAO.editExpense(id, expense);
        allExpenses();
        refreshFields();
    }//GEN-LAST:event_buttonEditActionPerformed

    private void tableExpensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableExpensesMouseClicked
        int selectedRow = tableExpenses.getSelectedRow();
        String title = tableExpenses.getValueAt(selectedRow, 1).toString();
        String description = tableExpenses.getValueAt(selectedRow, 2).toString();
        String cost = tableExpenses.getValueAt(selectedRow, 3).toString();
        int typeId = (int) tableExpenses.getValueAt(selectedRow, 4);
        int categoryId = (int)tableExpenses.getValueAt(selectedRow, 5);
        ExpenseType type = typeDAO.find(typeId);
        textFieldTitle.setText(title);
        ExpenseCategory category = catogoryDAO.find(categoryId);
        textFieldDescription.setText(description);
        textFieldCost.setText(cost);
        cmbTypeId.setSelectedItem(type.getName());
        cmbCategoryId.setSelectedItem(category.getName());
    }//GEN-LAST:event_tableExpensesMouseClicked

    private void textFieldTitleInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textFieldTitleInputMethodTextChanged

    }//GEN-LAST:event_textFieldTitleInputMethodTextChanged

    private void textFieldTitleCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textFieldTitleCaretPositionChanged

    }//GEN-LAST:event_textFieldTitleCaretPositionChanged

    private void textFieldTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTitleActionPerformed

    }//GEN-LAST:event_textFieldTitleActionPerformed

    private void textFieldTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldTitleKeyReleased

    }//GEN-LAST:event_textFieldTitleKeyReleased

    private void textFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSearchKeyReleased
        if (textFieldSearch.getText().equals("")) {
            allExpenses();
        } else {
            String content = textFieldSearch.getText();
            List<Expense> expenses = expenseDAO.searchExpense(content);
            DefaultTableModel tm = buildTableModel(expenses);
            tableExpenses.setModel(tm);
            refreshTable(expenses);
        }
    }//GEN-LAST:event_textFieldSearchKeyReleased

    private void textFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSearchActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        this.setVisible(false);
        new MainWindow().setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void cmbTypeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeIdActionPerformed

    }//GEN-LAST:event_cmbTypeIdActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        List<ExpenseType> list = typeDAO.selectAll();
        for (ExpenseType type : list) {
            cmbTypeId.addItem(type.getName());
        }
        List<ExpenseCategory> category = catogoryDAO.selectAll();
        for (ExpenseCategory expenseCategory : category) {
            cmbCategoryId.addItem(expenseCategory.getName());
        }
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpenseWindow().setVisible(true);
            }
        });
    }

    private void refreshTable(List<Expense> expenses) {
        DefaultTableModel tm = buildTableModel(expenses);
        tableExpenses.setModel(tm);
    }

    private void refreshFields() {
        textFieldTitle.setText("");
        textFieldDescription.setText("");
        textFieldCost.setText("");
       
        textFieldSearch.setText("");

    }

    private void allExpenses() {
        List<Expense> expenses = expenseDAO.allExpenses();
        refreshTable(expenses);
    }

    private DefaultTableModel buildTableModel(List<Expense> expenses) {

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("Title");
        columnNames.add("Description");
        columnNames.add("Cost");
        columnNames.add("Type ID");
        columnNames.add("Category ID");
        columnNames.add("Date");

        Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
        for (Expense expense : expenses) {
            Vector<Object> vector = new Vector<Object>();
            vector.add(expense.getId());
            vector.add(expense.getTitle());
            vector.add(expense.getDescription());
            vector.add(expense.getCost());
            vector.add(expense.getTypeId());
            vector.add(expense.getCategoryId());
            vector.add(expense.getDate());
            rows.add(vector);
        }

        DefaultTableModel dtm = new DefaultTableModel(rows, columnNames);
        return dtm;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JComboBox<String> cmbCategoryId;
    private javax.swing.JComboBox<String> cmbTypeId;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCategoryId;
    private javax.swing.JLabel labelCost;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JLabel labelTypeId;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTable tableExpenses;
    private javax.swing.JTextField textFieldCost;
    private javax.swing.JTextField textFieldDescription;
    private javax.swing.JTextField textFieldSearch;
    private javax.swing.JTextField textFieldTitle;
    // End of variables declaration//GEN-END:variables
}
