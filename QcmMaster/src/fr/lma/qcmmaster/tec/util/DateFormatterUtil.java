package fr.lma.qcmmaster.tec.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import fr.lma.qcmmaster.tec.exception.TechnicalException;

/**
 * Utilitaire de lecture/écriture des dates.
 */
public class DateFormatterUtil {

	private final static SimpleDateFormat FR_FORMAT = new SimpleDateFormat("yyyyMMdd-hh:mm:ss", Locale.FRANCE);

	/**
	 * Formate une date en String en utilisant {@link #FR_FORMAT}.
	 *
	 * @param date
	 *            La date à formater.
	 * @return La date formatée en String.
	 */
	public static String formatDate(final Date date) {
		return FR_FORMAT.format(date);
	}

	/**
	 * Parse une date String en Date.
	 *
	 * @param dateString
	 *            La chaîne à parser.
	 * @return La date lue depuis la chaîne.
	 * @throws TechnicalException
	 *             En cas de problème de lecture.
	 */
	public static Date parseDate(final String dateString) throws TechnicalException {
		try {
			return StringUtils.isEmpty(dateString) ? null : FR_FORMAT.parse(dateString);
		} catch (final ParseException pe) {
			throw new TechnicalException(String.format("Impossible de parser la date '%s'", dateString), pe);
		}
	}
}
