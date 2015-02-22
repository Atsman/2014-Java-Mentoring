package com.epam.enterprise.orb.server;

import com.epam.enterprise.orb.network.ClientMessage;
import com.epam.enterprise.orb.network.ServerMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class CallDispatcher {

    private Skeleton skeleton = new Skeleton();

    private static Map<String, Object> calleeMap = new HashMap<String, Object>();

    static {
        calleeMap.put("com.epam.enterprise.orb.Calculator", new Callee());
    }

    public ServerMessage dispatch(ClientMessage clientMessage) {
        try {
            String className = clientMessage.getClassName();
            Object callee = calleeMap.get(className);
            return skeleton.execute(callee, clientMessage);
        } catch (Exception e) {
            return new ServerMessage(null, e);
        }

    }

}
