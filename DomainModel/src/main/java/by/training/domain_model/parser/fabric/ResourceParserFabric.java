package by.training.domain_model.parser.fabric;

import by.training.domain_model.parser.ResourceParser;
import by.training.domain_model.parser.impl.FileParser;

import java.nio.file.Path;

public final class ResourceParserFabric {
    private static ResourceParser<Path> parser = new FileParser();
    private ResourceParserFabric() {}
    public static ResourceParser<Path> getParser() {
        return  parser;
    }
}
