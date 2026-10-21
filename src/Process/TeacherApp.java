package Process;

import Academic.Teacher;

import java.io.*;
import java.nio.Buffer;

public class TeacherApp {
    private int idTeacher;
    public TeacherApp(int idTeacher){
        this.idTeacher = idTeacher;
    }


    public void getInfo(){
        try (BufferedReader br = new BufferedReader(new FileReader("Data/teachers.txt"))){
            String line;
            boolean found = false;
            while((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                int idF = Integer.parseInt(data[0]);
                if(idTeacher == idF){
                    Teacher teacher = new Teacher(Integer.parseInt(data[0]), data[1], data[2]);
                    System.out.println(teacher.toString());
                    found = true;
                }
            }

            if (!found){
                System.err.println("Teacher not found");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getSubject(){
        String line;
        System.out.println("YOUR SUBJECT ASIGNED ARE");
        System.out.println("=========================");
        try(BufferedReader br = new BufferedReader(new FileReader("Data/schedules.txt"))){

            while((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                int idT = Integer.parseInt(data[0]);
                int idS = Integer.parseInt(data[1]);
                int hour = Integer.parseInt(data[2]);

                if(idT == idTeacher){

                    String line2;
                    try(BufferedReader br2 = new BufferedReader(new FileReader("Data/subjects.txt"))){
                        while((line2 = br2.readLine()) != null){
                            String[] dataSubject = line2.split("\\|");
                            int idSubject = Integer.parseInt(dataSubject[0]);
                            String name = dataSubject[1];

                            if(idSubject == idS){
                                System.out.println(name + "| Hour: " + hour);
                            }
                        }

                    }
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewStudent(){
        System.out.println("YOUR STUDENTS ARE: ");
        System.out.println("=======================");
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("Data/schedules.txt"))){

            while((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                int idT = Integer.parseInt(data[0]);
                int idS = Integer.parseInt(data[1]);


                if(idT == idTeacher){

                    String line2;
                    try(BufferedReader br2 = new BufferedReader(new FileReader("Data/subjects.txt"))){
                        while((line2 = br2.readLine()) != null){
                            String[] dataSubject = line2.split("\\|");
                            int idSubject = Integer.parseInt(dataSubject[0]);
                            String nameSubject = dataSubject[1];
                            if(idS == idSubject){
                                String line3;
                                try (BufferedReader br3 = new BufferedReader(new FileReader("Data/enrrollment.txt"))){
                                    while((line3 = br3.readLine()) != null){
                                        String[] data3 = line3.split("\\|");
                                        int idSE = Integer.parseInt(data3[0]);
                                        int idSuE = Integer.parseInt(data3[1]);

                                        if(idSubject == idSuE){
                                            String line4;
                                            try(BufferedReader br4 = new BufferedReader(new FileReader("Data/students.txt"))){
                                                while((line4 = br4.readLine()) != null){
                                                    String[] dataStudents = line4.split("\\|");
                                                    int idStudent = Integer.parseInt(dataStudents[0]);
                                                    String nameStudent = dataStudents[1];
                                                    if(idStudent == idSE){
                                                        System.out.println(nameStudent + "|" + nameSubject);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
