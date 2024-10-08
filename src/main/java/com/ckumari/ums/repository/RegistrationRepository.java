package com.ckumari.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ckumari.ums.entity.Registration;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String>{

    Optional<Registration> findByEmail(String email);
}