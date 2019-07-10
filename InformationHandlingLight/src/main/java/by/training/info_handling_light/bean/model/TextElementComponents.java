package by.training.info_handling_light.bean.model;

class TextElementComponents {

    private String connectingElement;
    private String separatorElement;

    public TextElementComponents(String connectingElement, String separatorElement) {
        this.connectingElement = connectingElement;
        this.separatorElement = separatorElement;
    }

    public String getConnectingElement() {
        return connectingElement;
    }

    public String getSeparatorElement() {
        return separatorElement;
    }
}
