package com.ftn.sbnz.backward.service;

import com.ftn.sbnz.backward.service.models.*;
import com.ftn.sbnz.backward.service.repository.StudentRepository;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@ComponentScan(basePackages = {"com.ftn.sbnz.backward.service.controllers", "com.ftn.sbnz.backward.service.services", "com.ftn.sbnz.backward.service.repository", "com.ftn.sbnz.backward.service.models"})
@SpringBootApplication(scanBasePackages = { "com.ftn.sbnz.backward.model", "com.ftn.sbnz.backward.kjar" })
@EnableJpaRepositories("com.ftn.sbnz.backward.service.repository")
public class BackwardServiceApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackwardServiceApplication.class, args);
	}
	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks
				.newKieContainer(ks.newReleaseId("com.ftn.sbnz", "backward-kjar", "0.0.1-SNAPSHOT"));
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(1000);
		return kContainer;
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.deleteAll();


		List<PersonalityTrait> personalityTraits1 = new ArrayList<>();
		personalityTraits1.add(PersonalityTrait.CREATIVE);
		personalityTraits1.add(PersonalityTrait.EXTROVERTED);
		personalityTraits1.add(PersonalityTrait.ANALYTICAL);

		Student student = new Student( "Pera", "Peric", personalityTraits1, Field.NATURAL_SCIENCES, "user1", "user1", Role.STUDENT);
		student.setField(Field.NATURAL_SCIENCES);
		student.setShouldTriggerBackward(true);
		student.setProsek(10.00);

		Subject sub1 = new Subject("matematika", SubjectName.MATHS);
		Subject sub2 = new Subject("fizika", SubjectName.PHYSICS);
		sub1.setStudent(student);
		sub2.setStudent(student);
		student.getSubjects().add(sub1);
		student.getSubjects().add(sub2);

		Student student1 = new Student();
		student1.setName("John");
		student1.setSurname("Doe");
		student1.setField(Field.ARTS);
		List<PersonalityTrait> personalityTraitList1 = new ArrayList<PersonalityTrait>();
		personalityTraitList1.add(PersonalityTrait.CREATIVE);
		personalityTraitList1.add(PersonalityTrait.EXTROVERTED);
		student1.setPersonalityTraits(personalityTraitList1);
		student1.setProsek(9.25);

		Student student2 = new Student();
		student2.setName("Jane");
		student2.setSurname("Doe");
		student2.setField(Field.SOCIAL_SCIENCES);
		student2.setProsek(6.00);

		Student student3 = new Student();
		student3.setName("Alice");
		student3.setSurname("Smith");
		student3.setField(Field.MEDICAL_SCIENCES);
		student3.setProsek(6.50);

		studentRepository.save(student);
		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);
	}
}

