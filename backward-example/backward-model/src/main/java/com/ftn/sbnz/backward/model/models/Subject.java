package com.ftn.sbnz.backward.model.models;

import org.kie.api.definition.type.Position;

public class Subject {
    @Position(0)
    private Integer id;

    @Position(1)
    private String name;

    @Position(2)
    private Field field;

    @Position(3)
    private SubjectName subjectName;

    public Subject() {
    }

    public Subject(Integer id, String name, Field field, SubjectName subjectName) {
        this.id = id;
        this.name = name;
        this.field = field;
        this.subjectName = subjectName;
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

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public SubjectName getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(SubjectName subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((field == null) ? 0 : field.hashCode());
        result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
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
        Subject other = (Subject) obj;
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
        if (field != other.field)
            return false;
        if (subjectName != other.subjectName)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Subject [id=" + id + ", name=" + name + ", field=" + field + ", subjectName=" + subjectName + "]";
    }

    
}
