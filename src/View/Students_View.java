package View;

import Controller.Student_Controller;
import Model.City;
import Model.List_Student;
import Model.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Students_View extends JFrame {
    private int stt = 0;
    public List_Student ListStudent;
    private JMenuBar menuBar;
    private JMenu file, about;
    private JMenuItem open, close, exit, aboutMe;
    private JLabel studentFilter, birthPlace, studentID, listStudent, studentInfo, id, name, date, gender, subject1, subject2, subject3, total;
    private JButton filter, insert, delete, edit, ok, cancel;
    public JTextField studentID_T, id_T, name_T, date_T, subject1_T, subject2_T, subject3_T, total_T;
    public JRadioButton male, female;
    public JComboBox<String> birthPlace_T1, birthPlace_T2;
    private JTable listSV_Table;
    public ButtonGroup buttonGroup;
    private String[] place = new String[]{"       ", "An Giang", "Bà rịa – Vũng tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định",
            "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên",
            "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang",
            "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An",
            "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La",
            "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang",
            "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"};

    public Students_View() {
        this.ListStudent = new List_Student();
        this.Init();
    }

    public void Init(){
        // create new window
        this.setSize(800,600);
        this.setTitle("Quản Lý Danh Sách Học Sinh");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(5,15));
        Color c = Color.CYAN;
        ActionListener ac = new Student_Controller(this);

        // create menubar
        menuBar = new JMenuBar();
        file = new JMenu("File");
        about = new JMenu("About");
        open = new JMenuItem("Open");
        open.addActionListener(ac);
        close = new JMenuItem("Close");
        close.addActionListener(ac);
        exit = new JMenuItem("Exit");
        exit.addActionListener(ac);
        aboutMe = new JMenuItem("About Me");
        aboutMe.addActionListener(ac);

        // add item in menu and menubar
        file.add(open);
        file.add(close);
        file.addSeparator();
        file.add(exit);
        about.add(aboutMe);
        menuBar.add(file);
        menuBar.add(about);

        // Divide the window into 3 components
        JPanel board1, board2, board3;
        board1 = new JPanel();
        board1.setLayout(new GridLayout(2,5, 10,10));
        board2 = new JPanel();
        board2.setLayout(new GridLayout(2,1,10,10));
        board3 = new JPanel();
        board3.setLayout(new GridLayout(1,5, 5,5));

        // create button
        insert = new JButton("Insert");
        insert.addActionListener(ac);
        delete = new JButton("Delete");
        delete.addActionListener(ac);
        edit = new JButton("Update");
        edit.addActionListener(ac);
        ok = new JButton("Save");
        ok.addActionListener(ac);
        cancel = new JButton("Cancel");
        cancel.addActionListener(ac);

        // add button in board3
        board3.add(insert);
        board3.add(delete);
        board3.add(edit);
        board3.add(ok);
        board3.add(cancel);

        // create components
        studentFilter = new JLabel("Student Filter", JLabel.LEFT);
        studentFilter.setOpaque(true);
        studentFilter.setBackground(c);
        birthPlace = new JLabel("BirthPlace", JLabel.CENTER);
        studentID = new JLabel("Student ID", JLabel.CENTER);
        birthPlace_T1 = new JComboBox<String>(place);
        studentID_T = new JTextField();
        filter = new JButton("Filter");
        filter.addActionListener(ac);

        // add components in board1
        board1.add(studentFilter);
        board1.add(new JLabel(""));
        board1.add(new JLabel(""));
        board1.add(new JLabel(""));
        board1.add(new JLabel(""));
        board1.add(birthPlace);
        board1.add(birthPlace_T1);
        board1.add(studentID);
        board1.add(studentID_T);
        board1.add(filter);

        // divide board2 into 2 components
        JPanel board21, board22;
        board21 = new JPanel();
        board21.setLayout(new BorderLayout(2,2));
        board22 = new JPanel();
        board22.setLayout(new GridLayout(6,4,10,10));
        buttonGroup = new ButtonGroup();

        // create components
        studentInfo = new JLabel("Studednt Information");
        studentInfo.setOpaque(true);
        studentInfo.setBackground(c);
        id = new JLabel("ID");
        id_T = new JTextField();
        name = new JLabel("Name");
        name_T = new JTextField();
        birthPlace = new JLabel("BirthPlace");
        birthPlace_T2 = new JComboBox<String>(place);
        date = new JLabel("Date");
        date_T = new JTextField();
        gender = new JLabel("Gender");
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        buttonGroup.add(male);
        buttonGroup.add(female);
        subject1 = new JLabel("Subject 1");
        subject1_T = new JTextField();
        subject2 = new JLabel("Subject 2");
        subject2_T = new JTextField();
        subject3 = new JLabel("Subject 3");
        subject3_T = new JTextField();
        total = new JLabel("Total");
        total_T = new JTextField();

        // add in board22
        board22.add(studentInfo);
        board22.add(new JLabel(""));
        board22.add(new JLabel(""));
        board22.add(new JLabel(""));
        board22.add(id);
        board22.add(id_T);
        board22.add(subject1);
        board22.add(subject1_T);
        board22.add(name);
        board22.add(name_T);
        board22.add(subject2);
        board22.add(subject2_T);
        board22.add(birthPlace);
        board22.add(birthPlace_T2);
        board22.add(subject3);
        board22.add(subject3_T);
        board22.add(date);
        board22.add(date_T);
        board22.add(total);
        board22.add(total_T);
        board22.add(gender);
        board22.add(male);
        board22.add(female);

        // create components in board21
        listStudent = new JLabel("List Student");
        listStudent.setOpaque(true);
        listStudent.setBackground(c);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.GREEN);
        listSV_Table = new JTable(11,9);
        listSV_Table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"STT", "ID", "Name", "Place", "Date", "Gender", "Score 1", "Score 2", "Score3"}));
        JTableHeader tableHeader = listSV_Table.getTableHeader();
        tableHeader.setDefaultRenderer(headerRenderer);
        JScrollPane scrollPane = new JScrollPane(listSV_Table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // complete board2
        board21.add(listStudent, BorderLayout.NORTH);
        board21.add(scrollPane, BorderLayout.CENTER);
        board2.add(board21);
        board2.add(board22);

        //  complete window layout
        this.setJMenuBar(menuBar);
        this.add(board1, BorderLayout.NORTH);
        this.add(board2, BorderLayout.CENTER);
        this.add(board3, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

    public void EmptyTextField(){
        studentID_T.setText("");
        birthPlace_T1.setSelectedIndex(-1);
        id_T.setText("");
        name_T.setText("");
        date_T.setText("");
        subject1_T.setText("");
        subject2_T.setText("");
        subject3_T.setText("");
        total_T.setText("");
        birthPlace_T2.setSelectedIndex(-1);
        buttonGroup.clearSelection();
    }

    public void addSV_inTable(Student sv){
        DefaultTableModel defaultTableModel = (DefaultTableModel) this.listSV_Table.getModel();
        defaultTableModel.addRow(new Object[]{(String.valueOf(++this.stt)), sv.getIdSt() + "", sv.getNameSt(), sv.getCity().getNameCity(), (sv.getBirthDay().getDayOfMonth() +"/" + sv.getBirthDay().getMonthValue() + "/" + sv.getBirthDay().getYear()), (sv.isGender() == true ? "Male" : "Female"), sv.getScore1() + "", sv.getScore2() + "", sv.getScore3() + ""});
    }

    public void InsertOrUpdateSt(Student sv){
        if(!(this.ListStudent.checkExistence(sv))){
            this.ListStudent.insertSt(sv);
            this.addSV_inTable(sv);
        }else {
            this.ListStudent.updateSt(sv);
            DefaultTableModel defaultTableModel = (DefaultTableModel) this.listSV_Table.getModel();
            int number_row = defaultTableModel.getRowCount();
            for(short i = 0; i < number_row; ++i){
                String id = defaultTableModel.getValueAt(i, 1).toString();
                if(String.valueOf(sv.getIdSt()).equals(id)){
                    defaultTableModel.setValueAt(sv.getIdSt() + "", i, 1);
                    defaultTableModel.setValueAt(sv.getNameSt(), i, 2);
                    defaultTableModel.setValueAt(sv.getCity().getNameCity(), i, 3);
                    defaultTableModel.setValueAt((sv.getBirthDay().getDayOfMonth() +"/" + sv.getBirthDay().getMonthValue() + "/" + sv.getBirthDay().getYear()), i, 4);
                    defaultTableModel.setValueAt((sv.isGender() == true ? "Male" : "Female"), i, 5);
                    defaultTableModel.setValueAt(sv.getScore1() + "", i, 6);
                    defaultTableModel.setValueAt(sv.getScore2() + "", i, 7);
                    defaultTableModel.setValueAt(sv.getScore3() + "", i, 8);
                }
            }
        }
        //System.out.println(this.ListStudent.getSize());
    }

    public void displayInforSt() {
        int row = listSV_Table.getSelectedRow();
        this.id_T.setText(listSV_Table.getValueAt(row, 1).toString());
        this.name_T.setText(listSV_Table.getValueAt(row, 2).toString());
        short ide = City.getIDCity(this.listSV_Table.getValueAt(row, 3).toString());
        this.birthPlace_T2.setSelectedIndex(ide);
        this.date_T.setText(this.listSV_Table.getValueAt(row, 4).toString());
        if(this.listSV_Table.getValueAt(row, 5).toString().equals("Male")){
            this.male.setSelected(true);
            this.female.setSelected(false);
        }
        else {
            this.female.setSelected(true);
            this.male.setSelected(false);
        }
        this.subject1_T.setText(this.listSV_Table.getValueAt(row, 6).toString());
        this.subject2_T.setText(this.listSV_Table.getValueAt(row, 7).toString());
        this.subject3_T.setText(this.listSV_Table.getValueAt(row, 8).toString());
    }

    public void deleteRow() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) this.listSV_Table.getModel();
        int row = this.listSV_Table.getSelectedRow();
        int idst = Integer.valueOf(defaultTableModel.getValueAt(row, 1).toString());
        String namest = defaultTableModel.getValueAt(row, 2).toString();
        short idtinh = City.getIDCity(defaultTableModel.getValueAt(row, 3).toString());
        City ct = City.getCitybyID(idtinh);



        String dateString = defaultTableModel.getValueAt(row, 4).toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdayst = null;
        LocalDate localDate;
        try {
            birthdayst = dateFormat.parse(dateString);
            localDate = birthdayst.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        short d,m,y;
        d = (short)birthdayst.getDate();
        m = (short)(birthdayst.getMonth() + 1);
        y = (short)(birthdayst.getYear() + 1900);
        birthdayst.setDate(d);
        birthdayst.setMonth(m);
        birthdayst.setYear(y);
        boolean gioitinhst = true;
        if(defaultTableModel.getValueAt(row, 5).toString().equals("Male"))
            gioitinhst = true;
        else if(defaultTableModel.getValueAt(row, 5).toString().equals("Female"))
            gioitinhst = false;
        float m1 = Float.valueOf(defaultTableModel.getValueAt(row, 6).toString());
        float m2 = Float.valueOf(defaultTableModel.getValueAt(row, 7).toString());
        float m3 = Float.valueOf(defaultTableModel.getValueAt(row, 8).toString());
        Student s2 = new Student(idst, namest, ct, localDate, gioitinhst, m1, m2, m3);
        this.ListStudent.removeSt(s2);
        defaultTableModel.removeRow(row);
    }

    public void FilterSt() {
        this.cancelFilterSt();
        short idtinh = (short) (this.birthPlace_T1.getSelectedIndex() - 1);
        String id = this.studentID_T.getText();
        DefaultTableModel defaultTableModel = (DefaultTableModel) this.listSV_Table.getModel();
        if(idtinh > 0){
            City ct = City.getCitybyID(idtinh);
            for(short i = 0; i < defaultTableModel.getRowCount(); ++i){
                String nameCity = defaultTableModel.getValueAt(i, 3).toString();
                if(!ct.getNameCity().equals(nameCity)){
                    defaultTableModel.removeRow(i);
                }
            }
        }
        if(!id.equals("")){
            for(short i = 0; i < defaultTableModel.getRowCount(); ++i){
                String id1 = defaultTableModel.getValueAt(i, 1).toString();
                if(!id.equals(id1)){
                    defaultTableModel.removeRow(i);
                }
            }
        }
    }

    public void cancelFilterSt() {
        this.stt = 0;
        while (true){
            DefaultTableModel defaultTableModel = (DefaultTableModel) this.listSV_Table.getModel();
            int row = defaultTableModel.getRowCount();
            if(row == 0) break;
            else {
                defaultTableModel.removeRow(0);
            }
        }
        for(Student x : this.ListStudent.getLst()){
            this.addSV_inTable(x);
        }
    }

    public void SaveFile(String path) {
        try {
            this.ListStudent.setNameFile(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Student x : this.ListStudent.getLst()){
                oos.writeObject(x);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveFileSt() {
        if(this.ListStudent.getNameFile().length() > 0){
            this.SaveFile(this.ListStudent.getNameFile());
        } else{
            JFileChooser jf = new JFileChooser();
            int v = jf.showSaveDialog(this);
            if(v == JFileChooser.APPROVE_OPTION){
                File f = jf.getSelectedFile();
                this.SaveFile(f.getAbsolutePath());
            }
        }
    }

    public void loadFileSt(String path){
        ArrayList<Student> arr = new ArrayList<Student>();
        try {
            Student st = null;
            this.ListStudent.setNameFile(path);
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true){
                st = (Student) ois.readObject();
                if(st == null) break;
                arr.add(st);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.ListStudent.setLst(null);
        this.ListStudent.setLst(arr);
        this.cancelFilterSt();
    }
}
