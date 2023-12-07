package org.jpa.app.compositeKeys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(DepartmentId.class)
public class Department {

    @Id
    private int id;

    @Id
    private String code;

    private String name;
}
