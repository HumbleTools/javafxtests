package fr.lma.qcmmaster.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import fr.lma.qcmmaster.model.facade.JsonAble;

/**
 * JavaBean d'une réponse de question.
 */
public class Answer implements JsonAble {

	private String body;

	private boolean isRight;

	public Answer() {
		super();
	}

	public Answer(final String json) {
		buildJavaBean(json);
	}

	public Answer(final JsonObject json) {
		buildJavaBean(json);
	}

	@Override
	public JsonObject getJsonObject() {
		final JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("body", body);
		builder.add("isRight", isRight);
		return builder.build();
	}

	@Override
	public void buildJavaBean(final JsonObject jsonObject) {
		body = jsonObject.getString("body");
		isRight = jsonObject.getBoolean("isRight");
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(final boolean isRight) {
		this.isRight = isRight;
	}

}
