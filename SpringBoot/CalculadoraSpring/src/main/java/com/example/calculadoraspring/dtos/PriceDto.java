package com.example.calculadoraspring.dtos;


public class PriceDto {

    private String location;
    private Integer price;

    public PriceDto(String location, Integer price) {
        this.location = location;
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
