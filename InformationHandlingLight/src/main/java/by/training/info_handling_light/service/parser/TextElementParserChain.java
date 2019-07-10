package by.training.info_handling_light.service.parser;

import by.training.info_handling_light.bean.composite.LeafTextElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract class TextElementParserChain implements ParserChain<LeafTextElement> {
    protected static final Logger LOGGER = LogManager.getLogger();
    private TextElementParserChain next;

    @Override
    public ParserChain<LeafTextElement> linkWith(ParserChain<LeafTextElement> next) {
        ((TextElementParserChain) next).next = this;
        return next;
    }

    protected LeafTextElement nextParse(String line) throws ParserException {
        if (next != null ) {
            return next.parseLine(line);
        } else {
            return null;
//            String message = "Invalid text in nextParse(String line)";
//            LOGGER.error(message);
//            throw new ParserException(message);
        }
    }

}
