package by.training.web_parsing.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {
    private int stars;
    private NutritionType nutrition;
    private String name;
    private List<Room> rooms = new ArrayList<>();

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public NutritionType getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionType nutrition) {
        this.nutrition = nutrition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return stars == hotel.stars &&
                nutrition == hotel.nutrition &&
                Objects.equals(name, hotel.name) &&
                Objects.equals(rooms, hotel.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stars, nutrition, name, rooms);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "stars=" + stars +
                ", nutrition=" + nutrition +
                ", name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}

