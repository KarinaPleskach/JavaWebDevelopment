package by.training.info_handling_light.sorting_service;

import by.training.info_handling_light.bean.composite.CompositeTextElement;
import by.training.info_handling_light.bean.model.Text;
import by.training.info_handling_light.repository.Repository;
import by.training.info_handling_light.repository.RepositoryFabric;
import by.training.info_handling_light.service.Service;
import by.training.info_handling_light.service.ServiceException;
import by.training.info_handling_light.service.ServiceFabric;
import by.training.info_handling_light.sorting_service.comparator.TextComparator;
import by.training.info_handling_light.sorting_service.comparator.TextComparatorFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class TextSortingService implements SortingService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final Service<Text> service = ServiceFabric.getService();
    private final Repository<Text> repository = RepositoryFabric.getRepository();

    @Override
    public void makeSorted(String request) throws ServiceException, SortingServiceException {
        LOGGER.info("start makeSorted in SortingService");
        Text text;
        try {
            text = service.get();
        } catch (ServiceException e) {
            String message = "Uninitialized text in get()";
            LOGGER.error(message);
            throw new ServiceException(message);
        }

        TextComparatorFabric fabric = TextComparatorFabric.getINSTANSE();
        TextComparator comparator = fabric.getComparator(request);

        switch (request) {
            case "sentences_count":
                text.getElements().sort(comparator);
                break;
            case "words_count":
                text.getElements()
                        .forEach(paragraph -> ((CompositeTextElement)paragraph).getElements().sort(comparator));
                break;
            case "word_length":
                text.getElements()
                        .forEach(paragraph -> ((CompositeTextElement) paragraph).getElements()
                                        .forEach(sentence -> ((CompositeTextElement) sentence).getElements().sort(comparator)));
                break;
        }

        repository.update(text);
    }
}
