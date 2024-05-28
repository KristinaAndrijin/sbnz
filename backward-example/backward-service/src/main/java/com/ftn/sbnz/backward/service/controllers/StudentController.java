package com.ftn.sbnz.backward.service.controllers;

import com.ftn.sbnz.backward.service.models.Student;
import com.ftn.sbnz.backward.service.models.Subject;
import com.ftn.sbnz.backward.service.repository.StudentRepository;
import com.ftn.sbnz.backward.service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{studentId}/subjects")
    public ResponseEntity<?> updateStudentSubjects(@PathVariable Long studentId, @RequestBody List<Subject> subjects) {
        try {
            studentService.updateStudentSubjects(studentId, subjects);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student subjects");
        }
    }
}
