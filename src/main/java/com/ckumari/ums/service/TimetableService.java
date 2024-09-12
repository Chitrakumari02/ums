// TimetableService.java
package com.ckumari.ums.service;

import com.ckumari.ums.entity.ClassSection;
import com.ckumari.ums.entity.Course;
import com.ckumari.ums.entity.TimetableEntry;
import com.ckumari.ums.repository.ClassSectionRepository;
import com.ckumari.ums.repository.CourseRepository;
import com.ckumari.ums.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassSectionRepository classSectionRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<ClassSection> getAllClassSections() {
        return classSectionRepository.findAll();
    }

    public List<TimetableEntry> getTimetableForCourseAndSection(Long courseId, Long classSectionId) {
        return timetableRepository.findByCourseIdAndClassSectionId(courseId, classSectionId);
    }

    public List<TimetableEntry> getAllTimetableEntries() {
        return timetableRepository.findAll();
    }

    public List<TimetableEntry> getTimetableByCourseAndClassSection(Long courseId, Long classSectionId) {
        return timetableRepository.findByCourseIdAndClassSectionId(courseId, classSectionId);
    }


}

