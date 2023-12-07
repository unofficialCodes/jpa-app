package org.jpa.app.relationalMappings.one_to_many.unidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

/*
* When it comes to one-to-many mapping, we can't switch the ownership from @ManyToOne to @OneToMany annotated class.
* we can either set the mapping in a separate table or in the owner of Many mapping class only
* because we can't store multiple values in the opposite mapping (One's mapping) class.
* Ownership when it comes to -many relations, it is always the many side
* */
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany
    @JoinColumn(name = "company") // defines the mapping column in company table with this mentioned companies_id as column name in it
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
