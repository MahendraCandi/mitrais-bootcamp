package com.mahendracandi.springorm;

import com.mahendracandi.springorm.config.AppConfig;
import com.mahendracandi.springorm.properties.AppProperties;
import com.mahendracandi.springorm.service.MusicianService;
import com.mahendracandi.springorm.service.impl.MusicainImplSpringJpa;
import com.mahendracandi.springorm.service.impl.MusicianServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main( String[] args ) {
//        MusicianService musicianService = new MusicianServiceImpl();
//
//        musicianService.addMusician("Gabu Gabu", "Bass", "Punch in the face");
//        musicianService.getAllMusician();
//        musicianService.updateMusician(1, "Golga", "Drum", "Fire Peak");
//        musicianService.deleteMusician(2);
//        musicianService.getMusician(3);
//        musicianService.getAllMusician();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AppProperties properties = applicationContext.getBean(AppProperties.class);
        System.out.println(properties.getJdbcDirverClassName());
        MusicianService musicianService = (MusicianService) applicationContext.getBean("MusicainImplSpringJpa");
        musicianService.addMusician("Gobta", "Vocal", "Absolomb");
        musicianService.getAllMusician();
        musicianService.updateMusician(3, "Drew", "Flute", "Water can");
        musicianService.deleteMusician(1);
        musicianService.getMusician(4);
        musicianService.getAllMusician();

    }
}
