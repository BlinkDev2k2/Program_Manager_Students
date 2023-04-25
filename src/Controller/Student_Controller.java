package Controller;

import Model.City;
import Model.Student;
import View.Students_View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.lang.System.exit;

public class Student_Controller implements ActionListener {
    private Students_View studentsView;

    public Student_Controller(Students_View studentsView) {
        this.studentsView = studentsView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        JFileChooser jFileChooser = new JFileChooser();
        switch (src){
            case "Filter":
                this.studentsView.ListStudent.setOption("Filter");
                this.studentsView.FilterSt();
                break;
            case "Save":
                try {
                    int idst = Integer.valueOf(this.studentsView.id_T.getText());
                    String namest = this.studentsView.name_T.getText();
                    short idtinh = (short) (this.studentsView.birthPlace_T2.getSelectedIndex() - 1);
                    City ct = City.getCitybyID(idtinh);
                    String dateString = this.studentsView.date_T.getText();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date birthdayst = dateFormat.parse(dateString);
                    LocalDate localDate = birthdayst.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    boolean gioitinhst = true;
                    if(this.studentsView.male.isSelected())
                        gioitinhst = true;
                    else if(this.studentsView.female.isSelected())
                        gioitinhst = false;
                    float m1 = Float.valueOf(this.studentsView.subject1_T.getText());
                    float m2 = Float.valueOf(this.studentsView.subject2_T.getText());
                    float m3 = Float.valueOf(this.studentsView.subject3_T.getText());
                    Student s1 = new Student(idst, namest, ct, localDate, gioitinhst, m1, m2, m3);
                    if(this.studentsView.ListStudent.getOption().equals("Insert") || this.studentsView.ListStudent.getOption().equals("")){
                        this.studentsView.InsertOrUpdateSt(s1);
                    } else if (this.studentsView.ListStudent.getOption().equals("Update")) {
                        this.studentsView.InsertOrUpdateSt(s1);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            case "Insert":
                this.studentsView.EmptyTextField();
                this.studentsView.ListStudent.setOption("Insert");
                break;
            case "Delete":
                short option = (short) JOptionPane.showConfirmDialog(this.studentsView, "Are you sure want to delete?");
                switch (option){
                    case JOptionPane.YES_OPTION:
                        this.studentsView.deleteRow();
                }
                break;
            case "Update":
                this.studentsView.displayInforSt();
                break;
            case "Cancel":
                if(this.studentsView.ListStudent.getOption().equals("Filter")){
                    this.studentsView.ListStudent.setOption("");
                    this.studentsView.EmptyTextField();
                    this.studentsView.cancelFilterSt();
                } else
                    this.studentsView.EmptyTextField();
                break;
            case "Open":
                int rtValue = jFileChooser.showOpenDialog(this.studentsView);
                switch (rtValue) {
                    case JFileChooser.APPROVE_OPTION:
                        File file = jFileChooser.getSelectedFile();
                        if(file.canRead()){
                            try {
                                this.studentsView.loadFileSt(file.getAbsolutePath());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(this.studentsView, "File khong the doc!", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                }
                break;
            case "Close":
                short opt = (short) JOptionPane.showConfirmDialog(this.studentsView, "Do you want save file", "Notify", JOptionPane.INFORMATION_MESSAGE);
                switch (opt){
                    case JOptionPane.YES_OPTION:
                        this.studentsView.saveFileSt();
                        exit(0);
                        break;
                    case JOptionPane.NO_OPTION:
                        exit(0);
                }
                break;
            case "Exit":
                short op = (short) JOptionPane.showConfirmDialog(this.studentsView, "Sure you want to exit", "Notify", JOptionPane.WARNING_MESSAGE);
                switch (op){
                    case JOptionPane.YES_OPTION:
                        exit(0);
                }
                break;
            case "About Me":
                JOptionPane.showMessageDialog(this.studentsView, "Hello, My name is Hoang", "Notify", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}