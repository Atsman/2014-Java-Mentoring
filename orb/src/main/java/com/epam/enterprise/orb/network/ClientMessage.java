package com.epam.enterprise.orb.network;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class ClientMessage {
    public String className;
    public String methodName;
    public Param[] params;

    public ClientMessage(String className, String methodName, Param[] params) {
        this.className = className;
        this.methodName = methodName;
        this.params = params;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Param[] getParams() {
        return params;
    }
}
