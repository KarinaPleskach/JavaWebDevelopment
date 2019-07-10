package by.training.domain_model.parser.fabric;

import by.training.domain_model.exception.ParserException;
import by.training.domain_model.parser.ResourceParser;
import by.training.domain_model.parser.impl.OneCriteriaParser;
import by.training.domain_model.parser.impl.TwoCriteriaParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class RequestParserFabric {
    private static final Logger LOGGER = LogManager.getLogger();

    private enum WordsInRequest {
        ONE, TWO
    }

    private final Map<WordsInRequest, ResourceParser<String>> repository = new HashMap();

    private RequestParserFabric() {
        repository.put(WordsInRequest.TWO, new TwoCriteriaParser());
        repository.put(WordsInRequest.ONE, new OneCriteriaParser());
    }

    public static RequestParserFabric getInstance() {
        return FabricHolder.INSTANCE;
    }
    private static class FabricHolder {
        private static final RequestParserFabric INSTANCE = new RequestParserFabric();
    }

    public ResourceParser<String> getRequestParser(String name) throws ParserException {
        ResourceParser<String> parser;
        try {
            parser = repository.get(WordsInRequest.valueOf(name.toUpperCase()));
        } catch (IllegalArgumentException ex) {
            LOGGER.warn("Illegal request in getRequestParser(String name)");
            throw new ParserException();
        }
        return parser;
    }
}
