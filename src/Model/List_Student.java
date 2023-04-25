package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class List_Student implements Serializable {
    private ArrayList<Student> listSt;
    private String option;
    private String nameFile;

    public List_Student(ArrayList<Student> lst) {
        this.listSt = lst;
        this.option = "";
        this.nameFile = "";
    }
    public List_Student() {
        this.listSt = new ArrayList<Student>();
        this.option = "";
        this.nameFile = "";
    }

    public ArrayList<Student> getLst() {
        return listSt;
    }

    public void setLst(ArrayList<Student> lst) {
        this.listSt = lst;
    }

    public void insertSt(Student st){
        this.listSt.add(st);
    }

    public void removeSt(Student st){
        this.listSt.remove(st);
    }

    public void updateSt(Student st){
        this.listSt.remove(st);
        this.listSt.add(st);
    }

    public String getOption(){
        return this.option;
    }

    public void setOption(String s){
        this.option = s;
    }

    public boolean checkExistence(Student s){
        for(Student x : this.listSt){
            if(x.getIdSt() == s.getIdSt())
                return true;
        }
        return false;
    }

    public int getSize(){
        return this.listSt.size();
    }

    public void clearSt(){
        this.listSt.clear();
    }

    public String getNameFile(){
        return this.nameFile;
    }

    public void setNameFile(String s){
        this.nameFile = s;
    }
}
