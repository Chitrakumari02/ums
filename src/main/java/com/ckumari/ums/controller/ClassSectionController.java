// ClassSectionController.java
package com.ckumari.ums.controller;

import com.ckumari.ums.entity.ClassSection;
import com.ckumari.ums.service.ClassSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class-sections")
public class ClassSectionController {
    @Autowired
    private ClassSectionService classSectionService;

    @GetMapping
    public List<ClassSection> getAllClassSections() {
        return classSectionService.getAllClassSections();
    }

    @GetMapping("/{id}")
    public ClassSection getClassSectionById(@PathVariable Long id) {
        return classSectionService.getClassSectionById(id);
    }

    @PostMapping
    public ClassSection createClassSection(@RequestBody ClassSection classSection) {
        return classSectionService.saveClassSection(classSection);
    }

    @DeleteMapping("/{id}")
    public void deleteClassSection(@PathVariable Long id) {
        classSectionService.deleteClassSection(id);
    }
}
