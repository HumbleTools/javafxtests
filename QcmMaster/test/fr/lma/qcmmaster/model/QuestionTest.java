package fr.lma.qcmmaster.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import org.junit.Test;

/**
 * Teste la classe {@link Question} du modèle.
 */
public class QuestionTest {

	@Test
	public void testGetJsonString() {
		final Question question = new Question();
		question.setId(123);
		question.setTitle("Question de test !");
		question.setBody("System.out.println(\"HelloWorld\");");
		question.setQuestion("Choose the right answers !");
		question.setTagList(Arrays.asList("easy", "obj-1.1"));
		final Answer a1 = new Answer();
		a1.setBody("Mauvaise réponse !");
		a1.setRight(false);
		a1.setPosition(1);
		final Answer a2 = new Answer();
		a2.setBody("Bonne réponse !");
		a2.setRight(true);
		a2.setPosition(2);
		final Answer a3 = new Answer();
		a3.setBody("La réponde D.");
		a3.setRight(true);
		a3.setPosition(3);
		question.setAnswerList(Arrays.asList(a1, a2, a3));
		final Calendar cal = Calendar.getInstance(Locale.FRANCE);
		cal.set(2017, 2, 5, 14, 32, 59);
		question.setCreationDate(cal.getTime());
		cal.set(2017, 2, 6, 16, 2, 31);
		question.setModificationDate(cal.getTime());

		System.out.println(question.getJsonString());
		// TODO terminer les junits
		// TODO make answers comparable (order)

	}

}
