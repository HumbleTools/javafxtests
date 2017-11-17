package fr.lma.qcmmaster.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * JavaBean d'une r�ponse de question.
 */
public class Answer implements Comparable<Answer> {

	/**
	 * Position de la r�ponse dans une question.
	 */
	private short position;

	/**
	 * Corps de la r�ponse.
	 */
	private String body;

	/**
	 * Si la r�ponse est bonne ou mauvaise.
	 */
	private boolean right;

	/**
	 * Constructeur par d�faut.
	 */
	public Answer() {
		super();
	}

	/**
	 * Constructeur param�tr�.
	 *
	 * @param position
	 *            La position de la r�ponse dans la question qui la poss�de.
	 * @param right
	 *            Le fait qu'une r�ponse soit bonne ou fausse.
	 * @param body
	 *            La r�ponse en elle-m�me.
	 */
	public Answer(final int position, final boolean right, final String body) {
		setPosition(position);
		this.body = body;
		this.right = right;
	}

	@Override
	public int compareTo(final Answer o) {
		return new CompareToBuilder()
				.append(position, o.position)
				.toComparison();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1231, 1237)
				.append(position)
				.append(body)
				.append(right)
				.toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		} else if ((null == obj) || !(obj instanceof Answer)) {
			return false;
		} else {
			final Answer answer = (Answer) obj;
			return new EqualsBuilder()
					.append(position, answer.position)
					.append(body, answer.body)
					.append(right, answer.right)
					.isEquals();
		}
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(final boolean isRight) {
		right = isRight;
	}

	public short getPosition() {
		return position;
	}

	public void setPosition(final int position) {
		this.position = (short) position;
	}

}
