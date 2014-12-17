package com.epam.mentoring.spring.factory.impl;

import com.epam.mentoring.spring.factory.SomeBean;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by alehatsman on 12/17/14.
 */
public class FactoryBeanImpl implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new SomeBeanImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return SomeBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
