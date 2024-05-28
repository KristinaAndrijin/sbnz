package com.ftn.sbnz.backward.service.repository;

import com.ftn.sbnz.backward.service.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}