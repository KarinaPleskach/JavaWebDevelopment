package by.training.info_handling_light.repository;

import by.training.info_handling_light.bean.model.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

class TextRepository implements Repository<Text> {

    private static final Logger LOGGER = LogManager.getLogger();

    private Text savedText;

    @Override
    public void update(Text element) {
        savedText = element;
    }

    @Override
    public Text get() throws RepositoryException {
        return Optional.ofNullable(savedText)
                .map(obj -> {
                    return obj;
                })
                .orElseThrow(RepositoryException::new);
//        if (savedText == null) {
//            String message = "Variable savedText is not initialized in get()";
//            LOGGER.error(message);
//            throw new RepositoryException(message);
//        }
//        return savedText;
    }
}
