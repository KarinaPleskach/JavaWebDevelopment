package by.training.domain_model.controller.comand;

import by.training.domain_model.exception.ControllerException;

public interface Command {
    String execute(String request) throws ControllerException;
}
