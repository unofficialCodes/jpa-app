package org.jpa.app.compositeKeys;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.compositeKeys.config.CustomPUInfo;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPUInfo(), new HashMap<>());
        var em = emf.createEntityManager();
        var tx = em.getTransaction();

        tx.begin();

        /*Department department = new Department();
        department.setCode("code-1");
        department.setName("department-1");

        em.persist(department);*/

        EmbeddableId ids = new EmbeddableId();
        ids.setNumber(1);
        ids.setCode("code-1");

        Company c1 = new Company();
        c1.setIds(ids);
        c1.setName("company-1");

        em.persist(c1);

        tx.commit();
        em.close();
        emf.close();
    }
}
