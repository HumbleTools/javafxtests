package fr.lma.qcmmaster.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import fr.lma.qcmmaster.tec.exception.TechnicalException;
import fr.lma.qcmmaster.tec.facade.JsonAble;
import fr.lma.qcmmaster.tec.util.DateFormatterUtil;

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
	 * Liste des réponses possibles.
	 */
	private List<Answer> answerList;

	/**
	 * Liste des tags pour chaque question.
	 */
	private List<String> tagList;

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
		for (final Answer answer : answerList) {
			answerArray.add(answer.getJsonObject());
		}
		builder.add("answerList", answerArray.build());
		final JsonArrayBuilder tagArray = Json.createArrayBuilder();
		for (final String tag : tagList) {
			tagArray.add(tag);
		}
		builder.add("tagList", tagArray.build());
		builder.add("creationDate", DateFormatterUtil.formatDate(creationDate));
		builder.add("modificationDate", DateFormatterUtil.formatDate(modificationDate));
		return builder.build();
	}

	@Override
	public void buildJavaBean(final JsonObject jsonObject) throws TechnicalException {
		id = jsonObject.getInt("id");
		title = jsonObject.getString("title");
		body = jsonObject.getString("body");
		question = jsonObject.getString("question");
		final JsonArray answerArray = jsonObject.getJsonArray("answerList");
		answerList = new ArrayList<Answer>();
		for (final JsonValue jsonValue : answerArray) {
			answerList.add(new Answer((JsonObject) jsonValue));
		}
		final JsonArray tagArray = jsonObject.getJsonArray("tagList");
		tagList = new ArrayList<String>();
		for (final JsonValue jsonValue : tagArray) {
			tagList.add(new String(jsonValue.toString()));
		}
		creationDate = DateFormatterUtil.parseDate(jsonObject.getString("creationDate"));
		modificationDate = DateFormatterUtil.parseDate(jsonObject.getString("modificationDate"));
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
