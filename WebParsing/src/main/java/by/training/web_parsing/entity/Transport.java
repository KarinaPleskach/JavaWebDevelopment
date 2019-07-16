package by.training.web_parsing.entity;

import java.util.Objects;

public class Transport {
    private TransportType type;

    public Transport() {}

    public Transport(TransportType type) {
        this.type = type;
    }

    public TransportType getType() {
        return type;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return type == transport.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "type=" + type +
                '}';
    }
}
