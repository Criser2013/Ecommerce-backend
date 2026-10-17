package com.criser2013.ecommerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "zipcode")
public class Zipcode {
    @Id
    public String zipcode;

    @Column(length = 100)
    public String city;

    @Column(length = 50)
    public String country;

    @Column(length = 50)
    public String districString;

    @Column(length = 100)
    public String state;
}
