package com.example.moviestreaming.Model;

import java.util.List;

public class AllCatagory {

    private Integer Id;
    private String Catagory;

    private List<Catagory> catagoryList = null;


    public AllCatagory(Integer id, String catagory, List<com.example.moviestreaming.Model.Catagory> catagoryList) {
        Id = id;
        Catagory = catagory;
        this.catagoryList = catagoryList;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCatagory() {
        return Catagory;
    }

    public void setCatagory(String catagory) {
        Catagory = catagory;
    }

    public List<com.example.moviestreaming.Model.Catagory> getCatagoryList() {
        return catagoryList;
    }

    public void setCatagoryList(List<com.example.moviestreaming.Model.Catagory> catagoryList) {
        this.catagoryList = catagoryList;
    }
}
