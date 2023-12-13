package org.jpa.app.compositeKeys;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

// No-args constructor, getters and setters, hashCode and equals implementation is mandatory for composite keys.
@Embeddable
public class EmbeddableId implements Serializable {

    @Serial
    private static final long serialVersionUID = -2441358346175834531L;
    private int number;
    private String code;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmbeddableId)) return false;
        EmbeddableId that = (EmbeddableId) o;
        return number == that.number && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, code);
    }
}
