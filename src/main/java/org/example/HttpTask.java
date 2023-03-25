package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.CharBuffer;

public class HttpTask {
    public static void main(String[] args) throws IOException {
        String uri =  "https://jsonplaceholder.typicode.com/users";
        URL url = new URL(uri);
        //отримання інформації про всіх користувачів
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStream stream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String response;
        response = reader.lines().reduce(String::concat).get();
        System.out.println(response);
      /* connection.setRequestMethod("POST");
       connection.setDoOutput(true);
       String jsonText = "[  {    \"id\": 11, " +
               "   \"name\": \"Leanne Graham\",  " +
               "  \"username\": \"Bret\",  " +
               "  \"email\": \"Sincere@april.biz\",  " +
               "  \"address\": {   " +
               "   \"street\": \"Kulas Light\",  " +
               "    \"suite\": \"Apt. 556\",    " +
               "  \"city\": \"Gwenborough\",     " +
               " \"zipcode\": \"92998-3874\",    " +
               "" +
               "  \"geo\": {     " +
               "   \"lat\": \"-37.3159\",    " +
               "    \"lng\": \"81.1496\"  " +
               "    }   " +
               " },    " +
               "\"phone\": \"1-770-736-8031 x56442\",  " +
               "  \"website\": \"hildegard.org\",  " +
               "  \"company\": {     " +
               " \"name\": \"Romaguera-Crona\",  " +
               "    \"catchPhrase\": \"Multi-layered client-server neural-net\",   " +
               "   \"bs\": \"harness real-time e-markets\"    }  } ]";
       OutputStream os = connection.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write(jsonText);
        os.close();
        connection.connect();
        InputStream stream1 = connection.getInputStream();
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(stream1));
        String response1 = reader1.lines().reduce(String::concat).get();
        System.out.println("response1 = " + response1);
        }*/


    }}

