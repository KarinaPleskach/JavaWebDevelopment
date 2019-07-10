package by.training.info_handling_light.service.parser;

public final class ParserFabric {
    private ParserFabric() {}
    private static Parser parser = new TextParser();
    public static Parser getParser() { return parser; }
}