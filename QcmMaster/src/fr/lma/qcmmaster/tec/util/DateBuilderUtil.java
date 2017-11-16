package fr.lma.qcmmaster.tec.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import fr.lma.qcmmaster.tec.exception.TechnicalException;

/**
 * Utilitaire de lecture/écriture des dates.
 */
public class DateBuilderUtil {

	private static final Locale FRANCE = Locale.FRANCE;

	private final static SimpleDateFormat FR_FORMAT = new SimpleDateFormat("yyyyMMdd-HH:mm:ss", FRANCE);

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
			Date parsedDate = null;
			if (StringUtils.isNotEmpty(dateString)) {
				final Calendar cal = Calendar.getInstance(FRANCE);
				cal.clear();
				cal.setTime(FR_FORMAT.parse(dateString));
				parsedDate = cal.getTime();
			}
			return parsedDate;
		} catch (final ParseException pe) {
			throw new TechnicalException(String.format("Impossible de parser la date '%s'", dateString), pe);
		}
	}

	/**
	 * Construit un Objet {@link Date} respectant strictement l'instant précisé
	 * par les paramètres, avec les millisecondes à zéro.
	 *
	 * @param year
	 *            Année de la date.
	 * @param month
	 *            Mois de la date.
	 * @param date
	 *            Jour calendaire de la date.
	 * @param hourOfDay
	 *            Heures de la date.
	 * @param minute
	 *            Minutes de la date.
	 * @param second
	 *            Secondes de la date.
	 * @return La date créée.
	 */
	public static Date getDate(final int year, final int month, final int date, final int hourOfDay, final int minute,
			final int second) {
		final Calendar cal = Calendar.getInstance(FRANCE);
		cal.clear();
		cal.set(year, month, date, hourOfDay, minute, second);
		return cal.getTime();
	}
}
