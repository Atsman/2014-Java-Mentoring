package com.epam.enterprise.orb;

import com.epam.enterprise.orb.chanel.Channel;
import com.epam.enterprise.orb.chanel.ChannelAdapter;
import com.epam.enterprise.orb.network.ClientMessage;
import com.epam.enterprise.orb.chanel.SomeTextChannel;
import com.epam.enterprise.orb.network.Param;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class Stub implements Calculator {

    private Channel<Double> channel = new ChannelAdapter<Double>();
    @Override
    public Double add(Double a, Double b) {
        try {
            ClientMessage clientMessage = new ClientMessage("com.epam.enterprise.orb.Calculator", "add",
                    new Param[]{new Param(a, "java.lang.Double"), new Param(b, "java.lang.Double")});
            return channel.execute(clientMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
