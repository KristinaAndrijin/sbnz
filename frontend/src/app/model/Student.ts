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
    VERBAL,
    AUDITORY,
    VISUAL,
    KINESTHETIC,
    AUDIO_VISUAL,
    GROUP_LEARNING,
    LOGICAL_MATHEMATICAL,
    LEARNING_THROUGH_PLAY
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
    NATURAL_SCIENCES,
    SOCIAL_SCIENCES,
    MEDICAL_SCIENCES,
    ARTS,
    LANGUAGES,
    TECHNICAL_SCIENCES,
    LECAL_ECONOMIC_SCIENCES,
    ARGICULTURE_ENVIRONMENTAL_SCIENCES
  }
  
  
  