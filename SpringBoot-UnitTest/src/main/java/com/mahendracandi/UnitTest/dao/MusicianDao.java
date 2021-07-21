package com.mahendracandi.UnitTest.dao;

import com.mahendracandi.UnitTest.model.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicianDao extends JpaRepository<Musician, Integer> {

    @Query(value="SELECT CASE WHEN COUNT(m.id) > 0 THEN TRUE ELSE FALSE END FROM Musician m WHERE m.song=:song")
    Boolean isMusicianExistsBySong(@Param("song") String song);
}
