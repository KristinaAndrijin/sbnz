package com.ftn.sbnz.backward.service.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ftn.sbnz.backward.service.models.*;
import com.ftn.sbnz.backward.service.repository.StudentRepository;
import org.checkerframework.checker.units.qual.A;
import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ActivateBackwardRulesService {
    private final KieContainer kieContainer;
    private final StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ActivateBackwardRulesService(KieContainer kieContainer, StudentRepository studentRepository) {
        this.kieContainer = kieContainer;
        this.studentRepository = studentRepository;
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

        Student s1 = new Student("Pera", "Peric", subjects1, personalityTraits1, Field.NATURAL_SCIENCES, "pera", bCryptPasswordEncoder.encode("123"));

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


    public boolean fireBackward(Student s, LearningMethod method) {
        KieSession kSession = kieContainer.newKieSession();
        try {

            AtomicBoolean methodAccepted = new AtomicBoolean(false);
            kSession.insert(methodAccepted);

            kSession.insert(s);

            String methodAsString = method.toString();
            kSession.insert(methodAsString);

            kSession.setGlobal("yValue", methodAsString);

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

            if (methodAccepted.get()) {
                System.out.println("Condition met in at least one iteration");
                return true;
            } else {
                System.out.println("Condition not met in any iteration");
                return false;
            }
        } finally {
            kSession.dispose();
        }

    }


    public List<LearningMethod> fireReport1() {
        List<LearningMethod> result = new ArrayList<>();
        KieSession kSession = kieContainer.newKieSession();
        try {
            List<Student> students = studentRepository.findAll(); // Pretpostavljam da imate repozitorijum za studente

            for (Student student : students) {
                kSession.insert(student);
            }

            System.out.println("report1");
            kSession.insert("report1");
            kSession.fireAllRules();

            Collection<Object> objects = (Collection<Object>) kSession.getObjects();

            // Pretraga globalne promenljive koja sadrži listu learningMethods
            List<LearningMethod> learningMethods = new ArrayList<>();
            for (Object object : objects) {
                if (object instanceof List && ((List<?>) object).get(0) instanceof LearningMethod) {
                    learningMethods = (List<LearningMethod>) object;
                    break;
                }
            }

            // Ispisivanje pronađenih learningMethods
            for (LearningMethod method : learningMethods) {
                System.out.println(method);
            }

            return learningMethods;

        } finally {
            kSession.dispose();
        }
    }


    public void fireTemplate1(Student s, LearningMethod method) throws FileNotFoundException {
      InputStream templateFieldRecommendations = new FileInputStream("C:/Users/andre/OneDrive/Documents/GitHub/sbnz/backward-example/backward-kjar/src/main/resources/rules/template1.drt");

        //field na osnovu metoda
        String[][] data = {
                {"NATURAL_SCIENCES", "KINESTHETIC"},
                {"MATS", "VERBAL"},
                {"SOCIAL_SCIENCES", "AUDITORY"},
                {"MEDICAL_SCIENCES", "VISUAL"},
                {"ARTS", "AUDIO_VISUAL"},
                {"LANGUAGES", "GROUP_LEARNING"},
                {"LECAL_ECONOMIC_SCIENCES", "LOGICAL_MATHEMATICAL"},
                {"ARGICULTURE_ENVIRONMENTAL_SCIENCES", "LOGICAL_MATHEMATICAL"},
                {"TECHNICAL_SCIENCES", "LEARNING_THROUGH_PLAY"}
        };

        DataProvider dataProvider = new ArrayDataProvider(data);

        DataProviderCompiler converter = new DataProviderCompiler();
        String drlFieldRecommendations = converter.compile(dataProvider, templateFieldRecommendations);

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drlFieldRecommendations, ResourceType.DRL);

        KieBase kieBase = kieHelper.build();
        KieSession kieSession = kieBase.newKieSession();

        ArrayList<String> recommendations = new ArrayList<>();
        kieSession.setGlobal("recommendations", recommendations);

//        for (Field field : Field.values()) {
//            kieSession.insert(field);
//        }
        kieSession.insert(s);
        kieSession.insert(method.toString());


        kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println(recommendations);

    }
}
