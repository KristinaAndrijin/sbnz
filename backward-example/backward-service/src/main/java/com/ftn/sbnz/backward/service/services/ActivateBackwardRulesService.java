package com.ftn.sbnz.backward.service.services;

import com.ftn.sbnz.backward.model.models.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivateBackwardRulesService {
  private final KieContainer kieContainer;

  @Autowired
  public ActivateBackwardRulesService(KieContainer kieContainer) {
    this.kieContainer = kieContainer;
  }

  public void fireRules() {
    KieSession kSession = kieContainer.newKieSession();

    // kSession.insert("say hey");
    // int fir = kSession.fireAllRules();
    // System.out.println("fir " + fir);

    kSession.insert(new Location("Office", "House"));
    kSession.insert(new Location("Kitchen", "House"));
    kSession.insert(new Location("Knife", "Kitchen"));
    kSession.insert(new Location("Cheese", "Kitchen"));
    kSession.insert(new Location("Desk", "Office"));
    kSession.insert(new Location("Chair", "Office"));
    kSession.insert(new Location("Computer", "Desk"));
    kSession.insert(new Location("Draw", "Desk"));

    kSession.insert(PersonalityTrait.EXTROVERTED);
    kSession.insert(PersonalityTrait.INTROVERTED);
    kSession.insert(PersonalityTrait.ANALYTICAL);
    kSession.insert(PersonalityTrait.CREATIVE);
    kSession.insert(PersonalityTrait.PRACTICAL);
    kSession.insert(PersonalityTrait.ORGANIZED);
    kSession.insert(PersonalityTrait.REFLECTIVE);

    kSession.insert(LearningMethod.VERBAL);
    kSession.insert(LearningMethod.AUDITORY);
    kSession.insert(LearningMethod.VISUAL);
    kSession.insert(LearningMethod.KINESTHETIC);
    kSession.insert(LearningMethod.AUDIO_VISUAL);
    kSession.insert(LearningMethod.GROUP_LEARNING);
    kSession.insert(LearningMethod.LOGICAL_MATHEMATICAL);
    kSession.insert(LearningMethod.LEARNING_THROUGH_PLAY);

    kSession.insert(SubjectName.PHYSICS);
    kSession.insert(SubjectName.HISTORY);
    kSession.insert(SubjectName.ENGLISH);
    kSession.insert(SubjectName.PROGRAMMING);
    kSession.insert(SubjectName.MATHS);
    kSession.insert(SubjectName.ARTS);

    kSession.insert(Field.NATURAL_SCIENCES);
    kSession.insert(Field.SOCIAL_SCIENCES);
    kSession.insert(Field.MEDICAL_SCIENCES);
    kSession.insert(Field.ARTS);
    kSession.insert(Field.LANGUAGES);
    kSession.insert(Field.TECHNICAL_SCIENCES);
    kSession.insert(Field.LECAL_ECONOMIC_SCIENCES);
    kSession.insert(Field.ARGICULTURE_ENVIRONMENTAL_SCIENCES);

    List<Subject> subjects1 = new ArrayList<>();
    Subject sub1 = new Subject(1, "matematika", SubjectName.MATHS);
    Subject sub2 = new Subject(2, "fizika", SubjectName.PHYSICS);
    kSession.insert(sub1);
    kSession.insert(sub2);
    subjects1.add(sub1);
    subjects1.add(sub2);
    List<PersonalityTrait> personalityTraits1 = new ArrayList<>();
    personalityTraits1.add(PersonalityTrait.CREATIVE);
    personalityTraits1.add(PersonalityTrait.EXTROVERTED);
    personalityTraits1.add(PersonalityTrait.ANALYTICAL);
    Student s1 = new Student(1, "Pera", "Peric", subjects1, personalityTraits1, Field.NATURAL_SCIENCES);
    s1.setField(Field.NATURAL_SCIENCES);

    kSession.insert(s1);

    // System.out.println("---Personality trait rules---");
    // kSession.insert("personality traits empty");
    // kSession.insert("recommend learning methods for personality trait - EXTROVERTED");
    // kSession.insert("recommend learning methods for personality trait - INTROVERTED");
    // kSession.insert("recommend learning methods for personality trait - ANALYTICAL");
    // kSession.insert("recommend learning methods for personality trait - CREATIVE");
    // kSession.insert("recommend learning methods for personality trait - PRACTICAL");
    // kSession.insert("recommend learning methods for personality trait - ORGANIZED");
    // kSession.insert("recommend learning methods for personality trait - REFLECTIVE");
    // System.out.println("---");

    // // int fired = kSession.fireAllRules();
    // // System.out.println(fired);

    // System.out.println("---Field rules---");
    // kSession.insert("recommend learning methods for field - NATURAL SCIENCES");
    // kSession.insert("recommend learning methods for field - SOCIAL SCIENCES");
    // kSession.insert("recommend learning methods for field - MEDICAL SCIENCES");
    // kSession.insert("recommend learning methods for field - ARTS");
    // kSession.insert("recommend learning methods for field - LANGUAGES");
    // kSession.insert("recommend learning methods for field - TECHNICAL SCIENCES");
    // kSession.insert("recommend learning methods for field - LECAL ECONOMIC SCIENCES");
    // kSession.insert("recommend learning methods for field - ARGICULTURE ENVIRONMENTAL SCIENCES");
    // System.out.println("---");

    System.out.println("---Subject name rules---");
    // kSession.insert("recommend learning methods for subject - PHYSICS");
    // kSession.insert("recommend learning methods for field - SOCIAL SCIENCES");
    // kSession.insert("recommend learning methods for field - MEDICAL SCIENCES");
    // kSession.insert("recommend learning methods for field - ARTS");
    // kSession.insert("recommend learning methods for field - LANGUAGES");
    // kSession.insert("recommend learning methods for field - TECHNICAL SCIENCES");
    // kSession.insert("recommend learning methods for field - LECAL ECONOMIC SCIENCES");
    // kSession.insert("recommend learning methods for field - ARGICULTURE ENVIRONMENTAL SCIENCES");
    System.out.println("---");

    kSession.insert(new Connected("ucenje u grupi", "fizika"));
    kSession.insert(new Connected("auditivno", "istorija"));
    kSession.insert(new Connected("vizuelno", "engleski"));
    kSession.insert(new Connected("ucenje kroz igru", "programiranje"));
    kSession.insert(new Connected("logicko_matematicko", "matematika"));
    kSession.insert(new Connected("kinesteticko", "umetnost"));
    kSession.insert(new Connected("verbalno", "fizika"));
    kSession.insert(new Connected("audio_vizuelno", "istorija"));

    kSession.insert(new Connected("fizika", "ekstrovert"));
    kSession.insert(new Connected("istorija", "introvert"));
    kSession.insert(new Connected( "engleski", "analiticar"));
    kSession.insert(new Connected( "programiranje", "kreativna_licnost"));
    kSession.insert(new Connected( "matematika", "prakticna_licnost"));
    kSession.insert(new Connected( "umetnost", "organizovana_licnost"));
    kSession.insert(new Connected( "programiranje", "ekstrovert"));
    kSession.insert(new Connected( "matematika", "introvert"));

    kSession.insert("backward");
    int fired = kSession.fireAllRules();
    System.out.println(fired);
    System.out.println("---");
    System.out.println("----------------------final--------------------------------");
    // s1.setLearningMethodsUpdated(false);
    System.out.println(s1);
    // kSession.insert("create recommendation learning methods list based on subjects");
    // kSession.insert("create recommendation learning methods list based on field");
    // kSession.fireAllRules();
    // System.out.println(s1);

//    kSession.insert("personality traits empty");
//    kSession.fireAllRules();
//    System.out.println("---");
    }
  }

