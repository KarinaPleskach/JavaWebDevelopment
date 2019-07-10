package by.training.domain_model.dao.specification;

import by.training.domain_model.dao.Specification;
import by.training.domain_model.dao.fabric.SpecificationFabric;
import by.training.domain_model.entity.Record;
import by.training.domain_model.entity.Ringtone;
import by.training.domain_model.entity.Song;
import by.training.domain_model.entity.music.Duration;
import by.training.domain_model.entity.music.Styles;
import by.training.domain_model.entity.music.Timbre;
import by.training.domain_model.entity.performer.impl.Band;
import by.training.domain_model.entity.performer.impl.SoloArtist;
import by.training.domain_model.exception.DAOException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ByPerformerTest {

    private static Specification specification;

    @Before
    public  void before() throws DAOException {
        specification = new SpecificationFabric("SoloArtist").getSpecification("performer");
    }

    @Test
    public void matchTrueTest() {
        Record record = new Song("a", new Duration(2, 2), new SoloArtist("Animal"), Styles.ROCK, Timbre.TENOR);
        boolean actual = specification.match(record);
        assertTrue(actual);
    }

    @Test
    public void matchFalseTest() {
        Record record = new Song("a", new Duration(2, 2), new Band("AAnimal"), Styles.ROCK, Timbre.BARITONE);
        boolean actual = specification.match(record);
        assertFalse(actual);
    }

    @Test
    public void matchAnotherTypeTest() {
        Record record = new Ringtone("a", new Duration(2, 2));
        boolean actual = specification.match(record);
        assertFalse(actual);
    }
}