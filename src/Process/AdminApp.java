package Process;

import Academic.Student;
import Academic.Subject;
import Academic.Teacher;

import java.io.*;
import java.nio.Buffer;
import java.time.LocalDate;

public class AdminApp {
    public void listStudents(){
        try(BufferedReader br = new BufferedReader(new FileReader("Data/students.txt"))){
            System.out.println("STUDENTS");
            String line;
            while((line = br.readLine()) != null){


                String[] info = line.split("\\|");

                int idStudent = Integer.parseInt(info[0]);
                String name = info[1];
                String mail = info[2];

                Student est = new Student(idStudent, name, mail);

                System.out.println(est.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void listSubjects(){
        try(BufferedReader br = new BufferedReader(new FileReader("Data/subjects.txt"))){
            System.out.println("SUBJECTS");
            String line;
            while((line = br.readLine()) != null){


                String[] info = line.split("\\|");

                int idSubject = Integer.parseInt(info[0]);
                String name = info[1];
                String programm = info[2];
                String course = info[3];

                Subject sub = new Subject(idSubject, name, programm, Subject.Course.valueOf(course.trim()));

                System.out.println(sub.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void listEnrrollments(){
        try (BufferedReader br = new BufferedReader(new FileReader("Data/enrrollment.txt"))){
            String line;
            System.out.println("ENRROLLMENTs");
            System.out.println("===============================");

            while((line = br.readLine()) != null){
                String[] datos = line.split("\\|");

                int nStudent = Integer.parseInt(datos[0]);
                int nSubject = Integer.parseInt(datos[1]);
                LocalDate date = LocalDate.parse(datos[2]);

                String line2;

                try(BufferedReader br2 = new BufferedReader(new FileReader("Data/students.txt"))) {
                    while((line2 = br2.readLine()) != null ){
                        String[] data2 = line2.split("\\|");
                        int nStudent2 = Integer.parseInt(data2[0]);
                        String nameStudent = data2[1];

                        if (nStudent2 == nStudent) {

                            String line3;
                            try (BufferedReader br3 = new BufferedReader(new FileReader("Data/subjects.txt"))){
                                while((line3 = br3.readLine()) != null){
                                    String[] data3 = line3.split("\\|");
                                    int nSubject2 = Integer.parseInt(data3[0]);
                                    if (nSubject2 == nSubject){
                                        String nameSubject = data3[1];
                                        System.out.println(nameStudent + " | " + nameSubject + " | " + date + " | ");
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

    public void listTeachers(){
        try(BufferedReader br = new BufferedReader(new FileReader("Data/teachers.txt"))){
            System.out.println("TEACHERS");
            String line;
            while((line = br.readLine()) != null){
                String[] info = line.split("\\|");

                int idStudent = Integer.parseInt(info[0]);
                String name = info[1];
                String spc = info[2];

                Teacher tch = new Teacher(idStudent, name, spc);

                System.out.println(tch.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void enrollmentStudent(int idStudent, int idSubject){
        boolean fStudent = false;
        boolean fSubject = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Data/students.txt"))){
            String linea;
            while((linea = br.readLine()) != null){

                String[] data = linea.split("|");
                int idFound = Integer.parseInt(data[0]);

                if(idStudent == idFound){
                    fStudent = true;
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("Data/subjects.txt"))){
            String linea;
            while((linea = br.readLine()) != null){

                String[] data = linea.split("|");
                int idFound = Integer.parseInt(data[0]);

                if(idSubject == idFound){
                    fSubject = true;
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(fStudent && fSubject){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("Data/enrrollment.txt",true))){
                LocalDate currentDate = LocalDate.now();
                bw.newLine();
                bw.write(idStudent + "|" + idSubject + "|" + currentDate);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if(!fStudent){
            System.err.println("Student ID not found");
        }else if(!fSubject){
            System.err.println("Subject ID not found");
        }

    }

    public void assignTeacher(int idTeacher, int idSubject, int hour){
        boolean fTeacher = false;
        boolean fSubject = false;

        try (BufferedReader br = new BufferedReader(new FileReader("Data/teachers.txt"))){
            String linea;

            while((linea = br.readLine()) != null){

                String[] data = linea.split("|");
                int idFound = Integer.parseInt(data[0]);

                if(idTeacher == idFound){
                    fTeacher = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("Data/subjects.txt"))){
            String linea;
            while((linea = br.readLine()) != null){

                String[] data = linea.split("|");
                int idFound = Integer.parseInt(data[0]);

                if(idSubject == idFound){
                    fSubject = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(hour < 1 || hour > 6){
            System.err.println("Hour outside the range");
        }else if(!fTeacher){
            System.err.println("Teacher ID not found");
        }else if(!fSubject){
            System.err.println("Subject ID not found");
        }else if(fTeacher && fSubject){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("Data/schedules.txt",true))){
                LocalDate currentDate = LocalDate.now();
                bw.newLine();
                bw.write(idTeacher + "|" + idSubject + "|" + hour);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    
    
}
