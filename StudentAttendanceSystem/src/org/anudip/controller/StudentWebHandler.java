package org.anudip.controller;


//package org.anudip.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import org.anudip.model.Student;
import org.anudip.service.StudentService;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class StudentWebHandler implements HttpHandler {

    private final StudentService studentService;

    public StudentWebHandler(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            exchange.getResponseHeaders().set(
                "Content-Type", "application/json; charset=UTF-8"
            );

            String method = exchange.getRequestMethod();

            if (method.equals("GET")) {
                handleGet(exchange);
            } else if (method.equals("POST")) {
                handlePost(exchange);
            } else {
                send(exchange, 405,
                    "{\"message\":\"Method not allowed\"}");
            }

        } catch (Exception e) {
            send(exchange, 500,
                "{\"message\":\"Internal server error\"}");
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {

        String query = exchange.getRequestURI().getRawQuery();

        if (query != null && query.startsWith("id=")) {
            String value = URLDecoder.decode(
                query.substring(3), StandardCharsets.UTF_8
            );

            try {
                int id = Integer.parseInt(value);
                Student student = studentService.searchStudentById(id);

                if (student == null) {
                    send(exchange, 404,
                        "{\"message\":\"Student not found\"}");
                    return;
                }

                send(exchange, 200, studentToJson(student));
                return;

            } catch (NumberFormatException e) {
                send(exchange, 400,
                    "{\"message\":\"Invalid student ID\"}");
                return;
            }
        }

        StringBuilder json = new StringBuilder("[");
        int count = studentService.getStudentCount();

        for (int i = 0; i < count; i++) {
            Student student = studentService.getStudetnAt(i);

            if (i > 0) {
                json.append(",");
            }

            json.append(studentToJson(student));
        }

        json.append("]");
        send(exchange, 200, json.toString());
    }

    private void handlePost(HttpExchange exchange) throws IOException {

        String body = new String(
            exchange.getRequestBody().readAllBytes(),
            StandardCharsets.UTF_8
        );

        Map<String, String> fields = new HashMap<>();

        for (String part : body.split("&")) {
            String[] pair = part.split("=", 2);

            if (pair.length == 2) {
                fields.put(
                    URLDecoder.decode(pair[0], StandardCharsets.UTF_8),
                    URLDecoder.decode(pair[1], StandardCharsets.UTF_8)
                );
            }
        }

        try {
            int id = Integer.parseInt(fields.getOrDefault("id", ""));

            String name = fields.getOrDefault("name", "").trim();
            String phone = fields.getOrDefault("phone", "").trim();
            String parentPhone =
                fields.getOrDefault("parentPhone", "").trim();
            String batch = fields.getOrDefault("batch", "").trim();

            Student student = new Student(
                id, name, phone, parentPhone, batch
            );

            boolean registered = studentService.registerStudent(student);

            if (registered) {
                send(exchange, 201,
                    "{\"message\":\"Student registered successfully\"}");
            } else {
                send(exchange, 400,
                    "{\"message\":\"Registration failed. Check the details or duplicate ID.\"}");
            }

        } catch (NumberFormatException e) {
            send(exchange, 400,
                "{\"message\":\"Student ID must be a number\"}");
        }
    }

    private String studentToJson(Student student) {

        return "{"
            + "\"id\":" + student.getUserId() + ","
            + "\"name\":" + quote(student.getName()) + ","
            + "\"phone\":" + quote(student.getPhoneNumber()) + ","
            + "\"parentPhone\":" + quote(student.getParentPhoneNumber()) + ","
            + "\"batch\":" + quote(student.getBatchName())
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
                        result.append(String.format("\\u%04x", (int) c));
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
        exchange.sendResponseHeaders(status, data.length);

        try (var output = exchange.getResponseBody()) {
            output.write(data);
        }
    }
}
