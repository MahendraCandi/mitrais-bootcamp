package com.mahendracandi.UnitTest.service;

import com.mahendracandi.UnitTest.dao.MusicianDao;
import com.mahendracandi.UnitTest.model.Musician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MusicianServiceImplTest {

//    example using @InjectMock:
//    @InjectMocks private Musician underTest = new MusicianServiceImpl();
//    use the above example if in service impl have autowired in property name

    private MusicianService underTest;

    @Mock
    private MusicianDao musicianDao;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
//        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new MusicianServiceImpl(musicianDao);
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }

    @Test
    void itShouldGetAllMusician() {
        // when
        underTest.getAllMusician();
        // then
        verify(musicianDao).findAll();
    }

    @Test
    void itShouldAddMusician() {
        // given
        Musician m = new Musician();
        m.setName("Raga");
        m.setSong("Bolok-bolok");
        m.setInstrument("Vokal");

        // when
        underTest.addMusician(m);

        // then
        ArgumentCaptor<Musician> musicianArgumentCaptor = ArgumentCaptor.forClass(Musician.class);
        verify(musicianDao).save(musicianArgumentCaptor.capture());
        Musician capturedMusician = musicianArgumentCaptor.getValue();
        assertThat(capturedMusician).isEqualTo(m);
    }

    @Test
    void itShouldThrownExceptionWhenMusicianIsExistBySong() {
        // given
        Musician m = new Musician();
        m.setName("Raga");
        m.setSong("Bolok-bolok");
        m.setInstrument("Vokal");

//        BDDMockito.given(musicianDao.isMusicianExistsBySong(m.getSong()))
        BDDMockito.given(musicianDao.isMusicianExistsBySong(anyString()))
                .willReturn(true);

        // when
        // then
        assertThatThrownBy(() -> underTest.addMusician(m))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Musician " + m.toString() + " already exists");

        verify(musicianDao, never()).save(any());
    }

    @Test
    @Disabled
    void deleteMusicianById() {
    }
}