
package org.anudip.app;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import org.anudip.controller.StudentWebHandler;
import org.anudip.service.StudentService;
import org.anudip.service.TrainerService;
import org.anudip.controller.TrainerWebHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public class WebServer {

    public static void main(String[] args) throws Exception {

        // Create the existing student service
        StudentService studentService = new StudentService(100);
        TrainerService trainerService = new TrainerService(50);

        // Start the server on your computer
        HttpServer server = HttpServer.create(
                new InetSocketAddress("127.0.0.1", 8080), 0);
        
        


        // Existing student API
        server.createContext(
                "/api/students",
                new StudentWebHandler(studentService));

        // Add this trainer API
        server.createContext(
        		"/api/trainers",
        		new TrainerWebHandler(trainerService)
        		);
        // Load the HTML page
        server.createContext("/", exchange -> {
            String requestPath = exchange.getRequestURI().getPath();

            if (requestPath.equals("/")) {
                sendFile(exchange, "web/index.html", "text/html");
            } else if (requestPath.equals("/style.css")) {
                sendFile(exchange, "web/style.css", "text/css");
            } else {
                sendText(exchange, 404, "Page not found: " + requestPath);
            }
        });
        

        server.start();

        System.out.println("Server started successfully!");
        System.out.println("Open: http://localhost:8080/");
    }

    private static void sendFile(
            HttpExchange exchange,
            String filePath,
            String contentType) throws IOException {

        Path path = Path.of(filePath);

        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            sendText(exchange, 404,
                    "File not found: " + path.toAbsolutePath());
            System.out.println("Missing file: " + path.toAbsolutePath());
            return;
        }

        byte[] content = Files.readAllBytes(path);

        exchange.getResponseHeaders().set(
                "Content-Type", contentType + "; charset=UTF-8");

        exchange.sendResponseHeaders(200, content.length);

        try (var output = exchange.getResponseBody()) {
            output.write(content);
        }
    }

    private static void sendText(
            HttpExchange exchange,
            int statusCode,
            String message) throws IOException {

        byte[] content = message.getBytes(java.nio.charset.StandardCharsets.UTF_8);

        exchange.getResponseHeaders().set(
                "Content-Type", "text/plain; charset=UTF-8");

        exchange.sendResponseHeaders(statusCode, content.length);

        try (var output = exchange.getResponseBody()) {
            output.write(content);
        }
    }
}
