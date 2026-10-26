package Process;

import Academic.Teacher;

import java.io.*;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public void viewGrades(){
        try(BufferedReader br = new BufferedReader(new FileReader("Data/schedules.txt"))){
            String infoSchedule;
            while((infoSchedule = br.readLine()) != null){
                String[] data = infoSchedule.split("\\|");
                int idTeaSch = Integer.parseInt(data[0]);
                int idSubSch = Integer.parseInt(data[1]);

                if(idTeaSch == idTeacher){


                    try(BufferedReader br2 = new BufferedReader(new FileReader("Data/subjects.txt"))){
                        String infoSubject;
                        while((infoSubject = br2.readLine()) != null){
                            String[] dataSubject = infoSubject.split("\\|");
                            int idSubject = Integer.parseInt(dataSubject[0]);
                            String nameSubject = dataSubject[1];

                            if(idSubject == idSubSch){
                                try(BufferedReader br3 = new BufferedReader(new FileReader("Data/enrrollment.txt"))){
                                    String infoEnrollment;
                                    while((infoEnrollment = br3.readLine()) != null){
                                        String[] dataEnrrollent = infoEnrollment.split("\\|");
                                        int idEstEnr = Integer.parseInt(dataEnrrollent[0]);
                                        int idSubEnr = Integer.parseInt(dataEnrrollent[1]);

                                        if(idSubEnr == idSubject){


                                            try(BufferedReader br4 = new BufferedReader(new FileReader("Data/students.txt"))){
                                                String infoStudents;
                                                while((infoStudents = br4.readLine()) != null){
                                                    String[] dataStudents = infoStudents.split("\\|");
                                                    int idEstEst = Integer.parseInt(dataStudents[0]);
                                                    String estName = dataStudents[1];
                                                    if (idEstEst == idEstEnr){

                                                        try (BufferedReader br5 = new BufferedReader(new FileReader("Data/grades.txt"))){
                                                            String infoGrades;
                                                            while((infoGrades = br5.readLine()) != null){
                                                                String[] dataGrades = infoGrades.split("\\|");
                                                                int idEstGra = Integer.parseInt(dataGrades[0]);
                                                                int idSubGra = Integer.parseInt(dataGrades[1]);
                                                                int grade = Integer.parseInt(dataGrades[2]);

                                                                if(idEstGra == idEstEst && idSubject == idSubGra){
                                                                    System.out.println(estName + " | " + nameSubject + " | " + grade);
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

                    }
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewAsistences(){
        ArrayList<Integer> idSubjectsTech = foundSubject(idTeacher);
        String dataAttendance;
        try(BufferedReader brAttendance = new BufferedReader(new FileReader("Data/attendances.txt"))) {
            while((dataAttendance = brAttendance.readLine()) != null){
                String[] infoAttendance = dataAttendance.split("\\|");
                int idStuAtten = Integer.parseInt(infoAttendance[0]);
                int idSubAtten = Integer.parseInt(infoAttendance[1]);
                LocalDate date = LocalDate.parse(infoAttendance[2]);

                for(int i : idSubjectsTech){
                    if(idSubAtten == i){
                        System.out.println(loadEstudent(idStuAtten) + " | " + loadSubject(idStuAtten) + " | " + date);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Integer> foundSubject(int id){
        String data;
        int idTeacher = 0;
        int idSubject = 0;
        ArrayList<Integer> subjects = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("Data/schedules.txt"))){
            while((data = br.readLine()) != null){
                String[] info = data.split("\\|");
                idTeacher = Integer.parseInt(info[0]);
                idSubject = Integer.parseInt(info[1]);

                if(id == idTeacher){
                    subjects.add(idSubject);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return subjects;

    }

    public String loadEstudent(int id){
        String name = "";
        try(BufferedReader br = new BufferedReader(new FileReader("Data/students.txt"))){
            String infoStudents;
            while((infoStudents = br.readLine()) != null){
                String[] dataStudents = infoStudents.split("\\|");
                int idStudent = Integer.parseInt(dataStudents[0]);
                String nameStudent = dataStudents[1];

                if(id == idStudent){
                    name = nameStudent;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return name;
    }

    public String loadSubject(int id){

        String name = "";
        try(BufferedReader br = new BufferedReader(new FileReader("Data/subjects.txt"))){
            String infoSubjects;
            while((infoSubjects = br.readLine()) != null){
                String[] dataSubjects = infoSubjects.split("\\|");
                int idStudent = Integer.parseInt(dataSubjects[0]);
                String nameSubject = dataSubjects[1];

                if(id == idStudent){
                    name = nameSubject;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return name;
    }


}
