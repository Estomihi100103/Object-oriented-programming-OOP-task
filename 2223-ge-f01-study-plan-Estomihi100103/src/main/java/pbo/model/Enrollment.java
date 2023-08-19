package pbo.model;

// import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "enrollment")

public class Enrollment {
    private static int nextId = 1;
    @Id
    @Column(name = "id", nullable = false, length = 25)
    private int id = 0;

    @Column(name = "student_id", nullable = false, length = 25)
    private String studentId;
    @Column(name = "course_id", nullable = false, length = 25)
    private String courseId;

    public Enrollment() {
        // empty constructor
    }

    public Enrollment(String studentId, String courseId) {
        this.id = nextId++;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

}
