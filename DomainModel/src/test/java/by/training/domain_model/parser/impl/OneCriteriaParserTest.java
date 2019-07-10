package by.training.domain_model.parser.impl;

import by.training.domain_model.exception.ParserException;
import by.training.domain_model.parser.ResourceParser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OneCriteriaParserTest {

    private static ResourceParser parser;

    @Before
    public void before() {
        parser = new OneCriteriaParser();
    }

    @Test
    public void parseNormalTest() throws ParserException {
        List<String> expected = new ArrayList<>(Arrays.asList(new String("hello"), new String("world")));
        List<String> actual = parser.parse("hello world");

        assertArrayEquals(expected.toString().toCharArray(), actual.toString().toCharArray());
    }

    @Test(expected = ParserException.class)
    public void parseEmptyTest() throws ParserException {
        List<String> actual = parser.parse("");
    }

}
