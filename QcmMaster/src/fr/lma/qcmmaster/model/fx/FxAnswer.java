package fr.lma.qcmmaster.model.fx;

import fr.lma.qcmmaster.model.Answer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FxAnswer {

	/**
	 * Position de la r�ponse dans une question.
	 */
	private IntegerProperty position;

	/**
	 * Corps de la r�ponse.
	 */
	private StringProperty body;

	/**
	 * Si la r�ponse est bonne ou mauvaise.
	 */
	private BooleanProperty right;

	/**
	 * Constructeur par d�faut.
	 */
	public FxAnswer() {
		super();
	}

	/**
	 * Constructeur param�tr�.
	 */
	public FxAnswer(final Answer answer) {
		position = new SimpleIntegerProperty(answer.getPosition());
		body = new SimpleStringProperty(answer.getBody());
		right = new SimpleBooleanProperty(answer.isRight());
	}

	public IntegerProperty getPosition() {
		return position;
	}

	public void setPosition(final IntegerProperty position) {
		this.position = position;
	}

	public StringProperty getBody() {
		return body;
	}

	public void setBody(final StringProperty body) {
		this.body = body;
	}

	public BooleanProperty getRight() {
		return right;
	}

	public void setRight(final BooleanProperty right) {
		this.right = right;
	}
}
