package by.training.domain_model.validator.record.impl;

import by.training.domain_model.exception.ValidatorException;
import by.training.domain_model.validator.ValidatorResult;
import by.training.domain_model.validator.record.RecordLineValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SongLineValidatorTest {

    private static RecordLineValidator validator;

    @Before
    public void before() {
        validator = new SongLineValidator();
    }

    @Test
    public void validNormalTest() {
        ValidatorResult expected = new ValidatorResult(true);
        ValidatorResult actual = validator.valid("Song a 2 2 Band Animal ROCK TENOR");
        assertArrayEquals(expected.toString().toCharArray(), actual.toString().toCharArray());
    }

    @Test
    public void validIllegalTest() {
        ValidatorResult expected = new ValidatorResult(false, "Invalid Song Record");
        ValidatorResult actual = validator.valid("Song");
        assertArrayEquals(expected.toString().toCharArray(), actual.toString().toCharArray());
    }
}