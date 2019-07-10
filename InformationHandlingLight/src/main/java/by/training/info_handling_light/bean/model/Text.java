package by.training.info_handling_light.bean.model;

import by.training.info_handling_light.bean.composite.CompositeTextElement;

public class Text extends CompositeTextElement {

    private static final TextElementComponents components = new TextElementComponents("\r\n", "");

    public String getAllValue() {
        return getCleanValue();
    }

    public String getCleanValue() {
        String result = getElements()
                .stream()
                .map(e -> e.getAllValue() + components.getConnectingElement())
                .reduce("", String::concat);
        return result;
    }
}
