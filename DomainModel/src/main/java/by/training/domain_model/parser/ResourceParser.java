package by.training.domain_model.parser;

import by.training.domain_model.exception.ParserException;

import java.util.List;

public interface ResourceParser<T> {
    List<String> parse(T path) throws ParserException;
}
