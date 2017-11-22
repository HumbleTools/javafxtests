package fr.lma.qcmmaster.model.fx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.lma.qcmmaster.model.Answer;
import fr.lma.qcmmaster.model.Question;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**
 * Javabean Question pour la vue JAVAFX.
 */
public class FxQuestion {

	/**
	 * Identifiant unique.
	 */
	private IntegerProperty id;

	/**
	 * Titre de la question.
	 */
	private StringProperty title;

	/**
	 * Corps de la question.
	 */
	private StringProperty body;

	/**
	 * Question précédant la liste des réponses.
	 */
	private StringProperty question;

	/**
	 * Set des réponses possibles.
	 */
	private SimpleListProperty<FxAnswer> answerList;

	/**
	 * Set des tags pour chaque question.
	 */
	private SimpleListProperty<StringProperty> tagList;

	/**
	 * Date de création.
	 */
	private ObjectProperty<Date> creationDate;

	/**
	 * Date de modification.
	 */
	private ObjectProperty<Date> modificationDate;

	/**
	 * Constructeur par défaut.
	 */
	public FxQuestion() {
		super();
	}

	/**
	 * Constructeur à partir d'une question
	 *
	 * @param question
	 *            Question sur laquelle baser notre bean modèle.
	 */
	public FxQuestion(final Question question) {
		id = new SimpleIntegerProperty(question.getId());
		title = new SimpleStringProperty(question.getTitle());
		body = new SimpleStringProperty(question.getBody());
		this.question = new SimpleStringProperty(question.getQuestion());
		creationDate = new SimpleObjectProperty<>(question.getCreationDate());
		modificationDate = new SimpleObjectProperty<>(question.getModificationDate());
		final List<FxAnswer> ansPropList = new ArrayList<>();
		for (final Answer answer : question.getAnswerSet()) {
			ansPropList.add(new FxAnswer(answer));
		}
		answerList = new SimpleListProperty<>(FXCollections.observableArrayList(ansPropList));
		final List<StringProperty> tagPropList = new ArrayList<>();
		for (final String tag : question.getTagSet()) {
			tagPropList.add(new SimpleStringProperty(tag));
		}
		tagList = new SimpleListProperty<>(FXCollections.observableArrayList(tagPropList));
	}

	public IntegerProperty getId() {
		return id;
	}

	public void setId(final IntegerProperty id) {
		this.id = id;
	}

	public StringProperty getTitle() {
		return title;
	}

	public void setTitle(final StringProperty title) {
		this.title = title;
	}

	public StringProperty getBody() {
		return body;
	}

	public void setBody(final StringProperty body) {
		this.body = body;
	}

	public StringProperty getQuestion() {
		return question;
	}

	public void setQuestion(final StringProperty question) {
		this.question = question;
	}

	public SimpleListProperty<FxAnswer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(final SimpleListProperty<FxAnswer> answerList) {
		this.answerList = answerList;
	}

	public SimpleListProperty<StringProperty> getTagList() {
		return tagList;
	}

	public void setTagList(final SimpleListProperty<StringProperty> tagList) {
		this.tagList = tagList;
	}

	public ObjectProperty<Date> getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final ObjectProperty<Date> creationDate) {
		this.creationDate = creationDate;
	}

	public ObjectProperty<Date> getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(final ObjectProperty<Date> modificationDate) {
		this.modificationDate = modificationDate;
	}

}
