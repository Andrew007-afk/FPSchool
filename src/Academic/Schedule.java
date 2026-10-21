package Academic;

import java.time.LocalTime;

public class Schedule {
    private int idTeacher;
    private int idSubject;
    private int hora;

    public Schedule(int idTeacher, int idSubject, int hora){
        this.idTeacher = idTeacher;
        this.idSubject = idSubject;
        this.hora = hora;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String toString(){
        return "=== Schedule ====" + "\n"
                + "ID Teacher: " + idTeacher + "\n" +
                "ID Subject: " + idSubject + "\n" +
                "Hora: " + hora + "\n";
    }
}
