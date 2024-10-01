package com.ckumari.ums.controller;

import com.ckumari.ums.entity.ClassSection;
import com.ckumari.ums.service.ClassSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/class-section")
public class ClassSectionController {

    @Autowired
    private ClassSectionService classSectionService;

    @PostMapping("/save")
    public ClassSection saveClassSection(@RequestBody ClassSection classSection) {
        return classSectionService.saveClassSection(classSection);
    }

    @GetMapping("/all")
    public List<ClassSection> getAllClassSections() {
        return classSectionService.getAllClassSections();
    }
}
