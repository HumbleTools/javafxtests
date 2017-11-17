package fr.lma.qcmmaster.model;

import java.util.Arrays;
import java.util.TreeSet;

import org.junit.Test;

import fr.lma.qcmmaster.tec.util.DateBuilder;
import fr.lma.qcmmaster.tec.util.JsonWriter;
import junit.framework.Assert;

/**
 * Teste la classe {@link Question} du modèle.
 */
public class QuestionTest {

	@Test
	public void testGetJsonString() {
		final Question questionIn = new Question();
		questionIn.setId(123);
		questionIn.setTitle("Question de test !");
		questionIn.setBody("System.out.println(\"HelloWorld\");");
		questionIn.setQuestion("Choose the right answers !");
		questionIn.setTagSet(new TreeSet<>(Arrays.asList("easy", "obj-1.1")));
		questionIn.setAnswerSet(new TreeSet<>(Arrays.asList(
				new Answer(1, false, "Mauvaise réponse !"),
				new Answer(2, true, "Bonne réponse !"),
				new Answer(3, true, "La réponse D."))));
		questionIn.setCreationDate(DateBuilder.getDate(2017, 2, 5, 14, 32, 59));
		questionIn.setModificationDate(DateBuilder.getDate(2017, 2, 6, 16, 2, 31));

		final String jsonString = new JsonWriter().getJsonString(questionIn);
		System.out.println(jsonString);
		final Question questionOut = new JsonWriter().fromJsonString(jsonString, Question.class);

		Assert.assertEquals(questionIn.getId(), questionOut.getId());
		Assert.assertEquals(questionIn.getBody(), questionOut.getBody());
		Assert.assertEquals(questionIn.getTitle(), questionOut.getTitle());
		Assert.assertEquals(questionIn.getQuestion(), questionOut.getQuestion());
		Assert.assertEquals(questionIn.getTagSet(), questionOut.getTagSet());
		Assert.assertEquals(questionIn.getAnswerSet(), questionOut.getAnswerSet());
		Assert.assertEquals(questionIn.getCreationDate(), questionOut.getCreationDate());
		Assert.assertEquals(questionIn.getModificationDate(), questionOut.getModificationDate());
		Assert.assertEquals(questionIn, questionOut);
	}

}
