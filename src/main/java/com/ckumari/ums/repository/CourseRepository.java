package com.ckumari.ums.repository;

import com.ckumari.ums.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
