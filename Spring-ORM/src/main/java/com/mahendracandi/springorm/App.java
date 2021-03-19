package com.mahendracandi.springorm;

import com.mahendracandi.springorm.service.MusicianService;
import com.mahendracandi.springorm.service.impl.MusicianServiceImpl;

public class App {

    public static void main( String[] args ) {
        MusicianService musicianService = new MusicianServiceImpl();

        musicianService.addMusician("dora", "guitar", "death metal pizza");
    }
}
