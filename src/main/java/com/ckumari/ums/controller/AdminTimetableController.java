package com.ckumari.ums.controller;

import com.ckumari.ums.entity.ClassSection;
import com.ckumari.ums.entity.Course;
import com.ckumari.ums.entity.TimetableEntry;
import com.ckumari.ums.service.ClassSectionService;
import com.ckumari.ums.service.CourseService;
import com.ckumari.ums.service.TimetableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/timetable")
public class AdminTimetableController {

    private final CourseService courseService;
    private final ClassSectionService classSectionService;
    private final TimetableService timetableService;

    public AdminTimetableController(CourseService courseService, TimetableService timetableService, ClassSectionService classSectionService) {
        this.courseService = courseService;
        this.timetableService = timetableService;
        this.classSectionService = classSectionService;
    }

    @GetMapping("/add")
    public String showAddTimetableEntryForm(Model model) {
        TimetableEntry timetableEntry = new TimetableEntry();

        // Initialize 8 periods for the form
        List<TimetableEntry.Period> periods = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            periods.add(new TimetableEntry.Period());
        }
        timetableEntry.setPeriods(periods);

        model.addAttribute("timetableEntry", timetableEntry);
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("sections", classSectionService.getAllClassSections());

        return "admin-add-timetable";
    }

    @PostMapping("/save")
    public String saveTimetableEntry(@ModelAttribute("timetableEntry") TimetableEntry timetableEntry,
                                     @RequestParam("course_id") Long courseId,
                                     @RequestParam("class_section_id") Long classSectionId) {
        Course course = courseService.getCourseById(courseId);
        ClassSection classSection = classSectionService.getClassSectionById(classSectionId);

        timetableEntry.setCourse(course);
        timetableEntry.setClassSection(classSection);
        timetableService.saveTimetableEntry(timetableEntry);

        return "redirect:/admin/dashboard";
    }

    @GetMapping("/view")
    public String viewTimetableEntries(Model model) {
        List<TimetableEntry> timetableEntries = timetableService.getAllTimetableEntries();
        model.addAttribute("timetableEntries", timetableEntries);
        return "admin-view-timetable";
    }

    @GetMapping("/edit/{id}")
    public String showEditTimetableEntryForm(@PathVariable Long id, Model model) {
        TimetableEntry timetableEntry = timetableService.getTimetableEntryById(id);
        if (timetableEntry != null) {
            model.addAttribute("timetableEntry", timetableEntry);
            model.addAttribute("courses", courseService.getAllCourses());
            model.addAttribute("sections", classSectionService.getAllClassSections());
            return "admin-edit-timetable";
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/update/{id}")
    public String updateTimetableEntry(@PathVariable Long id, @ModelAttribute("timetableEntry") TimetableEntry updatedTimetableEntry,
                                       @RequestParam("courseId") Long courseId,
                                       @RequestParam("classSectionId") Long classSectionId) {
        TimetableEntry timetableEntry = timetableService.getTimetableEntryById(id);
        if (timetableEntry != null) {
            Course course = courseService.getCourseById(courseId);
            ClassSection classSection = classSectionService.getClassSectionById(classSectionId);

            timetableEntry.setCourse(course);
            timetableEntry.setClassSection(classSection);
            timetableEntry.setDay(updatedTimetableEntry.getDay());
            timetableEntry.setPeriod(updatedTimetableEntry.getPeriod());
            timetableEntry.setSubject(updatedTimetableEntry.getSubject());
            timetableEntry.setTeacher(updatedTimetableEntry.getTeacher());
            timetableEntry.setClassroom(updatedTimetableEntry.getClassroom());

            timetableService.saveTimetableEntry(timetableEntry);
        }
        return "redirect:/admin/timetable/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteTimetableEntry(@PathVariable Long id) {
        timetableService.deleteTimetableEntry(id);
        return "redirect:/admin/timetable/view";
    }
}
