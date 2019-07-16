package by.training.web_parsing.service.parser;

public class ParserException extends Exception {
    public ParserException(){ super(); }
    public ParserException(String message){ super(message); }
    public ParserException(Exception e){ super(e); }
    public ParserException(String message, Exception e){ super(message, e); }
}