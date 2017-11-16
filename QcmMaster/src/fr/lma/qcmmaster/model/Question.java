package fr.lma.qcmmaster.model;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.json.JsonValue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import fr.lma.qcmmaster.tec.exception.TechnicalException;
import fr.lma.qcmmaster.tec.facade.JsonAble;
import fr.lma.qcmmaster.tec.util.DateBuilderUtil;

/**
 * Javabean représentant une question d'examen.
 */
public class Question implements JsonAble {

	private static final long serialVersionUID = 6209654778729641992L;

	/**
	 * Identifiant unique.
	 */
	private Integer id;

	/**
	 * Titre de la question.
	 */
	private String title;

	/**
	 * Corps de la question.
	 */
	private String body;

	/**
	 * Question précédant la liste des réponses.
	 */
	private String question;

	/**
	 * Set des réponses possibles.
	 */
	private TreeSet<Answer> answerSet;

	/**
	 * Set des tags pour chaque question.
	 */
	private TreeSet<String> tagSet;

	/**
	 * Date de création.
	 */
	private Date creationDate;

	/**
	 * Date de modification.
	 */
	private Date modificationDate;

	/**
	 * Constructeur par défaut.
	 */
	public Question() {
		super();
	}

	/**
	 * Constructeur à partir d'une chaîne JSON.
	 *
	 * @param json
	 *            La chaîne JSON représenant la question.
	 */
	public Question(final String json) {
		buildJavaBean(json);
	}

	/**
	 * Constructeur à partir d'un objet JSON.
	 *
	 * @param json
	 *            L'objet JSON représentant la question.
	 */
	public Question(final JsonObject json) throws TechnicalException {
		buildJavaBean(json);
	}

	@Override
	public JsonObject getJsonObject() {
		final JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("id", id);
		builder.add("title", title);
		builder.add("body", body);
		builder.add("question", question);
		final JsonArrayBuilder answerArray = Json.createArrayBuilder();
		for (final Answer answer : answerSet) {
			answerArray.add(answer.getJsonObject());
		}
		builder.add("answerSet", answerArray.build());
		final JsonArrayBuilder tagArray = Json.createArrayBuilder();
		for (final String tag : tagSet) {
			tagArray.add(tag);
		}
		builder.add("tagSet", tagArray.build());
		builder.add("creationDate", DateBuilderUtil.formatDate(creationDate));
		builder.add("modificationDate", DateBuilderUtil.formatDate(modificationDate));
		return builder.build();
	}

	@Override
	public void buildJavaBean(final JsonObject jsonObject) throws TechnicalException {
		id = jsonObject.getInt("id");
		title = jsonObject.getString("title");
		body = jsonObject.getString("body");
		question = jsonObject.getString("question");
		final JsonArray answerArray = jsonObject.getJsonArray("answerSet");
		answerSet = new TreeSet<>();
		for (final JsonValue jsonValue : answerArray) {
			answerSet.add(new Answer((JsonObject) jsonValue));
		}
		final JsonArray tagArray = jsonObject.getJsonArray("tagSet");
		tagSet = new TreeSet<>();
		for (final JsonValue jsonValue : tagArray) {
			tagSet.add(new String(((JsonString) jsonValue).getString()));
		}
		creationDate = DateBuilderUtil.parseDate(jsonObject.getString("creationDate"));
		modificationDate = DateBuilderUtil.parseDate(jsonObject.getString("modificationDate"));
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1233, 1239)
				.append(id)
				.append(title)
				.append(body)
				.append(question)
				.append(creationDate)
				.append(modificationDate)
				.append(answerSet)
				.append(tagSet)
				.toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		} else if ((null == obj) || !(obj instanceof Question)) {
			return false;
		} else {
			final Question quest = (Question) obj;
			return new EqualsBuilder()
					.append(id, quest.id)
					.append(title, quest.title)
					.append(body, quest.body)
					.append(question, quest.question)
					.append(creationDate, quest.creationDate)
					.append(modificationDate, quest.modificationDate)
					.append(answerSet, quest.answerSet)
					.append(tagSet, quest.tagSet)
					.isEquals();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(final String question) {
		this.question = question;
	}

	public Set<Answer> getAnswerSet() {
		return answerSet;
	}

	public void setAnswerSet(final TreeSet<Answer> answerSet) {
		this.answerSet = answerSet;
	}

	public Set<String> getTagSet() {
		return tagSet;
	}

	public void setTagSet(final TreeSet<String> tagSet) {
		this.tagSet = tagSet;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(final Date modificationDate) {
		this.modificationDate = modificationDate;
	}
}
