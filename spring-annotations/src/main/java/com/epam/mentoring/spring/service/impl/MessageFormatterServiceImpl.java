package com.epam.mentoring.spring.service.impl;

import com.epam.mentoring.spring.service.MessageFormatterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by alehatsman on 12/17/14.
 */
@Service("main")
public class MessageFormatterServiceImpl implements MessageFormatterService {

    private String start;
    private String end;

    @Override
    public String format(String message) {
        return start + message + end;
    }

    @Value("${formatter.start}")
    public void setStart(String start) {
        this.start = start;
    }

    @Value("${formatter.end}")
    public void setEnd(String end) {
        this.end = end;
    }
}
