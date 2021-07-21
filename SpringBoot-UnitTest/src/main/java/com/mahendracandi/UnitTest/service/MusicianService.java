package com.mahendracandi.UnitTest.service;

import com.mahendracandi.UnitTest.model.Musician;

import java.util.List;

public interface MusicianService {
    List<Musician> getAllMusician();

    void addMusician(Musician musician);

    void deleteMusicianById(Integer id);

    boolean isMusicianExistBySong(String song);
}
