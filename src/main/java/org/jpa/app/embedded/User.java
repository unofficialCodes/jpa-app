package org.jpa.app.embedded;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_t")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "custom_id")),
            @AttributeOverride(name = "name", column = @Column(name = "custom_name")),
            @AttributeOverride(name = "embedded.id", column = @Column(name = "ne_id")),
            @AttributeOverride(name = "embedded.name", column = @Column(name = "ne_name")),
            @AttributeOverride(name = "embedded.email", column = @Column(name = "ne_email"))
    })
    private EmbeddableEntity embeddable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmbeddableEntity getEmbeddable() {
        return embeddable;
    }

    public void setEmbeddable(EmbeddableEntity embeddable) {
        this.embeddable = embeddable;
    }

    public User(int id, String name, EmbeddableEntity embeddable) {
        this.id = id;
        this.name = name;
        this.embeddable = embeddable;
    }

    public User() {
    }
}
