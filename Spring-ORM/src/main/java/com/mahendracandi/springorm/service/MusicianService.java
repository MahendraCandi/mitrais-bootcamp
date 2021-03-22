package com.mahendracandi.springorm.service;

import com.mahendracandi.springorm.model.Musician;

import java.util.List;

public interface MusicianService {

    void addMusician(String name, String instrument, String song);

    void updateMusician(int id, String name, String instrument, String song);

    Musician getMusician(int id);

    List<Musician> getAllMusician();

    void deleteMusician(int id);
}
