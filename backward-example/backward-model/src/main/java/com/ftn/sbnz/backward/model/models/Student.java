package com.ftn.sbnz.backward.model.models;

import org.kie.api.definition.type.Position;

import java.util.ArrayList;
import java.util.List;

public class Student {
    @Position(0)
    private Integer id;

    @Position(1)
    private String name;

    @Position(2)
    private String surname;

    @Position(3)
    private List<Subject> subjects;

    @Position(4)
    private List<LearningMethod> learningMethods;

    @Position(5)
    private List<PersonalityTrait> personalityTraits;

    @Position(6)
    private PersonalizedPlan personalizedPlan;
    @Position(7)
    private Field field;

    @Position(8)
    private List<LearningMethod> learningMethodsBasedOnTraits;

    @Position(9)
    private List<LearningMethod> learningMethodsBasedOnField;

    @Position(10)
    private List<LearningMethod> learningMethodsBasedOnSubjectName;


    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
    }


    public Student(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
    }


    public Student(String name, String surname, List<Subject> subjects, List<PersonalityTrait> personalityTraits,
            Field field) {
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
        this.personalityTraits = personalityTraits;
        this.field = field;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
    }

    public Student(int id, String name, String surname, List<Subject> subjects, List<PersonalityTrait> personalityTraits,
            Field field) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
        this.personalityTraits = personalityTraits;
        this.field = field;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
    }


    public Student(Integer id, String name, String surname, List<Subject> subjects,
            List<LearningMethod> learningMethods, List<PersonalityTrait> personalityTraits,
            PersonalizedPlan personalizedPlan) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.personalityTraits = personalityTraits;
        this.personalizedPlan = personalizedPlan;
    }

    public Student(Integer id, String name, String surname, List<Subject> subjects,
            List<LearningMethod> learningMethods, List<PersonalityTrait> personalityTraits,
            PersonalizedPlan personalizedPlan, Field field, List<LearningMethod> learningMethodsBasedOnTraits,
            List<LearningMethod> learningMethodsBasedOnField, List<LearningMethod> learningMethodsBasedOnSubjectName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.personalityTraits = personalityTraits;
        this.personalizedPlan = personalizedPlan;
        this.field = field;
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<LearningMethod> getLearningMethods() {
        return learningMethods;
    }

    public void setLearningMethods(List<LearningMethod> lms) {
        for (LearningMethod lm : lms) {
            this.learningMethods.add(lm);
        }
    }

    public List<PersonalityTrait> getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(List<PersonalityTrait> personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public PersonalizedPlan getPersonalizedPlan() {
        return personalizedPlan;
    }

    public void setPersonalizedPlan(PersonalizedPlan personalizedPlan) {
        this.personalizedPlan = personalizedPlan;
    }
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    

    public List<LearningMethod> getLearningMethodsBasedOnTraits() {
        return learningMethodsBasedOnTraits;
    }


    public void setLearningMethodsBasedOnTraits(List<LearningMethod> lms) {
        for (LearningMethod lm : lms) {
            this.learningMethodsBasedOnTraits.add(lm);
        }
    }


    public List<LearningMethod> getLearningMethodsBasedOnField() {
        return learningMethodsBasedOnField;
    }


    public void setLearningMethodsBasedOnField(List<LearningMethod> lms) {
        for (LearningMethod lm : lms) {
            this.learningMethodsBasedOnField.add(lm);
        }
    }


    public List<LearningMethod> getLearningMethodsBasedOnSubjectName() {
        return learningMethodsBasedOnSubjectName;
    }



    public void setLearningMethodsBasedOnSubjectName(List<LearningMethod> lms) {
        for (LearningMethod lm : lms) {
            this.learningMethodsBasedOnSubjectName.add(lm);
        }
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
        result = prime * result + ((learningMethods == null) ? 0 : learningMethods.hashCode());
        result = prime * result + ((personalityTraits == null) ? 0 : personalityTraits.hashCode());
        result = prime * result + ((personalizedPlan == null) ? 0 : personalizedPlan.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        if (subjects == null) {
            if (other.subjects != null)
                return false;
        } else if (!subjects.equals(other.subjects))
            return false;
        if (learningMethods == null) {
            if (other.learningMethods != null)
                return false;
        } else if (!learningMethods.equals(other.learningMethods))
            return false;
        if (personalityTraits == null) {
            if (other.personalityTraits != null)
                return false;
        } else if (!personalityTraits.equals(other.personalityTraits))
            return false;
        if (personalizedPlan == null) {
            if (other.personalizedPlan != null)
                return false;
        } else if (!personalizedPlan.equals(other.personalizedPlan))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", subjects=" + subjects
                + ", learningMethods=" + learningMethods + ", personalityTraits=" + personalityTraits
                + ", personalizedPlan=" + personalizedPlan + ", field=" + field + ", learningMethodsBasedOnTraits="
                + learningMethodsBasedOnTraits + ", learningMethodsBasedOnField=" + learningMethodsBasedOnField
                + ", learningMethodsBasedOnSubjectName=" + learningMethodsBasedOnSubjectName + "]";
    }

    

    
}
