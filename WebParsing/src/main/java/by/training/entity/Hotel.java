package by.training.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class described hotel
 * that people choose in tour
 * when buy voucher for some country.
 *
 * @author      Karina Pleskach
 * @see         Voucher
 * @version     1.0
 */
public class Hotel {

    /**
     * Field shows number of stars.
     */
    private int stars;

    /**
     * Field shows type of nutrition.
     */
    private NutritionType nutrition;

    /**
     * Field shows name of hotel.
     */
    private String name;

    /**
     * Field shows list of rooms that person choose in this hotel.
     */
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

    /**
     * Use equals to check if hotels are identical.
     *
     * @param   o hotel that will be checked with this one.
     * @return  true if objects are equal and false if not.
     * @since   1.0
     * @see     Object#equals(Object).
     */
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

    /**
     * Hash of the object.
     *
     * @return  hash.
     * @since   1.0
     * @see     Object#hashCode().
     */
    @Override
    public int hashCode() {
        return Objects.hash(stars, nutrition, name, rooms);
    }

    /**
     * Always calls when you want to print hotel.
     *
     * @return  object string representation.
     * @since   1.0
     * @see     Object#toString().
     */
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

