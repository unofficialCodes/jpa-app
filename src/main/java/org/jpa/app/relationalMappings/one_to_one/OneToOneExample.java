package org.jpa.app.relationalMappings.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.relationalMappings.one_to_one.config.CustomPersistenceUnitInfo;

import java.util.HashMap;

public class OneToOneExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo("one-to-one"), new HashMap<>());

        EntityManager em = emf.createEntityManager();

        EntityTransaction eTx = em.getTransaction();

        eTx.begin();

        Candidate student = new Candidate();
        Credentials credentials = new Credentials();
        credentials.setId(1);
        credentials.setUserName("student-1");
        credentials.setPassword("student-1");

        student.setName("student-1");
        student.setCredentials(credentials);
        credentials.setCandidate(student);

        em.persist(student);
//        em.persist(credentials);

        eTx.commit();

        em.close();
        emf.close();
    }
}
