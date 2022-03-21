package com.accolitedigital.iTracker.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String employeeName;
    private String employeePassword;
    private String roles;
    private String primarySkill;
    private String secondarySkill;
    private String tertiarySkill;
    private int primaryRound;
    private int secondaryRound;
    private int tertiaryRound;

    public int getId() {
        return id;
    }

    public void setEmployeeId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String role) {
        this.roles = role;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primary) {
        this.primarySkill = primary;
    }

    public String getSecondarySkill() {
        return secondarySkill;
    }

    public void setSecondarySkill(String secondary) {
        this.secondarySkill = secondary;
    }

    public String getTertiarySkill() {
        return tertiarySkill;
    }

    public void setTertiarySkill(String tertiary) {
        this.tertiarySkill = tertiary;
    }

    public int getPrimaryRound() {
        return primaryRound;
    }

    public void setPrimaryRound(int primaryRound) {
        this.primaryRound = primaryRound;
    }

    public int getSecondaryRound() {
        return secondaryRound;
    }

    public void setSecondaryRound(int secondaryRound) {
        this.secondaryRound = secondaryRound;
    }

    public int getTertiaryRound() {
        return tertiaryRound;
    }

    public void setTertiaryRound(int tertiaryRound) {
        this.tertiaryRound = tertiaryRound;
    }

}
