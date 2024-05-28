package com.ftn.sbnz.backward.service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kie.api.definition.type.Position;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Position(0)
    private Long id;

    @Position(1)
    private String name;

    @Position(2)
    private String surname;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @Position(3)
    @JsonManagedReference
    private List<Subject> subjects  = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "student_learning_methods", joinColumns = @JoinColumn(name = "student_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "learning_method")
    @Position(4)
    private List<LearningMethod> learningMethods;

    @ElementCollection
    @CollectionTable(name = "student_personality_traits", joinColumns = @JoinColumn(name = "student_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "personality_trait")
    @Position(5)
    private List<PersonalityTrait> personalityTraits;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personalized_plan_id")
    @Position(6)
    private PersonalizedPlan personalizedPlan;

//    @ManyToOne
//    @JoinColumn(name = "field_id")
    @Position(7)
    private Field field;

    @ElementCollection
    @CollectionTable(name = "student_learning_methods_traits", joinColumns = @JoinColumn(name = "student_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "learning_method")
    @Position(8)
    private List<LearningMethod> learningMethodsBasedOnTraits;

    @ElementCollection
    @CollectionTable(name = "student_learning_methods_field", joinColumns = @JoinColumn(name = "student_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "learning_method")
    @Position(9)
    private List<LearningMethod> learningMethodsBasedOnField;

    @ElementCollection
    @CollectionTable(name = "student_learning_methods_subject", joinColumns = @JoinColumn(name = "student_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "learning_method")
    @Position(10)
    private List<LearningMethod> learningMethodsBasedOnSubjectName;

    @Position(11)
    private boolean learningMethodsUpdated;
    @Position(12)
    private boolean learningMethodsUpdated2;

    @ElementCollection
    @CollectionTable(name = "student_learning_methods", joinColumns = @JoinColumn(name = "student_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "learning_method")
    @Position(13)
    private List<LearningMethod> learningMethodsForward1;

    @ElementCollection
    @CollectionTable(name = "student_learning_methods", joinColumns = @JoinColumn(name = "student_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "learning_method")
    @Position(14)
    private List<LearningMethod> learningMethodsForward2;
    @Position(15)
    private boolean shouldTriggerBackward;


    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }


    public Student(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
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
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }

    public Student(Long id, String name, String surname, List<Subject> subjects, List<PersonalityTrait> personalityTraits,
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
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }


    public Student(Long id, String name, String surname, List<Subject> subjects,
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
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }

    public Student(String name, String surname, List<PersonalityTrait> personalityTraits,
                   Field field) {
        this.name = name;
        this.surname = surname;
        this.personalityTraits = personalityTraits;
        this.field = field;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }

    public Student(Long id, String name, String surname, List<Subject> subjects,
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
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void emptyLearningMethods() {
        this.learningMethods = new ArrayList<LearningMethod>();
    }



    public List<LearningMethod> getLearningMethodsForward1() {
        return learningMethodsForward1;
    }

    public void setLearningMethodsForward1(List<LearningMethod> learningMethodsForward1) {
        this.learningMethodsForward1 = new ArrayList<>();
        for (LearningMethod lm : learningMethodsForward1) {
            this.learningMethodsForward1.add(lm);
        }
        this.setLearningMethods(learningMethodsForward1);
    }

    public List<LearningMethod> getLearningMethodsForward2() {
        return learningMethodsForward2;
    }

    public void setLearningMethodsForward2(List<LearningMethod> learningMethodsForward2) {
        this.learningMethodsForward2 = new ArrayList<>();
        for (LearningMethod lm : learningMethodsForward2) {
            this.learningMethodsForward2.add(lm);
        }
        this.setLearningMethods(learningMethodsForward2);
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

    public void emptyLearningMethodsBasedOnTraits() {
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
    }


    public List<LearningMethod> getLearningMethodsBasedOnField() {
        return learningMethodsBasedOnField;
    }


    public void setLearningMethodsBasedOnField(List<LearningMethod> lms) {
        for (LearningMethod lm : lms) {
            this.learningMethodsBasedOnField.add(lm);
        }
    }

    public void emptyLearningMethodsBasedOnField() {
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
    }


    public List<LearningMethod> getLearningMethodsBasedOnSubjectName() {
        return learningMethodsBasedOnSubjectName;
    }


    public void setLearningMethodsBasedOnSubjectName(List<LearningMethod> lms) {
        for (LearningMethod lm : lms) {
            this.learningMethodsBasedOnSubjectName.add(lm);
        }
    }

    public void emptyLearningMethodsBasedOnSubjectName() {
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
    }

    public boolean isLearningMethodsUpdated() {
        return learningMethodsUpdated;
    }

    public void setLearningMethodsUpdated(boolean learningMethodsUpdated) {
        this.learningMethodsUpdated = learningMethodsUpdated;
    }



    public boolean isLearningMethodsUpdated2() {
        return learningMethodsUpdated2;
    }

    public void setLearningMethods2Updated(boolean learningMethodsUpdated) {
        this.learningMethodsUpdated2 = learningMethodsUpdated;
    }

    


    public boolean isShouldTriggerBackward() {
        return shouldTriggerBackward;
    }

    public void setShouldTriggerBackward(boolean shouldTriggerBackward) {
        this.shouldTriggerBackward = shouldTriggerBackward;
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
                + ", learningMethodsBasedOnSubjectName=" + learningMethodsBasedOnSubjectName
                + ", learningMethodsUpdated=" + learningMethodsUpdated + ", learningMethodsUpdated2="
                + learningMethodsUpdated2 + ", learningMethodsForward1=" + learningMethodsForward1
                + ", learningMethodsForward2=" + learningMethodsForward2 + "]";
    }

    // @Override
    // public String toString() {
    //     return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", subjects=" + subjects
    //             + ", learningMethods=" + learningMethods + ", personalityTraits=" + personalityTraits
    //             + ", personalizedPlan=" + personalizedPlan + ", field=" + field + ", learningMethodsBasedOnTraits="
    //             + learningMethodsBasedOnTraits + ", learningMethodsBasedOnField=" + learningMethodsBasedOnField
    //             + ", learningMethodsBasedOnSubjectName=" + learningMethodsBasedOnSubjectName + "]";
    // }

    

    

    
}
