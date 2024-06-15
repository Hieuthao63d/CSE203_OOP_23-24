/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Phan Thao
 */
public class CDStoreApp extends JFrame {

    private JTable table;
    private JTextField txtSearch;
    private JButton btnNewCD, btnSearch, btnDelete, btnBackup, btnRestore, btnRefresh;
    private CDCollection cdCollection;
    private CD lastDeletedCD; // To store last deleted CD for restore functionality
    private static final int expectedColumnCount = 5;
    private JComboBox<String> cbSearchType;

    public CDStoreApp() {
        setTitle("CD Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        cdCollection = new CDCollection();

        initializeComponents();
        layoutComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        table = new JTable(new DefaultTableModel(new Object[]{"ID", "Title", "Collection", "Type", "Price"}, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnNewCD = new JButton("New CD");
        btnBackup = new JButton("Backup");
        btnRestore = new JButton("Restore");
        btnRefresh = new JButton("Refresh");
        btnDelete = new JButton("Delete");
        btnSearch = new JButton("Search");

        txtSearch = new JTextField(10);
        String[] searchOptions = {"Type", "Title", "Collection"};
        cbSearchType = new JComboBox<>(searchOptions); // ComboBox for selecting search type
        cbSearchType.setSelectedIndex(0);

        btnNewCD.addActionListener(e -> displayNewCDFrame());
        btnRefresh.addActionListener(e -> refreshCDList());
        btnDelete.addActionListener(e -> deleteCD());
        btnRestore.addActionListener(e -> restoreCD());
        btnBackup.addActionListener(e -> backupDataToFile());

        btnSearch.addActionListener(e -> searchCD());
        layoutComponents();
    }

    private void layoutComponents() {
        JPanel topPanel = new JPanel();
        topPanel.add(btnNewCD);
        topPanel.add(btnBackup);
        topPanel.add(btnRestore);
        topPanel.add(btnRefresh);
        topPanel.add(btnDelete);
        add(topPanel, BorderLayout.NORTH);
        

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Search:"));
        bottomPanel.add(txtSearch);
        bottomPanel.add(btnSearch);
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search by:"));
        searchPanel.add(cbSearchType);  // Thêm JComboBox vào panel
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);
        add(searchPanel, BorderLayout.SOUTH);
        
    }

    private void displayNewCDFrame() {
        CDAddFrame cdAddFrame = new CDAddFrame(cdCollection);
        cdAddFrame.setVisible(true);
    }

    private void refreshCDList() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clears the table

        try (BufferedReader reader = new BufferedReader(new FileReader("D://CD.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == expectedColumnCount) { // Make sure the data array has the correct length
                    model.addRow(data);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading from file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteCD() {
        int selectedRow = table.getSelectedRow(); // Lấy hàng được chọn
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            // Lưu thông tin CD trước khi xóa
            lastDeletedCD = new CD(model.getValueAt(selectedRow, 0).toString(),
                    model.getValueAt(selectedRow, 1).toString(),
                    model.getValueAt(selectedRow, 2).toString(),
                    model.getValueAt(selectedRow, 3).toString(),
                    Double.parseDouble(model.getValueAt(selectedRow, 4).toString()));
            model.removeRow(selectedRow); // Xóa hàng
        }
    }

    private void restoreCD() {
        if (lastDeletedCD != null) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{lastDeletedCD.getId(), lastDeletedCD.getTitle(),
                lastDeletedCD.getCollection(), lastDeletedCD.getType(),
                lastDeletedCD.getPrice()});
            lastDeletedCD = null; // Reset sau khi khôi phục
        }
    }

    private void backupDataToFile() {
        File file = new File("D://CD.txt"); // Đường dẫn đến file
        try (PrintWriter writer = new PrintWriter(file)) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    sb.append(model.getValueAt(i, j));
                    if (j < model.getColumnCount() - 1) {
                        sb.append(","); // Thêm dấu phẩy giữa các giá trị
                    }
                }
                writer.println(sb.toString()); // Ghi dữ liệu vào file
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchCD() {
        String searchText = txtSearch.getText().toLowerCase();
        String searchType = cbSearchType.getSelectedItem().toString().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Depending on the search type, set the column index for filter
        int columnIndex = -1;
        switch (searchType) {
            case "title":
                columnIndex = 1; // Assuming title is at column index 1
                break;
            case "collection":
                columnIndex = 2; // Assuming collection is at column index 2
                break;
            case "type":
                columnIndex = 3; // Assuming type is at column index 3
                break;
        }
        if (columnIndex != -1) {
            sorter.setRowFilter(RowFilter.regexFilter(searchText, columnIndex));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CDStoreApp());
    }
}
