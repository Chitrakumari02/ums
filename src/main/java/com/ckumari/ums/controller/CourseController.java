package com.ckumari.ums.controller;

import com.ckumari.ums.entity.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/course")
public class CourseController {

    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course()); // Assuming Course is your entity class
        return "add-course"; // Return the Thymeleaf template name
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        // Logic to save the course to the database
        // CourseService.save(course);
        return "redirect:/admin"; // Redirect back to admin dashboard after saving
    }
}
