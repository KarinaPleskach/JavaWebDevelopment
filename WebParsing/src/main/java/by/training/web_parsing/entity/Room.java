package by.training.web_parsing.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {
    private int beds;
    private List<RoomFacility> facilities = new ArrayList<>();

    public Room(int beds, List<RoomFacility> facilities) {
        this.beds = beds;
        this.facilities = facilities;
    }
    public Room() {}

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public List<RoomFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<RoomFacility> facilities) {
        this.facilities = facilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return beds == room.beds &&
                Objects.equals(facilities, room.facilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beds, facilities);
    }

    @Override
    public String toString() {
        return "Room{" +
                "beds=" + beds +
                ", facilities=" + facilities +
                '}';
    }
}
