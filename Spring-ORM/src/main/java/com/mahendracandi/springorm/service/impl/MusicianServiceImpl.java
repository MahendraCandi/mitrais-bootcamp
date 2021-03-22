package com.mahendracandi.springorm.service.impl;

import com.mahendracandi.springorm.model.Musician;
import com.mahendracandi.springorm.service.MusicianService;

import javax.persistence.*;
import java.util.List;

/*
    implement jpa entity manager
 */
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

            System.out.println("add musician: " + m.toString());

            em.persist(m);
            et.commit();

        }catch (Exception e) {
            if (et != null) et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void updateMusician(int id, String name, String instrument, String song) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();

            Musician m = em.find(Musician.class, id);
            System.out.println("update musician: " + m.toString());
            m.setName(name);
            m.setInstrument(instrument);
            m.setSong(song);
            System.out.println("to: " + m.toString());

            em.persist(m);
            et.commit();

        }catch (Exception e) {
            if (et != null) et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Musician getMusician(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String sql = "SELECT m FROM Musician m WHERE m.id = :id";
        TypedQuery<Musician> q = em.createQuery(sql, Musician.class);
        q.setParameter("id", id);

        Musician musician = null;
        try {
            musician = q.getSingleResult();
            System.out.println("get musician: " + musician.toString());
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return musician;
    }

    public List<Musician> getAllMusician() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String sql = "SELECT m FROM Musician m";
        TypedQuery<Musician> q = em.createQuery(sql, Musician.class);
        List<Musician> musicianList = null;

        try {
            musicianList = q.getResultList();
            System.out.println("get all musician:");
            musicianList.stream().forEach(p -> System.out.println(p.toString()));
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return musicianList;
    }

    public void deleteMusician(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            Musician m = em.find(Musician.class, id);
            System.out.println("remove musician: " + m.toString());
            em.remove(m);

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
