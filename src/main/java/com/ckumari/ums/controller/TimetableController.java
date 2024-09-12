package com.ckumari.ums.controller;

import com.ckumari.ums.entity.ClassSection;
import com.ckumari.ums.entity.Course;
import com.ckumari.ums.entity.TimetableEntry;
import com.ckumari.ums.service.ClassSectionService;
import com.ckumari.ums.service.CourseService;
import com.ckumari.ums.service.TimetableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TimetableController {

    private final CourseService courseService;
    private final ClassSectionService classSectionService;
    private final TimetableService timetableService;

    public TimetableController(CourseService courseService, TimetableService timetableService, ClassSectionService classSectionService) {
        this.courseService = courseService;
        this.timetableService = timetableService;
        this.classSectionService = classSectionService;
    }

    @GetMapping("/timetable")
    public String showTimetable(Model model) {
        List<Course> courses = courseService.getAllCourses(); // Updated method call
        List<ClassSection> classSections = classSectionService.findAll(); // Updated method call
        model.addAttribute("courses", courses);
        model.addAttribute("classSections", classSections);
        return "timetable";
    }

    @GetMapping("/view-timetable")
    public String viewTimetable(@RequestParam("course") Long courseId,
                                @RequestParam("classSection") Long classSectionId,
                                Model model) {
        List<TimetableEntry> timetable = timetableService.getTimetableByCourseAndClassSection(courseId, classSectionId);
        System.out.println("Fetched Timetable: " + timetable);  // Debugging line
        model.addAttribute("timetable", timetable);
        return "view-timetable";
    }

}
