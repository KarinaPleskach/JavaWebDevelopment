package by.training.web_parsing.entity;

import java.util.Locale;
import java.util.Objects;

public class Location implements Cloneable {
    private Locale country;
    private String city;

    public Location(String countryCode, String city) {
        this.country = new Locale("", countryCode);
        this.city = city;
    }

    public Location(Locale country, String city) {
        this.country = (Locale) country.clone();
        this.city = city;
    }

    public Location() {

    }

    public Locale getCountry() {
        return (Locale) country.clone();
    }

    public void setCountry(Locale country) {
        this.country = (Locale) country.clone();
    }

    public void setCountry(String countryCode) {
        this.country = new Locale("", countryCode);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(country, location.country) &&
                Objects.equals(city, location.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public String toString() {
        return "Location{" +
                "country=" + country.getDisplayCountry() +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Location copy = (Location) super.clone();
        copy.country = (Locale) country.clone();
        return copy;
    }
}
