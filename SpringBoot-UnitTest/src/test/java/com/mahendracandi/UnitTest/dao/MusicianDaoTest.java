package com.mahendracandi.UnitTest.dao;

import com.mahendracandi.UnitTest.model.Musician;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MusicianDaoTest {

    @Autowired
    private MusicianDao underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void isShouldCheckWhenMusicianExistsBySong() {
        // given
        Musician musician = new Musician();
        String name = "Jaya";
        String song = "Shark Bite";
        String instrument = "Guitar";
        musician.setName(name);
        musician.setSong(song);
        musician.setInstrument(instrument);
        underTest.save(musician);

        // when
        boolean expectedResult = underTest.isMusicianExistsBySong(song);

        // then
        assertThat(expectedResult).isTrue();
    }

    @Test
    void isShouldCheckWhenMusicianDoesNotExistsBySong() {
        // given
        String song = "Shark Dance";

        // when
        boolean expectedResult = underTest.isMusicianExistsBySong(song);

        // then
        assertThat(expectedResult).isFalse();
    }
}