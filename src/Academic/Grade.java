package Academic;

import java.util.ArrayList;
import java.util.Map;

public class Grade {
    private int idStudent;
    private int idSubject;
    private int grade;

    public Grade(int idStudent, int idSubject, int grade){
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.grade = grade;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String toString(){
        return "=== Grade ====" + "\n"
                + "Id Student: " + idStudent + "\n" +
                "Id Subject: " + idSubject + "\n" +
                "Grade: " + grade + "\n";
    }
}
