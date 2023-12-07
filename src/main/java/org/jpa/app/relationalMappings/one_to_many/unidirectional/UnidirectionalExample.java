package org.jpa.app.relationalMappings.one_to_many.unidirectional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.relationalMappings.one_to_many.unidirectional.config.CustomPersistenceUnitInfo;

import java.util.HashMap;
import java.util.List;

public class UnidirectionalExample {
    public static void main(String[] args) {

        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo("one-to-one"), new HashMap<>());
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Company company_1 = new Company();
        company_1.setName("company-1");

        Department d1 = new Department();
        d1.setName("department-1");
//        d1.setCompany(company_1);

        Department d2 = new Department();
        d2.setName("department-2");
//        d2.setCompany(company_1);
        company_1.setDepartments(List.of(d1, d2));
        em.persist(d1);
        em.persist(d2);
        em.persist(company_1);
        tx.commit();

        em.close();
        emf.close();
    }
}
