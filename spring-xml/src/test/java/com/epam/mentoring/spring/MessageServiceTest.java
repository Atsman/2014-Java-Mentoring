package com.epam.mentoring.spring;

import com.epam.mentoring.spring.service.MessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by alehatsman on 12/17/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config.xml"})
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void test() {
        Assert.assertEquals("Default", messageService.getMessage());
        messageService.setMessage("My message");
        Assert.assertEquals("My message", messageService.getMessage());
    }

}
