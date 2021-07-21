package com.mahendracandi.UnitTest.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "musician")
public class Musician implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "instrument", length = 50, nullable = false)
    private String instrument;

    @Column(name = "song", length = 50, nullable = false)
    private String song;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Musician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instrument='" + instrument + '\'' +
                ", song='" + song + '\'' +
                '}';
    }
}
