package com.ftn.sbnz.backward.model.models;

import java.sql.Date;

import org.kie.api.definition.type.Position;

public class PersonalizedPlan {
    @Position(0)
    private Integer id;

    @Position(1)
    private Student studentId;

    @Position(2)
    private LearningMethod methodId;

    @Position(3)
    private Date startDate;

    @Position(4)
    private Integer studentReview;

    @Position(5)
    private Grade subjectGrade;

    public PersonalizedPlan() {
    }

    public PersonalizedPlan(Integer id, Student studentId, LearningMethod methodId, Date startDate,
            Integer studentReview, Grade subjectGrade) {
        this.id = id;
        this.studentId = studentId;
        this.methodId = methodId;
        this.startDate = startDate;
        this.studentReview = studentReview;
        this.subjectGrade = subjectGrade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public LearningMethod getMethodId() {
        return methodId;
    }

    public void setMethodId(LearningMethod methodId) {
        this.methodId = methodId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getStudentReview() {
        return studentReview;
    }

    public void setStudentReview(Integer studentReview) {
        this.studentReview = studentReview;
    }

    public Grade getSubjectGrade() {
        return subjectGrade;
    }

    public void setSubjectGrade(Grade subjectGrade) {
        this.subjectGrade = subjectGrade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
        result = prime * result + ((methodId == null) ? 0 : methodId.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((studentReview == null) ? 0 : studentReview.hashCode());
        result = prime * result + ((subjectGrade == null) ? 0 : subjectGrade.hashCode());
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
        PersonalizedPlan other = (PersonalizedPlan) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (studentId == null) {
            if (other.studentId != null)
                return false;
        } else if (!studentId.equals(other.studentId))
            return false;
        if (methodId != other.methodId)
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (studentReview == null) {
            if (other.studentReview != null)
                return false;
        } else if (!studentReview.equals(other.studentReview))
            return false;
        if (subjectGrade == null) {
            if (other.subjectGrade != null)
                return false;
        } else if (!subjectGrade.equals(other.subjectGrade))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PersonalizedPlan [id=" + id + ", studentId=" + studentId + ", methodId=" + methodId + ", startDate="
                + startDate + ", studentReview=" + studentReview + ", subjectGrade=" + subjectGrade + "]";
    }

    
}
