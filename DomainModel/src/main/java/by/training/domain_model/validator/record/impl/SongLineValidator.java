package by.training.domain_model.validator.record.impl;

import by.training.domain_model.validator.ValidatorResult;
import by.training.domain_model.validator.record.RecordLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SongLineValidator implements RecordLineValidator {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public ValidatorResult valid(String line) {
        ValidatorResult validatorResult;
        if (!line.matches("Song \\w+ \\d+ \\d+ (Band|SoloArtist) [A-Za-z_0-9]+ (ROCK|BLUES|POP|RAP|CLASSICAL|COUNTRY|ELECTRONIC|FOLK|METAL|HIP_HOP|JAZZ) (TENOR|BARITONE|BASS|SOPRANO|MEZZO_SOPRANO|CONTRALTO)")) {
            LOGGER.warn("Invalid Song line in valid(String line)");
            validatorResult = new ValidatorResult(false, "Invalid Song Record");
        } else {
            validatorResult = new ValidatorResult(true);
        }
        return validatorResult;
    }
}
