package by.training.domain_model.validator.record;

import by.training.domain_model.validator.ValidatorResult;

public interface RecordLineValidator {
    ValidatorResult valid(String line);
}
