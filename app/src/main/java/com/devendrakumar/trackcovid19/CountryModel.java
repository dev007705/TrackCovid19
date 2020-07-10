package com.devendrakumar.trackcovid19;

public class CountryModel {
    private String flag,totalcases, country,cases,deaths, recovered, active,critical,todaycases, todaydeaths;

    public CountryModel(){

    }

    public CountryModel(String flag, String country, String totalcases, String cases, String deaths, String recovered, String todaycases,String todaydeaths) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;

        this.todaycases=todaycases;
        this.todaydeaths=todaydeaths;
        this.totalcases=totalcases;
    }

    public String getTotalcases() {
        return totalcases;
    }

    public void setTotalcases(String totalcases) {
        this.totalcases = totalcases;
    }

    public String getTodaycases() {
        return todaycases;
    }

    public void setTodaycases(String todaycases) {
        this.todaycases = todaycases;
    }

    public String getTodaydeaths() {
        return todaydeaths;
    }

    public void setTodaydeaths(String todaydeaths) {
        this.todaydeaths = todaydeaths;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }
}
