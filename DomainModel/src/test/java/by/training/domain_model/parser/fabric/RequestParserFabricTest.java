package by.training.domain_model.parser.fabric;

import by.training.domain_model.exception.ParserException;
import by.training.domain_model.parser.ResourceParser;
import by.training.domain_model.parser.impl.OneCriteriaParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestParserFabricTest {

    private static RequestParserFabric parserFabric;

    @Before
    public void before() {
        parserFabric = RequestParserFabric.getInstance();
    }

    @Test
    public void getRequestParserNormalTest() throws ParserException {
        ResourceParser expected = new OneCriteriaParser();
        ResourceParser actual = parserFabric.getRequestParser("one");

        assertEquals(expected.getClass().getSimpleName(), actual.getClass().getSimpleName());
    }

    @Test(expected = ParserException.class)
    public void getRequestValidatorIllegalTest() throws ParserException {
        ResourceParser actual = parserFabric.getRequestParser("_");
    }
}