package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {

    private final Logger logger = LogManager.getLogger(SimpleHTTPServer.class);

    public void start() throws Exception{
        final ServerSocket server = new ServerSocket(8080);
        logger.info("Listening for connection on port 8080 ....");

        while(true){
            // 1. Read HTTP request from the client socket
            // 2. Prepare an HTTP response
            // 3. Send HTTP response to the client
            // 4. Close the socket
//            InputStreamReader isr = new InputStreamReader(client.getInputStream());
//            BufferedReader reader = new BufferedReader(isr);
//            String line = reader.readLine();
//            while(!line.isEmpty()){
//                System.out.println(line);
//                line = reader.readLine();
//            }
            try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream()
                        .write(httpResponse.getBytes("UTF-8"));
            }
        }

    }
}
