package org.jpa.app.relationalMappings.many_to_many.bidirectional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.relationalMappings.many_to_many.bidirectional.config.CustomPersistenceUnitInfo;
import org.jpa.app.relationalMappings.many_to_many.bidirectional.entities.Group;
import org.jpa.app.relationalMappings.many_to_many.bidirectional.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap());
        EntityManager em = emf.createEntityManager();
        EntityTransaction eTx = em.getTransaction();

        eTx.begin();

        Group group_1 = new Group();
        User user_1 = new User();
        User user_2 = new User();

        user_1.setName("user-1");
        user_2.setName("user-2");

        user_1.setGroups(Set.of(group_1));
        user_2.setGroups(Set.of(group_1));

        group_1.setName("group-1");
        group_1.setUsers(List.of(user_1, user_2));

        em.persist(group_1);
        em.persist(user_1);
        em.persist(user_2);

        eTx.commit();

        em.close();
        emf.close();
    }
}
