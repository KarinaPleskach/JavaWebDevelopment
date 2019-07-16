package by.training.web_parsing.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

class CommandProvider {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<CommandName, Command> repository = new HashMap();

    CommandProvider() {
        repository.put(CommandName.SHOW, new Show());
        repository.put(CommandName.PARSE, new Parse());
        repository.put(CommandName.EXIT, new Exit());
        repository.put(CommandName.WRONG_REQUEST,new WrongRequest());
    }

    Command getCommand(String name) {
        Command command;
        try{
            command = repository.get(CommandName.valueOf(name.toUpperCase()));
        }catch(IllegalArgumentException ex){
            LOGGER.warn("Illegal request in getCommand(String name)");
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
