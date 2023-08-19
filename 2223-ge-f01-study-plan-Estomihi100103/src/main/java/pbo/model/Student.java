package pbo.model;

// import java.util.*;
import javax.persistence.*;

//12S21001|Dhino Turnip|S1 Sistem Informasi
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id", nullable = false, length = 255)
    private String studentId;

    @Column(name = "student_name", nullable = false, length = 255)

    private String studentName;

    @Column(name = "study_program", nullable = false, length = 25)
    private String studyProgram;

    public Student() {
        // empty constructor
    }

    public Student(String studentId, String studentName, String studyProgram) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studyProgram = studyProgram;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    @Override
    public String toString() {
        return studentId + "|" + studentName + "|" + studyProgram;
    }

}
