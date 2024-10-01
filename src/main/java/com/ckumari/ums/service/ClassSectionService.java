package com.ckumari.ums.service;

import com.ckumari.ums.entity.ClassSection;
import com.ckumari.ums.repository.ClassSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassSectionService {

    private final ClassSectionRepository classSectionRepository;

    @Autowired
    public ClassSectionService(ClassSectionRepository classSectionRepository) {
        this.classSectionRepository = classSectionRepository;
    }

    public List<ClassSection> getAllClassSections() {
        return classSectionRepository.findAll();
    }

    public ClassSection getClassSectionById(Long id) {
        Optional<ClassSection> optionalClassSection = classSectionRepository.findById(id);
        return optionalClassSection.orElse(null);
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
