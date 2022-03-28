package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Course;
import com.patikadev.Model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentGUI extends JFrame{
    private JPanel wrapper;

    private final Student student;
    private JTabbedPane tab_operator;
    private JPanel pnl_course_list;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JTable tbl_course_list;
    private JScrollPane scrl_course_list;
    private JLabel my_courses;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;
    private JComboBox cmb_course_user;

    public StudentGUI(Student student){
        this.student = student;

        add(wrapper);
        setSize(1000,500);
        int x= Helper.screenCenterPoint("x",getSize());
        int y= Helper.screenCenterPoint("y",getSize());
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldin, Student: " + student.getName());

        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI login=new LoginGUI();
        });

        // CourseList

        mdl_course_list= new DefaultTableModel();
        Object[] col_courseList= {"ID","Ders Adı", "Programlama Dili", "Patika","Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_courseList);
        row_course_list=new Object[col_courseList.length];
        loadCourseModel();
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);

        // ## CourseList
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i=0;
        for(Course obj: Course.getList()){
            i=0;
            row_course_list[i++]=obj.getId();
            row_course_list[i++]=obj.getName();
            row_course_list[i++]=obj.getLang();
            row_course_list[i++]=obj.getPatika().getName();
            row_course_list[i++]=obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }
    }
}
