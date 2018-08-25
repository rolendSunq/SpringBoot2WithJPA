package com.springboot.jpa.web.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.ObjectUtils;

@Entity
@Table(name = "Question_Answer_Board")
public class QuestionAnswerBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_answer_board_writer"))
	private User writer;
	private String contents;
	private LocalDateTime localDateTime;
	
	public QuestionAnswerBoard() {
		// Empty
	}
	
	public QuestionAnswerBoard(String title, User writer, String contents) {
		super();
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.localDateTime = LocalDateTime.now();
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

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public String getContent() {
		return contents;
	}

	public void setContent(String contents) {
		this.contents = contents;
	}

	public String getFormattedDate() {
		
		if (ObjectUtils.isEmpty(localDateTime)) {
			return "";
		}
		
		return localDateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")); 
	}
	
	@Override
	public String toString() {
		return new StringBuffer("QuestionAnswerBoard [id=").append( id )
				.append(", title=").append( title )
				.append(", writer=").append( writer.getUserid() )
				.append(", contents=").append( contents )
				.append(", localDateTime=").append( getFormattedDate() )
				.append("]").toString();
	}

}
