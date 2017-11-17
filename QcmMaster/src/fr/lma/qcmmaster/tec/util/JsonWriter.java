package fr.lma.qcmmaster.tec.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonWriter {

	/**
	 * G�n�re l'objet GSON.
	 * 
	 * @return L'objet GSON g�n�r�.
	 */
	private Gson getGson() {
		return new GsonBuilder().setDateFormat(DateBuilder.FR_FORMAT.toPattern()).create();
	}

	/**
	 * G�n�re la String JSON du javabean.
	 *
	 * @param obj
	 *            L'objet � convertir en JSON.
	 * @return La cha�ne JSON g�n�r�e.
	 */
	public String getJsonString(final Object obj) {
		return getGson().toJson(obj);
	}

	/**
	 * G�n�re un objet de type T � partir de la cha�ne JSON.
	 *
	 * @param jsonString
	 *            La cha�ne JSON � parser.
	 * @param classType
	 * @return
	 */
	public <T> T fromJsonString(final String jsonString, final Class<T> classType) {
		return getGson().fromJson(jsonString, classType);
	}

}
