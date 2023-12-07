package org.jpa.app.compositeKeys;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class EmbeddableId implements Serializable {

    @Serial
    private static final long serialVersionUID = -2441358346175834531L;
    private int number;
    private String code;
}
