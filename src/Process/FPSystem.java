package Process;

public class FPSystem {
    public static void main(String[] args){
        AdminApp testAdmin = new AdminApp();

        TeacherApp test = new TeacherApp(2);
        test.viewStudent();
    }
}