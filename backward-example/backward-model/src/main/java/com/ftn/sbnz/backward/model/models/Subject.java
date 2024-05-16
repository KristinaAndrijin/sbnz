package com.ftn.sbnz.backward.model.models;

import org.kie.api.definition.type.Position;

import java.util.Objects;

public class Subject {
    @Position(0)
    private Integer id;

    @Position(1)
    private String name;

    @Position(2)
    private SubjectName subjectName;

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

    public SubjectName getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(SubjectName subjectName) {
        this.subjectName = subjectName;
    }

    public Subject(Integer id, String name, SubjectName subjectName) {
        this.id = id;
        this.name = name;
        this.subjectName = subjectName;
    }

    public Subject() {
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjectName=" + subjectName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) && Objects.equals(name, subject.name) && subjectName == subject.subjectName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subjectName);
    }
}
