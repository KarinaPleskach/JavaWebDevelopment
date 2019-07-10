package by.training.domain_model.parser.impl;

import by.training.domain_model.exception.ParserException;
import by.training.domain_model.parser.ResourceParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OneCriteriaParser implements ResourceParser<String> {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String paramDelimiter = " ";

    @Override
    public List<String> parse(String path) throws ParserException {
        String[] wordsInRequest = path.split(paramDelimiter);
        if (wordsInRequest[0].equals("")) {
            LOGGER.warn("Illegal request in parse(String path)");
            throw new ParserException();
        }
        List<String> requests = new ArrayList<>();
        for (String request : wordsInRequest) {
            requests.add(request);
        }
        return requests;
    }
}
