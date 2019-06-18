package by.training.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandProviderTest {

    private static CommandProvider provider;

    @Before
    public void before() {
        provider = new CommandProvider();
    }

    @Test
    public void getCommandNormalTest() {
        Command expected = new Show();
        Command actual = provider.getCommand("show");
        assertEquals(expected.getClass().getSimpleName(), actual.getClass().getSimpleName());
    }

    @Test
    public void getCommandIllegalNameTest() {
        Command expected = new WrongRequest();
        Command actual = provider.getCommand("_");
        assertEquals(expected.getClass().getSimpleName(), actual.getClass().getSimpleName());
    }

}