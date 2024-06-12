package com.ftn.sbnz.backward.service.repository;

import com.ftn.sbnz.backward.service.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
