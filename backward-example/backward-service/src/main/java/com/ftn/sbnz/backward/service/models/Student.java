package com.ftn.sbnz.backward.service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kie.api.definition.type.Position;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Position(0)
    private Integer id;

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

    @Position(16)
    private String username;

    @Position(17)
    private String password;

    @Position(18)
    private Role role;

    @Position(19)
    @Column(name = "prosek", nullable = true)
    private Double prosek = 6.88;


    public Student(String name, String surname, String username, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }


    public Student(Integer id, String name, String surname, String username, String password, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }


    public Student(String name, String surname, List<Subject> subjects, List<PersonalityTrait> personalityTraits,
                   Field field, String username, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.subjects = subjects;
        this.role = role;
        this.personalityTraits = personalityTraits;
        this.field = field;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }

    public Student(int id, String name, String surname, List<Subject> subjects, List<PersonalityTrait> personalityTraits,
                   Field field, String username, String password, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.subjects = subjects;
        this.role = role;
        this.personalityTraits = personalityTraits;
        this.field = field;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }

    public Student(String name, String surname, List<PersonalityTrait> personalityTraits,
                   Field field, String username, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.personalityTraits = personalityTraits;
        this.field = field;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }

    public Student(Integer id, String name, String surname, List<Subject> subjects,
                   List<LearningMethod> learningMethods, List<PersonalityTrait> personalityTraits,
                   PersonalizedPlan personalizedPlan, String username, String password, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.subjects = subjects;
        this.role = role;
        this.learningMethods = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnTraits = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnField = new ArrayList<LearningMethod>();
        this.learningMethodsBasedOnSubjectName = new ArrayList<LearningMethod>();
        this.personalityTraits = personalityTraits;
        this.personalizedPlan = personalizedPlan;
        this.learningMethodsUpdated = false;
        this.learningMethodsUpdated2 = false;
    }

    public Student(Integer id, String name, String surname, List<Subject> subjects,
                   List<LearningMethod> learningMethods, List<PersonalityTrait> personalityTraits,
                   PersonalizedPlan personalizedPlan, Field field, List<LearningMethod> learningMethodsBasedOnTraits,
                   List<LearningMethod> learningMethodsBasedOnField, List<LearningMethod> learningMethodsBasedOnSubjectName, String username, String password, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.subjects = subjects;
        this.role = role;
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

    public List<LearningMethod> getLearningMethods() {
        return learningMethods;
    }

    public void setLearningMethodsUpdated2(boolean learningMethodsUpdated2) {
        this.learningMethodsUpdated2 = learningMethodsUpdated2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    public PersonalizedPlan getPersonalizedPlan() {
        return personalizedPlan;
    }

    public Field getField() {
        return field;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Double getProsek() {
        return prosek;
    }

    public void setProsek(Double prosek) {
        this.prosek = prosek;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setPersonalityTraits(List<PersonalityTrait> personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public void setPersonalizedPlan(PersonalizedPlan personalizedPlan) {
        this.personalizedPlan = personalizedPlan;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getId() != null ? !getId().equals(student.getId()) : student.getId() != null) return false;
        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(student.getSurname()) : student.getSurname() != null)
            return false;
        if (getSubjects() != null ? !getSubjects().equals(student.getSubjects()) : student.getSubjects() != null)
            return false;
        if (getPersonalityTraits() != null ? !getPersonalityTraits().equals(student.getPersonalityTraits()) : student.getPersonalityTraits() != null)
            return false;
        if (getField() != student.getField()) return false;
        if (getRole() != student.getRole()) return false;
        if (getUsername() != null ? !getUsername().equals(student.getUsername()) : student.getUsername() != null)
            return false;
        return getPassword() != null ? getPassword().equals(student.getPassword()) : student.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getSubjects() != null ? getSubjects().hashCode() : 0);
        result = 31 * result + (getPersonalityTraits() != null ? getPersonalityTraits().hashCode() : 0);
        result = 31 * result + (getField() != null ? getField().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subjects=" + subjects +
                ", learningMethods=" + learningMethods +
                ", personalityTraits=" + personalityTraits +
                ", personalizedPlan=" + personalizedPlan +
                ", field=" + field +
                ", learningMethodsBasedOnTraits=" + learningMethodsBasedOnTraits +
                ", learningMethodsBasedOnField=" + learningMethodsBasedOnField +
                ", learningMethodsBasedOnSubjectName=" + learningMethodsBasedOnSubjectName +
                ", learningMethodsUpdated=" + learningMethodsUpdated +
                ", learningMethodsUpdated2=" + learningMethodsUpdated2 +
                ", learningMethodsForward1=" + learningMethodsForward1 +
                ", learningMethodsForward2=" + learningMethodsForward2 +
                ", shouldTriggerBackward=" + shouldTriggerBackward +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // @Override
    // public String toString() {
    //     return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", subjects=" + subjects
    //             + ", learningMethods=" + learningMethods + ", personalityTraits=" + personalityTraits
    //             + ", personalizedPlan=" + personalizedPlan + ", field=" + field + ", learningMethodsBasedOnTraits="
    //             + learningMethodsBasedOnTraits + ", learningMethodsBasedOnField=" + learningMethodsBasedOnField
    //             + ", learningMethodsBasedOnSubjectName=" + learningMethodsBasedOnSubjectName + "]";
    // }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.getRole().toString()));
        return authorities;
    }

    

    
}
