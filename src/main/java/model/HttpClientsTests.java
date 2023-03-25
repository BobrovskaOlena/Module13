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
              User userWithYourId = HttpClients.getUserFromID(URI.create(String.format("%s/%d", myUrl, id)));
              System.out.println(userWithYourId);
              System.out.println("Please print new name for user: ");
              String scanner1 = new Scanner(System.in).nextLine();
              userWithYourId.setName(scanner1);
              User userAfterUpdate = HttpClients.updateUser(URI.create(String.format("%s/%d", myUrl, id)), userWithYourId);
              System.out.println("User after update: " + userAfterUpdate);

              System.out.println("Task 1.3 : ");
              System.out.println("Please print user for delete: " );
              Scanner scanner3 = new Scanner(System.in).nextLine();

        }}