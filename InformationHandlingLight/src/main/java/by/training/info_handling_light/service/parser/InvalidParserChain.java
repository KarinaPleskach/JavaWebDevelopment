package by.training.info_handling_light.service.parser;

import by.training.info_handling_light.bean.composite.LeafTextElement;

import org.apache.commons.lang3.StringUtils;

class InvalidParserChain extends TextElementParserChain {
    @Override
    public LeafTextElement parseLine(String line) throws ParserException {
        if (StringUtils.startsWith(line, "\t") && StringUtils.endsWith(line, ".")) {
            return nextParse(line);
        } else {
            String message = "Invalid text in parseLine(String path)";
            LOGGER.error(message);
            throw new ParserException(message);
        }
    }
}
