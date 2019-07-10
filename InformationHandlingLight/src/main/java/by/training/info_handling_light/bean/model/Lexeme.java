package by.training.info_handling_light.bean.model;

import by.training.info_handling_light.bean.composite.LeafTextElement;

import java.util.Objects;

public class Lexeme implements LeafTextElement {

    private final String value;

    public Lexeme(String value) {
        this.value = value;
    }

    public String getAllValue() {
        return value;
    }

    public String getCleanValue() {
        return value.replace("\\W", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lexeme lexeme = (Lexeme) o;
        return Objects.equals(value, lexeme.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return getAllValue();
    }
}
