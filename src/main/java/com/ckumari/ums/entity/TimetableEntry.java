package com.ckumari.ums.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "timetable_entries")
public class TimetableEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @NotBlank(message = "Day cannot be blank")
    @Size(max = 20, message = "Day cannot exceed 20 characters")
    @Column(name = "day", nullable = false, length = 20)
    private String day;

    @NotBlank(message = "Period cannot be blank")
    @Size(max = 20, message = "Period cannot exceed 20 characters")
    @Column(name = "period", nullable = false, length = 20)
    private String period;

    @NotBlank(message = "Subject cannot be blank")
    @Size(max = 50, message = "Subject cannot exceed 50 characters")
    @Column(name = "subject", nullable = false, length = 50)
    private String subject;

    @NotBlank(message = "Teacher cannot be blank")
    @Size(max = 50, message = "Teacher cannot exceed 50 characters")
    @Column(name = "teacher", nullable = false, length = 50)
    private String teacher;

    @NotBlank(message = "Classroom cannot be blank")
    @Size(max = 20, message = "Classroom cannot exceed 20 characters")
    @Column(name = "classroom", nullable = false, length = 20)
    private String classroom;

    @NotNull(message = "Time cannot be null")
    @Column(name = "time", nullable = false)
    private String time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_section_id", nullable = false)
    private ClassSection classSection;

    @ElementCollection
    @CollectionTable(name = "timetable_periods", joinColumns = @JoinColumn(name = "timetable_entry_id"))
    private List<Period> periods;

    // Nested class for representing each period in the timetable
    @Embeddable
    public static class Period {

        @NotBlank(message = "Subject cannot be blank")
        @Size(max = 50, message = "Subject cannot exceed 50 characters")
        private String subject;

        @NotBlank(message = "Teacher cannot be blank")
        @Size(max = 50, message = "Teacher cannot exceed 50 characters")
        private String teacher;

        @NotBlank(message = "Classroom cannot be blank")
        @Size(max = 20, message = "Classroom cannot exceed 20 characters")
        private String classroom;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "course_id", nullable = false)
        private Course course;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "class_section_id", nullable = false)
        private ClassSection classSection;

        // Getters and setters
        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public String getClassroom() {
            return classroom;
        }

        public void setClassroom(String classroom) {
            this.classroom = classroom;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public ClassSection getClassSection() {
            return classSection;
        }

        public void setClassSection(ClassSection classSection) {
            this.classSection = classSection;
        }
    }
}
