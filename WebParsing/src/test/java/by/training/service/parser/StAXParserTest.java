package by.training.service.parser;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class StAXParserTest {
    @Test(expected = NullPointerException.class)
    public void parseIllegalTest() throws ParserException, URISyntaxException {

        URL res = getClass().getClassLoader().getResource("illegal.xml");
        File xml = null;
        xml = Paths.get(res.toURI()).toFile();
        System.out.println(ParserFabric.getINSTANSE().getParser("dom").parse(xml));
    }
}