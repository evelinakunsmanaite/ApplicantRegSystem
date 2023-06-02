package entity;

import java.util.Arrays;

public class Abiturient {

    private String id, name, lastName, patronimic, telephone, address;
    private int[] noten;
    private double avg;

    public Abiturient(String id, String name, String lastName, String patronimic, String telephone, String address, int... noten) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.patronimic = patronimic;
        this.telephone = telephone;
        this.address = address;
        this.noten = noten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronimic() {
        return patronimic;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int[] getNoten() {
        return noten;
    }

    public void setNoten(int[] noten) {
        this.noten = noten;
    }

    public Abiturient() {
    }

    public double getAvg() {
        avg = Arrays.stream(noten).average().getAsDouble();
        return avg;
    }

}
