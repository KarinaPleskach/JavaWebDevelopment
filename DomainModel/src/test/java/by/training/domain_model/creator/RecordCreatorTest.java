package by.training.domain_model.creator;

import by.training.domain_model.entity.Record;
import by.training.domain_model.entity.Ringtone;
import by.training.domain_model.entity.music.Duration;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecordCreatorTest {

    private static Creator<Record> creator;

    @Before
    public void before() {
        creator = CreatorFabric.getCreator();
    }

    @Test
    public void createTest() {
        Record expected = new Ringtone("a", new Duration(2, 2));
        Record actual = creator.create("Ringtone a 2 2");
        assertArrayEquals(expected.toString().toCharArray(), actual.toString().toCharArray());
    }

}