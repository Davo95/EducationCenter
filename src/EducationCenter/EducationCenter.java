package EducationCenter;

import java.util.Scanner;

public class EducationCenter {
    static StudentStorage studentStorage = new StudentStorage();
    static LessonStorage lessonStorage = new LessonStorage();
    static Scanner scanner = new Scanner(System.in);
    private static final int EXIT = 0;
    private static final int ADD_STUDENT = 1;
    private static final int ADD_LESSON = 2;
    private static final int PRINT_STUDENT = 3;
    private static final int PRINT_LESSON = 4;
    private static final int CHANGE_STUDENT_LESSON = 5;
    private static final int PRINT_STUDENT_BY_LESSON_NAME = 6;


    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            printCommandas();
            String commandStr = scanner.nextLine();
            int command = Integer.parseInt(commandStr);
            switch (command) {
                case EXIT:
                    isRun = false;
                    System.out.println("Good luck");
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case PRINT_STUDENT:
                    printStudent();
                    break;
                case PRINT_LESSON:
                    printLesson();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLesson();
                    break;
                case PRINT_STUDENT_BY_LESSON_NAME:
                    printStudentByLessonName();
                    break;
                default:
                    System.out.println("Wrong command");

            }
        }

    }


    private static void addStudent() {
        System.out.println("Enhance lesson data (name,duration,prace,lecturerName)");
        String lessonStorageStr = scanner.nextLine();
        String[] lessonStorageRege = lessonStorageStr.split(",");
        Lesson lesson = new Lesson();
        lesson.setName(lessonStorageRege[0]);
        lesson.setDuration(Integer.parseInt(lessonStorageRege[1]));
        lesson.setPrace(Double.parseDouble(lessonStorageRege[2]));
        lesson.setLecturerName(lessonStorageRege[3]);
        lessonStorage.addLesson(lesson);

        System.out.println("Enter student information (name,surname,phone,email,lessons)");
        String studentStorageSet = scanner.nextLine();
        String[] studentStorige = studentStorageSet.split(",");
        Student student = new Student();
        student.setName(studentStorige[0]);
        student.setSurname(studentStorige[1]);
        student.setPhone(Integer.parseInt(studentStorige[2]));
        student.setEmail(studentStorige[3]);

        student.setLessons(lessonStorage.getLessons());
        studentStorage.add(student);
        System.out.println("the student increased");

    }

    private static void addLesson() {
        printStudent();
        System.out.println("Write the student's name");
        String studentStorageStr = scanner.nextLine();
        Student student = studentStorage.getStudentByName(studentStorageStr);
        LessonStorage storage = new LessonStorage();
        Lesson[] lessons = student.getLessons();
        for (int i = 0; i < lessons.length; i++) {
            storage.addLesson(lessons[i]);
        }
        System.out.println("Write the names of the subjects");
        String lessonStorageStr = scanner.nextLine();
        String[] lesseonStorage = lessonStorageStr.split(",");
        Lesson lesson = new Lesson();
        lesson.setName(lesseonStorage[0]);
        lesson.setDuration(Integer.parseInt(lesseonStorage[1]));
        lesson.setPrace(Double.parseDouble(lesseonStorage[2]));
        lesson.setLecturerName(lesseonStorage[3]);
        lessonStorage.addLesson(lesson);
        storage.addLesson(lesson);
        student.setLessons(storage.getLessons());
    }

    private static void printStudentByLessonName() {

        for (int i = 0;i < lessonStorage.getLessons().length;i++) {
            if(lessonStorage.getLessons()[i] != null){
                System.out.println(lessonStorage.getLessons()[i]);
            }

        }
        System.out.println("Import the search class");
        String lessonName = scanner.nextLine();

        StudentStorage storage = new StudentStorage();
        Student[] allStudents = studentStorage.getStudents();
        for (int i = 0; i < allStudents.length ;i++){
            Student student = allStudents[i];
            for (int j = 0; j < student.getLessons().length;j++) {
                Lesson lesson = student.getLessons()[j];
                if (lesson.getName().equals(lessonName)) {
                    storage.add(student);
                }
            }
        }
        for (int i = 0;i < allStudents.length;i++) {
            if(allStudents[i] != null) {
                System.out.println(allStudents[i]);
            }

        }
    }


    public static void changeStudentLesson() {
        printStudent();
        System.out.println("Write the name of the student whose subject you want to change");
        String studentStorageStr = scanner.nextLine();
        Student student = studentStorage.getStudentByName(studentStorageStr);
        Lesson[] lessons = student.getLessons();
        for (int i = 0; i < lessons.length; i++) {
            if(lessons[i] != null){
                System.out.println(lessons[i].getName());
            }

        }
        System.out.println("Write the names of the subjects");
        String lessonStorageStr = scanner.nextLine();
        String[] lesseonStorage = lessonStorageStr.split(",");
        Lesson lesson = new Lesson();
        lesson.setName(lesseonStorage[0]);
        lesson.setDuration(Integer.parseInt(lesseonStorage[1]));
        lesson.setPrace(Double.parseDouble(lesseonStorage[2]));
        lesson.setLecturerName(lesseonStorage[3]);
        lessonStorage.addLesson(lesson);
        LessonStorage storage = new LessonStorage();
        storage.addLesson(lesson);
        student.setLessons(storage.getLessons());
    }

    private static void printStudent() {
        Student[] student = studentStorage.getStudents();
        for (int i = 0; i < student.length; i++) {
            if(student[i] != null){
                System.out.println(student[i]);
            }

        }
    }

    private static void printLesson() {
        printStudent();
        System.out.println("Write the name of the student");
        String studentName = scanner.nextLine();
        Student student = studentStorage.getStudentByName(studentName);
        Lesson[] lessons = student.getLessons();
        for (int i = 0; i < lessons.length; i++) {
            if(lessons[i] != null){
                System.out.println(lessons[i]);
            }

        }
    }
    private static void printCommandas() {
        System.out.println( + EXIT + " Import to exit");
        System.out.println( + ADD_STUDENT + " To add to the student");
        System.out.println( + ADD_LESSON + " Import to add lessons");
        System.out.println( + PRINT_STUDENT + " Print student information");
        System.out.println( + PRINT_LESSON + " Print lesson data");
        System.out.println(+CHANGE_STUDENT_LESSON+" Change student and class names");
        System.out.println(+PRINT_STUDENT_BY_LESSON_NAME+" Print the names of the student's lessons");

    }
}
