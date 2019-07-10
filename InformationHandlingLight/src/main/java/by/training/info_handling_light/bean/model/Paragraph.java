package by.training.info_handling_light.bean.model;

import by.training.info_handling_light.bean.composite.CompositeTextElement;

public class Paragraph extends CompositeTextElement {

    private static final TextElementComponents components = new TextElementComponents(" ", "\t");

    public String getAllValue() {
        return components.getSeparatorElement() + getCleanValue();
    }

    public String getCleanValue() {
        String result = getElements()
                .stream()
                .map(e -> e.getAllValue() + components.getConnectingElement())
                .reduce("", String::concat)
                .trim();
        return result;
    }
}
