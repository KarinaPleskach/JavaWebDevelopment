package by.training.entity;

/**
 * Enum described facilities
 * that people will pay on tour for
 * when buy voucher for some country.
 *
 * @author      Karina Pleskach
 * @see         Cost
 * @version     1.0
 */
public enum Facility {

    /**
     * In case of adding you must add the same info to xsd file.
     */
    EXCURSION(100), GUIDE(140), TRANSLATOR(200), INSURANCE(190);

    /**
     * Field that contains cost for each facility
     */
    private int cost;

    /**
     * Constructor for setting cost.
     * @param cost that will be set on field.
     * @since 1.0
     */
    Facility(final int cost) {
        this.cost = cost;
    }

    /**
     * You can not get cost from field cause it is private one.
     *
     * @return  cost of the facility.
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
    public void setCost(final int cost) {
        this.cost = cost;
    }

    /**
     * Always calls when you want to print facility.
     *
     * @return  object string representation.
     * @since   1.0
     * @see     Object#toString().
     */
    @Override
    public String toString() {
        return String.format("%s : cost = %d", name(), cost);
    }

}
