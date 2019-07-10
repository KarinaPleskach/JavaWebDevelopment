package by.training.info_handling_light.bean.model;

import by.training.info_handling_light.bean.composite.CompositeTextElement;

public class Sentence extends CompositeTextElement {

    private static final TextElementComponents components = new TextElementComponents(" ", ".");

    public String getAllValue() {
        return getCleanValue() + components.getSeparatorElement();
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
