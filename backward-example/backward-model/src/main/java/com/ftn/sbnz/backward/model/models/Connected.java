package com.ftn.sbnz.backward.model.models;
import org.kie.api.definition.type.Position;

public class Connected {
    @Position(0)
    private String parent;

    @Position(1)
    private String child;

    public Connected(String child, String parent) {
        this.child = child;
        this.parent = parent;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
