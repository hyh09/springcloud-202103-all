package com.yunhui.eurak.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class HouseInfo implements Serializable {

    private Long id;

    private String city;

    private String region;

    private String name;

    public HouseInfo() {
    }

    public HouseInfo(Long id, String city, String region, String name) {
        this.id = id;
        this.city = city;
        this.region = region;
        this.name = name;
    }
}
