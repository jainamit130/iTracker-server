package com.accolitedigital.iTracker.model;

import org.springframework.stereotype.Component;

@Component
public class Stats {
    private Long monthlyCount;
    private Long yearlyCount;
    private Long quarterlyCount;
    private Long weeklyCount;
    private Long lastYearCount;
    private Long lastMonthCount;
    private Long rangeCount;

    public Long getMonthlyCount() {
        return monthlyCount;
    }

    public void setMonthlyCount(Long monthlyCount) {
        this.monthlyCount = monthlyCount;
    }

    public Long getYearlyCount() {
        return yearlyCount;
    }

    public void setYearlyCount(Long yearlyCount) {
        this.yearlyCount = yearlyCount;
    }

    public Long getQuarterlyCount() {
        return quarterlyCount;
    }

    public void setQuarterlyCount(Long quarterlyCount) {
        this.quarterlyCount = quarterlyCount;
    }

    public Long getWeeklyCount() {
        return weeklyCount;
    }

    public void setWeeklyCount(Long weeklyCount) {
        this.weeklyCount = weeklyCount;
    }

    public Long getLastYearCount() {
        return lastYearCount;
    }

    public void setLastYearCount(Long lastYearCount) {
        this.lastYearCount = lastYearCount;
    }

    public Long getLastMonthCount() {
        return lastMonthCount;
    }

    public void setLastMonthCount(Long lastMonthCount) {
        this.lastMonthCount = lastMonthCount;
    }

    public Long getRangeCount() {
        return rangeCount;
    }

    public void setRangeCount(Long rangeCount) {
        this.rangeCount = rangeCount;
    }
}
