package com.jk.bean;


import java.io.Serializable;

public class User implements Serializable {

    private Integer id;

    private String yhMch;

    private String yhNch;


    private String yhMm;

    private String yhXm;

    private String yhShjh;

    private String yhYx;

    private String yhTx;

    private Integer yhJb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYhMch() {
        return yhMch;
    }

    public void setYhMch(String yhMch) {
        this.yhMch = yhMch;
    }

    public String getYhNch() {
        return yhNch;
    }

    public void setYhNch(String yhNch) {
        this.yhNch = yhNch;
    }

    public String getYhMm() {
        return yhMm;
    }

    public void setYhMm(String yhMm) {
        this.yhMm = yhMm;
    }

    public String getYhXm() {
        return yhXm;
    }

    public void setYhXm(String yhXm) {
        this.yhXm = yhXm;
    }

    public String getYhShjh() {
        return yhShjh;
    }

    public void setYhShjh(String yhShjh) {
        this.yhShjh = yhShjh;
    }

    public String getYhYx() {
        return yhYx;
    }

    public void setYhYx(String yhYx) {
        this.yhYx = yhYx;
    }

    public String getYhTx() {
        return yhTx;
    }

    public void setYhTx(String yhTx) {
        this.yhTx = yhTx;
    }

    public Integer getYhJb() {
        return yhJb;
    }

    public void setYhJb(Integer yhJb) {
        this.yhJb = yhJb;
    }
}