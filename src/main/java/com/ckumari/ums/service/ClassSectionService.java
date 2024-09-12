// ClassSectionService.java
package com.ckumari.ums.service;

import com.ckumari.ums.entity.ClassSection;
import com.ckumari.ums.repository.ClassSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassSectionService {
    @Autowired
    private ClassSectionRepository classSectionRepository;

    public List<ClassSection> getAllClassSections() {
        return classSectionRepository.findAll();
    }

    public ClassSection getClassSectionById(Long id) {
        return classSectionRepository.findById(id).orElse(null);
    }

    public ClassSection saveClassSection(ClassSection classSection) {
        return classSectionRepository.save(classSection);
    }

    public void deleteClassSection(Long id) {
        classSectionRepository.deleteById(id);
    }
    public List<ClassSection> findAll() {
        return classSectionRepository.findAll();
    }

}
