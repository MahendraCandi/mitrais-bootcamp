package com.mahendracandi.springorm.service.impl;

import com.mahendracandi.springorm.dao.MusicianDao;
import com.mahendracandi.springorm.model.Musician;
import com.mahendracandi.springorm.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
    implement spring data jpa
 */
@Service("MusicainImplSpringJpa")
public class MusicainImplSpringJpa implements MusicianService {

    @Autowired
    private MusicianDao musicianDao;

    @Override
    @Transactional
    public void addMusician(String name, String instrument, String song) {
        Musician m = new Musician();
        m.setName(name);
        m.setInstrument(instrument);
        m.setSong(song);

        System.out.println("Spring JPA add musician: " + m.toString());
        musicianDao.save(m);
    }

    @Override
    @Transactional
    public void updateMusician(int id, String name, String instrument, String song) {
        Musician m = musicianDao.findById(id).orElse(null);
        if (m == null) {
            System.out.println("Id not found");
            return;
        }
        System.out.println("Spring JPA update musician: " + m.toString());

        m.setName(name);
        m.setInstrument(instrument);
        m.setSong(song);
        System.out.println("Spring JPA to: " + m.toString());

        musicianDao.save(m);
    }

    @Override
    public Musician getMusician(int id) {
        Musician m = musicianDao.findById(id).orElse(null);
        if (m == null) {
            System.out.println("Id not found");
        } else {
            System.out.println("Spring JPA get musician: " + m.toString());
        }
        return m;
    }

    @Override
    public List<Musician> getAllMusician() {
        List<Musician> list = musicianDao.findAll();
        System.out.println("Spring JPA get all musician:");
        list.stream().forEach(p -> System.out.println(p.toString()));
        return list;
    }

    @Override
    public void deleteMusician(int id) {
        Musician m = getMusician(id);
        if ( m != null ) {
            System.out.println("remove musician: " + m.toString());
            musicianDao.delete(m);
        }
    }
}
