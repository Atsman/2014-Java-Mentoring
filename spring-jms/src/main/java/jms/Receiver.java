package jms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Aleh_Atsman on 2/5/2015.
 */
public class Receiver {

    private final String id;

    public Receiver(String id) {
        this.id = id;
    }
    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    public void receiveMessage(String message) {
        System.out.println("Receiver #" + id + " - Received <" + message + ">");
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(id, true)))) {
            out.println(message);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
