package pbo.model;

import java.util.*;
import javax.persistence.*;

public class drivApp {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static ArrayList<Student> containerStudents = new ArrayList<Student>();
    public static ArrayList<Course> containerCourses = new ArrayList<Course>();

    // initialize entity manager
    public static void initializeEntityManager() {
        factory = Persistence.createEntityManagerFactory("study_plan_pu");
        entityManager = factory.createEntityManager();
    }

    // clean table Student
    public static void cleanTableStudent() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Student s").executeUpdate();  
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    // clean table Course
    public static void cleanTableCourse() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Course c").executeUpdate();  //bagian dhino
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public static void cleanTableEnrollment() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Enrollment e").executeUpdate();
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    // create student
    public static void CreateStudent(String studentId, String name, String studyProgram) {
        boolean cek = false;
        for (Student student : containerStudents) {
            if (student.getStudentId().equals(studentId)) {
                cek = true;
                break;
            }
        }
        if (cek == false) {
            Student newStudent = new Student(studentId, name, studyProgram);
            containerStudents.add(newStudent);
            entityManager.getTransaction().begin();
            entityManager.persist(newStudent);
            entityManager.flush();
            entityManager.getTransaction().commit();

        }
    }

    // create student
    public static void createCourse(String courseId, String courseName, int semester, int credit) {

        boolean cek = false;
        for (Course course : containerCourses) {
            if (course.getCourseId().equals(courseId)) {
                cek = true;
                break;
            }
        }
        // public Course(String courseId, String courseName, int semester, int credit)    //bagian dhino
        if (cek == false) {
            Course newCourse = new Course(courseId, courseName, semester, credit);
            containerCourses.add(newCourse);
            entityManager.getTransaction().begin();
            entityManager.persist(newCourse);
            entityManager.flush();
            entityManager.getTransaction().commit();

        }
    }

    // create enroll
    // enroll#12S21001#KUS3001

    // show student
    public static void ShowStudent() {
        String query = "SELECT s FROM Student s ORDER BY s.studentId ASC";
        List<Student> students = entityManager.createQuery(query, Student.class)
                .getResultList();

        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    // show course
    public static void ShowCourse() {
        String query = "SELECT c FROM Course c ORDER BY c.courseId ASC";
        List<Course> courses = entityManager.createQuery(query, Course.class)   //bagian dhino
                .getResultList();

        for (Course c : courses) {
            System.out.println(c.toString());
        }
    }




    public static void createEnroll(String studentId, String courseId) {
        boolean studentExists = false;
        boolean courseExists = false;

        for (Student student : containerStudents) {
            if (student.getStudentId().equals(studentId)) {
                studentExists = true;
                break;
            }
        }

        for (Course course : containerCourses) {
            if (course.getCourseId().equals(courseId)) {
                courseExists = true;
                break;
            }
        }

        if (studentExists && courseExists) {
            Enrollment newEnroll = new Enrollment(studentId, courseId);
            entityManager.getTransaction().begin();
            entityManager.persist(newEnroll);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
    }

    // student-show#12S21001
    public static void ShowStudentDetail(String studentId) {
        String query = "SELECT s FROM Student s WHERE s.studentId = :studentId";
        Student student = entityManager.createQuery(query, Student.class)
                .setParameter("studentId", studentId)
                .getSingleResult();

        System.out.println(student.toString());

        String query_selectCourse_from_enrol = "SELECT e FROM Enrollment e WHERE e.studentId = :studentId";
        List<Enrollment> enrollments = entityManager.createQuery(query_selectCourse_from_enrol, Enrollment.class)
                .setParameter("studentId", studentId)
                .getResultList();

        List<Course> courses = new ArrayList<>();
        for (Enrollment e : enrollments) {
            String courseId = e.getCourseId();
            Course course = entityManager.find(Course.class, courseId);
            if (course != null) {
                courses.add(course);
            }
        }

        // Mengurutkan daftar kursus berdasarkan courseId secara ascending
        courses.sort(Comparator.comparing(Course::getCourseId));

        for (Course c : courses) {
            System.out.println(c.toString());
        }
    }

}
