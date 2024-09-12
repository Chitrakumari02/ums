// ClassSectionRepository.java
package com.ckumari.ums.repository;

import com.ckumari.ums.entity.ClassSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassSectionRepository extends JpaRepository<ClassSection, Long> {
    // Custom query methods can be added here if needed
}
