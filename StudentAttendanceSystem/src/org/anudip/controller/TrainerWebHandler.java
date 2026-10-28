
package org.anudip.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import org.anudip.model.Trainer;
import org.anudip.service.TrainerService;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TrainerWebHandler implements HttpHandler {

    private final TrainerService trainerService;

    public TrainerWebHandler(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            String method = exchange.getRequestMethod();

            if ("GET".equals(method)) {
                handleGet(exchange);
            } else if ("POST".equals(method)) {
                handlePost(exchange);
            } else {
                send(exchange, 405,
                    "{\"message\":\"Method not allowed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();

            send(exchange, 500,
                "{\"message\":\"Internal server error\"}");
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {

        String query = exchange.getRequestURI().getRawQuery();

        if (query != null && query.startsWith("id=")) {

            String value = URLDecoder.decode(
                query.substring(3), StandardCharsets.UTF_8);

            try {
                int id = Integer.parseInt(value);
                Trainer trainer = trainerService.searchTrainerById(id);

                if (trainer == null) {
                    send(exchange, 404,
                        "{\"message\":\"Trainer not found\"}");
                } else {
                    send(exchange, 200, trainerToJson(trainer));
                }

            } catch (NumberFormatException e) {
                send(exchange, 400,
                    "{\"message\":\"Invalid trainer ID\"}");
            }

            return;
        }

        StringBuilder json = new StringBuilder("[");
        int count = trainerService.getTrainerCount();

        for (int i = 0; i < count; i++) {
            if (i > 0) {
                json.append(",");
            }

            json.append(trainerToJson(
                trainerService.getTrainerAt(i)));
        }

        json.append("]");
        send(exchange, 200, json.toString());
    }

    private void handlePost(HttpExchange exchange) throws IOException {

        String body = new String(
            exchange.getRequestBody().readAllBytes(),
            StandardCharsets.UTF_8);

        Map<String, String> fields = new HashMap<>();

        for (String part : body.split("&")) {
            String[] pair = part.split("=", 2);

            if (pair.length == 2) {
                fields.put(
                    URLDecoder.decode(pair[0], StandardCharsets.UTF_8),
                    URLDecoder.decode(pair[1], StandardCharsets.UTF_8));
            }
        }

        try {
            int id = Integer.parseInt(
                fields.getOrDefault("id", ""));

            String name = fields.getOrDefault("name", "").trim();
            String phone = fields.getOrDefault("phone", "").trim();

            Trainer trainer = new Trainer(id, name, phone);

            if (trainerService.registerTrainer(trainer)) {
                send(exchange, 201,
                    "{\"message\":\"Trainer registered successfully\"}");
            } else {
                send(exchange, 400,
                    "{\"message\":\"Registration failed. Check required fields, capacity, and duplicate ID.\"}");
            }

        } catch (NumberFormatException e) {
            send(exchange, 400,
                "{\"message\":\"Trainer ID must be a valid number\"}");
        }
    }

    private String trainerToJson(Trainer trainer) {
        return "{"
            + "\"id\":" + trainer.getUserId() + ","
            + "\"name\":" + quote(trainer.getName()) + ","
            + "\"phone\":" + quote(trainer.getPhoneNumber())
            + "}";
    }

    private String quote(String value) {

        if (value == null) {
            return "null";
        }

        StringBuilder result = new StringBuilder("\"");

        for (char c : value.toCharArray()) {
            switch (c) {
                case '"': result.append("\\\""); break;
                case '\\': result.append("\\\\"); break;
                case '\n': result.append("\\n"); break;
                case '\r': result.append("\\r"); break;
                case '\t': result.append("\\t"); break;
                default:
                    if (c < 32) {
                        result.append(
                            String.format("\\u%04x", (int) c));
                    } else {
                        result.append(c);
                    }
            }
        }

        return result.append("\"").toString();
    }

    private void send(
        HttpExchange exchange, int status, String response
    ) throws IOException {

        byte[] data = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().set(
            "Content-Type", "application/json; charset=UTF-8");

        exchange.sendResponseHeaders(status, data.length);

        try (var output = exchange.getResponseBody()) {
            output.write(data);
        }
    }
}
