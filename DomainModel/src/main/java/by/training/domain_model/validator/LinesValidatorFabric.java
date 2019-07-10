package by.training.domain_model.validator;

public class LinesValidatorFabric {
    private static LinesValidator validator = new RecordLinesValidator();
    private LinesValidatorFabric() {}
    public static LinesValidator getValidator() {
        return  validator;
    }
}
