package by.training.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class described room
 * that people will have in hotel in tour
 * when buy voucher for some country.
 *
 * @author      Karina Pleskach
 * @see         Hotel
 * @version     1.0
 */
public class Room {

    /**
     * Field show number of beds in room.
     */
    private int beds;

    /**
     * Field contains all facilities that room included
     */
    private List<RoomFacility> facilities = new ArrayList<>();

    /**
     * Constructs a new room with specified
     * number of beds and facilities.
     *
     * @param   beds that specified number of beds in room.
     * @param   facilities that specified facilities in room.
     * @since   1.0
     */
    public Room(int beds, List<RoomFacility> facilities) {
        this.beds = beds;
        this.facilities = facilities;
    }

    /**
     * Constructs a new room with 0 in it fields.
     *
     * @since   1.0
     */
    public Room() {}

    /**
     * You can not get beds from field cause it is private one.
     *
     * @return  number of beds in the room.
     * @since   1.0
     */
    public int getBeds() {
        return beds;
    }

    /**
     * You can not change beds from field cause it is private one.
     *
     * @param   beds will be set to the field beds.
     * @since   1.0
     */
    public void setBeds(int beds) {
        this.beds = beds;
    }

    /**
     * You can not get facilities from field cause it is private one.
     *
     * @return  facilities of the cost.
     * @since   1.0
     */
    public List<RoomFacility> getFacilities() {
        return facilities;
    }

    /**
     * You can not change facilities from field cause it is private one.
     *
     * @param   facilities will be set to the field facilities.
     * @since   1.0
     */
    public void setFacilities(List<RoomFacility> facilities) {
        this.facilities = facilities;
    }

    /**
     * Use equals to check if rooms are identical.
     *
     * @param   o room that will be checked with this one.
     * @return  true if objects are equal and false if not.
     * @since   1.0
     * @see     Object#equals(Object).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return beds == room.beds &&
                Objects.equals(facilities, room.facilities);
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
        return Objects.hash(beds, facilities);
    }

    /**
     * Always calls when you want to print room.
     *
     * @return  object string representation.
     * @since   1.0
     * @see     Object#toString().
     */
    @Override
    public String toString() {
        return "Room{" +
                "beds=" + beds +
                ", facilities=" + facilities +
                '}';
    }
}
