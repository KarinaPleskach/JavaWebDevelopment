package by.training.domain_model.validator.record.impl;

import by.training.domain_model.validator.ValidatorResult;
import by.training.domain_model.validator.record.RecordLineValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinusLineValidatorTest {

    private static RecordLineValidator validator;

    @Before
    public void before() {
        validator = new MinusLineValidator();
    }

    @Test
    public void validNormalTest() {
        ValidatorResult expected = new ValidatorResult(true);
        ValidatorResult actual = validator.valid("Minus dskf 1 11 SoloArtist jjj RAP");
        assertArrayEquals(expected.toString().toCharArray(), actual.toString().toCharArray());
    }

    @Test
    public void validIllegalTest() {
        ValidatorResult expected = new ValidatorResult(false, "Invalid Minus Record");
        ValidatorResult actual = validator.valid("Minus");
        assertArrayEquals(expected.toString().toCharArray(), actual.toString().toCharArray());
    }
}