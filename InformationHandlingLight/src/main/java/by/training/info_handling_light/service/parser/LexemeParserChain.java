package by.training.info_handling_light.service.parser;

import by.training.info_handling_light.bean.composite.LeafTextElement;
import by.training.info_handling_light.bean.model.Lexeme;

class LexemeParserChain extends TextElementParserChain {
    @Override
    public LeafTextElement parseLine(String line) {
        return new Lexeme(line);
    }
}
