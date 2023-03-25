package org.example;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonPlaceHolderApi {
private User user;
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://jsonplaceholder.typicode.com/users");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        // Тіло запиту - JSON з даними для нового об'єкту
        String body = "{\"name\": \"Test User\", \"username\": \"testUser\", \"email\": \"testuser@gmail.com\", }";

        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Виводимо відповідь в консоль
        System.out.println(response.toString());
    }
}