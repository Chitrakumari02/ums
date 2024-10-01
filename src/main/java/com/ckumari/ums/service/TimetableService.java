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
import java.util.Optional;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final CourseRepository courseRepository;
    private final ClassSectionRepository classSectionRepository;

    @Autowired
    public TimetableService(TimetableRepository timetableRepository, CourseRepository courseRepository, ClassSectionRepository classSectionRepository) {
        this.timetableRepository = timetableRepository;
        this.courseRepository = courseRepository;
        this.classSectionRepository = classSectionRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<ClassSection> getAllClassSections() {
        return classSectionRepository.findAll();
    }

    public List<TimetableEntry> getAllTimetableEntries() {
        return timetableRepository.findAll();
    }

    public List<TimetableEntry> getTimetableByCourseAndClassSection(Long courseId, Long classSectionId) {
        return timetableRepository.findByCourseIdAndClassSectionId(courseId, classSectionId);
    }

    public void saveTimetableEntry(TimetableEntry timetableEntry) {
        timetableRepository.save(timetableEntry);
    }

    public TimetableEntry getTimetableEntryById(Long id) {
        Optional<TimetableEntry> optionalTimetableEntry = timetableRepository.findById(id);
        return optionalTimetableEntry.orElse(null);
    }

    public void deleteTimetableEntry(Long id) {
        timetableRepository.deleteById(id);
    }
}
