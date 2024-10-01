package com.ckumari.ums.dto;

public class TimetableEntryDTO {
    private Long id;
    private String day;
    private String period;
    private String subject;
    private String teacher;
    private String classroom;
    private String time; // Use String for time representation in DTO

    // Default constructor
    public TimetableEntryDTO() {}

    // Parameterized constructor for easy initialization
    public TimetableEntryDTO(Long id, String day, String period, String subject, String teacher, String classroom, String time) {
        this.id = id;
        this.day = day;
        this.period = period;
        this.subject = subject;
        this.teacher = teacher;
        this.classroom = classroom;
        this.time = time;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // Convenience method to check if the DTO has valid data
    public boolean isValid() {
        return day != null && !day.isEmpty()
                && period != null && !period.isEmpty()
                && subject != null && !subject.isEmpty()
                && teacher != null && !teacher.isEmpty()
                && classroom != null && !classroom.isEmpty()
                && time != null && !time.isEmpty();
    }

    @Override
    public String toString() {
        return "TimetableEntryDTO{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", period='" + period + '\'' +
                ", subject='" + subject + '\'' +
                ", teacher='" + teacher + '\'' +
                ", classroom='" + classroom + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
