package com.accolitedigital.iTracker.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = true, length = 1000)
    private String pictureUrl;
    @Email(message = "Email is invalid!")
    @NotBlank
    private String email;
    @NotBlank(message = "Name cannot be blank!")
    private String name;
    @NotBlank(message = "Password cannot be blank!")
    private String password;
    @NotBlank(message = "Role must be assigned")
    private String role;
    @ElementCollection
    private List<String> skills;

    public Employee() {
    }

    public Employee(String pictureUrl, String email, String name, String password, String role, List<String> skills) {
        this.pictureUrl = pictureUrl;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String roles) {
        this.role = roles;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", skills=" + skills +
                '}';
    }
}
