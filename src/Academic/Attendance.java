package Academic;
import java.time.LocalDate;

public class Attendance {
    private int idStudent;
    private int idSubject;
    private LocalDate fecha;

    public Attendance(int idStudent, int idSubject, LocalDate fecha){
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.fecha = fecha;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String toString(){
        return "=== Enrollment ====" + "\n"
                + "ID Student: " + idStudent + "\n" +
                "ID Subject: " + idSubject + "\n" +
                "Date: " + fecha + "\n";
    }
}
