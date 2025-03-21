package com.yourcompany.studentmanagement;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class JFStudent extends javax.swing.JFrame {

    private List<Student> studentList = new ArrayList<>();
    private Student currentStudent;
    private static int currentPosition = 0;
    private static int checkFlag = 0;
    private JPanel panel;

    public JFStudent() {
        initComponents();
        this.jPanel1.setBackground(Color.GRAY);

        studentList.add(new Student("1111", "Nguyen Anh", 20));
        studentList.add(new Student("2222", "Le Duong", 20));
        studentList.add(new Student("3333", "Le Long", 30));
        studentList.add(new Student("4444", "Nguyen Minh", 25));

        viewStudent();
        updateTable();
    }

  
    public void viewStudent() {
        currentStudent = studentList.get(currentPosition);
        this.txtID.setText(currentStudent.getId());
        this.txtName.setText(currentStudent.getName());
        this.txtAge.setText(String.valueOf(currentStudent.getAge()));
        toggleButtons(true, false);
    }

   
    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblStudent.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

        int index = 1;
        for (Student student : studentList) {
            model.addRow(new Object[]{index++, student.getId(), student.getName(), student.getAge()});
        }

        this.tblStudent.setRowHeight(22);
    }

    public void toggleButtons(boolean enableMain, boolean enableSaveCancel) {
        this.btnSave.setVisible(enableSaveCancel);
        this.btnCancel.setVisible(enableSaveCancel);

        this.btnAdd.setVisible(enableMain);
        this.btnEdit.setVisible(enableMain);
        this.btnDel.setVisible(enableMain);
    }
}
