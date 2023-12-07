package org.jpa.app.relationalMappings.one_to_one;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "oto_candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @OneToOne(cascade = CascadeType.PERSIST) // cascade - The operations that must be cascaded to the target of the association
    @AttributeOverrides({
            // @AttributeOverride(name = "id", column = @Column(name = "credential_id")), // default naming convention by JPA credential_id
            @AttributeOverride(name = "userName", column = @Column(name = "user_name")),
            @AttributeOverride(name = "password", column = @Column(name = "user_password"))
    })
    // @JoinColumn(name = "credentialId") // custom name of credentials.id, overrides @AttributeOverride column custom name
    private Credentials credentials;

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

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
