package com.epam.enterprise.orb.chanel;

import com.epam.enterprise.orb.network.ClientMessage;
import com.epam.enterprise.orb.network.ServerMessage;
import com.google.gson.Gson;

/**
 * Created by alehatsman on 2/22/15.
 */
public class ChannelAdapter<T> implements Channel<T> {

    private Gson gson = new Gson();
    private SomeTextChannel channel = new SomeTextChannel();

    public T execute(ClientMessage clientMessage) throws Exception {
        return sendPost(clientMessage);
    }

    private T sendPost(ClientMessage clientMessage) throws Exception {
        String responce = channel.sendPost(gson.toJson(clientMessage));
        ServerMessage serverMessage = gson.fromJson(responce, ServerMessage.class);

        if(serverMessage.getException() != null) {
            throw  serverMessage.getException();
        }
        return (T) serverMessage.getReturnType();
    }
}
