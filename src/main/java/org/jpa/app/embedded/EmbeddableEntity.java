package org.jpa.app.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class EmbeddableEntity {

    private int id;
    private String name;
    @Embedded
    private NestedEmbedded embedded;
}
