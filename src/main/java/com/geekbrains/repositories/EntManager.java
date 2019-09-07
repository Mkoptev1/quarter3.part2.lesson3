package com.geekbrains.repositories;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class EntManager {
    private EntityManager myEntityManager;

    public EntityManager getMyEntityManager() {
        // Получаем фабрику менеджеров сущностей
        EntityManagerFactory factory = new Configuration()
            .configure("resources/hibernate.cfg.xml")
            .buildSessionFactory();
        // Из фабрики создаем EntityManager
        myEntityManager = factory.createEntityManager();

        return myEntityManager;
    }
}