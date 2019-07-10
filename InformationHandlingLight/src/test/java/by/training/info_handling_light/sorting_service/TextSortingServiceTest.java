package by.training.info_handling_light.sorting_service;

import by.training.info_handling_light.bean.model.Lexeme;
import by.training.info_handling_light.bean.model.Paragraph;
import by.training.info_handling_light.bean.model.Sentence;
import by.training.info_handling_light.bean.model.Text;
import by.training.info_handling_light.repository.Repository;
import by.training.info_handling_light.repository.RepositoryException;
import by.training.info_handling_light.repository.RepositoryFabric;
import by.training.info_handling_light.service.ServiceException;
import by.training.info_handling_light.sorting_service.comparator.TextComparator;
import by.training.info_handling_light.sorting_service.comparator.TextComparatorFabric;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TextSortingServiceTest {

    private static SortingService service;
    private static Repository<Text> repository;
    private Text actual;

    @BeforeClass
    public static void beforeClass() {
        repository = RepositoryFabric.getRepository();
        service = SortingServiceFabric.getService();
    }

    @Before
    public void before() {

        Sentence sentence1 = new Sentence();
        sentence1.addElement(new Lexeme("test1"));

        Sentence sentence2 = new Sentence();
        sentence2.addElement(new Lexeme("test2"));
        sentence2.addElement(new Lexeme("test22"));

        Sentence sentence3 = new Sentence();
        sentence3.addElement(new Lexeme("test3"));
        sentence3.addElement(new Lexeme("test33"));
        sentence3.addElement(new Lexeme("test333"));

        Paragraph paragraph1 = new Paragraph();
        paragraph1.addElement(sentence1);

        Paragraph paragraph2 = new Paragraph();
        paragraph2.addElement(sentence2);
        paragraph2.addElement(sentence3);

        actual = new Text();
        actual.addElement(paragraph1);
        actual.addElement(paragraph2);
    }

    @Test
    public void bySentencesCountTest() throws SortingServiceException, ServiceException, RepositoryException {

        Sentence sentence1 = new Sentence();
        sentence1.addElement(new Lexeme("test1"));

        Sentence sentence2 = new Sentence();
        sentence2.addElement(new Lexeme("test2"));
        sentence2.addElement(new Lexeme("test22"));

        Sentence sentence3 = new Sentence();
        sentence3.addElement(new Lexeme("test3"));
        sentence3.addElement(new Lexeme("test33"));
        sentence3.addElement(new Lexeme("test333"));

        Paragraph paragraph1 = new Paragraph();
        paragraph1.addElement(sentence1);

        Paragraph paragraph2 = new Paragraph();
        paragraph2.addElement(sentence2);
        paragraph2.addElement(sentence3);

        Text expected = new Text();
        expected.addElement(paragraph2);
        expected.addElement(paragraph1);

        repository.update(expected);

        service.makeSorted("sentences_count");
        Text what = repository.get();
        System.out.println(what.getAllValue());
        System.out.println(actual.getAllValue());
        Assert.assertArrayEquals(what.getAllValue().toCharArray(), actual.getAllValue().toCharArray());
    }

}