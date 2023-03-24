import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class JsonPlaceHolderApiClient {
        public static void main(String[] args) throws IOException {
            String myUrl = "https://jsonplaceholder.typicode.com";
            String response = Jsoup.connect(myUrl + "/users")
                    .requestBody(new Gson().toJson(Map.of(
                            "id","10",
                            "name", "test-user"
                    )))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .headers(Map.of(
                            "Content-Type", "application/json; charset=UTF-8'"
                    ))
                    .execute()
                    .body();
            System.out.println("response = " + response);
        }}



      /* final static String
        public static String createUser(String json) throws IOException {
            URL url = new URL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");

            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response = in.readLine();
                in.close();
                return response;
            } else {
                return null;
            }
        }

        public static String updateUser(String json, int id) throws IOException {
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json");

            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response = in.readLine();
                in.close();
                return response;
            } else {
                return null;
            }
        }

        public static boolean deleteUser(int id) throws IOException {
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");

            int responseCode = con.getResponseCode();
            return responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_MULT_CHOICE;
        }

        public static String getAllUsers() throws IOException {
            URL url = new URL(BASE_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return null;
            }
        }

        public static String getUserById(int id) throws IOException {
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return null;
            }
        }}
*/
