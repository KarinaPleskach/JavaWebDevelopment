package by.training.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class described cost
 * that people will be pay in tour
 * when buy voucher for some country.
 *
 * @author      Karina Pleskach
 * @see         Voucher
 * @version     1.0
 */
public class Cost {

    /**
     * Field show initial cost.
     */
    private int cost;

    /**
     * Field contains all facilities that cost included
     */
    private List<Facility> facilities = new ArrayList<>();

    /**
     * You can not get cost from field cause it is private one.
     *
     * @return  cost of the cost.
     * @since   1.0
     */
    public int getCost() {
        return cost;
    }

    /**
     * You can not change cost from field cause it is private one.
     *
     * @param   cost will be set to the field cost.
     * @since   1.0
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * You can not get facilities from field cause it is private one.
     *
     * @return  facilities of the cost.
     * @since   1.0
     */
    public List<Facility> getFacilities() {
        return facilities;
    }

    /**
     * You can not change facilities from field cause it is private one.
     *
     * @param   facilities will be set to the field facilities.
     * @since   1.0
     */
    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    /**
     * Use equals to check if costs are identical.
     *
     * @param   o cost that will be checked with this one.
     * @return  true if objects are equal and false if not.
     * @since   1.0
     * @see     Object#equals(Object).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost1 = (Cost) o;
        return cost == cost1.cost &&
                Objects.equals(facilities, cost1.facilities);
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
        return Objects.hash(cost, facilities);
    }

    /**
     * Always calls when you want to print cost.
     *
     * @return  object string representation.
     * @since   1.0
     * @see     Object#toString().
     */
    @Override
    public String toString() {
        return "Cost{" +
                "cost=" + cost +
                ", facilities=" + facilities +
                '}';
    }
}
