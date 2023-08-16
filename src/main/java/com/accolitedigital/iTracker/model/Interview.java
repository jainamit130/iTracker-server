package com.accolitedigital.iTracker.model;

import javax.persistence.*;

@Entity
@Table(name = "interviews")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String skill;
    private String round;
    private Long startDate;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean recurringType;
    private Long endDate;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Interview(){
    }

    public Interview(Interview interview) {
        this.setEmail(interview.getEmail());
        this.setSkill(interview.getSkill());
        this.setRound(interview.getRound());
        this.setStartDate(interview.getStartDate());
        this.setEndDate(interview.getEndDate());
        this.setRecurringType(interview.getRecurringType());
        this.setEmployee(interview.getEmployee());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Boolean getRecurringType() {
        return recurringType;
    }

    public void setRecurringType(Boolean recurringType) {
        this.recurringType = recurringType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", skill='" + skill + '\'' +
                ", round='" + round + '\'' +
                ", startDate=" + startDate +
                ", recurringType=" + recurringType +
                ", endDate=" + endDate +
                ", employee=" + employee +
                '}';
    }
}
