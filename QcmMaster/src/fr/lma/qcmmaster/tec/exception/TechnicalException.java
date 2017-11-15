package fr.lma.qcmmaster.tec.exception;

/**
 * A Basic exception wrapper.
 */
public class TechnicalException extends Exception {

	private static final long serialVersionUID = -683476873646120071L;

	public TechnicalException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
