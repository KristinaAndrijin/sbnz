package com.ftn.sbnz.backward.service.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ftn.sbnz.backward.service.models.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivateBackwardRulesService {
  private final KieContainer kieContainer;

  @Autowired
  public ActivateBackwardRulesService(KieContainer kieContainer) {
    this.kieContainer = kieContainer;
  }

  public void fireRules() {
    KieSession kSession = kieContainer.newKieSession();

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
    Student s1 = new Student( "Pera", "Peric", subjects1, personalityTraits1, Field.NATURAL_SCIENCES);
    s1.setField(Field.NATURAL_SCIENCES);
    s1.setShouldTriggerBackward(true);

    kSession.insert(s1);

    // BACKWARD CHAINING
    // metod ucenja -> predmet -> tip licnosti
    kSession.insert(new Connected("GROUP_LEARNING", "PHYSICS"));
    kSession.insert(new Connected("AUDITORY", "HISTORY"));
    kSession.insert(new Connected("VISUAL", "ENGLISH"));
    kSession.insert(new Connected("LEARNING_THROUGH_PLAY", "PROGRAMMING"));
    kSession.insert(new Connected("LOGICAL_MATHEMATICAL", "MATHEMATICS"));
    kSession.insert(new Connected("KINESTHETIC", "ART"));
    kSession.insert(new Connected("VERBAL", "PHYSICS"));
    kSession.insert(new Connected("AUDIO_VISUAL", "HISTORY"));

    kSession.insert(new Connected("PHYSICS", "EXTROVERTED"));
    kSession.insert(new Connected("HISTORY", "INTROVERTED"));
    kSession.insert(new Connected("ENGLISH", "ANALYTICAL"));
    kSession.insert(new Connected("PROGRAMMING", "CREATIVE"));
    kSession.insert(new Connected("MATHEMATICS", "PRACTICAL"));
    kSession.insert(new Connected("ART", "ORGANIZED"));
    kSession.insert(new Connected("PROGRAMMING", "REFLECTIVE"));
    kSession.insert(new Connected("MATHEMATICS", "INTROVERT"));

    kSession.insert("backward2");
    int fired = kSession.fireAllRules();
//    System.out.println(fired);
//    System.out.println("---");
    System.out.println("----------------------final--------------------------------");
    // s1.setLearningMethodsUpdated(false);
    // System.out.println(s1);
    // kSession.insert("create recommendation learning methods list based on subjects");
    // kSession.insert("create recommendation learning methods list based on field");
//    kSession.insert("personality traits empty");
    }


  public Student fireForward(Student s) {
    KieSession kSession = kieContainer.newKieSession();
    try {
      kSession.insert(s);
      kSession.fireAllRules();
      System.out.println(s + "\n");
      return s;
    } finally {
      kSession.dispose();
    }
  }


  public Student fireBackward(Student s, LearningMethod method) {
    KieSession kSession = kieContainer.newKieSession();
    try {
      kSession.insert(s);

      String methodAsString = method.toString();
      kSession.insert(methodAsString);

      kSession.insert(new Connected("AUDITORY", "CREATIVE"));


      kSession.insert(new Connected("GROUP_LEARNING", "PHYSICS"));
      kSession.insert(new Connected("AUDITORY", "HISTORY"));
      kSession.insert(new Connected("VISUAL", "ENGLISH"));
      kSession.insert(new Connected("LEARNING_THROUGH_PLAY", "PROGRAMMING"));
      kSession.insert(new Connected("LOGICAL_MATHEMATICAL", "MATHEMATICS"));
      kSession.insert(new Connected("KINESTHETIC", "ART"));
      kSession.insert(new Connected("VERBAL", "PHYSICS"));
      kSession.insert(new Connected("AUDIO_VISUAL", "HISTORY"));

      kSession.insert(new Connected("PHYSICS", "EXTROVERTED"));
      kSession.insert(new Connected("HISTORY", "INTROVERTED"));
      kSession.insert(new Connected("ENGLISH", "ANALYTICAL"));
      kSession.insert(new Connected("PROGRAMMING", "CREATIVE"));
      kSession.insert(new Connected("MATHEMATICS", "PRACTICAL"));
      kSession.insert(new Connected("ART", "ORGANIZED"));
      kSession.insert(new Connected("PROGRAMMING", "REFLECTIVE"));
      kSession.insert(new Connected("MATHEMATICS", "INTROVERT"));

      kSession.insert("backward2");
      kSession.fireAllRules();
      System.out.println("----------------------final--------------------------------");

      System.out.println(s + "\n");
      return s;
    } finally {
      kSession.dispose();
    }

  }
}
