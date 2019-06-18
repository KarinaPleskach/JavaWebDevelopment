package by.training.entity;

import java.util.Objects;

/**
 * Class described transport
 * that people will use when buy
 * voucher for some country.
 *
 * @author      Karina Pleskach
 * @see         Voucher
 * @version     1.0
 */
public class Transport {

    /**
     * Field that describe what transport type it is.
     */
    private TransportType type;

    /**
     * Constructs a new transport with {@code null} as its type.
     *
     * @since   1.0
     */
    public Transport() {
    }

    /**
     * Constructs a new transport with specified type.
     *
     * @param   type show the type of the transport.
     * @since   1.0
     */
    public Transport(final TransportType type) {
        this.type = type;
    }

    /**
     * You can not get type from field cause it is private one.
     *
     * @return  type of the transport.
     * @since   1.0
     */
    public TransportType getType() {
        return type;
    }

    /**
     * You can not change type from field cause it is private one.
     *
     * @param   type will be set to the field type.
     * @since   1.0
     */
    public void setType(final TransportType type) {
        this.type = type;
    }

    /**
     * Use equals to check if transports are identical.
     *
     * @param   o transport that will be checked with this one.
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
        Transport transport = (Transport) o;
        return type == transport.type;
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
        return Objects.hash(type);
    }

    /**
     * Always calls when you want to print transport.
     *
     * @return  object string representation.
     * @since   1.0
     * @see     Object#toString().
     */
    @Override
    public String toString() {
        return "Transport{"
                + "type="
                + type
                + '}';
    }
}
