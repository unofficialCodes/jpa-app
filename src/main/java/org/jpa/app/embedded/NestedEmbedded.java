package org.jpa.app.embedded;

import jakarta.persistence.Embeddable;

@Embeddable
public class NestedEmbedded {

    private int id;
    private String name;
    private String email;
}
