package chap3.ex9.person;

public class Person {

    private String firstname;
    private String lastname;
    private String country;
    private int age;

    public Person() {
    }

    public Person(String firstname, String lastname, String country, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
