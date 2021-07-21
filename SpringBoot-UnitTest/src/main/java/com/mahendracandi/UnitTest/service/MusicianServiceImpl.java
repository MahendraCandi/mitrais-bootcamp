package com.mahendracandi.UnitTest.service;

import com.mahendracandi.UnitTest.dao.MusicianDao;
import com.mahendracandi.UnitTest.model.Musician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicianServiceImpl implements MusicianService{

    private final MusicianDao musicianDao;

    public MusicianServiceImpl(MusicianDao musicianDao) {
        this.musicianDao = musicianDao;
    }

    @Override
    public List<Musician> getAllMusician() {
        return musicianDao.findAll();
    }

    @Override
    public void addMusician(Musician musician) {
        boolean isMusicianExist = musicianDao.isMusicianExistsBySong(musician.getSong());
        if (isMusicianExist) {
            throw new IllegalStateException("Musician " + musician.toString() + " already exists");
        }

        musicianDao.save(musician);

    }

    @Override
    public void deleteMusicianById(Integer id) {
        boolean isMusicianPresent = musicianDao.findById(id).isPresent();
        if (!isMusicianPresent) {
            throw new IllegalStateException("Musician with Id " + id + " not exists");
        }

        musicianDao.deleteById(id);
    }

    @Override
    public boolean isMusicianExistBySong(String song) {
        return musicianDao.isMusicianExistsBySong(song);
    }
}
