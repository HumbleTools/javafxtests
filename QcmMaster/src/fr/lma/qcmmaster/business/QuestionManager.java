package fr.lma.qcmmaster.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import fr.lma.qcmmaster.model.Answer;
import fr.lma.qcmmaster.model.Question;
import fr.lma.qcmmaster.model.fx.FxQuestion;
import fr.lma.qcmmaster.tec.util.DateBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Business class offering static methods to handle question treatment.
 */
public class QuestionManager {

	/**
	 * Crée une liste de {@link Question} à partir d'un fichier JSON.
	 * 
	 * @param filePath
	 *            Le chemin complet vers le fichier.
	 * @return La liste des questions lues dans le fichier.
	 */
	public static List<Question> loadQuestions(final String filePath) {
		// TODO retirer ce code temporaire
		// TODO lire le fichier JSON
		final ArrayList<Question> mockQuestions = new ArrayList<>();
		mockQuestions.add(getMockQuestion(1));
		mockQuestions.add(getMockQuestion(2));
		mockQuestions.add(getMockQuestion(3));
		return mockQuestions;
	}

	/**
	 * Appelle {@link #loadQuestions(String)} mais retourne une
	 * {@link ObservableList} de {@link FxQuestion}.
	 * 
	 * @see {@link #loadQuestions(String)}
	 * @param filePath
	 *            Le chemin complet vers le fichier.
	 * @return La liste des questions lues dans le fichier.
	 */
	public static ObservableList<FxQuestion> loadFxQuestions(final String filePath) {
		final List<Question> questions = loadQuestions(filePath);
		final ObservableList<FxQuestion> fxQuestions = FXCollections.observableArrayList();
		for (final Question question : questions) {
			fxQuestions.add(new FxQuestion(question));
		}
		return fxQuestions;
	}

	private static Question getMockQuestion(final int mockId) {
		final Question mockQuestion = new Question();
		mockQuestion.setId(mockId);
		mockQuestion.setTitle("Question de test !" + mockId);
		mockQuestion.setBody("System.out.println(\"HelloWorld" + mockId + "\");");
		mockQuestion.setQuestion("Choose the right answers !" + mockId);
		mockQuestion.setTagSet(new TreeSet<>(Arrays.asList("easy + mockId", "obj-1.1*" + mockId)));
		mockQuestion.setAnswerSet(new TreeSet<>(Arrays.asList(
				new Answer(1, false, "Mauvaise réponse !" + mockId),
				new Answer(2, true, "Bonne réponse !" + mockId),
				new Answer(3, true, "La réponse D." + mockId))));
		mockQuestion.setCreationDate(DateBuilder.getDate(2017, 2, mockId, 14, 32, 59));
		mockQuestion.setModificationDate(DateBuilder.getDate(2017, 2, mockId, 16, 2, 31));
		return mockQuestion;
	}
}
