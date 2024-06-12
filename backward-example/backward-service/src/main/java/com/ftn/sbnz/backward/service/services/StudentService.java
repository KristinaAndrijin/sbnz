package com.ftn.sbnz.backward.service.services;

import com.ftn.sbnz.backward.service.models.PersonalityTrait;
import com.ftn.sbnz.backward.service.models.Student;
import com.ftn.sbnz.backward.service.models.Subject;
import com.ftn.sbnz.backward.service.models.SubjectName;
import com.ftn.sbnz.backward.service.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void updateStudentSubjects(Long studentId, List<Subject> subjects) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " not found"));

        student.getSubjects().clear();

        for (Subject s : subjects){
            s.setStudent(student);
            student.getSubjects().add(s);
        }

        studentRepository.save(student);
    }

    public void updateStudentTraits(Long studentId, List<PersonalityTrait> personalityTraits) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " not found"));

        student.getPersonalityTraits().clear();

        student.setPersonalityTraits(personalityTraits);

        System.out.println(student.getPersonalityTraits());

        studentRepository.save(student);
    }

}