package ch.erard22.mysecondhand.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "customers", type = "customers")
public class Customer {

    @Id
    private String id;

    @Field(type = FieldType.Text, fielddata = true)
    private String name;
    private String firstname;
    private String street;
    private int zip;
    private String city;

    public Customer() {
    }

    public Customer(String id, String name, String firstname, String street, int zip, String city) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.street = street;
        this.zip = zip;
        this.city = city;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
