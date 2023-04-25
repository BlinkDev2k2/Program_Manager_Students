package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Student implements Serializable {
    private int idSt;
    private String nameSt;
    private City city;
    private LocalDate birthDay;
    private boolean gender;
    private float score1, score2, score3;

    public Student() {
        this.idSt = 0;
        this.nameSt = "unknow";
        this.city.setIdCity((short)0);
        this.city.setNameCity("unknow");
        birthDay = LocalDate.of(1900, 2, 30);
        this.gender = true;
        this.score1 = 0;
        this.score2 = 0;
        this.score3 = 0;
    }

    public Student(int idSt, String nameSt, City city, LocalDate birthDay, boolean gender, float score1, float score2, float score3) {
        if(idSt >= 0)
            this.idSt = idSt;
        else
            this.idSt = 0;
        this.nameSt = nameSt;
        this.city = city;
        if(birthDay.getDayOfMonth() > 0 && birthDay.getDayOfMonth() < 32 && birthDay.getMonthValue() > 0 && birthDay.getMonthValue() < 13 && birthDay.getYear() > 1900)
            this.birthDay = birthDay;
        else
        {
            birthDay = LocalDate.of(1900, 2, 30);
        }
        this.gender = gender;
        if(score1 < 0 || score1 > 10)
            this.score1 = 0;
        else
            this.score1 = score1;
        if(score2 < 0 || score2 > 10)
            this.score2 = 0;
        else
            this.score2 = score2;
        if(score3 < 0 || score3 > 10)
            this.score3 = 0;
        else
            this.score3 = score3;
    }

    public int getIdSt() {
        return idSt;
    }

    public void setIdSt(int idSt) {
        if(idSt < 0)
            this.idSt = 0;
        else
            this.idSt = idSt;
    }

    public String getNameSt() {
        return nameSt;
    }

    public void setNameSt(String nameSt) {
        this.nameSt = nameSt;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        if(birthDay.getDayOfMonth() > 0 && birthDay.getDayOfMonth() < 32 && birthDay.getMonthValue() > 0 && birthDay.getMonthValue() < 13 && birthDay.getYear() > 1900)
            this.birthDay = birthDay;
        else
        {
            birthDay = LocalDate.of(1900, 2, 30);
        }
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        if(score1 < 0 || score1 > 10)
            this.score1 = 0;
        else
            this.score1 = score1;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        if(score2 < 0 || score2 > 10)
            this.score2 = 0;
        else
            this.score2 = score2;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore3(float score3) {
        if(score3 < 0 || score3 > 10)
            this.score3 = 0;
        else
            this.score3 = score3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return idSt == student.idSt; //&& gender == student.gender && Float.compare(student.score1, score1) == 0 && Float.compare(student.score2, score2) == 0 && Float.compare(student.score3, score3) == 0 && Objects.equals(nameSt, student.nameSt) && Objects.equals(city, student.city) && Objects.equals(birthDay, student.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSt, nameSt, city, birthDay, gender, score1, score2, score3);
    }
}
