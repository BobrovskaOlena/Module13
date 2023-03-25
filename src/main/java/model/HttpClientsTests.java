package model;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class HttpClientsTests {
    private static final String myUrl = "https://jsonplaceholder.typicode.com/users";

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
    public static void main(String[] args) throws IOException, InterruptedException {
           System.out.println("Task 1.1: " + HttpClients.postNewUser(URI.create(myUrl), createNewUser()));

           System.out.println("Task 1.2: Please write the ID for update name");
           int id = Integer.parseInt(new Scanner(System.in).nextLine());
             System.out.println("User before update: ");
                /*User userWithYourId = HttpClients.sendGET_User(URI.create(String.format("%s/%d", USERS_URL, userId)));
        System.out.println(userWithYourId);
        userWithYourId.setName("Alex");
        User userAfterRename = HttpClients.updateUser(URI.create(String.format("%s/%d", USERS_URL, userId)), userWithYourId);
        System.out.println("User after update: " + userAfterRename);*/


        }}