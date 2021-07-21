package com.mahendracandi.UnitTest;

import com.mahendracandi.UnitTest.dao.MusicianDao;
import com.mahendracandi.UnitTest.model.Musician;
import com.mahendracandi.UnitTest.service.MusicianService;
import com.mahendracandi.UnitTest.service.MusicianServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class UnitTestApplicationTests {

	@Autowired
	private MusicianDao musicianDao;

	@Test
	public void MusicianShouldExistsBySong() {
		String song = "Dadada";

		Musician musician = new Musician();
		musician.setName("Caca");
		musician.setSong("Dadada");
		musician.setInstrument("Guitar");
		musicianDao.save(musician);

		boolean isSongExists = musicianDao.isMusicianExistsBySong(song);

		Assertions.assertThat(isSongExists).isTrue();
	}

	@Test
	public void MusicianShouldNotExistsBySong() {
		String song = "death metal pizza";

		boolean isSongExists = musicianDao.isMusicianExistsBySong(song);

		Assertions.assertThat(isSongExists).isFalse();
	}

}
