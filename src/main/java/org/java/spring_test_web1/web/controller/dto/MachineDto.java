package org.java.spring_test_web1.web.controller.dto;

public class MachineDto {
    private String name;
    private String description;
    private int price;

    public MachineDto(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {

        return "MachineDto{\n" + "name='" + name + '\'' + ",\n" + "description='" + description + '\'' + ",\n" + "price=" + price + "\n" + "}";
    }

}
