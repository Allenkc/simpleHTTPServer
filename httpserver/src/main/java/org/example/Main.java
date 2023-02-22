package org.example;

public class Main {
    public static void main(String[] args) {

        SimpleHTTPServer server = new SimpleHTTPServer();
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}