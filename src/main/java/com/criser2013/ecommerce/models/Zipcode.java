package com.criser2013.ecommerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "zipcode")
public class Zipcode {
    @Id
    @Column(length = 10)
    public String zipcode;

    @Column(length = 100)
    public String city;

    @Column(length = 50)
    public String country;

    @Column(length = 50)
    public String district;

    @Column(length = 100)
    public String state;

    public Zipcode() {}

    public Zipcode(String zipcode, String city, String country, String district, String state) {
        this.zipcode = zipcode;
        this.city = city;
        this.district = district;
        this.country = country;
        this.state = state;
    }
}
