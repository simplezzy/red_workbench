package com.redcode.workbench.springbootdubbos.domain;

import java.io.Serializable;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */
public class City implements Serializable {
    private static final long serialVersionUID = 6342337640993502601L;

    private Long id;

    private String cityName;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
