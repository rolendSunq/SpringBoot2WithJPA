package com.springboot.jpa.web.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question_Answer_Board")
public class QuestionAnswerBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String writer;
	private String contents;

	public QuestionAnswerBoard() {
		// Empty
	}
	
	public QuestionAnswerBoard(String title, String writer, String contents) {
		super();
		this.title = title;
		this.writer = writer;
		this.contents = contents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return contents;
	}

	public void setContent(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return new StringBuffer("QuestionAnswerBoard [id=").append( id )
				.append(", title=").append( title )
				.append(", writer=").append( writer )
				.append(", contents=").append( contents )
				.append("]").toString();
	}

}
