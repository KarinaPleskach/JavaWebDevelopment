package by.training.domain_model.dao.specification;

import by.training.domain_model.dao.Specification;
import by.training.domain_model.dao.fabric.SpecificationFabric;
import by.training.domain_model.entity.Record;
import by.training.domain_model.entity.Ringtone;
import by.training.domain_model.entity.Song;
import by.training.domain_model.entity.music.Duration;
import by.training.domain_model.entity.music.Styles;
import by.training.domain_model.entity.music.Timbre;
import by.training.domain_model.entity.performer.impl.SoloArtist;
import by.training.domain_model.exception.DAOException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ByDurationSpecificationTest {

    @Test
    public void matchAllTest() throws DAOException {
        Specification specification = new SpecificationFabric("all").getSpecification("duration");
        Record record = new Song("a", new Duration(2, 2), new SoloArtist("Animal"), Styles.ROCK, Timbre.TENOR);
        boolean actual = specification.match(record);
        assertTrue(actual);
    }

    @Test
    public void matchThisTrueTest() throws DAOException {
        Specification specification = new SpecificationFabric("2.2").getSpecification("duration");
        Record record = new Song("a", new Duration(2, 2), new SoloArtist("AAnimal"), Styles.ROCK, Timbre.BARITONE);
        boolean actual = specification.match(record);
        assertTrue(actual);
    }

    @Test
    public void matchThisFalseTest() throws DAOException {
        Specification specification = new SpecificationFabric("2.2").getSpecification("duration");
        Record record = new Song("a", new Duration(3, 2), new SoloArtist("AAnimal"), Styles.ROCK, Timbre.BARITONE);
        boolean actual = specification.match(record);
        assertFalse(actual);
    }

    @Test
    public void matchBetweenTrueTest() throws DAOException {
        Specification specification = new SpecificationFabric("1.0-3.0").getSpecification("duration");
        Record record = new Ringtone("a", new Duration(2, 2));
        boolean actual = specification.match(record);
        assertTrue(actual);
    }

    @Test
    public void matchBetweenFalseTest() throws DAOException {
        Specification specification = new SpecificationFabric("1.0-2.0").getSpecification("duration");
        Record record = new Ringtone("a", new Duration(2, 2));
        boolean actual = specification.match(record);
        assertFalse(actual);
    }

}