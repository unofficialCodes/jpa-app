package org.jpa.app.compositeKeys;

import java.io.Serializable;

// It is mandatory to mark Id/Embeddable class with Serializable marker interface.
// No-args constructor, getters and setters, hashCode and equals implementation is mandatory for composite keys.

public class DepartmentId implements Serializable {

    private int id;
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
