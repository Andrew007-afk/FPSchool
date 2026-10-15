package Academic;

import java.time.LocalDate;

public class Enrollment {
    private int idStudent;
    private int idSubject;
    private LocalDate inscripcion;

    public Enrollment(int idStudent, int idSubject, LocalDate inscripcion){
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.inscripcion = inscripcion;
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

    public LocalDate getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(LocalDate inscripcion) {
        this.inscripcion = inscripcion;
    }

    public String toString(){
        return "=== Enrollment ====" + "\n"
                + "Id Student: " + idStudent + "\n" +
                "Id Subject: " + idSubject + "\n" +
                "Inscription Date: " + inscripcion + "\n";
    }
}
