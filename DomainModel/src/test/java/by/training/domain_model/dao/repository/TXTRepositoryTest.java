package by.training.domain_model.dao.repository;

import by.training.domain_model.dao.Repository;
import by.training.domain_model.dao.Specification;
import by.training.domain_model.dao.fabric.RepositoryFabric;
import by.training.domain_model.dao.fabric.SpecificationFabric;
import by.training.domain_model.entity.Record;
import by.training.domain_model.entity.Ringtone;
import by.training.domain_model.entity.music.Duration;
import by.training.domain_model.exception.DAOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TXTRepositoryTest {

    private static Repository repository;

    @Before
    public void before(){
        repository = RepositoryFabric.getRepository();
    }

    @Test(expected = DAOException.class)
    public void findEmptyTest() throws DAOException {
        repository.delete();
        repository.find();
    }

    @Test(expected = DAOException.class)
    public void updateNullTest() throws DAOException {
        repository.update(null);
    }

    @Test
    public void updateNormalTest() throws DAOException {
        Record record = new Ringtone("Name", new Duration(5, 50));
        List<Record> records = new ArrayList<>(Arrays.asList(record));
        repository.update(records);
        List<Record> result = repository.find();
        assertArrayEquals(records.toArray(), result.toArray());
    }

    @Test(expected = DAOException.class)
    public void addNullTest() throws DAOException {
        repository.add(null);
    }

    @Test
    public void addNormalTest() throws DAOException {
        Record record = new Ringtone("Name", new Duration(5, 50));
        List<Record> records = new ArrayList<>(Arrays.asList(record));

        repository.delete();
        repository.add(records);
        List<Record> result = repository.find();
        assertArrayEquals(records.toArray(), result.toArray());
    }

    @Test(expected = DAOException.class)
    public void DeleteAllNormalTest() throws DAOException {
        repository.delete();
        repository.find();
    }

    @Test(expected = DAOException.class)
    public void DeleteNullTest() throws DAOException {
        repository.delete(null);
    }

    @Test(expected = DAOException.class)
    public void DeleteNormalTest() throws DAOException {
        Record record = new Ringtone("Name", new Duration(5, 50));
        List<Record> records = new ArrayList<>(Arrays.asList(record));

        repository.delete();
        repository.add(records);
        repository.delete(records);

        repository.find();
    }

    @Test
    public void DeleteNotFoundTest() throws DAOException {
        Record record = new Ringtone("Name", new Duration(5, 50));
        Record deletedRecord = new Ringtone("AnotherName", new Duration(5, 50));
        List<Record> records = new ArrayList<>(Arrays.asList(record));
        List<Record> deletedRecords = new ArrayList<>(Arrays.asList(deletedRecord));

        repository.delete();
        repository.add(records);
        repository.delete(deletedRecords);

        List<Record> result = repository.find();
        assertArrayEquals(records.toArray(), result.toArray());
    }

    @Test
    public void FindNormalTest() throws DAOException {
        Record record = new Ringtone("Name", new Duration(5, 50));
        List<Record> records = new ArrayList<>(Arrays.asList(record));

        repository.delete();
        repository.add(records);
        List<Record> result = repository.find();
        assertArrayEquals(records.toArray(), result.toArray());
    }

    @Test
    public void FindSpecificationNormalTest() throws DAOException {
        Specification[] specifications = new Specification[] {
                new SpecificationFabric("Name").getSpecification("song_name")
        };
        Record[] record = new Record[] {
                new Ringtone("Name", new Duration(5, 50)),
                new Ringtone("AnotherName", new Duration(5, 50))
        };
        List<Record> records = new ArrayList<>(Arrays.asList(record));

        repository.delete();
        repository.add(records);
        List<Record> result = repository.find(specifications);
        List<Record> expected = new ArrayList<>(Arrays.asList(new Ringtone("Name", new Duration(5, 50))));
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test(expected = DAOException.class)
    public void FindSpecificationEmptyTest() throws DAOException {
        Specification[] specifications = new Specification[] {
                new SpecificationFabric("Name").getSpecification("song_name")
        };
        Record[] record = new Record[] {
                new Ringtone("AnotherName", new Duration(5, 50))
        };
        List<Record> records = new ArrayList<>(Arrays.asList(record));

        repository.delete();
        repository.add(records);
        repository.find(specifications);
    }
}