package com.criser2013.ecommerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "zipcode")
    public Zipcode zipcode;

    @Column (length = 100)
    public String address;

    @Column(name = "is_default")
    public Boolean isDefault;

    public Address() {}

    public Address(User user, Zipcode zipcode, String address) {
        this.user = user;
        this.zipcode = zipcode;
        this.address = address;
        this.isDefault = false;
    }

    public Address(User user, Zipcode zipcode, String address, Boolean isDefault) {
        this.user = user;
        this.zipcode = zipcode;
        this.address = address;
        this.isDefault = isDefault;
    }
}
