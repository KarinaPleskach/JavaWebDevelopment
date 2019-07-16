package by.training.multithreading_matrix.dao;

/**
 * Checked exception thrown to indicate request to dao is not valid
 * or can be empty.
 *
 * @author Karina Pleskach
 * @see DAO
 * @version  1.0
 */
public class DAOException extends Exception {

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized.
     * @since 1.0
     */
    public DAOException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.
     * The cause is not initialized.
     *
     * @param   message   the detail message. The detail message is saved for
     *                    later retrieval by the {@link #getMessage()} method.
     * @since 1.0
     */
    public DAOException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of {@code (cause==null ? null : cause.toString())} (which
     * typically contains the class and detail message of {@code cause}).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *               {@link #getCause()} method).  (A {@code null} value is
     *               permitted, and indicates that the cause is nonexistent or
     *               unknown.)
     * @since 1.0
     */
    public DAOException(final Exception cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param  message the detail message (which is saved for later retrieval
     *                 by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *               {@link #getCause()} method).  (A {@code null} value is
     *               permitted, and indicates that the cause is nonexistent or
     *               unknown.)
     * @since 1.0
     */
    public DAOException(final String message, final Exception cause) {
        super(message, cause);
    }
}
