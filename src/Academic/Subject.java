package Academic;

public class Subject {
    private int id;
    private String name;
    private String programm;
    public enum Course{First, Second};
    private Course course;

    public Subject(int id, String name, String programm, Course course){
        this.id = id;
        this.name = name;
        this.programm = programm;
        this.course = course;
    }

    public Subject(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getProgramm() {
        return programm;
    }

    public void setProgramm(String programm) {
        this.programm = programm;
    }

    public String toString(){
        return "=== Subject ====" + "\n"
                + "id: " + id + "\n" +
                "Nombre: " + name + "\n" +
                "Programm: " + programm + "\n" +
                "Course: " + course + "\n";

    }
}
