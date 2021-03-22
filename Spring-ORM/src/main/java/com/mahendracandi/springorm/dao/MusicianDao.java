package com.mahendracandi.springorm.dao;

import com.mahendracandi.springorm.model.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicianDao extends JpaRepository<Musician, Integer> {
}
