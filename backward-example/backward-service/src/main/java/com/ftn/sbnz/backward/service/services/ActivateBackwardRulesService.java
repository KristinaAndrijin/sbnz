package com.ftn.sbnz.backward.service.services;

import com.ftn.sbnz.backward.model.models.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
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


    List<Subject> subjects1 = new ArrayList<>();
    Subject sub1 = new Subject(1, "matematika", SubjectName.MATHS);
    Subject sub2 = new Subject(2, "fizika", SubjectName.PHYSICS);
    kSession.insert(sub1);
    kSession.insert(sub2);
    subjects1.add(sub1);
    subjects1.add(sub2);
    // subjects1.add(new Subject(1, "matematika", SubjectName.MATHS));
    // subjects1.add(new Subject(2, "fizika", SubjectName.PHYSICS));
    // subjects1.add(new Subject(1, "za sta je ovaj string",  SubjectName.MATHS));
    // subjects1.add(new Subject(2, "za sta je ovaj string", SubjectName.PHYSICS));

    List<PersonalityTrait> personalityTraits1 = new ArrayList<>();
    personalityTraits1.add(PersonalityTrait.CREATIVE);
    personalityTraits1.add(PersonalityTrait.EXTROVERTED);
    Student s1 = new Student(1, "Pera", "Peric", subjects1, personalityTraits1, Field.ARTS);
    s1.setField(Field.ARTS);
    kSession.insert(s1);

//    kSession.insert("personality traits empty");
//    kSession.fireAllRules();
//    System.out.println("---");

    kSession.insert("recommend learning methods for field - NATURAL SCIENCES");
    kSession.insert("recommend learning methods for field - SOCIAL SCIENCES");
    kSession.insert("recommend learning methods for field - MEDICAL SCIENCES");
    kSession.insert("recommend learning methods for field - ARTS");
    kSession.insert("recommend learning methods for field - LANGUAGES");
    kSession.insert("recommend learning methods for field - TECHNICAL SCIENCES");
    kSession.insert("recommend learning methods for field - LECAL ECONOMIC SCIENCES");
    kSession.insert("recommend learning methods for field - ARGICULTURE ENVIRONMENTAL SCIENCES");

    kSession.fireAllRules();
    System.out.println("---");
    System.out.println(s1);
    System.out.println("----------------------final--------------------------------");
    kSession.insert("create recommendation learning methods list");
    kSession.fireAllRules();
    System.out.println(s1);
    System.out.println("stundetttt" + s1);

//    kSession.insert("field analyse");
//    kSession.fireAllRules();
//    System.out.println("---");



//    kSession.insert("personality traits empty");
//    kSession.fireAllRules();
//    System.out.println("---");
//
//    kSession.insert("personality traits not empty");
//    kSession.fireAllRules();
//    System.out.println("---");

//    QueryResults results = kSession.getQueryResults("personality traits empty");
//    if (results.size() > 0) {
//      System.out.println("Pravilo 'backward' je ispunjeno.");
//      // Možete dalje obraditi rezultate ili izvršiti neke akcije ako je pravilo ispunjeno
//    } else {
//      System.out.println("Pravilo 'backward' nije ispunjeno.");
//    }
//      kSession.insert("go1");
//      kSession.fireAllRules();
//      System.out.println("---");
//
//    kSession.insert( "go2" );
//    kSession.fireAllRules();
//    System.out.println("---");
//
//    kSession.insert( "go3" );
//    kSession.fireAllRules();
//    System.out.println("---");
//
//    kSession.insert( new Location("Key", "Draw") );
//    kSession.fireAllRules();
//    System.out.println("---");
//
//    kSession.insert( "go4" );
//    kSession.fireAllRules();
//    System.out.println("---");
//
//    kSession.insert( "go5" );
//    kSession.fireAllRules();
    }
  }

