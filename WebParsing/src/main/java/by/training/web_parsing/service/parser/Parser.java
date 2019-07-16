package by.training.web_parsing.service.parser;

import java.io.File;
import java.util.List;

public interface Parser<T> {
    List<T> parse(File file) throws ParserException;
}
