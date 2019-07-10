package by.training.info_handling_light.sorting_service.comparator;

import by.training.info_handling_light.sorting_service.SortingServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TextComparatorFabric {
    private static final Logger LOGGER = LogManager.getLogger();
    private static TextComparatorFabric INSTANSE = new TextComparatorFabric();
    private final Map<ComparatorName, TextComparator> repository = new HashMap();

    private TextComparatorFabric() {
        repository.put(ComparatorName.SENTENCES_COUNT, new BySentencesCount());
        repository.put(ComparatorName.WORD_LENGTH, new ByWordLength());
        repository.put(ComparatorName.WORDS_COUNT, new ByWordsCount());
    }
    public static TextComparatorFabric getINSTANSE() {
        return INSTANSE;
    }

    public TextComparator getComparator(String name) throws SortingServiceException {
        TextComparator comparator;
        try{
            comparator = repository.get(ComparatorName.valueOf(name.toUpperCase()));
        }catch(IllegalArgumentException ex){
            LOGGER.warn("Illegal request in getComparator(String name)");
            throw new SortingServiceException("Illegal request");
        }
        return comparator;
    }


}
