package com.example.price.model;

public class product {

    private String Name;
    private float Price;



    public void setName(String Name){
        this.Name = Name;
    }
    public void setPrice(float Price){
        this.Price =Price;
    }

    public String getName(){
       return this.Name;
    }
    public float getPrice(){
        return this.Price;
    }



    @Override
    public String toString() {
        return "product{" +
                "Name='" + Name + '\'' +
                ", Price=" + Price +
                '}';
    }
}
