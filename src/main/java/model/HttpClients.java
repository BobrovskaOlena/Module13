package model;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
        return gson.fromJson(response.body(), User.class);
    }
}
