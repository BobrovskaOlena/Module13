package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpClients {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public static User postNewUser(URI uri, User user) throws IOException, InterruptedException {
        String body = gson.toJson(user);
         HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
         HttpResponse <String> response =client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status cod " +response.statusCode());
        return gson.fromJson(response.body(), User.class);
    }
    public static User updateUser(URI uri, User user) throws IOException, InterruptedException {
        String body = gson.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .headers("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status cod " +response.statusCode());
        return gson.fromJson(response.body(), User.class);
    }
    public static void deleteUser (URI uri) throws IOException, InterruptedException{
    HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .DELETE()
                .build();
    HttpResponse <String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: "+response.statusCode());}
    public static List<User> getAllUsers(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .headers("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: "+response.statusCode());
        return gson.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
    }

    public static User getUserFromID (URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .headers("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: "+response.statusCode());
        return gson.fromJson(response.body(), User.class);
    }

    public static User[] getUsername(URI uri) throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .headers("Content-Type", "application/json")
            .GET()
            .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println("System code: "+response.statusCode());
    return gson.fromJson(response.body(), User[].class);
    }

    }

