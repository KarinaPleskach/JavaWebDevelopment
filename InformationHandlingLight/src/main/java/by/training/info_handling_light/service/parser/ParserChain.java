package by.training.info_handling_light.service.parser;

interface ParserChain<T> {
    T parseLine(String line) throws ParserException;
    ParserChain<T> linkWith(ParserChain<T> next);
}
