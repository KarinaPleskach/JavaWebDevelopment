package by.training.info_handling_light.service;

import by.training.info_handling_light.bean.model.Text;
import by.training.info_handling_light.repository.Repository;
import by.training.info_handling_light.repository.RepositoryException;
import by.training.info_handling_light.repository.RepositoryFabric;
import by.training.info_handling_light.service.parser.Parser;
import by.training.info_handling_light.service.parser.ParserException;
import by.training.info_handling_light.service.parser.ParserFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileParserService implements Service<Text> {

    private static final Logger LOGGER = LogManager.getLogger();
    private final Repository<Text> repository = RepositoryFabric.getRepository();

    private String get(Path path) throws ServiceException {
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            LOGGER.error("invalid file in update(Path pat)");
            throw new ServiceException();
        }
        String text = new String(bytes);
        return text;
    }

    @Override
    public void update(Path path) throws ServiceException {
        LOGGER.info("start update in Service");

        String fileText = get(path);

        Parser<Text> parser = ParserFabric.getParser();

        Text text = null;
        try {
            text = parser.parse(fileText);
        } catch (ParserException e) {
            String message = "Invalid text in update(Path path)";
            LOGGER.error(message);
            throw new ServiceException(message);
        }
        repository.update(text);
    }

    @Override
    public Text get() throws ServiceException {
        Text text;
        try {
            text = repository.get();
        } catch (RepositoryException e) {
            String message = "Uninitialized text in get()";
            LOGGER.error(message);
            throw new ServiceException(message);
        }
        return text;
    }
}
