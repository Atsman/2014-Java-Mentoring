package com.epam.ear.twitter.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alehatsman on 11/23/14.
 */

@Entity
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String text;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "authorId", nullable = false)
    private User author;

    public Tweet(){}

    public Tweet(String text, User author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
