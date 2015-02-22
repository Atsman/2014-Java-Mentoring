package com.epam.enterprise.orb.chanel;

import com.epam.enterprise.orb.network.ClientMessage;

/**
 * Created by alehatsman on 2/22/15.
 */
public interface Channel<T> {

    T execute(ClientMessage clientMessage) throws Exception;

}
