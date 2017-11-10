package fr.lma.qcmmaster.model;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import fr.lma.qcmmaster.model.facade.JsonAble;

/**
 * Javabean représentant une question d'examen.
 */
public class Question implements JsonAble {

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
	 * Liste des réponses possibles.
	 */
	private List<Answer> answerList;

	/**
	 * Liste des tags pour chaque question.
	 */
	private List<String> tagList;

	private Long creationDate;

	private Long modificationDate;

	@Override
	public JsonObject getJsonObject() {
		final JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("id", id);
		builder.add("title", title);
		builder.add("body", body);
		builder.add("question", question);
		final JsonArrayBuilder answerArray = Json.createArrayBuilder();
		for (final Answer answer : answerList) {
			answerArray.add(answer.getJsonObject());
		}
		builder.add("answerList", answerArray.build());
		final JsonArrayBuilder tagArray = Json.createArrayBuilder();
		for (final String tag : tagList) {
			tagArray.add(tag);
		}
		builder.add("tagList", tagArray.build());
		builder.add("creationDate", creationDate);
		builder.add("modificationDate", modificationDate);
		return builder.build();
	}

	@Override
	public void buildJavaBean(final JsonObject jsonObject) {
		id = jsonObject.getInt("id");
		title = jsonObject.getString("title");
		body = jsonObject.getString("body");
		question = jsonObject.getString("question");
		final JsonArray answerArray = jsonObject.getJsonArray("answerList");
		for (final JsonValue jsonValue : answerArray) {
			// TODO correctly read answers
		}
		final JsonArray tagArray = jsonObject.getJsonArray("tagList");
		for (final JsonValue jsonValue : answerArray) {
			// TODO correctly read tags
		}
		// TODO change timestamps to dates + store timestamp strings in json
		// strings
		// TODO finish this method
		// TODO test model with JUnits
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

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(final List<Answer> answerList) {
		this.answerList = answerList;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(final List<String> tagList) {
		this.tagList = tagList;
	}

	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final Long creationDate) {
		this.creationDate = creationDate;
	}

	public Long getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(final Long modificationDate) {
		this.modificationDate = modificationDate;
	}
}
