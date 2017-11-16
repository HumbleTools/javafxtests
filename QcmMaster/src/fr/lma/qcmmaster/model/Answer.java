package fr.lma.qcmmaster.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import fr.lma.qcmmaster.tec.facade.JsonAble;

/**
 * JavaBean d'une r�ponse de question.
 */
public class Answer implements JsonAble {

	private static final long serialVersionUID = 1612937502701519025L;

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
	 * Constructeur � partir d'une cha�ne JSON.
	 *
	 * @param json
	 *            La cha�ne JSON repr�senant la r�ponse.
	 */
	public Answer(final String json) {
		buildJavaBean(json);
	}

	/**
	 * Constructeur � partir d'un objet JSON.
	 *
	 * @param json
	 *            L'objet JSON repr�sentant la r�ponse.
	 */
	public Answer(final JsonObject json) {
		buildJavaBean(json);
	}

	@Override
	public JsonObject getJsonObject() {
		final JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("body", body);
		builder.add("isRight", right);
		builder.add("position", position);
		return builder.build();
	}

	@Override
	public void buildJavaBean(final JsonObject jsonObject) {
		body = jsonObject.getString("body");
		right = jsonObject.getBoolean("isRight");
		position = (short) jsonObject.getInt("position");
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
