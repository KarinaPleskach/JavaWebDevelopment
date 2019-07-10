package by.training.domain_model.validator;

import java.util.List;

public interface LinesValidator {
    ValidatorResult valid(List<String> lines);
}
