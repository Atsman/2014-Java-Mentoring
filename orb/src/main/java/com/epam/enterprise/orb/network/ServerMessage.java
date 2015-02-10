package com.epam.enterprise.orb.network;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class ServerMessage {

    private Object returnType;
    private Exception exception;

    public ServerMessage(Object returnType, Exception exception) {
        this.returnType = returnType;
        this.exception = exception;
    }

    public Object getReturnType() {
        return returnType;
    }

    public Exception getException() {
        return exception;
    }
}


