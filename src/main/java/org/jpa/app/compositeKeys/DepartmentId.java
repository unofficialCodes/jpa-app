package org.jpa.app.compositeKeys;

import java.io.Serializable;

// It is mandatory to mark Id/Embeddable class with Serializable marker interface.

public class DepartmentId implements Serializable {

    private int id;
    private String name;
}
