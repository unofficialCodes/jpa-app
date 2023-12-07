package org.jpa.app.relationalMappings.many_to_many.unidirectional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.relationalMappings.many_to_many.unidirectional.config.CustomPersistenceUnitInfo;
import org.jpa.app.relationalMappings.many_to_many.unidirectional.entities.Group;
import org.jpa.app.relationalMappings.many_to_many.unidirectional.entities.User;

import java.util.HashMap;
import java.util.List;

public class TestDrive {
    public static void main(String[] args) {

        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap());
        EntityManager em = emf.createEntityManager(); // create a context
        EntityTransaction eTx = em.getTransaction(); // get transaction

        eTx.begin();

        Group g1 = new Group();
        g1.setName("group-1");

        User u1 = new User();
        u1.setName("user-1");

        User u2 = new User();
        u2.setName("user-2");

        g1.setUsers(List.of(u1, u2));

        em.persist(u1);
        em.persist(u2);
        em.persist(g1);

        eTx.commit();

        em.close();
        emf.close();
    }
}
