package com.epam.enterprise.orb;

import com.epam.enterprise.orb.network.ClientMessage;
import com.epam.enterprise.orb.network.Param;
import com.epam.enterprise.orb.network.ServerMessage;

import java.lang.reflect.Method;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class Skeleton {

    public ServerMessage execute(Object callee, ClientMessage clientMessage) {
        try {
            Param[] params = clientMessage.getParams();
            Class[] types = paramsToTypes(params);
            Object[] values = paramsToValue(params);

            Method method = callee.getClass().getMethod(clientMessage.getMethodName(), types);

            Object result = method.invoke(callee, values);
            return new ServerMessage(result, null);
        } catch (Exception e) {
            return new ServerMessage(null, e);
        }
    }

    private Class[] paramsToTypes(Param[] params) throws ClassNotFoundException {
        Class[] types = new Class[params.length];
        for(int i = 0; i < params.length; i++) {
            Param p = params[i];
            String classname = p.getClassName();
            Class type = Class.forName(classname);
            types[i] = type;
        }
        return types;
    }

    private Object[] paramsToValue(Param[] params) throws ClassNotFoundException {
        Object[] values = new Object[params.length];
        for(int i = 0; i < params.length; i++) {
            Param p = params[i];
            String className = p.getClassName();
            Class type = Class.forName(className);
            values[i] = type.cast(p.getValue());
        }
        return values;
    }



}
