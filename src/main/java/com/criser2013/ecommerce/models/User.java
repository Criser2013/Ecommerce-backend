package com.criser2013.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "unique_users_dni_email", columnNames = { "email", "dni" })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public Role roleId;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    public SecurityQuestion questionId;

    @Column(name = "first_name", length = 100)
    public String firstName;

    @Column(name = "last_name", length = 100)
    public String lastName;

    @Column(unique = true, length = 100)
    public String email;

    @Column(name = "registration_date")
    public LocalDateTime registrationDate;

    public String phone;

    @Column(length = 15)
    public String dni;

    public String password;

    @Column(name = "security_answer", length = 200)
    public String securityAnswer;

    @Column(name = "status")
    public Long status;

    public User() {}

    public User(Role roleId, SecurityQuestion questionId, String firstName, String lastName, String email, String phone, String dni, String password, String securityAnswer) {
        this.questionId = questionId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dni = dni;
        this.password = password;
        this.securityAnswer = securityAnswer;
        this.roleId = roleId;
        this.registrationDate = LocalDateTime.now();
        this.status = Long.valueOf(1);
    }
}
