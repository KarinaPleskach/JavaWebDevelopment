package by.training.domain_model.parser.impl;

import by.training.domain_model.exception.ParserException;
import by.training.domain_model.parser.ResourceParser;
import by.training.domain_model.parser.fabric.ResourceParserFabric;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileParserTest {

    private static ResourceParser parser;

    @Before
    public void before() {
        parser = ResourceParserFabric.getParser();
    }

    @Test
    public void parseNormalTest() throws ParserException {
        Path path = Paths.get(".\\src\\main\\resources\\add.txt");
        List<String> expected = new ArrayList<>(Arrays.asList(new String("Ringtone ring 5 49")));
        List<String> actual = parser.parse(path);

        assertArrayEquals(expected.toString().toCharArray(), actual.toString().toCharArray());
    }

    @Test(expected = ParserException.class)
    public void parseIllegalPathTest() throws ParserException {
        Path path = Paths.get(".\\src\\main\\resources\\aaaaaadd.txt");
        List<String> actual = parser.parse(path);
    }

    @Test(expected = ParserException.class)
    public void parseEmptyTest() throws ParserException {
        Path path = Paths.get(".\\src\\main\\resources\\empty.txt");
        List<String> actual = parser.parse(path);
    }
}