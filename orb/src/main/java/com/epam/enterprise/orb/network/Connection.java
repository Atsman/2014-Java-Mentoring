package com.epam.enterprise.orb.network;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class Connection<T> {

    private Gson gson = new Gson();

    public T execute(ClientMessage clientMessage) throws Exception {
        return sendPost(clientMessage);
    }

    private T sendPost(ClientMessage clientMessage) throws Exception {
        String url = "http://localhost:4567/execute";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(gson.toJson(clientMessage));
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        ServerMessage serverMessage = gson.fromJson(response.toString(), ServerMessage.class);

        if(serverMessage.getException() != null) {
            throw  serverMessage.getException();
        }
        return (T) serverMessage.getReturnType();
    }

}
