package by.training.service.parser;

import java.io.File;
import java.util.List;

public interface Parser<T> {
    List<T> parse(File file) throws ParserException;
}
