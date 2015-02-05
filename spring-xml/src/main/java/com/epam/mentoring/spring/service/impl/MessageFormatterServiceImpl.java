package com.epam.mentoring.spring.service.impl;

import com.epam.mentoring.spring.service.MessageFormatterService;

/**
 * Created by alehatsman on 12/17/14.
 */
public class MessageFormatterServiceImpl implements MessageFormatterService {

    private String start;
    private String end;

    public MessageFormatterServiceImpl(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String format(String message) {
        return start + message + end;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}
