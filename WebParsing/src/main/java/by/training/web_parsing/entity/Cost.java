package by.training.web_parsing.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cost {
    private int cost;
    private List<Facility> facilities = new ArrayList<>();

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost1 = (Cost) o;
        return cost == cost1.cost &&
                Objects.equals(facilities, cost1.facilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, facilities);
    }

    @Override
    public String toString() {
        return "Cost{" +
                "cost=" + cost +
                ", facilities=" + facilities +
                '}';
    }
}
