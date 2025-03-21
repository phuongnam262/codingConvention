package studentdemo;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

public class JFStudent extends javax.swing.JFrame {

    List<Student> list = new ArrayList<Student>();
    Student x;
    private static int pos = 0;
    private static int check = 0;
    JPanel panel;

    public JFStudent() {
        initComponents();
        this.jPanel1.setBackground(Color.GRAY);
        list.add(new Student("1111", "Nguyen Anh", 20));
        list.add(new Student("2222", "Le Duong", 20));
        list.add(new Student("3333", "Le Long", 30));
        list.add(new Student("4444", "Nguyen Minh", 25));
        View();
        ViewTable();
    }

    public void View() {
        x = list.get(pos);
        this.txtID.setText(x.getID());
        this.txtName.setText(x.getName());
        this.txtAge.setText("" + x.getAge());
        OnOff(true, false);

    }

    public void ViewTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblStudent.getModel();
        model.setNumRows(0);
        int n = 1;
        for (Student x : list) {
            model.addRow(new Object[]{n++, x.getID(), x.getName(), x.getAge()});
        }

        this.tblStudent.setRowHeight(22);

    }

    public void OnOff(boolean a, boolean b) {
        this.btnSave.show(b);
        this.btnCancel.show(b);

        this.btnAdd.show(a);
        this.btnEdit.show(a);
        this.btnDel.show(a);
    }
