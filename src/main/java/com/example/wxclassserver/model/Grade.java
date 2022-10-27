package com.example.wxclassserver.model;

public class Grade {
    Integer id;
    String name;
    Integer number;
    String intro;
    String charge;
    Integer hot;

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", intro='" + intro + '\'' +
                ", charge='" + charge + '\'' +
                ", hot=" + hot +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}
