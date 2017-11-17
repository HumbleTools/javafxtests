package fr.lma.qcmmaster.model;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Javabean représentant une question d'examen.
 */
public class Question {

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
	 * Set des réponses possibles.
	 */
	private TreeSet<Answer> answerSet;

	/**
	 * Set des tags pour chaque question.
	 */
	private TreeSet<String> tagSet;

	/**
	 * Date de création.
	 */
	private Date creationDate;

	/**
	 * Date de modification.
	 */
	private Date modificationDate;

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1233, 1239)
				.append(id)
				.append(title)
				.append(body)
				.append(question)
				.append(creationDate)
				.append(modificationDate)
				.append(answerSet)
				.append(tagSet)
				.toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		} else if ((null == obj) || !(obj instanceof Question)) {
			return false;
		} else {
			final Question quest = (Question) obj;
			return new EqualsBuilder()
					.append(id, quest.id)
					.append(title, quest.title)
					.append(body, quest.body)
					.append(question, quest.question)
					.append(creationDate, quest.creationDate)
					.append(modificationDate, quest.modificationDate)
					.append(answerSet, quest.answerSet)
					.append(tagSet, quest.tagSet)
					.isEquals();
		}
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

	public Set<Answer> getAnswerSet() {
		return answerSet;
	}

	public void setAnswerSet(final TreeSet<Answer> answerSet) {
		this.answerSet = answerSet;
	}

	public Set<String> getTagSet() {
		return tagSet;
	}

	public void setTagSet(final TreeSet<String> tagSet) {
		this.tagSet = tagSet;
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
