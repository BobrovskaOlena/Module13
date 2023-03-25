package model;

public class User {
private int id;
private String name;
private String username;
private String email;
private Address address;
private String phone;
private String website;
private Company company;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    @Override
    public String toString() {
        return "User { \"id\": \""+id+"\", " +
                "\"name\": "+name+"\", " +
                "\"username\": "+username+"\", " +
                "\"email\": "+email+"\", "+
                "\"address\": "+address+"\", " +
                "\"phone\": "+phone+"\", " +
                "\"website\": "+website+"\", " +
                "\"company\": "+company+ " }";
    }
}
