package Tasks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.*;

public class HttpClientsTests {
    private static final String myUrl = "https://jsonplaceholder.typicode.com/users";
    private static final String urlPosts = "https://jsonplaceholder.typicode.com/posts";
    private static final String newPath = "src/main/resources";
    public static void main(String[] args) throws IOException, InterruptedException, IllegalStateException {
        System.out.println("Task 1.1: " + HttpClients.postNewUser(URI.create(myUrl), createNewUser()));

        System.out.println("Task 1.2: Please write the ID for update name");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("User before update: ");
        User userWithYourId = HttpClients.getUserFromID(URI.create(String.format("%s/%d", myUrl, id)));
        System.out.println(userWithYourId);
        System.out.println("Please print new name for user: ");
        String scanner1 = new Scanner(System.in).nextLine();
        userWithYourId.setName(scanner1);
        User userAfterUpdate = HttpClients.updateUser(URI.create(String.format("%s/%d", myUrl, id)), userWithYourId);
        System.out.println("User after update: " + userAfterUpdate);

        System.out.println("Task 1.3 : ");
        System.out.println("Please print ID of user for delete: ");
        int scanner3 = Integer.parseInt(new Scanner(System.in).nextLine());
        HttpClients.deleteUser(URI.create(String.format("%s/%d", myUrl, scanner3)));

        System.out.println("Task 1.4 :");
        List<User> users = HttpClients.getAllUsers(URI.create(myUrl));
        users.forEach(System.out::println);

        System.out.println("Task 1.5 :");
        System.out.println("Please print ID for receiving user information: ");
        int scanner4 = Integer.parseInt(new Scanner(System.in).nextLine());
        User userOfId = HttpClients.getUserFromID(URI.create(String.format("%s/%d", myUrl, scanner4)));
        System.out.println(userOfId);

        System.out.println("Task 1.6 :");
        System.out.println("Please print username for searching: ");
        String scanner5 = new Scanner(System.in).nextLine();
        User[] userWithUsername = HttpClients.getUsername(URI.create(String.format("%s?username=%s", myUrl, scanner5)));
        if (userWithUsername.length == 0) {
            System.out.println("This username doesn't exist.");
        } else {
            StringJoiner us = new StringJoiner(", ");
            for (User value : userWithUsername) {
                us.add(value.toString());
            }
            System.out.println(us);
        }

        System.out.println("Task 2: ");
        System.out.println("Please print ID of user for searching user's comments: ");
        int idComments = new Scanner(System.in).nextInt();
        List<Posts> postsList = HttpClients.getPosts(URI.create(String.format("%s/%d/%s", myUrl, idComments, "posts")));

        Integer max = postsList
                .stream()
                .max(Comparator.comparing(Posts::getId))
                .orElseThrow(NoSuchElementException::new)
                .getId();
        System.out.println(max);

        // ЗВІДСИ В ЗАДАЧІ 2 ВИНИКАЄ ПОМИЛКА. НЕ РОЗУМІЮ, ЩО НЕ ТАК

        Comment[] com = HttpClients.getCommentInMaxId(URI.create(String.format("%s/%d/%s", urlPosts, max, "comments")));
        if (com.length == 0) {
            System.out.println("ID not exist.");
        } else {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String myJson = gson.toJson(com);
            File file = new File(newPath, String.format("user-%d-post-%d-comments.json", idComments, max));
            if (!file.exists()) {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                    bufferedWriter.write(myJson);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }}



            System.out.println("Task 3: ");
            System.out.println("Please print ID");
            Integer scanner6 = new Scanner(System.in).nextInt();
            List<Todos> todos = HttpClients.sendTodos(URI.create(String.format("%s/%d/%s", myUrl, scanner6, "todos")));
            if (todos.size() == 0) {
                System.out.println("This id doesn't exist.");
            } else {
                for (Todos todo : todos) {
                    if (!todo.isCompleted()) {
                        System.out.println(todo);
                    }
                }
            }
        }



    public static User createNewUser() {
        User user = new User();
        Address address = new Address();
        user.setAddress(address);
        Geo geo = new Geo();
        address.setGeo(geo);
        Company company = new Company();
        user.setCompany(company);

        user.setId(11);
        user.setName("Olena");
        user.setUsername("Bobrovska");
        user.setEmail("lena@gmail.com");
        address.setStreet("Pasichna");
        address.setSuite("Apt. 69");
        address.setCity("Lviv");
        address.setZipcode("72403");
        geo.setLat("404250");
        geo.setLng("547824");
        user.setPhone("3-290-897-5860");
        user.setWebsite("bobrovska.com");
        company.setNameOfCompany("MyCompany");
        company.setCatchPhrase("Will be delicious");
        company.setBs("API");


        return user;
    }
}
