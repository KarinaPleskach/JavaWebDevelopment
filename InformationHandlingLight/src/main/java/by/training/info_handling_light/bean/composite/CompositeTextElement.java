package by.training.info_handling_light.bean.composite;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class CompositeTextElement implements LeafTextElement {
    private List<LeafTextElement> elements;
    public CompositeTextElement() {
        elements = new LinkedList<LeafTextElement>();
    }

    public List<LeafTextElement> getElements() {
        return elements;
    }

    public void addElement(LeafTextElement element) {
        elements.add(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeTextElement that = (CompositeTextElement) o;
        return this.elements.equals(that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    @Override
    public String toString() {
        return getAllValue();
    }
}
