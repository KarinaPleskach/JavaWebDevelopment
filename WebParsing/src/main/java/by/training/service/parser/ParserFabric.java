package by.training.service.parser;

import by.training.entity.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ParserFabric {
    private static final Logger LOGGER = LogManager.getLogger();
    private static ParserFabric INSTANSE = new ParserFabric();
    private final Map<ParserType, Parser<Voucher>> repository = new HashMap();

    private ParserFabric() {
        repository.put(ParserType.DOM, new DOMParser());
        repository.put(ParserType.SAX, new SaxParser());
        repository.put(ParserType.STAX, new StAXParser());
    }
    public static ParserFabric getINSTANSE() {
        return INSTANSE;
    }

    public Parser<Voucher> getParser(String name) throws ParserException {
        Parser<Voucher> comparator;
        try{
            comparator = repository.get(ParserType.valueOf(name.toUpperCase()));
        }catch(IllegalArgumentException ex){
            LOGGER.warn("Illegal request in getParser(String name)");
            throw new ParserException("Illegal request");
        }
        return comparator;
    }
}
