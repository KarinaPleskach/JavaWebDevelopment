package by.training.entity;

import java.util.Objects;

/**
 * Class described duration
 * that people will be in tour
 * when buy voucher for some country.
 *
 * @author      Karina Pleskach
 * @see         Voucher
 * @version     1.0
 */
public class Duration {

    /**
     * Field that show number of days.
     */
    private int days;

    /**
     * Field that show number of nights.
     */
    private int nights;

    /**
     * Constructs a new duration with specified
     * number of days and nights.
     *
     * @param   days that specified number of days of tour.
     * @param   nights that specified number of nights of tour.
     * @since   1.0
     */
    public Duration(final int days, final int nights) {
        this.days = days;
        this.nights = nights;
    }

    /**
     * Constructs a new duration with 0 in it fields.
     *
     * @since   1.0
     */
    public Duration() {
    }

    /**
     * You can not get days from field cause it is private one.
     *
     * @return  number of days of the duration.
     * @since   1.0
     */
    public int getDays() {
        return days;
    }

    /**
     * You can not change number of days from field cause it is private one.
     *
     * @param   days will be set to the field days.
     * @since   1.0
     */
    public void setDays(final int days) {
        this.days = days;
    }

    /**
     * You can not get nights from field cause it is private one.
     *
     * @return  number of nights of the duration.
     * @since   1.0
     */
    public int getNights() {
        return nights;
    }

    /**
     * You can not change number of nights from field cause it is private one.
     *
     * @param   nights will be set to the field nights.
     * @since   1.0
     */
    public void setNights(final int nights) {
        this.nights = nights;
    }

    /**
     * Use equals to check if durations are identical.
     *
     * @param   o duration that will be checked with this one.
     * @return  true if objects are equal and false if not.
     * @since   1.0
     * @see     Object#equals(Object).
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Duration duration = (Duration) o;
        return days == duration.days
                && nights == duration.nights;
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
        return Objects.hash(days, nights);
    }

    /**
     * Always calls when you want to print duration.
     *
     * @return  object string representation.
     * @since   1.0
     * @see     Object#toString().
     */
    @Override
    public String toString() {
        return "Duration{"
                + "days=" + days
                + ", nights=" + nights
                + '}';
    }
}
