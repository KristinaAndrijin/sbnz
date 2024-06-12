package com.ftn.sbnz.backward.service.controllers;

import com.ftn.sbnz.backward.service.models.LearningMethod;
import com.ftn.sbnz.backward.service.models.PersonalityTrait;
import com.ftn.sbnz.backward.service.models.Student;
import com.ftn.sbnz.backward.service.models.Subject;
import com.ftn.sbnz.backward.service.repository.StudentRepository;
import com.ftn.sbnz.backward.service.services.ActivateBackwardRulesService;
import com.ftn.sbnz.backward.service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private final StudentService studentService;

    @Autowired
    private ActivateBackwardRulesService backService;


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

    @PutMapping("/{studentId}/traits")
    public ResponseEntity<?> updateStudentTraits(@PathVariable Long studentId, @RequestBody List<PersonalityTrait> personalityTraits) {
        try {
            studentService.updateStudentTraits(studentId, personalityTraits);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student personality traits");
        }
    }

    @GetMapping("/{id}/forward1")
    public ResponseEntity<List<LearningMethod>> getMethodForward1(@PathVariable Long id) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            backService.fireForward(student);
            return ResponseEntity.ok(student.getLearningMethodsForward1());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/forward2")
    public ResponseEntity<List<LearningMethod>> getMethodForward2(@PathVariable Long id) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            backService.fireForward(student);
            return ResponseEntity.ok(student.getLearningMethodsForward2());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/forward12")
    public ResponseEntity<List<LearningMethod>> getMethodForward12(@PathVariable Long id) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            backService.fireForward(student);
            return ResponseEntity.ok(student.getLearningMethods());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/backward")
    public ResponseEntity<LearningMethod> getLearningMethodsBackward(@PathVariable Long id,@RequestParam LearningMethod method) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            System.out.println(method);
            Student student = studentOpt.get();
            backService.fireBackward(student, method);
            return ResponseEntity.ok(method);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getReport1")
    public ResponseEntity<List<LearningMethod>> getReport1() {
        try {
            List<LearningMethod> learningMethods = new ArrayList<>();
            backService.fireReport1();
            System.out.println(learningMethods);
            return ResponseEntity.ok(learningMethods);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}