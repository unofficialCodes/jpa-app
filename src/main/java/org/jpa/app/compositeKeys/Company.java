package org.jpa.app.compositeKeys;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Company {

    @EmbeddedId
    private EmbeddableId ids;
    private String name;
}
