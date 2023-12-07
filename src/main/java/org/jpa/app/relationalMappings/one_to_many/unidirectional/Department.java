package org.jpa.app.relationalMappings.one_to_many.unidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    // @ManyToOne
    // @JoinColumn(name = "company_id") // this won't map the foreign key column
    // private Company company;

    /*public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
