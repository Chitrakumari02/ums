package com.ckumari.ums.repository;

import com.ckumari.ums.entity.TimetableEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<TimetableEntry, Long> {

    // If ClassSection has a relationship with Course, use this method:
    @Query("SELECT t FROM TimetableEntry t WHERE t.classSection.course.id = :courseId AND t.classSection.id = :classSectionId")
    List<TimetableEntry> findByCourseIdAndClassSectionId(@Param("courseId") Long courseId, @Param("classSectionId") Long classSectionId);

    // Find timetable entries by ClassSection ID only:
    @Query("SELECT t FROM TimetableEntry t WHERE t.classSection.id = :classSectionId")
    List<TimetableEntry> findByClassSectionId(@Param("classSectionId") Long classSectionId);



}
