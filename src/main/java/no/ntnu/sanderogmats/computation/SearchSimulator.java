package no.ntnu.sanderogmats;

import java.io.PrintWriter;
import java.net.Socket;

public class SearchSimulator {
    public static void processClientRequest(Socket socket, String title) throws Exception {

        long time1 = System.currentTimeMillis();
        Thread.sleep(10 * (long) 1000);

        long time2 = System.currentTimeMillis();

        String body = ResponseGenerator.generatorResponseHTML(title, time1, time2);
        String header = ResponseGenerator.generatorResponseHeader(body.length());

        new PrintWriter(socket.getOutputStream(), true).println(header + body);
    }
}
