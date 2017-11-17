package fr.lma.qcmmaster.tec.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonWriter {

	/**
	 * Génère l'objet GSON.
	 * 
	 * @return L'objet GSON généré.
	 */
	private Gson getGson() {
		return new GsonBuilder().setDateFormat(DateBuilder.FR_FORMAT.toPattern()).create();
	}

	/**
	 * Génère la String JSON du javabean.
	 *
	 * @param obj
	 *            L'objet à convertir en JSON.
	 * @return La chaîne JSON générée.
	 */
	public String getJsonString(final Object obj) {
		return getGson().toJson(obj);
	}

	/**
	 * Génère un objet de type T à partir de la chaîne JSON.
	 *
	 * @param jsonString
	 *            La chaîne JSON à parser.
	 * @param classType
	 * @return
	 */
	public <T> T fromJsonString(final String jsonString, final Class<T> classType) {
		return getGson().fromJson(jsonString, classType);
	}

}
