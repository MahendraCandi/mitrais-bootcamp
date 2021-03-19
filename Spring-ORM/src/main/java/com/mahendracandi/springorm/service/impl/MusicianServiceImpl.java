package com.mahendracandi.springorm.service.impl;

import com.mahendracandi.springorm.model.Musician;
import com.mahendracandi.springorm.service.MusicianService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MusicianServiceImpl implements MusicianService {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("entity-manager-test");

    public void addMusician(String name, String instrument, String song) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();

            Musician m = new Musician();
            m.setName(name);
            m.setInstrument(instrument);
            m.setSong(song);

            em.persist(m);
            et.commit();

        }catch (Exception e) {
            if (et != null) et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }



    }
}
