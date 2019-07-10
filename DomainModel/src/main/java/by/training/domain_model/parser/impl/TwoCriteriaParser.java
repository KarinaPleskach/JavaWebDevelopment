package by.training.domain_model.parser.impl;

import by.training.domain_model.exception.ParserException;
import by.training.domain_model.parser.ResourceParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TwoCriteriaParser implements ResourceParser<String> {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String paramDelimiter = " ";

    @Override
    public List<String> parse(String path) throws ParserException {
        String[] wordsInRequest = path.split(paramDelimiter);
        if (wordsInRequest[0].equals("") || wordsInRequest.length % 2 != 0) {
            LOGGER.warn("Illegal request in parse(String path)");
            throw new ParserException();
        }
        List<String> requests = new ArrayList<>();
        for (int i = 0; i < wordsInRequest.length; i += 2) {
            requests.add(wordsInRequest[i] + " " + wordsInRequest[i + 1]);
        }
        return requests;
    }
}
