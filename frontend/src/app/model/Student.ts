export interface Student {
    id: number;
    name: string;
    surname: string;
    subjects?: Subject[];
    learningMethods?: LearningMethod[];
    personalityTraits?: PersonalityTrait[];
    personalizedPlan?: PersonalizedPlan;
    field?: Field;
    learningMethodsBasedOnTraits?: LearningMethod[];
    learningMethodsBasedOnField?: LearningMethod[];
    learningMethodsBasedOnSubjectName?: LearningMethod[];
    learningMethodsUpdated?: boolean;
    learningMethodsUpdated2?: boolean;
    learningMethodsForward1?: LearningMethod[];
    learningMethodsForward2?: LearningMethod[];
    shouldTriggerBackward?: boolean;
  }
  

  export enum LearningMethod {
    VERBAL = 'VERBAL',
    AUDITORY = 'AUDITORY',
    VISUAL = 'VISUAL',
    KINESTHETIC = 'KINESTHETIC',
    AUDIO_VISUAL = 'AUDIO_VISUAL',
    GROUP_LEARNING = 'GROUP_LEARNING',
    LOGICAL_MATHEMATICAL = 'LOGICAL_MATHEMATICAL',
    LEARNING_THROUGH_PLAY = 'LEARNING_THROUGH_PLAY'
  }

  export enum PersonalityTrait {
    EXTROVERTED,
    INTROVERTED,
    ANALYTICAL,
    CREATIVE,
    PRACTICAL,
    ORGANIZED,
    REFLECTIVE
  }
  

  export interface Subject {
    id: number;
    name: string;
    studentId: number;
    subjectName: SubjectName;
  }

  export enum SubjectName {
    PHYSICS = 'PHYSICS',
    HISTORY = 'HISTORY',
    ENGLISH = 'ENGLISH',
    PROGRAMMING = 'PROGRAMMING',
    MATHS = 'MATHS',
    ARTS = 'ARTS'
  }
  
  export interface PersonalizedPlan {
    id: number;
    planDetails: string; //izmeniti
  }

  export enum Field {
    NATURAL_SCIENCES = 'NATURAL SCIENCES',
    SOCIAL_SCIENCES = 'SOCIAL SCIENCES',
    MEDICAL_SCIENCES = 'MEDICAL SCIENCES',
    ARTS = 'ARTS',
    LANGUAGES = 'LANGUAGES',
    TECHNICAL_SCIENCES = 'TECHNICAL SCIENCES',
    LEGAL_ECONOMIC_SCIENCES = 'LEGAL ECONOMIC SCIENCES',
    AGRICULTURE_ENVIRONMENTAL_SCIENCES = 'AGRICULTURE ENVIRONMENTAL_SCIENCES'
}
  
  
  