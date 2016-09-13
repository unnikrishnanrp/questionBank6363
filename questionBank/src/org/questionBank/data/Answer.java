package org.questionBank.data;
// Generated Sep 13, 2016 2:54:40 AM by Hibernate Tools 5.1.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Answer generated by hbm2java
 */
@Entity
@Table(name = "ANSWER", schema = "SYSTEM")
public class Answer implements java.io.Serializable {

	private String answerId;
	private Question question;
	private String answerText;

	public Answer() {
	}

	public Answer(String answerId) {
		this.answerId = answerId;
	}

	public Answer(String answerId, Question question, String answerText) {
		this.answerId = answerId;
		this.question = question;
		this.answerText = answerText;
	}

	@Id

	@Column(name = "ANSWER_ID", unique = true, nullable = false, length = 7)
	public String getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID")
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "ANSWER_TEXT", length = 200)
	public String getAnswerText() {
		return this.answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

}
