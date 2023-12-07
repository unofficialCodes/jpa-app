package org.jpa.app.relationalMappings.one_to_one;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "credentials")
@Access(AccessType.FIELD)
public class Credentials {

    @Id
    private int id; // FIELD ACCESS
    private String userName;
    private String password;
    @OneToOne // mappedBy indicates the original mapping table, and no column will be created in this table.
//    @JoinColumn(name = "student_id") // if mappedBy column is not mentioned then, we can accompany a new column with specified join column
    private Candidate candidate;

    // @Id // PROPERTY ACCESS
    public int getId() {
        return id;
    }
    // @OneToOne // PROPERTY ACCESS
    public Candidate getCandidate() {
        return candidate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
