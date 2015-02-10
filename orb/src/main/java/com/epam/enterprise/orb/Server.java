package com.epam.enterprise.orb;

import com.epam.enterprise.orb.network.ClientMessage;
import com.epam.enterprise.orb.network.ServerMessage;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class Server {

    public static void main(String[] args) {

        final Gson gson = new Gson();
        final CallDispatcher callDispatcher = new CallDispatcher();

        post(new Route("/execute") {
            @Override
            public Object handle(Request request, Response response) {
                String body = request.body();
                ClientMessage clientMessage = gson.fromJson(body, ClientMessage.class);
                ServerMessage serverMessage = callDispatcher.dispatch(clientMessage);
                return gson.toJson(serverMessage);
            }
        });
    }

}
