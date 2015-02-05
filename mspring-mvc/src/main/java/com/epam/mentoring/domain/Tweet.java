package com.epam.mentoring.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Tweet {
	
	private Long id;
	
	@NotEmpty
	@Size(min=1,max=255)
	private String text;

    @NotEmpty
    @Size(min=1,max=255)
    private String author;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
