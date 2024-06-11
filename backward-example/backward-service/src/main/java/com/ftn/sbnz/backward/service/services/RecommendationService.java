package com.ftn.sbnz.backward.service.services;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.backward.service.models.*;

@Service
public class RecommendationService {
    private final KieContainer kieContainer;


    private Map<PersonalityTrait, List<LearningMethod>> traitRecommendations;
    private Map<SubjectName, List<LearningMethod>> subjectRecommendations;
    private Map<Field, List<LearningMethod>> fieldRecommendations;

    @Autowired
    public RecommendationService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
        this.traitRecommendations = this.getTraitRecommendations();
        this.subjectRecommendations = this.getSubjectRecommendations();
        this.fieldRecommendations = this.getFieldRecommendations();
    }

    public Map<PersonalityTrait, List<LearningMethod>> getTraitRecommendations() {
        Map<PersonalityTrait, List<LearningMethod>> traitRecommendationMap = new HashMap<>();

        traitRecommendationMap.put(PersonalityTrait.EXTROVERTED, Arrays.asList(
            LearningMethod.GROUP_LEARNING,
            LearningMethod.AUDITORY,
            LearningMethod.VISUAL
        ));
        traitRecommendationMap.put(PersonalityTrait.INTROVERTED, Arrays.asList(
            LearningMethod.AUDITORY,
            LearningMethod.VISUAL,
            LearningMethod.LEARNING_THROUGH_PLAY
        ));
        traitRecommendationMap.put(PersonalityTrait.ANALYTICAL, Arrays.asList(
            LearningMethod.LOGICAL_MATHEMATICAL,
            LearningMethod.KINESTHETIC,
            LearningMethod.GROUP_LEARNING
        ));
        traitRecommendationMap.put(PersonalityTrait.CREATIVE, Arrays.asList(
            LearningMethod.LEARNING_THROUGH_PLAY,
            LearningMethod.AUDIO_VISUAL,
            LearningMethod.KINESTHETIC
        ));
        traitRecommendationMap.put(PersonalityTrait.PRACTICAL, Arrays.asList(
            LearningMethod.KINESTHETIC,
            LearningMethod.GROUP_LEARNING,
            LearningMethod.LEARNING_THROUGH_PLAY
        ));
        traitRecommendationMap.put(PersonalityTrait.ORGANIZED, Arrays.asList(
            LearningMethod.VISUAL,
            LearningMethod.KINESTHETIC,
            LearningMethod.GROUP_LEARNING
        ));
        traitRecommendationMap.put(PersonalityTrait.REFLECTIVE, Arrays.asList(
            LearningMethod.VERBAL,
            LearningMethod.KINESTHETIC
        ));

        return traitRecommendationMap;

    }

    public Map<SubjectName, List<LearningMethod>> getSubjectRecommendations() {
        Map<SubjectName, List<LearningMethod>> subjectRecommendationMap = new HashMap<>();

        subjectRecommendationMap.put(SubjectName.PHYSICS, Arrays.asList(
            LearningMethod.VERBAL,
            LearningMethod.AUDITORY,
            LearningMethod.LOGICAL_MATHEMATICAL
        ));
        subjectRecommendationMap.put(SubjectName.HISTORY, Arrays.asList(
            LearningMethod.AUDITORY,
            LearningMethod.VISUAL,
            LearningMethod.GROUP_LEARNING
        ));
        subjectRecommendationMap.put(SubjectName.ENGLISH, Arrays.asList(
            LearningMethod.VERBAL,
            LearningMethod.AUDITORY
        ));
        subjectRecommendationMap.put(SubjectName.PROGRAMMING, Arrays.asList(
            LearningMethod.KINESTHETIC,
            LearningMethod.VISUAL,
            LearningMethod.GROUP_LEARNING
        ));
        subjectRecommendationMap.put(SubjectName.MATHS, Arrays.asList(
            LearningMethod.VISUAL,
            LearningMethod.AUDITORY,
            LearningMethod.LOGICAL_MATHEMATICAL
        ));
        subjectRecommendationMap.put(SubjectName.ARTS, Arrays.asList(
            LearningMethod.VISUAL,
            LearningMethod.AUDIO_VISUAL
        ));

        return subjectRecommendationMap;

    }

    public Map<Field, List<LearningMethod>> getFieldRecommendations() {
        Map<Field, List<LearningMethod>> fieldRecommendationMap = new HashMap<>();

        fieldRecommendationMap.put(Field.NATURAL_SCIENCES, Arrays.asList(
            LearningMethod.VERBAL,
            LearningMethod.AUDITORY,
            LearningMethod.LOGICAL_MATHEMATICAL
        ));
        fieldRecommendationMap.put(Field.SOCIAL_SCIENCES, Arrays.asList(
            LearningMethod.AUDITORY,
            LearningMethod.VISUAL,
            LearningMethod.GROUP_LEARNING
        ));
        fieldRecommendationMap.put(Field.MEDICAL_SCIENCES, Arrays.asList(
            LearningMethod.KINESTHETIC,
            LearningMethod.AUDIO_VISUAL
        ));
        fieldRecommendationMap.put(Field.ARTS, Arrays.asList(
            LearningMethod.AUDIO_VISUAL,
            LearningMethod.GROUP_LEARNING,
            LearningMethod.KINESTHETIC
        ));
        fieldRecommendationMap.put(Field.LANGUAGES, Arrays.asList(
            LearningMethod.VERBAL,
            LearningMethod.AUDITORY
        ));
        fieldRecommendationMap.put(Field.TECHNICAL_SCIENCES, Arrays.asList(
            LearningMethod.KINESTHETIC,
            LearningMethod.VISUAL,
            LearningMethod.GROUP_LEARNING
        ));
        fieldRecommendationMap.put(Field.LECAL_ECONOMIC_SCIENCES, Arrays.asList(
            LearningMethod.VISUAL,
            LearningMethod.AUDITORY,
            LearningMethod.LOGICAL_MATHEMATICAL
        ));
        fieldRecommendationMap.put(Field.ARGICULTURE_ENVIRONMENTAL_SCIENCES, Arrays.asList(
            LearningMethod.VISUAL,
            LearningMethod.AUDIO_VISUAL
        ));

        return fieldRecommendationMap;
    }

}
