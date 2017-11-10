package fr.lma.qcmmaster.model.facade;

import java.io.StringReader;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;

public interface JsonAble {

	/**
	 * Builds a JSON String corresponding to this JsonAble object.
	 *
	 * @return The String representation of the JsonAble object.
	 */
	JsonObject getJsonObject();

	/**
	 * Génère la String JSON du javabean.
	 *
	 * @return La représentation JSON du javabean.
	 */
	default String getJsonString() {
		String output = null;
		final JsonObject jsonObject = getJsonObject();
		if (null != jsonObject) {
			final StringWriter stringWriter = new StringWriter();
			final JsonWriter writer = Json.createWriter(stringWriter);
			writer.writeObject(jsonObject);
			writer.close();
			output = stringWriter.getBuffer().toString();
		}
		return output;
	}

	/**
	 * Builds the current object with the jsonObject.
	 *
	 * @param jsonObject
	 *            Le JSON entrant.
	 */
	void buildJavaBean(JsonObject jsonObject);

	/**
	 * Builds the current object with the json string.
	 *
	 * @param jsonString
	 *            Le JSON entrant.
	 */
	default void buildJavaBean(final String jsonString) {
		final JsonReader reader = Json.createReader(new StringReader(jsonString));
		buildJavaBean(reader.readObject());
		reader.close();
	}

}
