package by.training.web_parsing.entity;

import java.util.Objects;

public class Duration {
    private int days;
    private int nights;

    public Duration(int days, int nights) {
        this.days = days;
        this.nights = nights;
    }
    public Duration() {}

    public int getDays() { return days; }

    public void setDays(int days) {
        this.days = days;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration = (Duration) o;
        return days == duration.days &&
                nights == duration.nights;
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, nights);
    }

    @Override
    public String toString() {
        return "Duration{" +
                "days=" + days +
                ", nights=" + nights +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
