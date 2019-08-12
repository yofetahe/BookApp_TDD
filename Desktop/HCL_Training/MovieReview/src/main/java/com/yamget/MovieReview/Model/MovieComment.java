package com.yamget.MovieReview.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="moviecomment")
public class MovieComment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int comment_id;
	@Column
	@NotEmpty(message="* Please provide your comment content.")
	private String content;
	@Column
	private String given_by;
	@Column
	private int like_count;
	@Column
	private int dislike_count;
	@Column
	private int movie_id;
	
	public MovieComment() {}

	public MovieComment(int comment_id, String content, String given_by, int like_count, int dislike_count,
			int movie_id) {
		super();
		this.comment_id = comment_id;
		this.content = content;
		this.given_by = given_by;
		this.like_count = like_count;
		this.dislike_count = dislike_count;
		this.movie_id = movie_id;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGiven_by() {
		return given_by;
	}

	public void setGiven_by(String given_by) {
		this.given_by = given_by;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public int getDislike_count() {
		return dislike_count;
	}

	public void setDislike_count(int dislike_count) {
		this.dislike_count = dislike_count;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	
}
