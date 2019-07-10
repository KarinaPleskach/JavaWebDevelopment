package by.training.info_handling_light.service.parser;

import by.training.info_handling_light.bean.composite.LeafTextElement;

public interface Parser<T extends LeafTextElement> {
    T parse(String text) throws ParserException;
}
